package br.com.serratec.api.projeto01;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

    @RequestMapping(value = "/recurso", method = RequestMethod.GET)
    public String hello() {
        return "Olá mundo!";
    }

    @RequestMapping("/msg")
    public String msg() {
        return "Curso de API Restful";
    }

}
