package com.proyecto.Labweb.Controller;

import com.proyecto.Labweb.Entities.User;
import com.proyecto.Labweb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Create a new user
    @PostMapping
    public ResponseEntity<?> create (@RequestBody User user){

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    //Read a user
    @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable(value = "id") Long userId){
        Optional<User> oUser = userService.findById(userId);

        if (!oUser.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oUser);
    }


    //Update an User
    @PutMapping("/{id}")
    public ResponseEntity<?> update (@RequestBody User userDetails, @PathVariable(value = "id") Long userId){
        Optional<User> user = userService.findById(userId);
        if (!user.isPresent()){
            return ResponseEntity.notFound().build();
        }
        user.get().setName(userDetails.getName());
    }
}
