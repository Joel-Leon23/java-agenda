package com.agenda.agendapia.controller;

import com.agenda.agendapia.entities.Client;
import com.agenda.agendapia.entities.Provider;
import com.agenda.agendapia.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping(value = "/providers")
public class ProviderController {
    @Autowired
    ProviderRepository providerRepository;

    @GetMapping(value = "/{id}")
    ResponseEntity<Provider> getProvider(@PathVariable long id) {
        Optional<Provider> providerData = providerRepository.findById(id);
        if (providerData.isPresent()) {
            return new ResponseEntity<>(providerData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    @ResponseBody
    ResponseEntity<List<Provider>> getProvider() {
        return new ResponseEntity<>(providerRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", headers = "Accept=application/json")
    ResponseEntity<Provider> updateProvider(@RequestBody Provider provider, @PathVariable(value = "id") long id) {
        Optional<Provider> providerData = providerRepository.findById(id);
        if (providerData.isPresent()) {
            try {
                Provider foundProvider = providerData.get();
                foundProvider.setName(provider.getName());
                foundProvider.setFirstLastName(provider.getFirstLastName());
                foundProvider.setSecondLastName(provider.getSecondLastName());
                foundProvider.setPhoneNumber(provider.getPhoneNumber());
                foundProvider.setIsActive(provider.getIsActive());
                foundProvider.setEmail(provider.getEmail());
                return new ResponseEntity<>(foundProvider, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(headers = "Accept=application/json")
    ResponseEntity<Provider> newProvider(@RequestBody Provider provider) {
        try {
            providerRepository.save(provider);
            return new ResponseEntity<>(provider, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<HttpStatus> deleteProvider(@PathVariable long id) {
        try {
            providerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
