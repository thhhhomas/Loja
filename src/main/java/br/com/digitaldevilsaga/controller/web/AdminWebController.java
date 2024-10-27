package br.com.digitaldevilsaga.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.digitaldevilsaga.service.BrinquedoService;
import br.com.digitaldevilsaga.dto.BrinquedoDto;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminWebController {

    @Autowired
    private BrinquedoService brinquedoService;

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
        List<BrinquedoDto> brinquedos = brinquedoService.listarBrinquedos();

        model.addAttribute("brinquedos", brinquedos);

        return "admbrinquedo";
    }
}
