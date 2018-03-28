package pl.bockowsk.dao;

import java.util.List;

import pl.bockowsk.entity.Customer;

public interface CustomerDAO {
	List<Customer> getCustomers();

	void saveCustomer(Customer customer);

	Customer getCustomer(int theId);

	void deleteCustomer(int theId);

}
