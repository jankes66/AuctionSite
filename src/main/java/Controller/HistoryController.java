package Controller;

import Model.HistoryModel;
import Service.HistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class HistoryController {

// Initialize the HistoryService
    public final HistoryService historyService;

// Download a list of Stories
    @GetMapping("/stories")
    public String getStoriesList(Model model){
        List<HistoryModel> historyModelList = historyService.getAllStories();
        model.addAttribute("historyModel", historyModelList);
        return "stories/storiesList";
    }

    // Download all Stories by pagination
    @GetMapping("/allStories")
    public Page<HistoryModel> getAllStories(Pageable pageable){
        int currentPage = pageable.getPageNumber();
        return historyService.getAllPageableStories(pageable);
    }

    // Adding a new history
    @GetMapping("/addHistory")
    public String getAddHistory(){
        return "stories/addNewHistory";
    }

    // Creating a new History
    @PostMapping("/addHistory")
    public RedirectView postAddAddress(HistoryModel historyModel){
        historyService.addHistory(historyModel);
        return  new RedirectView("/stories");
    }

    // Download a history with a specific ID for editing
    @GetMapping("/editHistory/{id}")
    public String getEditHistory(@PathVariable("id") Long id, Model model){
        HistoryModel historyModel = historyService.getHistoryById(id);
        model.addAttribute("historyModel", historyModel);
        return "stories/editHistory";
    }

    // Upgrade an edited history with a specific id
    @PostMapping("addHistory/{id}")
    public RedirectView postEditHistory(HistoryModel editHistory){
        historyService.saveEditHistory(editHistory);
        return new RedirectView("/editHistory/{id}");
    }

    // Delete the history with a specific id
    @DeleteMapping("/deleteHistory/{id}")
    public RedirectView deleteHistory(@PathVariable("id") Long id){
        historyService.deleteHistory(id);
        return new RedirectView("/stories");
    }
}
