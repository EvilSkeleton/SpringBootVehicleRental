package rohit.vehicle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    // private AdminService servAdmin;

    //Home()
    @GetMapping("/")
    public String home() {
        return "main";
    }
 
    //Login to User
    @GetMapping("/user")
    public String loginUser() {
        return "userHome";
    }
 
    //login to admin
    @GetMapping("/admin")
    public String loginAdmin() {
        return "redirect:/";
    }
}