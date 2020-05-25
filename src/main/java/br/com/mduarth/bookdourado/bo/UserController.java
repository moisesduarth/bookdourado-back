package br.com.mduarth.bookdourado.bo;

import org.springframework.stereotype.Controller;

@Controller
public class UserController {
	
    public String list(){
        return "users";
    }
}
