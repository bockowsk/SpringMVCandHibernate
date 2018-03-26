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
		String hql="from Customer";
		Query<Customer> query=session.createQuery(hql,Customer.class);
		List<Customer> customers=query.getResultList();
		return customers;
	}

}
