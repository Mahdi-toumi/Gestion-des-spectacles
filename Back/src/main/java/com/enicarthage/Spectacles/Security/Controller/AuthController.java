package com.enicarthage.Spectacles.Security.Controller;

import com.enicarthage.Spectacles.Security.DTOs.AuthenticationRequest;
import com.enicarthage.Spectacles.Security.DTOs.AuthenticationResponse;
import com.enicarthage.Spectacles.Security.DTOs.RegisterRequest;
import com.enicarthage.Spectacles.Security.Service.AuthenticationService;
import com.enicarthage.Spectacles.User.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody AuthenticationRequest request) {
        System.out.println("Email reçu: " + request.getEmail());
        System.out.println("Mot de passe reçu: " + request.getMotDePasse());

        try {
            User authenticatedUser = authenticationService.authenticate(request);
            return ResponseEntity.ok(authenticatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}