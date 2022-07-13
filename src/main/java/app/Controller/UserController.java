package app.Controller;

import app.Model.User;
import app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String sayUsers(Model model) {
        model.addAttribute("users", userService.readUsers());
        return "/users";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("new_user", new User());
        return "/new";
    }

    @PostMapping("/users")
    public String create(@ModelAttribute("user") User user) {
        userService.createUsers(user);
        return "redirect:/users";
    }

    @GetMapping("{id}/update")
    public String updateUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUsers(id));
        return "/update";
    }

    @PostMapping("{id}/updateUser")
    public String updateUsers(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUsers(id);
        return "redirect:/users";
    }
}
