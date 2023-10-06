import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static Personagem personagem = new Personagem("Personagem");
    private static Labirinto labirinto = new Labirinto(personagem);

    public static void main(String[] args) {
        //System.out.println(labirinto.mostrarLabirinto());
        do{
            System.out.println(personagem.getVisao(labirinto));
            personagem.mover(menu(), labirinto);
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
