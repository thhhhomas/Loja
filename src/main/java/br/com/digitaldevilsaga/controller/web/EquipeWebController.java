package br.com.digitaldevilsaga.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sobre")
public class EquipeWebController {

    @GetMapping("/equipe")
    public String nos(Model model){
        return "sobre";
    }
}
