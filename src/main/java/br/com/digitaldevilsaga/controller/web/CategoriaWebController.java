package br.com.digitaldevilsaga.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.digitaldevilsaga.model.repository.BrinquedoRepository;
import br.com.digitaldevilsaga.model.repository.CategoriaRepository;
import br.com.digitaldevilsaga.dto.BrinquedoDto;
import br.com.digitaldevilsaga.dto.CategoriaDto;
import br.com.digitaldevilsaga.model.entity.Brinquedo;
import br.com.digitaldevilsaga.model.entity.Categoria;
import br.com.digitaldevilsaga.dto.CategoriaDto;

import java.util.List;
import java.util.Random;
import java.util.Base64;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/categorias")
public class CategoriaWebController {

    @Autowired
    private CategoriaRepository repository;
    @Autowired
    private BrinquedoRepository briRepository;
    
    @GetMapping("/home")
    public String listAll(Model model){
        List<Categoria> categorias = repository.findAll();
        
        List<CategoriaDto> categoriasComImagens = categorias.stream().map(categoria -> {
            Brinquedo brinquedo = briRepository.brinquedoAleatorio(categoria.getId());

            String imagemBase64 = Base64.getEncoder().encodeToString(brinquedo.getImagem());

            return new CategoriaDto(categoria, imagemBase64);
        }).collect(Collectors.toList());

        model.addAttribute("categorias", categoriasComImagens);

        return "categorias";
    }
}
