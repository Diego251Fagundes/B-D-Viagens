package bd.viagens.controller;

import bd.viagens.command.CancelarReservaCommand;
import bd.viagens.command.Command;
import bd.viagens.command.ReservaCommand;
import bd.viagens.facade.ReservaFacade;
import bd.viagens.model.entity.Reserva;
import bd.viagens.model.entity.Viagem;
import bd.viagens.dao.ViagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaFacade reservaFacade;

    @Autowired
    private ViagemRepository viagemRepository;

    // Exibe o formulário
    @GetMapping("/form")
    public String mostrarFormulario(@RequestParam Integer viagemId, Model model) {
        Optional<Viagem> viagemOpt = viagemRepository.findById(viagemId);
        if (viagemOpt.isPresent()) {
            model.addAttribute("viagem", viagemOpt.get());
            return "formReserva";
        } else {
            model.addAttribute("mensagem", "Viagem não encontrada.");
            return "erro";
        }
    }

    @PostMapping("/executarReserva")
    public String executarReserva(@RequestParam Long clienteId,
                                  @RequestParam Integer viagemId,
                                  @RequestParam String situacao,
                                  RedirectAttributes redirectAttributes) {
        Command comando = new ReservaCommand(reservaFacade, clienteId, viagemId, situacao);
        String resultado = comando.executar();
        redirectAttributes.addFlashAttribute("mensagem", "Parabéns, a sua reserva foi confirmada com sucesso!");
        return "redirect:/";
    }

    // Exibe formulário de cancelamento
    @GetMapping("/cancelar")
    public String mostrarCancelarForm() {
        return "formCancelarReserva";
    }

    // Executa o cancelamento com Command
    @PostMapping("/executarCancelamento")
    public String executarCancelamento(@RequestParam Long reservaId, Model model) {
        Command comando = new CancelarReservaCommand(reservaFacade, reservaId);
        String resultado = comando.executar();
        model.addAttribute("mensagem", resultado);
        return "reservaResultado";
    }

    @GetMapping
    public String listarReservas(Model model) {
        List<Reserva> reservas = reservaFacade.buscarTodasReservas();
        model.addAttribute("reservas", reservas);
        return "reserva/listaReservas";
    }
}