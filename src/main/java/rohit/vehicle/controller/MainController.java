package rohit.vehicle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    @RequestMapping(path="/user", method = RequestMethod.POST)
    public String loginUser() {
        return "userHome";
    }
 
    //login to admin
    @RequestMapping(path="/admin", method = RequestMethod.POST)
    public String loginAdmin() {
        return "redirect:/";
    }
}