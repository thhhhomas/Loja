package br.com.digitaldevilsaga.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.digitaldevilsaga.service.BrinquedoService;
import br.com.digitaldevilsaga.service.CategoriaService;
import br.com.digitaldevilsaga.service.BrinquedoCategoriaService;
import br.com.digitaldevilsaga.dto.BrinquedoDto;
import br.com.digitaldevilsaga.dto.CategoriaDto;
import br.com.digitaldevilsaga.model.entity.Brinquedo;

import br.com.digitaldevilsaga.dto.NovoBrinquedoDto;

import br.com.digitaldevilsaga.model.repository.BrinquedoRepository;
import br.com.digitaldevilsaga.model.repository.CategoriaRepository;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminWebController {

    @Autowired
    private BrinquedoService brinquedoService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private BrinquedoCategoriaService brinquedoCategoriaService;

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
        List<Brinquedo> brinquedos = brinquedoService.listarBrinquedosNoImages();
        
        model.addAttribute("brinquedos", brinquedos);

        return "admbrinquedo";
    }

    @GetMapping("/categoria")
    public String admCategoria(Model model){
        List<CategoriaDto> categorias = brinquedoCategoriaService.listarCategorias();

        model.addAttribute("categorias", categorias);

        return "admcategoria";
    }

    @GetMapping("/brinquedo/novo")
    public String novoBrinquedoForm(Model model) {
        model.addAttribute("categorias", categoriaService.listarCategorias());
        return "novobrinquedo";
    }

    @PostMapping("/brinquedo/adicionar")
    public String adicionarBrinquedo(@ModelAttribute NovoBrinquedoDto novoBrinquedoDto) {
        try {
            brinquedoCategoriaService.salvarBrinquedo(novoBrinquedoDto);
        } catch (Exception e) {
            
        }
        return "redirect:/admin/brinquedo"; // Redireciona para a página de listagem de brinquedos
    }  
    
    @GetMapping("/brinquedo/editar")
    public String editarBrinquedoForm(@RequestParam("id") int id, Model model) {
        model.addAttribute("brinquedoDto", brinquedoService.getBrinquedoById(id));
        model.addAttribute("categorias", categoriaService.listarCategorias());
        return "editar";
    }
    
    @PostMapping("/brinquedo/salvar")
    public String editarBrinquedo(@ModelAttribute NovoBrinquedoDto novoBrinquedoDto) {
        brinquedoCategoriaService.atualizarBrinquedo(novoBrinquedoDto);
        
        return "redirect:/admin/brinquedo";
    }
}
