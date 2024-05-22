package framework.integration;

import framework.domain.Customer;

public interface Observer {
    public void update(String message, Customer customer);
}
