package com.leszeknowinski.ShopAssistant.models.services;

import com.leszeknowinski.ShopAssistant.models.entities.CustomerEntity;
import com.leszeknowinski.ShopAssistant.models.forms.CustomerForm;
import com.leszeknowinski.ShopAssistant.models.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "session")
public class CustomerService {

    private CustomerEntity customerData;
    private boolean isLogged;

    public CustomerEntity getCustomerData() {
        return customerData;
    }

    public void setCustomerData(CustomerEntity customerData) {
        this.customerData = customerData;
    }

    public boolean isLogged() {
        return isLogged;
    }

    @Autowired
    CustomerRepository customerRepository;


    public boolean register(CustomerForm customerForm) {
        CustomerEntity newCustomer = new CustomerEntity();
        newCustomer.setName(customerForm.getName());
        newCustomer.setSurname(customerForm.getSurname());
        newCustomer.setEmail(customerForm.getEmail());
        newCustomer.setCardActive(false);
        newCustomer.setLogin(customerForm.getLogin());
        newCustomer.setPassword(customerForm.getPassword());
        customerRepository.save(newCustomer);
        return true;
    }

    public boolean isCustomerExistByLogin(String login) {
        return customerRepository.existsByLogin(login);
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public boolean authenticate(String login, String password) {
        Optional<CustomerEntity> loggedCustomer = customerRepository.findByLoginAndPassword(login, password);
        if (loggedCustomer.isPresent()) {
            isLogged = true;
            customerData = loggedCustomer.get();
        }
        return loggedCustomer.isPresent();
    }
}
