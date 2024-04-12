package main.tripservice.controllers;

import main.tripservice.models.dto.AuthenticationRequest;
import main.tripservice.secutiry.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;


@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public String AuthenticateAndGetToken(@RequestBody AuthenticationRequest authenticationRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getLogin(), authenticationRequest.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.GenerateToken(authenticationRequest.getLogin());
        } else {
            throw new UsernameNotFoundException("invalid user request..!!");
        }
    }


}
