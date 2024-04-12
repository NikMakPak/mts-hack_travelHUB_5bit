package main.tripservice.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.jsonwebtoken.Jwt;
import main.tripservice.models.dto.AuthenticationRequest;
import main.tripservice.models.response.JWTToString;
import main.tripservice.secutiry.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/api/login")
    public ResponseEntity<JWTToString> AuthenticateAndGetToken(@RequestBody AuthenticationRequest authenticationRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getLogin(), authenticationRequest.getPassword()));
        if(authentication.isAuthenticated()){
            return new ResponseEntity<>(new JWTToString(jwtService.GenerateToken(authenticationRequest.getLogin())), HttpStatus.OK);
        } else {
            throw new UsernameNotFoundException("invalid user request..!!");
        }
    }


}
