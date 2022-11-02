package rohit.vehicle.controller;

import java.util.List;
import java.util.function.Predicate;

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
public class UserController {
@Autowired
    private AdminService service;
 
    //view all availible rentals
    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Rental> listrentals = service.listAll();
        model.addAttribute("listrental", listrentals);
        System.out.print("Get / ");
        return "home";
    }
 
    //book a new rental
    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("rental", new Rental());
        return "editRental";
    }
 
    //save new rental booking
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveRental(@ModelAttribute("rental") Rental rent) {
        service.saveRental(rent);
        return "redirect:/";
    }
 
    //edit new rental booking
    @RequestMapping("/edit/{v_id}")
    public ModelAndView showEditRentalPage(@PathVariable(name = "v_id") int id) {
        ModelAndView mav = new ModelAndView("new");
        Rental rent = service.get(id);
        mav.addObject("rental", rent);
        return mav;
        
    }
    
    //view all booked rentals
    @GetMapping("/custRentals")
    public String viewCustRentalsPage(Model model,User usr) {
        List<Rental> listrentals = service.listAll();
        Predicate<Rental> condition = rental -> rental.getV_cust().equals(usr.getU_name());
        listrentals.removeIf(condition);
        model.addAttribute("listrental", listrentals);
        System.out.print("Get / ");
        return "home";
    }

    //finish rental usage
    @RequestMapping("/delete/{v_id}")
    public String deleteRental(@PathVariable(name = "v_id") int id) {
        service.deleteRental(id);
        return "redirect:/";
    }
}