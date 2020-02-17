package com.partyProgram.partyProgram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/party")
public class PartyController {

    @Autowired
    private PartyRepository partyRepository;

    @GetMapping
    public List<Person> attendeesList(){
        return partyRepository.findAll();
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        partyRepository.save(person);
    }

    @DeleteMapping("{id}")
    public void leaveParty(@PathVariable Long id){
        partyRepository.deleteById(id);
    }

}
