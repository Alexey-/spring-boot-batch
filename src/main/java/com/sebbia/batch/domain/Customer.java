package com.sebbia.batch.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Customer {

    @Id
    private String id;
    @Column
    private String name;
    @Column
    private long salary;
    @Column
    private String position;

    public Customer() {

    }

    public Customer(String name, long salary, String position) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.salary = salary;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (salary != customer.salary) return false;
        if (id != null ? !id.equals(customer.id) : customer.id != null) return false;
        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        return !(position != null ? !position.equals(customer.position) : customer.position != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) (salary ^ (salary >>> 32));
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }
}
