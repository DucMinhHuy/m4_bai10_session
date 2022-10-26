package huy.test.controller;

import huy.test.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("user")
public class LoginController {
    @ModelAttribute("user")
    public User setUpUserForm(){
        return new User();
    }
    @GetMapping("")
    public String Index(){
        return "index";
    }
    @PostMapping("doLogin")
    public String doLogin(@ModelAttribute ("user") User user, Model model){
        if(user.getEmail().equals("admin@example.com")&& user.getPassword().equals("12345")){
            model.addAttribute("message","tao vao day");
        }else {
            model.addAttribute("message", "may la ai");
        }
        return "index";
    }
}
