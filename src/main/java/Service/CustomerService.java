package Service;

import Model.CustomerModel;
import Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class CustomerService {

// Initialize the CustomerRepository
    private final CustomerRepository customerRepository;

// List of all clients in CustomRepository
    public List<CustomerModel> getAllCustomers(){
        return customerRepository.findAll();
    }

// List of all clients in CustomRepository by pagination
    public Page<CustomerModel> getAllPageableCustomers(Pageable pageable){
        return customerRepository.findAll(pageable);
    }

// Adding a new customer.
    public CustomerModel addCustomer(CustomerModel addCustomer) {
           return customerRepository.save(addCustomer);
    }

// Search for a customer by id.
    public CustomerModel getCustomerById(Long id){
        Optional<CustomerModel> customer = customerRepository.findById(id);
        if (customer.isPresent()){
            return customerRepository.findById(id).orElse(null);
        } else {
            log.info("Customer with id:" + id + ", does not exist!");
            return null;
        }
    }

// Save edited Customer
    public void saveEditCustomer(CustomerModel editCustomer){
        customerRepository.save(editCustomer);
    }

//Delete a customer with a specific ID
    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

}
