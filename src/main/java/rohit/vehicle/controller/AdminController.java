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
    public String viewHomePage(Model model) {
        List<Rental> listrentals = servAdmin.listAll();
        model.addAttribute("listrental", listrentals);
        System.out.print("Get / ");
        return "admin";
    }
 
    //Add New Rental
    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("rental", new Rental());
        return "new";
    }
 
    //Save Rental details
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveRental(@ModelAttribute("rental") Rental rent) {
        servAdmin.saveRental(rent);
        return "redirect:/";
    }
 
    //Edit Rental details
    @RequestMapping("/edit/{v_id}")
    public ModelAndView showEditRentalPage(@PathVariable(name = "v_id") int id) {
        ModelAndView mav = new ModelAndView("editRental");
        Rental rent = servAdmin.get(id);
        mav.addObject("rental", rent);
        return mav;
    }

    //delete Rental
    @RequestMapping("/delete/{v_id}")
    public String deleteRental(@PathVariable(name = "v_id") int id) {
        servAdmin.deleteRental(id);
        return "redirect:/";
    }

    //View all Customers
    @RequestMapping("/customer")
    public String viewCustomers(Model model) {
        List<User> listrentals = servAdmin.listAllUsers();
        model.addAttribute("listrental", listrentals);
        System.out.print("Get /customer ");
        return "customer";
    }

    //Save Customer details
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("rental") User usr) {
        servAdmin.save(usr);
        return "redirect:/";
    }

    //Edit customer details
    @RequestMapping("/edit/{c_id}")
    public ModelAndView showEditCustomerPage(@PathVariable(name = "c_id") int id) {
        ModelAndView mav = new ModelAndView("editCustomer");
        User usr = servAdmin.getUser(id);
        mav.addObject("user", usr);
        return mav;
    }

    //delete customer
    @RequestMapping("/delete/{v_id}")
    public String deleteCustomer(@PathVariable(name = "c_id") int id) {
        servAdmin.deleteRental(id);
        return "redirect:/";
    }

    //view all rental requests

    //accept or deny request
}