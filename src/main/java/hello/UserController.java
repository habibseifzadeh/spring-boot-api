package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demo")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/add")
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String password) {
        User aUser = new User();
        aUser.setName(name);
        aUser.setPassword(password);
        userRepository.save(aUser);
        return "Saved";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/is-password-correct")
    public @ResponseBody boolean isPasswordCorrect(@RequestParam String username, 
    @RequestParam String password) {
        try {
            Iterable<User> users = userRepository.findAll();
            for(User u : users)
                if(u.getName().equals(username) && u.getPassword().equals(password)) 
                    return true;
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}