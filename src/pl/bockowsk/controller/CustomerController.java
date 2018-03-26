package pl.bockowsk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.bockowsk.dao.CustomerDAO;
import pl.bockowsk.entity.Customer;
import pl.bockowsk.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// robimy DI
	@Autowired
	private CustomerService customerService;
	
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		List<Customer> customers=customerService.getCustomers();
		theModel.addAttribute("attributeCustomers", customers);
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Customer customer=new Customer();
		theModel.addAttribute("newCustomer", customer);
		return "customer-form";
	}
}
