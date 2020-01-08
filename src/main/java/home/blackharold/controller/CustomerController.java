package home.blackharold.controller;

import home.blackharold.entity.Customer;
import home.blackharold.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //    need to inject customer service
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {

//        get customers from the service
        List<Customer> customers = customerService.getCustomers();
        System.out.println("/list customers: " + customers);

//        add the customers to the model
        model.addAttribute("customers", customers);

        return "list-customers";
    }

    @PostMapping("/processForm")
    public String processForm() {
        return "processForm";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

//        create model attribute to bind form data
        Customer customer = new Customer();
        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {

//        save the customer
        customerService.saveCustomer(customer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String updateCustomer(@RequestParam("customerId") int id, Model model) {

        System.out.println("customer id: " + id);
//        get the customer from service
        Customer customer = customerService.getCustomer(id);

//        set customer as a model attribute to pre-populate the form
        model.addAttribute("customer", customer);

//        send over to out form
        return "customer-form";
    }
}
