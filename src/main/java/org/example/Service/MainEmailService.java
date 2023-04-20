package org.example.Service;

import org.example.Model.MainEmailModel;
import org.example.Repository.MainEmailRepository;
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
public class MainEmailService {

    // Initialize the MainEmailRepository
    private final MainEmailRepository mainEmailRepository;

    // List of all stories in MainEmailRepository
    public List<MainEmailModel> getAllMainEmails(){
        return mainEmailRepository.findAll();
    }

    // List of all stories in MainEmailRepository by pagination
    public Page<MainEmailModel> getAllPageableMainEmails(Pageable pageable){
        return mainEmailRepository.findAll(pageable);
    }

    // Adding a new mainEmail.
    public MainEmailModel addMainEmail(MainEmailModel addMainEmail) {
        return mainEmailRepository.save(addMainEmail);
    }

    // Search for the mainEmail by id.
    public MainEmailModel getMainEmailById(Long id){
        Optional<MainEmailModel> mainEmail = mainEmailRepository.findById(id);
        if (mainEmail.isPresent()){
            return mainEmailRepository.findById(id).orElse(null);
        } else {
            log.info("MainEmail with id:" + id + ", does not exist!");
            return null;
        }
    }

    // Save edited mainEmail
    public void saveEditMainEmail(MainEmailModel editMainEmail){
        mainEmailRepository.save(editMainEmail);
    }

    //Delete a mainEmail with a specific ID
    public void deleteMainEmail(Long id){
        mainEmailRepository.deleteById(id);
    }
}
