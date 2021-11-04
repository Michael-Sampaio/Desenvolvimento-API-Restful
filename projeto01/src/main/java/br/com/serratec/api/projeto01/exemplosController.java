package br.com.serratec.api.projeto01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class exemplosController {

    @GetMapping("/teste")
    public String teste(){
        return "aula 02";
    }

    @GetMapping("/teste2")
    public String teste2(){
        return "Aula de Rest";
    }

    @GetMapping("/converter")
    public String converter(@RequestParam String texto){
        return texto.toUpperCase();
    }
    
}
