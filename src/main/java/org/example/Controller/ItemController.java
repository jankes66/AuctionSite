package org.example.Controller;


import org.example.Model.ItemModel;
import org.example.Service.ItemService;
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
public class ItemController {

    // Initialize the ItemService
    public final ItemService itemService;

    // Download a list of Items
    @GetMapping("/items")
    public String getItemsList(Model model){
        List<ItemModel> itemModelList = itemService.getAllItems();
        model.addAttribute("itemModel", itemModelList);
        return "items/itemsList";
    }

    // Download all Items by pagination
    @GetMapping("/allItems")
    public Page<ItemModel> getAllItems(Pageable pageable){
        int currentPage = pageable.getPageNumber();
        return itemService.getAllPageableItems(pageable);
    }

    // Adding a new item
    @GetMapping("/addItem")
    public String getAddItem(){
        return "items/addNewItem";
    }

    // Creating a new Item
    @PostMapping("/addItem")
    public RedirectView postAddAddress(ItemModel itemModel){
        itemService.addItem(itemModel);
        return  new RedirectView("/items");
    }

    // Download a item with a specific ID for editing
    @GetMapping("/editItem/{id}")
    public String getEditItem(@PathVariable("id") Long id, Model model){
        ItemModel itemModel = itemService.getItemById(id);
        model.addAttribute("itemModel", itemModel);
        return "items/editItem";
    }

    // Upgrade an edited item with a specific id
    @PostMapping("addItem/{id}")
    public RedirectView postEditItem(ItemModel editItem){
        itemService.saveEditItem(editItem);
        return new RedirectView("/editItem/{id}");
    }

    // Delete the item with a specific id
    @DeleteMapping("/deleteItem/{id}")
    public RedirectView deleteItem(@PathVariable("id") Long id){
        itemService.deleteItem(id);
        return new RedirectView("/items");
    }
}
