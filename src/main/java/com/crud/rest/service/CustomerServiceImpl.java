package com.crud.rest.service;

/*
 * This class is used for Service call only nothing much.
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.crud.rest.bean.MyCustomer;
import com.crud.rest.dao.CustomerDao;

public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	// setter for CustomerDao
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public MyCustomer findById(long id) {
		return customerDao.findById(id);
	}

	@Override
	public MyCustomer findByName(String name) {
		return customerDao.findByName(name);
	}

	@Override
	public void saveCustomer(MyCustomer customer) {
		customerDao.saveCustomer(customer);
	}

	@Override
	public void updateCustomer(MyCustomer customer) {
		customerDao.updateCustomer(customer);
	}

	@Override
	public void deleteCustomerById(long id) {
		customerDao.deleteCustomerById(id);
	}

	@Override
	public List<MyCustomer> findAllCustomers() {
		return customerDao.findAllCustomers();
	}

	@Override
	public void deleteAllCustomers() {
		customerDao.deleteAllCustomers();
	}

	@Override
	public boolean isCustomerExist(MyCustomer customer) {
		return customerDao.isCustomerExist(customer);
	}

}
