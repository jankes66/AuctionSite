package Controller;

import Model.MainEmailModel;
import Service.MainEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.ui.Model;


import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainEmailController {

    // Initialize the MainEmailService
    public final MainEmailService mainEmailService;

    // Download a list of MainEmails
    @GetMapping("/mainEmails")
    public String getMainEmailsList(Model model){
        List<MainEmailModel> mainEmailModelList = mainEmailService.getAllMainEmails();
        model.addAttribute("mainEmailModel", mainEmailModelList);
        return "mainEmails/mainEmailsList";
    }

    // Download all MainEmails by pagination
    @GetMapping("/allMainEmails")
    public Page<MainEmailModel> getAllMainEmails(Pageable pageable){
        int currentPage = pageable.getPageNumber();
        return mainEmailService.getAllPageableMainEmails(pageable);
    }

    // Adding a new mainEmail
    @GetMapping("/addMainEmail")
    public String getAddMainEmail(){
        return "mainEmails/addNewMainEmail";
    }

    // Creating a new MainEmail
    @PostMapping("/addMainEmail")
    public RedirectView postAddAddress(MainEmailModel mainEmailModel){
        mainEmailService.addMainEmail(mainEmailModel);
        return  new RedirectView("/mainEmails");
    }

    // Download a mainEmail with a specific ID for editing
    @GetMapping("/editMainEmail/{id}")
    public String getEditMainEmail(@PathVariable("id") Long id, Model model){
        MainEmailModel mainEmailModel = mainEmailService.getMainEmailById(id);
        model.addAttribute("mainEmailModel", mainEmailModel);
        return "mainEmails/editMainEmail";
    }

    // Upgrade an edited mainEmail with a specific id
    @PostMapping("addMainEmail/{id}")
    public RedirectView postEditMainEmail(MainEmailModel editMainEmail){
        mainEmailService.saveEditMainEmail(editMainEmail);
        return new RedirectView("/editMainEmail/{id}");
    }

    // Delete the mainEmail with a specific id
    @DeleteMapping("/deleteMainEmail/{id}")
    public RedirectView deleteMainEmail(@PathVariable("id") Long id){
        mainEmailService.deleteMainEmail(id);
        return new RedirectView("/mainEmails");
    }
}
