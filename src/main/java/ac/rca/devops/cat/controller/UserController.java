package ac.rca.devops.cat.controller;

import ac.rca.devops.cat.model.User;
import ac.rca.devops.cat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/get-all")
    public List<User> getAll(){
        return userService.getAllUsers();
    }
    @GetMapping("/get-by-id")
    public User getUserById(@RequestParam Long id) throws Throwable {
        return userService.getUserById(id);
    }

    @PostMapping("/add-User")
    public User addUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/update-user")
    public User UpdateUser(@RequestBody User user) throws Throwable {
        return userService.updateUser(user.getId(),user);
    }

    @DeleteMapping("/delete-user")
    public User DeleteUser(@RequestParam Long id) throws Throwable {
        return userService.deleteUser(id);
    }
}