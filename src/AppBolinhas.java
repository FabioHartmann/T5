import java.util.Scanner;

public class AppBolinhas {
    public AppBolinhas() {
    }


    public static void main(String[] args) {
//        new Bolinhas();
        Scanner in = new Scanner(System.in);
        Bolinhas bol = new Bolinhas();

        System.out.println("Pressione qualquer tecla para continuar...");
        in.nextLine();
//        bol.ordenador();
//        bol.escreve();
//        System.out.println("Pressione qualquer tecla para continuar...");
//        in.nextLine();
        bol.intercalaCor();
        bol.escreve();

}

}
