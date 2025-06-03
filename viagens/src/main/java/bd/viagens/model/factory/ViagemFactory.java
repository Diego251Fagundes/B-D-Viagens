package bd.viagens.model.factory;

import bd.viagens.model.builder.ViagemBuilder;
import bd.viagens.model.entity.Viagem;
import bd.viagens.model.entity.Reserva;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ViagemFactory {

    public static Viagem criarViagemSimples(String destino, String localPartida, Date dataPartida, Date dataRetorno, BigDecimal preco) {
        return new ViagemBuilder()
                .comDestino(destino)
                .comLocalPartida(localPartida)
                .comDataPartida(dataPartida)
                .comDataRetorno(dataRetorno)
                .comPreco(preco)
                .comReservas(List.of())
                .build();
    }

    public static Viagem criarViagemComReservas(String destino, String localPartida, Date dataPartida, Date dataRetorno, BigDecimal preco, List<Reserva> reservas) {
        return new ViagemBuilder()
                .comDestino(destino)
                .comLocalPartida(localPartida)
                .comDataPartida(dataPartida)
                .comDataRetorno(dataRetorno)
                .comPreco(preco)
                .comReservas(reservas)
                .build();
    }
}