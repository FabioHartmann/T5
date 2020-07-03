import java.util.Scanner;

public class AppE5 {
    public static void main(String[] args) {
        Bolinhas bolTask = new Bolinhas();

        Scanner t = new Scanner(System.in);

        System.out.println("Digite qualquer coisa para executar a tarefa 1:");
        t.nextLine();
        bolTask.ordenador();
        bolTask.escreve();
        System.out.println("Digite qualquer coisa para executar a tarefa 2:");
        t.nextLine();
        bolTask.intercalaCor();
        bolTask.escreve();
        System.out.println("Digite qualquer coisa para limpar o circulos e ir aos quadradinhos:");
        t.nextLine();
        bolTask.makeInvisible();
        Quadradinhos quadTask = new Quadradinhos();
        System.out.println("Digite qualquer coisa para executar a tarefa 3:");
        t.nextLine();
        quadTask.ordenaPorCor();
        quadTask.escreve();
        System.out.println("Digite qualquer coisa para executar a tarefa 4:");
        t.nextLine();
        int[][] corPorLinha = quadTask.contaCorPorLinha();
        for (int i = 0; i < corPorLinha.length; i++) {
            int linha = i+1;
            System.out.println("Linha " + linha);
            System.out.println("Black: " + corPorLinha[i][0]);
            System.out.println("Blue: " + corPorLinha[i][1]);
            System.out.println("-----------------------------");
        }
    }
}
