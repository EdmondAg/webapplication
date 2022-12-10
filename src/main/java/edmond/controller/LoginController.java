package edmond.controller;

import edmond.service.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class LoginController {
    private final AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String goToLogin() {
        return "login";
    }

    //when a post request is made this method will kick off
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String redirectWelcome(@RequestParam String name,@RequestParam String password, ModelMap modelMap){
        if (authenticationService.authenticate(name,password)){
            modelMap.put("name",name);
            modelMap.put("password",password);
            return "welcome";
        }
        boolean parametersError = true;
        modelMap.put("parametersError",parametersError);
        return "login";
    }
}



