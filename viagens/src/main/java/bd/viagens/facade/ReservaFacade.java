package bd.viagens.facade;

import bd.viagens.model.entity.Cliente;
import bd.viagens.model.entity.Reserva;
import bd.viagens.model.entity.Viagem;
import bd.viagens.dao.ClienteRepository;
import bd.viagens.dao.ViagemRepository;
import bd.viagens.dao.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class ReservaFacade {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ViagemRepository viagemRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    public String realizarReserva(Long clienteId, Integer viagemId, String situacao) {
        Optional<Cliente> clienteOpt = clienteRepository.findById(clienteId);
        Optional<Viagem> viagemOpt = viagemRepository.findById(viagemId);

        if (clienteOpt.isPresent() && viagemOpt.isPresent()) {
            Reserva reserva = new Reserva();
            reserva.setCliente(clienteOpt.get());
            reserva.setViagem(viagemOpt.get());
            reserva.setDataReserva(new Date()); // Data atual
            reserva.setSituacao(situacao);

            reservaRepository.save(reserva);
            return "Reserva realizada com sucesso!";
        } else {
            return "Cliente ou Viagem não encontrados.";
        }
    }

    public String cancelarReserva(Long reservaId) {
        Optional<Reserva> reservaOpt = reservaRepository.findById(reservaId);
        if (reservaOpt.isPresent()) {
            reservaRepository.delete(reservaOpt.get());
            return "Reserva cancelada com sucesso!";
        } else {
            return "Reserva não encontrada.";
        }
    }

    public List<Reserva> buscarTodasReservas() {
        return reservaRepository.findAll();
    }
}