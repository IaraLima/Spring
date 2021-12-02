package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HabilidadeController {

    @RequestMapping(value="/habilidade", method=RequestMethod.GET)
    public String helloWorld()
    {
        // The html file name is helloWorldPage.html.
        return "HabilidadePage";
    }
}