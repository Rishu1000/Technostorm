package com.Demo.Banking.controller;

import com.Demo.Banking.exception.ResourceNotFoundException;
import com.Demo.Banking.model.Bank;
import com.Demo.Banking.model.User;
import com.Demo.Banking.repository.BankRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.sql.Date;
import java.util.List;


@RestController
@RequestMapping("/technostorms")
public class BankController {

    @Autowired
    BankRepository bankRepository;

    @GetMapping("/bank")
    public List<Bank> getAllNotes() {
        return bankRepository.findAll();
    }

    @PostMapping(path="/banks/create",consumes = "application/json", produces = "application/json")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Bank createBankAccount(@RequestBody Bank bank ){
    	
		
		 
    	//bank.setUser(user);
        return bankRepository.save(bank);
    }

    @GetMapping("/bankapp/{id}")
    public Bank getBankById(@PathVariable(value = "id") Long accountId) {
        return bankRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Bank", "id", accountId));
    }
    
    @GetMapping("/bankapp/{firstName}")
    public Bank findByFirstName(@PathVariable(value = "firstName") String firstName) {
        return  bankRepository.findByFirstName(firstName);
               // .orElseThrow(() -> new ResourceNotFoundException("Bank", "firstName", firstName));
    }
    @GetMapping("/bankapp/{lastName}")
    public Bank findByLastName(@PathVariable(value = "lastName") String lastName) {
        return bankRepository.findByLastName(lastName);
               // .orElseThrow(() -> new ResourceNotFoundException("Bank", "id", lastName));
    }
    @GetMapping("/bankapp/{createdDate}")
    public Bank findByDate(@PathVariable(value = "id") Date date) {
        return bankRepository.findByDate(date);
                //.orElseThrow(() -> new ResourceNotFoundException("Bank", "id", date));
    }

	/*
	 * @PutMapping("/bank/{id}") public Bank updateNote(@PathVariable(value = "id")
	 * Long noteId,
	 * 
	 * @Valid @RequestBody Note noteDetails) {
	 * 
	 * Bank bank = bankRepository.findById(noteId) .orElseThrow(() -> new
	 * ResourceNotFoundException("Bank", "id", noteId));
	 * 
	 * bank.setTitle(noteDetails.getTitle());
	 * note.setContent(noteDetails.getContent());
	 * 
	 * Note updatedNote = bankRepository.save(note); return updatedNote; }
	 */

    @DeleteMapping("/bankapp/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long accountId) {
        Bank bank = bankRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Bank", "accountId", accountId));

        bankRepository.delete(bank);

        return ResponseEntity.ok().build();
    }
}
