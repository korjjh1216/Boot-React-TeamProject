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
    
    @PostMapping("")
    public ResponseEntity<?> doJoin(@RequestBody User user) {
    	System.out.println("doJoin()");
    	service.save(user);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public ResponseEntity<?> UserList(){
    	System.out.println("Get UserList()");
    	return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> Userlogin(@RequestBody User user){
    	System.out.println("get UserLogin()");
    	System.out.println(user.getUsername() + ":" + user.getPassword());
    	String userlogin = service.login(user.getUsername(), user.getPassword());
    	    
    	
    	if(userlogin != null) {
    		System.out.println("=== login success ===");
    		return new ResponseEntity<>(HttpStatus.OK);	
    	} else {
    		System.out.println("=== login failed ===");
    	}
    	return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
    	
    }
}
