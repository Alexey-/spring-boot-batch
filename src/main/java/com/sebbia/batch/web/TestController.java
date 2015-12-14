package com.sebbia.batch.web;

import com.sebbia.batch.domain.Customer;
import com.sebbia.batch.response.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
public class TestController {

    @Autowired
    EntityManager entityManager;

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public SuccessResponse test() {
        entityManager.flush();
        for (int i = 0; i < 30; ++i) {
            Customer employee = new Customer("Customer" + i, (i + 5) * 1000, "Position " + i);
            entityManager.persist(employee);
            if (i % 20 == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
        entityManager.flush();
        entityManager.clear();
        return new SuccessResponse();
    }
}
