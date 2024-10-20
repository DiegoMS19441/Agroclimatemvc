package br.com.fiap.agroclimate.agroclimatemvc.controller;

import br.com.fiap.agroclimate.agroclimatemvc.model.Fazenda;
import br.com.fiap.agroclimate.agroclimatemvc.model.Clima;
import br.com.fiap.agroclimate.agroclimatemvc.model.Fazenda;
import br.com.fiap.agroclimate.agroclimatemvc.repository.FazendaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("fazenda")
public class FazendaController {

    @Autowired
    private FazendaRepository fazendaRepository;


    @GetMapping("home")
    public String home(){
        return "fazenda/home";
    }

    @GetMapping("cadastrar")
    public String cadastrar(Fazenda fazenda, Model model) {
        model.addAttribute("clima", Clima.values());
        return "fazenda/cadastro";
    }

    @PostMapping("cadastrar")
    @Transactional
    public String cadastrar(@Valid Fazenda fazenda,
                            BindingResult result,
                            RedirectAttributes redirect, Model model) {
        if(result.hasErrors()){
            model.addAttribute("clima", Clima.values());
            return "fazenda/cadastro";
        }
        fazendaRepository.save(fazenda);
        redirect.addFlashAttribute("mensagem", "Cadastrado com sucesso!");
        return "redirect:/fazenda/cadastrar";
    }
/////////////////////////////////////////

    @GetMapping("listar")
    public String listarFazendas(Model model) {
        model.addAttribute("fazendas", fazendaRepository.findAll());
        return "fazenda/listar";
    }

    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("fazenda", fazendaRepository.findById(id));
        return "fazenda/editar";
    }

    @PostMapping("editar")
    public String editar(@Valid Fazenda fazenda, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()) {
            return "fazenda/editar";
        }
        fazendaRepository.save(fazenda);
        redirectAttributes.addFlashAttribute("mensagem", "Atualizado com sucesso");
        return "redirect:/fazenda/listar";
    }

    @PostMapping("remover")
    @Transactional
    public String remover(Long id, RedirectAttributes redirectAttributes) {
        fazendaRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("mensagem", "Fazenda removida");
        return "redirect:/fazenda/listar";
    }

}
