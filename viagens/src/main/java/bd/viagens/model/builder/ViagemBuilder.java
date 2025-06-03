package bd.viagens.model.builder;

import bd.viagens.model.entity.Viagem;
import bd.viagens.model.entity.Reserva;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ViagemBuilder {

    private String destino;
    private String localPartida;
    private Date dataPartida;
    private Date dataRetorno;
    private BigDecimal preco;
    private List<Reserva> reservas;

    public ViagemBuilder comDestino(String destino) {
        this.destino = destino;
        return this;
    }

    public ViagemBuilder comLocalPartida(String localPartida) {
        this.localPartida = localPartida;
        return this;
    }

    public ViagemBuilder comDataPartida(Date dataPartida) {
        if (dataPartida == null) {
            throw new IllegalArgumentException("Data de partida não pode ser nula.");
        }
        this.dataPartida = new Date(dataPartida.getTime());
        return this;
    }

    public ViagemBuilder comDataRetorno(Date dataRetorno) {
        this.dataRetorno = new Date(dataRetorno.getTime());
        return this;
    }

    public ViagemBuilder comPreco(BigDecimal preco) {
        this.preco = preco;
        return this;
    }

    public ViagemBuilder comReservas(List<Reserva> reservas) {
        this.reservas = List.copyOf(reservas);
        return this;
    }

    public Viagem build() {
        return new Viagem(destino, localPartida, dataPartida, dataRetorno, preco, reservas);
    }
}