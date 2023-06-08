package com.agenda.agendapia.controller;

import com.agenda.agendapia.entities.Client;
import com.agenda.agendapia.entities.Provider;
import com.agenda.agendapia.repository.ClientRepository;
import com.agenda.agendapia.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping(value = "/clients")
public class ClientController {
    @Autowired
    ClientRepository clientRepository;

    @GetMapping(value = "/{id}")
    ResponseEntity<Client> getClient(@PathVariable long id) {
        Optional<Client> clientData = clientRepository.findById(id);
        if (clientData.isPresent()) {
            return new ResponseEntity<>(clientData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @ResponseBody
    ResponseEntity<List<Client>> getClient() {
        return new ResponseEntity<>(clientRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", headers = "Accept=application/json")
    ResponseEntity<Client> updateClient(@RequestBody Client client, @PathVariable(value = "id") long id) {
        Optional<Client> clientData = clientRepository.findById(id);
        if (clientData.isPresent()) {
            try {
                Client foundClient = clientData.get();
                foundClient.setName(client.getName());
                foundClient.setFirstLastName(client.getFirstLastName());
                foundClient.setSecondLastName(client.getSecondLastName());
                foundClient.setPhoneNumber(client.getPhoneNumber());
                foundClient.setHasMembership(client.getHasMembership());
                foundClient.setEmail(client.getEmail());
                return new ResponseEntity<>(foundClient, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(headers = "Accept=application/json")
    ResponseEntity<Client> newClient(@RequestBody Client client) {
        try {
            clientRepository.save(client);
            return new ResponseEntity<>(client, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<HttpStatus> deleteProvider(@PathVariable long id) {
        try {
            clientRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
