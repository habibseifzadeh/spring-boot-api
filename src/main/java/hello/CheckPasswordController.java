package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CheckPasswordController {

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/is-password-correct")
    @ResponseBody
    /* public PasswordResult isPasswordCorrect(String username, String password) {
        try {
            if (username.equals("habib") && password.equals("123")) {
                return new PasswordResult(true);
            } else {
                return new PasswordResult(false);
            }
        } catch (NullPointerException e) {
            return new PasswordResult(false);
        }
    } */
    public boolean isPasswordCorrect(String username, String password) {
        try {
            if (username.equals("habib") && password.equals("123")) {
                return true;
            } else {
                return false;
            }
        } catch (NullPointerException e) {
            return false;
        }
    }

}