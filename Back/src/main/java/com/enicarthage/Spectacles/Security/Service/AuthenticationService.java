package com.enicarthage.Spectacles.Security.Service;

import com.enicarthage.Spectacles.Security.DTOs.AuthenticationRequest;
import com.enicarthage.Spectacles.Security.DTOs.AuthenticationResponse;
import com.enicarthage.Spectacles.Security.DTOs.RegisterRequest;
import com.enicarthage.Spectacles.Security.JwtUtil;
import com.enicarthage.Spectacles.User.Model.User;
import com.enicarthage.Spectacles.User.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .nom(request.getNom())
                .prenom(request.getPrenom())
                .tel(request.getTel())
                .email(request.getEmail())
                .motDePasse(passwordEncoder.encode(request.getMotDePasse()))
                .build();

        userRepository.save(user);

        var jwtToken = jwtUtil.generateToken(user.getEmail());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public User authenticate(AuthenticationRequest request) {
        // 1. Vérifier que l'email et le mot de passe ne sont pas null
        if (request.getEmail() == null || request.getMotDePasse() == null) {
            throw new RuntimeException("Email et mot de passe sont requis");
        }

        // 2. Rechercher l'utilisateur par email
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        // 3. Vérifier si le mot de passe correspond (comparaison directe non sécurisée)
        if (!user.getMotDePasse().equals(request.getMotDePasse())) {
            throw new RuntimeException("Mot de passe incorrect");
        }

        // 4. Retourner l'utilisateur authentifié
        return user;
    }
}
