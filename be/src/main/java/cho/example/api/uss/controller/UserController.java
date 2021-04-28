package cho.example.api.uss.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cho.example.api.uss.domain.User;
import cho.example.api.uss.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor
@RequestMapping(value="/user")
@CrossOrigin(origins ="*", allowedHeaders = "*")
public class UserController {
    private final UserServiceImpl service;

}
