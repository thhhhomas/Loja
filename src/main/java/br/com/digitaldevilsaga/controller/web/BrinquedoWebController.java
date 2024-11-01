package br.com.digitaldevilsaga.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.digitaldevilsaga.dto.BrinquedoDto;
import br.com.digitaldevilsaga.service.BrinquedoCategoriaService;
import br.com.digitaldevilsaga.service.BrinquedoService;

import org.springframework.ui.Model;

import java.util.List;


@Controller
@RequestMapping("/brinquedos")
public class BrinquedoWebController {
    

    @Autowired
    private BrinquedoService brinquedoService;

    @Autowired BrinquedoCategoriaService brinquedoCategoriaService;

    @GetMapping("/home")
    public String listAll(Model model){

        List<BrinquedoDto> brinquedos = brinquedoService.listarBrinquedos();

        model.addAttribute("brinquedos", brinquedos);

        return "index";
    }

    @GetMapping("/search")
    public String listSearch(@RequestParam("pesquisa") String pesquisa, Model model){

        List<BrinquedoDto> brinquedos = brinquedoService.listarBrinquedos(pesquisa);

        model.addAttribute("brinquedos", brinquedos);

        return "index"; 
    }

    @GetMapping("/compra")
    public String fazerCompra(@RequestParam("id") Integer id, Model model){
        
        BrinquedoDto brinquedo = brinquedoService.getBrinquedoById(id);

        model.addAttribute("brinquedoDto", brinquedo);

        return "brinquedo";
    }

    @GetMapping("/categoria/search")
    public String searchCategoria(@RequestParam("cat") String catDesc, Model model){

        List<BrinquedoDto> brinquedos = brinquedoCategoriaService.listarBrinquedoByCategoriaDescricao(catDesc);

        model.addAttribute("brinquedos", brinquedos);

        return "index";
    }
}
