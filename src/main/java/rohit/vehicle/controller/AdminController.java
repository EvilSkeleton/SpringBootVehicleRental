package rohit.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rohit.vehicle.domain.Rental;
import rohit.vehicle.domain.User;
import rohit.vehicle.service.AdminService;
 
@Controller
public class AdminController {
    @Autowired
    private AdminService servAdmin;

    //Home(Also the page for viewing all rentals)
    @GetMapping("/admin")
    public String viewHomePage() {
        // List<Rental> listrentals = servAdmin.listAll();
        // model.addAttribute("listrental", listrentals);
        System.out.print("Get /admin ");
        return "admin";
    }

    //View all rentals
    @GetMapping("/adminRental")
    public String viewRentalsPage(Model model) {
        List<Rental> listrentals = servAdmin.listAll();
        model.addAttribute("listrental", listrentals);
        System.out.print("Get /adminrental ");
        return "adminRental";
    }
 
    //Add New Rental
    @GetMapping("/adminAddRental")
    public String addRental(Model model) {
        model.addAttribute("rental", new Rental());
        return "adminAddRental";
    }
 
    //Save Rental details
    @RequestMapping(value = "/saveRental", method = RequestMethod.POST)
    public String saveRentalAdmin(@ModelAttribute("rental") Rental rent) {
        servAdmin.saveRental(rent);
        return "redirect:/adminRental";
    }
 
    //Edit Rental details
    @RequestMapping("/editRental/{v_id}")
    public ModelAndView showEditRentalPage(@PathVariable(name = "v_id") int id) {
        ModelAndView mav = new ModelAndView("adminAddRental");
        Rental rent = servAdmin.get(id);
        mav.addObject("rental", rent);
        return mav;
    }

    //delete Rental
    @RequestMapping("/deleteRental/{v_id}")
    public String deleteRental(@PathVariable(name = "v_id") int id) {
        servAdmin.deleteRental(id);
        return "redirect:/adminRental";
    }

    //View all Users
    @RequestMapping("/adminUserView")
    public String viewUsers(Model model) {
        List<User> listuser = servAdmin.listAllUsers();
        model.addAttribute("listuser", listuser);
        System.out.print("Get /user ");
        return "adminUserView";
    }

    //Save User details
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("rental") User usr) {
        servAdmin.save(usr);
        return "redirect:/adminUserView";
    }

    //Edit User details
    @RequestMapping("/editUser/{id}")
    public ModelAndView showEditUserPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("adminUserEdit");
        User usr = servAdmin.getUser(id);
        mav.addObject("user", usr);
        return mav;
    }

    //delete User
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(name = "id") int id) {
        servAdmin.deleteusr(id);
        return "redirect:/adminUserView";
    }

    //Add New User
    @GetMapping("/adminAddUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "adminUserEdit";
    }

    //view all rental requests(NOT PRIORITY)

    //accept or deny request
}