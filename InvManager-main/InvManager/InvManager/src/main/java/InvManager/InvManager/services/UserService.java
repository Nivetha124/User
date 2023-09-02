package InvManager.InvManager.services;

import InvManager.InvManager.models.User;
import InvManager.InvManager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    //@Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //
//
    public User saveDetails(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllDetails() {
        return userRepository.findAll();
    }

//    public User updateDetails(User user) {
//        User updateUser = userRepository.findById(user.getUserId()).orElse(null);
//        if (updateUser != null) {
//            updateUser.setUserName(user.getUserName());
//            updateUser.setEmail(user.getEmail());
//            userRepository.save(updateUser);
//            return updateUser;
//        }
//        return null;
//    }

    public String deleteUser(int Userid) {
        userRepository.deleteById(Userid);
        return "delete" + Userid;
    }

    public String authenticate(String username, String password) {
        String userName = " ";
        User user = userRepository.findByusername(username);
        if (user != null && user.getPassword().equals(password)) {
            return "success";
        } else {
            return "failure";
        }
    }
}
