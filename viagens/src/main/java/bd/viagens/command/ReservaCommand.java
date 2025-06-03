package bd.viagens.command;

import bd.viagens.facade.ReservaFacade;

public class ReservaCommand implements Command {

    private final ReservaFacade reservaFacade;
    private final Long clienteId;
    private final Integer viagemId;
    private final String situacao;

    public ReservaCommand(ReservaFacade reservaFacade, Long clienteId, Integer viagemId, String situacao) {
        this.reservaFacade = reservaFacade;
        this.clienteId = clienteId;
        this.viagemId = viagemId;
        this.situacao = situacao;
    }

    @Override
    public String executar() {
        return reservaFacade.realizarReserva(clienteId, viagemId, situacao);
    }
}