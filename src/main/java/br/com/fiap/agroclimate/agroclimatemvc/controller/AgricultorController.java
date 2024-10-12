package br.com.fiap.agroclimate.agroclimatemvc.controller;

import br.com.fiap.agroclimate.agroclimatemvc.model.Agricultor;
import br.com.fiap.agroclimate.agroclimatemvc.repository.AgricultorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("agricultor")
public class AgricultorController {

    @Autowired
    private AgricultorRepository agricultorRepository;


                                    //CADASTRANDO AGRICULTOR//
/////////////////////////////////////////
    @GetMapping("cadastrar")
    public String cadastrar(Agricultor agricultor) {
        return "agricultor/cadastro";
    }

    @PostMapping("cadastrar")
    @Transactional
    public String cadastrar(Agricultor agricultor, RedirectAttributes redirect) {
        agricultorRepository.save(agricultor);
        redirect.addFlashAttribute("mensagem", "Cadastrado com sucesso!");
        return "redirect:/agricultor/cadastrar";
    }
/////////////////////////////////////////

}
