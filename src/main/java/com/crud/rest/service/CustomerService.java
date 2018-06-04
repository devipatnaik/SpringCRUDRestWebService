package com.crud.rest.service;

/*
 * author : Devi patnaik
 * This class is used for Service purpose
 */
import java.util.List;

import com.crud.rest.bean.MyCustomer;

public interface CustomerService {
	
	MyCustomer findById(long id);

	MyCustomer findByName(String name);

	public void saveCustomer(MyCustomer customer);

	public void updateCustomer(MyCustomer customer);

	public void deleteCustomerById(long id);

	public List<MyCustomer> findAllCustomers();

	public void deleteAllCustomers();

	public boolean isCustomerExist(MyCustomer customer);

}
