package bd.viagens.controller;

import bd.viagens.model.entity.Viagem;
import bd.viagens.dao.ViagemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:63342")
public class ViagemController {

    private final ViagemRepository viagemRepository;

    public ViagemController(ViagemRepository viagemRepository) {
        this.viagemRepository = viagemRepository;
    }

    @GetMapping("/")
    public String listarViagens(Model model) {
        List<Viagem> viagens = viagemRepository.findAll();
        model.addAttribute("viagens", viagens);
        return "index";
    }
}