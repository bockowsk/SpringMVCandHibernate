package pl.bockowsk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.bockowsk.entity.Customer;
import pl.bockowsk.dao.CustomerDAO;

@Service
public class CustomerServiceImpl implements CustomerService {
	// DI
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		Customer theCustomer=customerDAO.getCustomer(theId);
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		customerDAO.deleteCustomer(theId);
		
	}

}
