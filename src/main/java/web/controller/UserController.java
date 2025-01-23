package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import web.Model.User;
import web.service.UserServiceImp;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserServiceImp userService;

    @Autowired
    public UserController(UserServiceImp userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String listUser(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("user", new User());
        return "users";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("surname") String surname,
                          @RequestParam("age") int age,
                          RedirectAttributes redirectAttributes) {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setAge(age);
        userService.addUser(user);
        redirectAttributes.addAttribute("message", "User added successfully! ");
        return "redirect:/";
    }

    @PostMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @PostMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") Long id,
                             @RequestParam("name") String name,
                             @RequestParam("surname") String surname,
                             @RequestParam("age") int age) {
        User user = userService.findById(id);
        user.setName(name);
        user.setSurname(surname);
        user.setAge(age);
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping("/findById")
    public String findById(@RequestParam("id") Long id, Model model) {
        User user = userService.findById(id);
        if(user!=null){
            model.addAttribute(user);
        }else {
            model.addAttribute("errorMessage", "User not found!");
        }
        return "/findById";
    }
}
