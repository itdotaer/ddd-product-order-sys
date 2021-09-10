package com.alibaba.demo.domain.customer.gateway;

import com.alibaba.demo.domain.customer.Customer;

public interface CustomerGateway {
    public Customer getByById(String customerId);
}
