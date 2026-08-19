package com.gvscolombia.placetopay.controllers;

import com.gvscolombia.placetopay.dtos.ResponseDto;
import com.gvscolombia.placetopay.dtos.SessionRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gvscolombia.placetopay.services.SessionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/sessions")
@CrossOrigin({"*"})
@Slf4j
public class SessionController {
    
    @Autowired
    private SessionService sessionService;
    
    
    
    @PostMapping("/crearSession")
    public ResponseEntity<ResponseDto> crearSession(@RequestBody SessionRequest request) {
        
        return ResponseEntity.ok((ResponseDto.sucess(sessionService.crearSession(request))));
    }
    
    @GetMapping("/consultarSession/{requestId}")
    public ResponseEntity<ResponseDto> crearSession(@PathVariable("requestId") Long requestId) {
        
        return ResponseEntity.ok((ResponseDto.sucess(sessionService.consultarSession(requestId))));
    }
    
}
