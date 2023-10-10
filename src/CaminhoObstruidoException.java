public class CaminhoObstruidoException extends RuntimeException{
    public CaminhoObstruidoException() {
        super("Parece que há uma pedra em seu caminho!\n");
    }
}
