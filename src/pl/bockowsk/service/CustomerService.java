package pl.bockowsk.service;

import java.util.List;
import pl.bockowsk.entity.Customer;

public interface CustomerService {
	List<Customer> getCustomers();

	void saveCustomer(Customer customer);

	Customer getCustomer(int theId);

	void deleteCustomer(int theId);
}
