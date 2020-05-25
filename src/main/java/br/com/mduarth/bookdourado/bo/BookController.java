package br.com.mduarth.bookdourado.bo;

import org.springframework.stereotype.Controller;

@Controller
public class BookController {
	
    public String list(){
        return "books";
    }
}
