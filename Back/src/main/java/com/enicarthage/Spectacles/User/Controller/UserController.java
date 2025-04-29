package com.enicarthage.Spectacles.User.Controller;

import com.enicarthage.Spectacles.User.Model.LoginRequest;
import com.enicarthage.Spectacles.User.Model.User;
import com.enicarthage.Spectacles.User.Repository.UserRepository;
import com.enicarthage.Spectacles.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/by-email")
    public Optional<User> getByEmail(@RequestParam String email) {
        return userService.findByEmail(email);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        User user = userRepository.findByEmail(request.email())
                .orElse(null);

        if (user == null || !user.getMotDePasse().equals(request.motp())) {
            return ResponseEntity.status(401).body("Email ou mot de passe incorrect");
        }

        return ResponseEntity.ok(Map.of(
                "message", "Connexion réussie",
                "user", Map.of(
                        "id", user.getId(),
                        "nom", user.getNom(),
                        "prenom", user.getPrenom(),
                        "email", user.getEmail()
                )
        ));
    }
}
