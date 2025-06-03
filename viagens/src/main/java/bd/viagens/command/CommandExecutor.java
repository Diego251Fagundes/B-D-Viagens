package bd.viagens.command;

public class CommandExecutor {
    public String executarComando(Command comando) {
        return comando.executar();
    }
}