package org.example.Service;

import org.example.Model.HistoryModel;
import org.example.Repository.HistoryRepository;
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
public class HistoryService {

    // Initialize the HistoryRepository
    private final HistoryRepository historyRepository;

    // List of all stories in HistoryRepository
    public List<HistoryModel> getAllStories(){
        return historyRepository.findAll();
    }

    // List of all stories in HistoryRepository by pagination
    public Page<HistoryModel> getAllPageableStories(Pageable pageable){
        return historyRepository.findAll(pageable);
    }

    // Adding a new history.
    public HistoryModel addHistory(HistoryModel addHistory) {
        return historyRepository.save(addHistory);
    }

    // Search for a history by id.
    public HistoryModel getHistoryById(Long id){
        Optional<HistoryModel> history = historyRepository.findById(id);
        if (history.isPresent()){
            return historyRepository.findById(id).orElse(null);
        } else {
            log.info("History with id:" + id + ", does not exist!");
            return null;
        }
    }

    // Save edited history
    public void saveEditHistory(HistoryModel editHistory){
        historyRepository.save(editHistory);
    }

    //Delete a history with a specific ID
    public void deleteHistory(Long id){
        historyRepository.deleteById(id);
    }
}
