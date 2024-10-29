package br.com.digitaldevilsaga.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.digitaldevilsaga.service.BrinquedoCategoriaService;
import br.com.digitaldevilsaga.dto.CategoriaDto;

import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaWebController {

    @Autowired
    private BrinquedoCategoriaService brinquedoCategoriaService;
    
    @GetMapping("/home")
    public String listAll(Model model){
        
        List<CategoriaDto> categorias = brinquedoCategoriaService.listarCategorias();

        model.addAttribute("categorias", categorias);

        return "categorias";
    }
}
