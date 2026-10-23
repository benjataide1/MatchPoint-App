package com.app.matchpoint.controller;

import com.app.matchpoint.dto.UserDTO;
import com.app.matchpoint.model.User;
import com.app.matchpoint.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }


    // Get all users
    @GetMapping()
    public List<UserDTO> getAllUsers() {

        return userService.getAllUsers().stream()
                .map(this::toDTO)
                .toList();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        User userFind = userService.getUserById(id);
        if (userFind == null) {
            return ResponseEntity.status(404).body("User not found with ID: " + id);
        }

        return ResponseEntity.ok(toDTO(userFind));
    }

    // Create
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {

        User createUser = userService.createUser(user);

        if (createUser == null) {
            return ResponseEntity.badRequest().body("Invalid user data");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(toDTO(createUser));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user) {

        User update = userService.updateUser(id, user);
        if (update == null) {
            return ResponseEntity.badRequest().body("Failed to update user with ID: " + id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(toDTO(update));
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {

        boolean canDelete = userService.deleteUser(id);

        if (!canDelete) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with ID: " + id);
        }

        return ResponseEntity.ok().body("User Deleted successfully");
    }

    private UserDTO toDTO(User user) {
        return new UserDTO(user.getId_user(), user.getName(), user.getEmail());
    }

}



