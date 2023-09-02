package InvManager.InvManager.controller;
import InvManager.InvManager.models.User;
import InvManager.InvManager.services.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //
//    @PostMapping("/addUsers")
//    public ResponseEntity<User>  saveDetails(@RequestBody User user) {
//        return new ResponseEntity<>(userService.saveDetails(user), HttpStatus.OK);
//    }
    @PostMapping("/addUsers")
    public User saveDetails(@RequestBody User user) {
        return userService.saveDetails(user);
    }


    @GetMapping("/getUser")
    public List<User> getDetails() {
        return userService.getAllDetails();
    }

//    @PutMapping("/updateUser")
//    public User updateUserDetails(@RequestBody User user) {
//        return  userService.updateDetails(user);
//    }

    @DeleteMapping("deleteUser/{id}")
    public String deletefunction(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody User loginRequest) {
        String response = userService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        if ("success".equals(response)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid login data");
        }
    }
}