package rohit.vehicle.controller;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
import rohit.vehicle.domain.Rental;
// import rohit.vehicle.domain.User;
import rohit.vehicle.service.UserService;
 
@Controller
public class UserController {
@Autowired
    private UserService service;
 
    //view all availible rentals
    @GetMapping("/user")
    public String viewHomePage(Model model) {
        List<Rental> listrentals = service.listAll();
        Predicate<Rental> condition = rental -> rental.getV_status().equals("Running");
        listrentals.removeIf(condition);
        model.addAttribute("listrental", listrentals);
        System.out.print("Get / ");
        return "userHome";
    }
 
    //book a new rental
    @GetMapping("/uer")
    public String add(Model model) {
        model.addAttribute("rental", new Rental());
        return "userEditRental";
    }
 
    //save new rental booking
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveRental(@ModelAttribute("rental") Rental rent) {
        rent.setV_status("Running");
        // rent.setV_cust("Rohit");
        service.saveRentalUser(rent);
        return "redirect:/user";
    }
 
    //edit new rental booking
    @RequestMapping("/book/{v_id}")
    public ModelAndView showEditRentalPage(@PathVariable(name = "v_id") int id) {
        ModelAndView mav = new ModelAndView("bookRental");
        Rental rent = service.get(id);
        mav.addObject("rental", rent);
        return mav;
        
    }
    
    //search all booked rentals
    @GetMapping("/ucr")
    public String viewCustRentalsPage(Model model) {
        List<Rental> listrentals = service.listAll();
        // for(Rental rental : listrentals)
        // {
        //     if(rental.getV_cust() == null)
        //     {
        //         listrentals.remove(rental);
        //     }
        // }
        model.addAttribute("listrental", listrentals);
        System.out.print("Get / ");
        return "userCustRental";
    }

    //finish rental usage
    @RequestMapping("/finish/{v_id}")
    public String deleteRental(@PathVariable(name = "v_id") int id) {
        //modify the rental list to delete customer name and its status to change to idle
        service.finishRental(id);
        return "redirect:/user";
    }

    //view all booked rentals
    @GetMapping("/scr/{name}")
    public String showCustRentalsPage(Model model,@PathVariable(name = "name") String name) {
        List<Rental> listrentals = service.listAll();
        // try {
        //     Predicate<Rental> condition = rental -> rental.getV_cust().equals(name);
        //     listrentals.removeIf(condition);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        Predicate<Rental> condition = rental -> rental.getV_status().equalsIgnoreCase("Idle");
        listrentals.removeIf(condition);
        model.addAttribute("listrental", listrentals);
        System.out.print("Get / ");
        return "showCustRental";
    }
}