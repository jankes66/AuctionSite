package org.example.Service;

import org.example.Model.AddressModel;
import org.example.Repository.AddressRepository;
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
public class AddressService {

    // Initialize the AddressRepository
    private final AddressRepository addressRepository;

    // List of all addresses in AddressRepository
    public List<AddressModel> getAllAddresses(){
        return addressRepository.findAll();
    }

    // List of all addresses in AddressRepository by pagination
    public Page<AddressModel> getAllPageableAddresses(Pageable pageable){
        return addressRepository.findAll(pageable);
    }

    // Adding a new address.
    public AddressModel addAddress(AddressModel addAddress) {
        return addressRepository.save(addAddress);
    }

    // Search for a address by id.
    public AddressModel getAddressById(Long id){
        Optional<AddressModel> customer = addressRepository.findById(id);
        if (customer.isPresent()){
            return addressRepository.findById(id).orElse(null);
        } else {
            log.info("Address with id:" + id + ", does not exist!");
            return null;
        }
    }

    // Save edited Address
    public void saveEditAddress(AddressModel editAddress){
        addressRepository.save(editAddress);
    }

    //Delete a address with a specific ID
    public void deleteAddress(Long id){
        addressRepository.deleteById(id);
    }
}
