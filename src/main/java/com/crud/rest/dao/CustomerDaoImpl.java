package com.crud.rest.dao;

/*
 * In this class we are using Session and SessionFactory object to connect to database and business logics
 */
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.crud.rest.bean.MyCustomer;

public class CustomerDaoImpl implements CustomerDao {
	
    @Autowired
    private SessionFactory sessionFactory;
	
    // setters for SessionFactory
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	

	@Override
	public MyCustomer findById(long id) {
		Session session=sessionFactory.openSession();
		Transaction transcation = session.beginTransaction();
		MyCustomer customer = new MyCustomer();
		try{
			customer = (MyCustomer)session.get(MyCustomer.class,id);
			transcation.commit();
			session.close();
		}catch(Exception e){
			transcation.rollback();
			session.close();
		}
		return customer;

	}

	@Override
	public MyCustomer findByName(String name) {
		Session session=sessionFactory.openSession();
		Transaction transcation = session.beginTransaction();
		MyCustomer customer = new MyCustomer();
		String hql = "from com.crud.rest.bean.MyCustomer where name = ?";
		try{
			Query query = session.createQuery(hql);
			query.setParameter(0,name);
			customer = (MyCustomer)query.uniqueResult();
			transcation.commit();
			session.close();
		}catch(Exception e){
			transcation.rollback();
			session.close();
		}
		return customer;
	}

	@Override
	public void saveCustomer(MyCustomer customer) {
		Session session=sessionFactory.openSession();
		Transaction transcation = session.beginTransaction();
		if(customer!=null){
			try{
				session.save(customer);
				transcation.commit();
			}catch(Exception e){
				transcation.rollback();
			session.close();
			}
		}
		
	}

	@Override
	public void updateCustomer(MyCustomer customer) {
		Session session=sessionFactory.openSession();
		Transaction transcation = session.beginTransaction();
		if(customer!=null){
			try{
				session.update(customer);
				transcation.commit();
			}catch(Exception e){
				transcation.rollback();
			session.close();
		}
	 }
		
   }

	@Override
	public void deleteCustomerById(long id) {
		Session session=sessionFactory.openSession();
		Transaction transcation = session.beginTransaction();
		MyCustomer customer = new MyCustomer();
		try{
			customer = (MyCustomer)session.get(MyCustomer.class,id);
			session.delete(customer);
			transcation.commit();
			session.close();
		}catch(Exception e){
			transcation.rollback();
			session.close();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MyCustomer> findAllCustomers() {
		List<MyCustomer> customer = new ArrayList<MyCustomer>();
		Session session=sessionFactory.openSession();
		customer = session.createQuery("from com.crud.rest.bean.MyCustomer").list();
		return customer;
	}

	@Override
	public void deleteAllCustomers() {
		Session session=sessionFactory.openSession();
		Transaction transcation = session.beginTransaction();
		try{
			session.createQuery("delete from MyCustomer").executeUpdate();
			transcation.commit();
			session.close();
		}catch(Exception e){
			transcation.rollback();
			session.close();
		}
		
	}

	@Override
	public boolean isCustomerExist(MyCustomer customer) {
		return findByName(customer.getName())!=null;
	}
}

// ************* End Of DAO Implementation *************
