package br.com.digitaldevilsaga.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.digitaldevilsaga.dto.BrinquedoDto;
import br.com.digitaldevilsaga.model.entity.Brinquedo;
import br.com.digitaldevilsaga.model.entity.Categoria;
import br.com.digitaldevilsaga.model.repository.BrinquedoRepository;
import jakarta.websocket.server.PathParam;

import org.springframework.ui.Model;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/brinquedos")
public class BrinquedoWebController {
    
    @Autowired
    private BrinquedoRepository repository;

    // @GetMapping("/home")
    // public String listAll(Model model){
    //     List<Brinquedo> brinquedos = repository.findAll();
    //     model.addAttribute("brinquedos", brinquedos);
    //     return "home";
    // }

    @GetMapping("/home")
    public String listAll(Model model){

        List<Brinquedo> brinquedos = repository.findAll();

        List<BrinquedoDto> brinquedosComImagens = brinquedos.stream().map(brinquedo -> {
            String imagemBase64 = Base64.getEncoder().encodeToString(brinquedo.getImagem());
            return new BrinquedoDto(brinquedo, imagemBase64);
        }).collect(Collectors.toList());

        model.addAttribute("brinquedos", brinquedosComImagens);

        return "index";
    }

    @GetMapping("/teste")
    public String listAllTeste(Model model){

        List<Brinquedo> brinquedos = repository.findAll();

        List<BrinquedoDto> brinquedosComImagens = brinquedos.stream().map(brinquedo -> {
            String imagemBase64 = Base64.getEncoder().encodeToString(brinquedo.getImagem());
            return new BrinquedoDto(brinquedo, imagemBase64);
        }).collect(Collectors.toList());

        model.addAttribute("brinquedos", brinquedosComImagens);

        return "index";
    }

    @GetMapping("/search")
    public String listSearch(@RequestParam("pesquisa") String pesquisa, Model model){
        List<Brinquedo> brinquedos = repository.findByNomeContains(pesquisa);

        List<BrinquedoDto> brinquedosComImagens = brinquedos.stream().map(brinquedo -> {
            String imagemBase64 = Base64.getEncoder().encodeToString(brinquedo.getImagem());
            return new BrinquedoDto(brinquedo, imagemBase64);
        }).collect(Collectors.toList());

        model.addAttribute("brinquedos", brinquedosComImagens);

        return "index"; 
    }

    @GetMapping("/compra")
    public String fazerCompra(@RequestParam("id") Integer id, Model model){
        Brinquedo brinquedo = repository.findById(id).get();

        String imagemBase64 = Base64.getEncoder().encodeToString(brinquedo.getImagem());
        BrinquedoDto brinquedoDto = new BrinquedoDto(brinquedo, imagemBase64);

        model.addAttribute("brinquedoDto", brinquedoDto);

        return "brinquedo";
    }
}
