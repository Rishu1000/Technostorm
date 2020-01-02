package com.Demo.Banking.controller;

import com.Demo.Banking.exception.ResourceNotFoundException;
import com.Demo.Banking.model.Bank;
import com.Demo.Banking.model.Both;
import com.Demo.Banking.model.User;
import com.Demo.Banking.repository.BankRepository;
import com.Demo.Banking.repository.UserRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;

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
    
    @Autowired
    UserRepository userRepository;

    @GetMapping("/bankapp")
    public List<Bank> getAllNotes() {
        return bankRepository.findAll();
    }

    @PostMapping(path="/bankapp/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Bank createBankAccount( @RequestBody Bank bank){
    	
		/*
		 * String firstName = objectNode.get("firstName").asText(); String lastName =
		 * objectNode.get("lastName").asText(); int age = objectNode.get("age").asInt();
		 * String accountType = objectNode.get("accountType").asText();
		 * 
		 * Bank bank = new Bank(); bank.setAccountType(accountType); User user = new
		 * User(); user.setFirstName(firstName); user.setUserId(null);
		 * user.setLastName(lastName); user.setAge(age);
		 * 
		 * bank.setUser(user);
		 */
    	
        return bankRepository.save(bank);
    }

    @GetMapping("/bankapp?accountId={id}")
    public Bank getBankById(@PathVariable(value = "id") Long accountId) {
    	System.err.print(accountId+"ttttttttttttttttttTTTTTT");
        return bankRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Bank", "id", accountId));
    }
    
    @GetMapping("/bankapp/{firstName}")
    public Bank findByFirstName(@PathVariable(value = "firstName") String firstName) {
    	
         List<User> user =   userRepository.findByFirstNameIgnoreCaseContaining(firstName);
         System.err.print(user);
         return null;
          
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

    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping("/bankapp/delete/accountId={id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long accountId) {
        Bank bank = bankRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Bank", "accountId", accountId));

        bankRepository.delete(bank);

        return ResponseEntity.ok().build();
    }
}
