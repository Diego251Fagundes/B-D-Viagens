package bd.viagens.command;

import bd.viagens.facade.ReservaFacade;

public class CancelarReservaCommand implements Command {

    private final ReservaFacade reservaFacade;
    private final Long reservaId;

    public CancelarReservaCommand(ReservaFacade reservaFacade, Long reservaId) {
        this.reservaFacade = reservaFacade;
        this.reservaId = reservaId;
    }

    @Override
    public String executar() {
        return reservaFacade.cancelarReserva(reservaId);
    }
}