package Controller;

import Service.AddressService;
import Model.AddressModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AddressController {

// Initialize the AddressService
    public final AddressService addressService;

// Download a list of addresses
    @GetMapping("/addresses")
    public String getAddressesList(Model model){
        List<AddressModel> addressModelList = addressService.getAllAddresses();
        model.addAttribute("addressModel", addressModelList);
        return "addresses/addressesList";
    }

// Adding a new Address
    @GetMapping("/addAddress")
    public String getAddAddress(){
        return "addresses/addNewAddress";
    }

// Creating a new Address
    @PostMapping("/addAddress")
    public RedirectView postAddAddress(AddressModel addressModel){
        addressService.addAddress(addressModel);
        return  new RedirectView("/addresses");
    }

// Download a address with a specific ID for editing
    @GetMapping("/editAddress/{id}")
    public String getEditAddress(@PathVariable("id") Long id, Model model){
        AddressModel addressModel = addressService.getAddressById(id);
        model.addAttribute("addressModel", addressModel);
        return "addresses/editAddress";
    }

// Upgrade an edited address with a specific id
    @PostMapping("addAddress/{id}")
    public RedirectView postEditAddress(AddressModel editAddress){
        addressService.saveEditAddress(editAddress);
        return new RedirectView("/editAddress/{id}");
    }

// Delete the address with a specific id
    @DeleteMapping("/deleteAddress/{id}")
    public RedirectView deleteAddress(@PathVariable("id") Long id){
        addressService.deleteAddress(id);
        return new RedirectView("/addresses");
    }

// Download all addresses by pagination
    @GetMapping("/allAddresses")
    public Page<AddressModel> getAllAddresses(Pageable pageable){
        int currentPage = pageable.getPageNumber();
        return addressService.getAllPageableAddresses(pageable);
    }

}
