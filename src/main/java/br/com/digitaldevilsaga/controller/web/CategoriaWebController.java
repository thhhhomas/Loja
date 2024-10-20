package br.com.digitaldevilsaga.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.digitaldevilsaga.model.repository.CategoriaRepository;

@Controller
@RequestMapping("/categorias")
public class CategoriaWebController {

    @Autowired
    private CategoriaRepository repository;
    
    

}
