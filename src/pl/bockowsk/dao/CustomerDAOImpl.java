package pl.bockowsk.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.bockowsk.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		// get a session from factory
		Session session=sessionFactory.getCurrentSession();
		String hql="FROM Customer ORDER BY last_name";
		Query<Customer> query=session.createQuery(hql,Customer.class);
		List<Customer> customers=query.getResultList();
		return customers;
	}

	@Transactional
	@Override
	public void saveCustomer(Customer customer) {
		// get a session from factory
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		Session session=sessionFactory.getCurrentSession();
		Customer theCustomer=session.get(Customer.class, theId);
		return theCustomer;
	}

	@Transactional
	@Override
	public void deleteCustomer(int theId) {
		Session session=sessionFactory.getCurrentSession();
		Customer customer=session.get(Customer.class, theId);
		session.delete(customer);
	}

}
