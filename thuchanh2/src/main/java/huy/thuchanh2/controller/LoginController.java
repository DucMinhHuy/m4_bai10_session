package huy.thuchanh2.controller;

import huy.thuchanh2.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("huy")
public class LoginController {
    @ModelAttribute("huy")
    public User setUpUserForm(){
        return new  User();
    }
    @RequestMapping("")
    public String Index(@CookieValue(value = "setHuy",defaultValue = "")String setUser, Model model){
        Cookie cookie=new Cookie("setHuy",setUser);
        model.addAttribute("cookieValue",cookie);
        return "login";
    }
    @PostMapping("doLogin")
    public String doLogin(@ModelAttribute("huy") User user, Model model, @CookieValue(value = "setHuy",defaultValue = "")String setUser, HttpServletResponse response, HttpServletRequest request){
        if(user.getEmail().equals("huy@gmail.com")&& user.getPassword().equals("1234")){
            if(user.getEmail()!=null){
                setUser=user.getEmail();
                Cookie cookie=new Cookie("setHuy",setUser);
                cookie.setMaxAge(30);
                response.addCookie(cookie);
                Cookie cookie1[]=request.getCookies();
                for(Cookie cookie2 :cookie1) {
                    if(cookie2.getName().equals("setHuy")){
                        model.addAttribute("cookieValue",cookie2);
                        break;
                    }else {
                        cookie2.setValue("");
                        model.addAttribute("cookieValue",cookie2);
                        break;
                    }
                }
                model.addAttribute("message","Login Welcome");
            }else {
                user.setEmail("");
                Cookie cookie=new Cookie("setHuy",setUser);
                model.addAttribute("cookieValue",cookie);
                model.addAttribute("message","Login faile, try again");
            }
        }
        return "login";
    }

}
