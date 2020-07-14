package com.acelera.tcc.group03.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acelera.tcc.group03.domains.TransactionChannel;
import com.acelera.tcc.group03.dto.TransactionChannelDTO;
import com.acelera.tcc.group03.services.TransactionChannelService;

@RestController
@RequestMapping("/transaction-channel")
public class TransactionChannelController {
    private TransactionChannelService service;
    
    public TransactionChannelController (TransactionChannelService service) {
    	this.service = service;
    }
    
    @GetMapping
    public ResponseEntity<List<TransactionChannel>> getAll() {
        List<TransactionChannel> transactionChannels = this.service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(transactionChannels);
    }
    
    @GetMapping ("/{id}")
    public ResponseEntity<Optional<TransactionChannel>> getById(@PathVariable("id") Long id) {
        Optional<TransactionChannel> transactionChannel = this.service.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(transactionChannel);
    }
    
    @PostMapping
    public ResponseEntity<TransactionChannel> create (@RequestBody TransactionChannelDTO transactionChannelDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.create(transactionChannelDTO));
    }
    
    @PutMapping
    public ResponseEntity<TransactionChannel> update(@RequestBody TransactionChannel transactionChannel) {
    	this.service.update(transactionChannel);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(transactionChannel);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete (@PathVariable("id") Long id){
        this.service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}