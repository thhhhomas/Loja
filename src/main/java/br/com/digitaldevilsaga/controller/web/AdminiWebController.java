package br.com.digitaldevilsaga.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.digitaldevilsaga.model.repository.AdminRepository;
import br.com.digitaldevilsaga.model.repository.BrinquedoRepository;

@Controller
@RequestMapping("/admin")
public class AdminiWebController {

    @Autowired
    BrinquedoRepository brinquedoRepository;

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/login")
    public String loginAdmin(Model model){
        return "login";
    }

    @GetMapping("/administracao")
    public String adm(Model model){
        return "administracao";
    }

    @GetMapping("/brinquedo")
    public String admBrinquedo(Model model){
        
        return "admbrinquedo";
    }
}
