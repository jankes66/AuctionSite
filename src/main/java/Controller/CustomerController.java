package Controller;

import Model.CustomerModel;
import Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CustomerController {

// Initialize the CustomerService
    private final CustomerService customerService;

// Download a list of customers
    @GetMapping("/customers")
    public String getCustomersList(Model model){
        List<CustomerModel> customerModelList = customerService.getAllCustomers();
        model.addAttribute("customerModel", customerModelList);
        return "persons/personsList";
    }

// Adding a new Customer
    @GetMapping("/addCustomer")
    public String getAddCustomer(){
        return "persons/addNewPerson";
    }

// Creating a new Customer
    @PostMapping("/addCustomer")
    public RedirectView postAddCustomer(CustomerModel customerModel){
        customerService.addCustomer(customerModel);
        return  new RedirectView("/customers");
    }

// Download a client with a specific ID for editing
    @GetMapping("/editCustomer/{id}")
    public String getEditCustomer(@PathVariable("id") Long id, Model model){
        CustomerModel customerModel = customerService.getCustomerById(id);
        model.addAttribute("customerModel", customerModel);
        return "persons/editPerson";
    }

// Upgrade an edited client with a specific id
    @PostMapping("addCustomer/{id}")
    public RedirectView postEditCustomer(CustomerModel editCustomer){
        customerService.saveEditCustomer(editCustomer);
        return new RedirectView("/editCustomer/{id}");
    }

// Delete a client with a specific id
    @DeleteMapping("/deleteCustomer/{id}")
    public RedirectView deleteCustomer(@PathVariable("id") Long id){
        customerService.deleteCustomer(id);
        return new RedirectView("/customers");
    }

// Download all clients by pagination
    @GetMapping("/allCustomers")
    public List<CustomerModel> getAllPageableCustomers(){

        return customerService.getAllCustomers();
    }

    @GetMapping("/test")
    public List<CustomerModel> getCustomerModel(){
        CustomerModel c1 = CustomerModel.builder()
                .firstName("Jacek")
                .lastName("Grochowski")
                .secondEmail("jgrochowski@xx.pl")
                .phoneNumber("+42800700600")
                .build();
        CustomerModel c2 = CustomerModel.builder()
                .firstName("Maciej")
                .lastName("Nowicki")
                .secondEmail("m.nowicki@xx.pl")
                .phoneNumber("+42300200100")
                .build();
        customerService.addCustomer(c1);
        customerService.addCustomer((c2));
    return List.of(c1, c2);
    }

}
