package pl.bockowsk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("newCustomer") Customer customer) {
		// pobieram obiekt z modelu, jak?
		// anotacja @ModelAttirbute("newCustomer" w deklaracji metody)
		customerService.saveCustomer(customer);
		// save do db za pomoca Service -> DAO 
		
		// nie wiem co return?
		// po prostu redirect na koncu do glownego, e.g. return "redirect:/customer/list";
		return "redirect:/customer/list";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		// get the customer from the database
		Customer theCustomer=customerService.getCustomer(theId);
		// set customer as a model attribute to pre-populate
		theModel.addAttribute("newCustomer", theCustomer);
		return "customer-form";
	}
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
}
