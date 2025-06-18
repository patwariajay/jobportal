package com.jobportal.api;

import com.jobportal.dto.LoginDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.dto.UserDto;
import com.jobportal.service.UserService;

@RestController
@CrossOrigin
@Validated
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserAPI {

@Autowired
private UserService userService ;

@PostMapping("/register")
public ResponseEntity<UserDto> registerUser (@RequestBody @Valid UserDto userDto){
	UserDto registeredUser = userService.registerUser(userDto);
	return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
}

@PostMapping("/login")
public ResponseEntity<UserDto> loginUser (@RequestBody LoginDto LoginDto){
	UserDto registeredUser = userService.loginUser(LoginDto);
	return new ResponseEntity<>(registeredUser, HttpStatus.OK);
}


}
