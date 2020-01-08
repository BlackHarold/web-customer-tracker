package home.blackharold.controller;

import home.blackharold.entity.Customer;
import home.blackharold.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
