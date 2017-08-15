package org.smart4j.frameworkweb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.framework.annotation.Service;
import org.smart4j.frameworkweb.helper.DatabaseHelper;
import org.smart4j.frameworkweb.model.Customer;

import java.util.List;
import java.util.Map;

@Service
public class CustomerService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    public List<Customer> getCustomerList() {
        String sql = "SELECT * FROM customer";
        return DatabaseHelper.queryEntityList(Customer.class, sql);
    }

    public Customer getCustomer(long id) {
        String sql = "SELECT * FROM customer WHERE id=?";
        return DatabaseHelper.queryEntity(Customer.class, sql, id);
    }

    public boolean createCustomer(Map<String, Object> fileMap) {
        return DatabaseHelper.insertEntity(Customer.class, fileMap);
    }

    public boolean updateCustomer(long id, Map<String, Object> fileMap) {
        return DatabaseHelper.updateEntity(Customer.class, id, fileMap);
    }

    public boolean deleteCustomer(long id) {
        return DatabaseHelper.deleteEntity(Customer.class, id);
    }
}
