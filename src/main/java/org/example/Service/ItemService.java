package org.example.Service;


import org.example.Model.ItemModel;
import org.example.Repository.ItemRepository;
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
public class ItemService {

    // Initialize the ItemRepository
    private final ItemRepository itemRepository;

    // List of all stories in ItemRepository
    public List<ItemModel> getAllItems(){
        return itemRepository.findAll();
    }

    // List of all stories in ItemRepository by pagination
    public Page<ItemModel> getAllPageableItems(Pageable pageable){
        return itemRepository.findAll(pageable);
    }

    // Adding a new item.
    public ItemModel addItem(ItemModel addItem) {
        return itemRepository.save(addItem);
    }

    // Search for the item by id.
    public ItemModel getItemById(Long id){
        Optional<ItemModel> item = itemRepository.findById(id);
        if (item.isPresent()){
            return itemRepository.findById(id).orElse(null);
        } else {
            log.info("Item with id:" + id + ", does not exist!");
            return null;
        }
    }

    // Save edited item
    public void saveEditItem(ItemModel editItem){
        itemRepository.save(editItem);
    }

    //Delete a item with a specific ID
    public void deleteItem(Long id){
        itemRepository.deleteById(id);
    }
}
