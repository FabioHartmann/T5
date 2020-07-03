import java.util.Scanner;

public class AppQuadradinhos {
    public AppQuadradinhos() {
    }

    public static void main(String[] args) {
       Quadradinhos quad = new Quadradinhos();
        Scanner in = new Scanner(System.in);
        System.out.println("Pressione qualquer tecla para continuar...");
        in.nextLine();
        quad.ordenaPorCor();
        quad.escreve();
    }
}
