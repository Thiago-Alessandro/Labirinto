import java.util.Random;
import java.util.Scanner;

public class Main {

    private final static Scanner sc = new Scanner(System.in);
    private final static Personagem personagem = new Personagem();
    private final static Labirinto labirinto = new Labirinto(personagem);

    public static void main(String[] args) {
//        System.out.println(labirinto.mostrarLabirinto());
        do{
            System.out.println(personagem.getVisao(labirinto));
            try {
                personagem.mover(menu(), labirinto);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }while(!personagem.escapouLabirinto(labirinto));
        System.out.println("Parabens você escapou!!!!");
    }

    private static String menu(){
        System.out.println("""
                
                w - cima
                a - esquerda
                s - baixo
                d - direita
                """);
        return sc.next();
    }
}
