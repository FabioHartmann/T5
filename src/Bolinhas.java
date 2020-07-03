import java.util.Random;
public class Bolinhas {
    private Circle[][] circulos;

    public Bolinhas() {
        circulos = new Circle[8][8];
        inicializa();
    }

    public void inicializa() {
        String[] cores = {"red", "green", "blue"};
        Random gera = new Random();
        int k;
        for (int i = 0; i < circulos.length; i++) {
            for (int j = 0; j < circulos[i].length; j++) {
                k = gera.nextInt(cores.length);
                circulos[i][j] = new Circle();
                circulos[i][j].moveUp();
                circulos[i][j].changeColor(cores[k]);
                circulos[i][j].moveVertical(i * 30);
                circulos[i][j].moveHorizontal(30 * j);
                circulos[i][j].makeVisible();
            }
        }
        resetaPosicoes();
    }

    public void makeInvisible(){
        for (int i = 0; i < circulos.length; i++) {
            for (int j = 0; j < circulos[i].length; j++) {
                circulos[i][j].makeInvisible();
            }
        }
    }

    public void troca(int linha, int i, int j) {
        Circle aux = circulos[linha][i];
        circulos[linha][i] = circulos[linha][j];
        circulos[linha][j] = aux;
    }

    public void escreve() {
        for (int i = 0; i < circulos.length; i++) {
            for (int j = 0; j < circulos[i].length; j++) {
                circulos[i][j].moveUp();
                circulos[i][j].moveVertical(i * 30);
                circulos[i][j].moveHorizontal(30 * j);
                circulos[i][j].makeVisible();
            }
        }
    }

    public void resetaPosicoes() {
        for (int i = 0; i < circulos.length; i++) {
            for (int j = 0; j < circulos[i].length; j++) {
                circulos[i][j].reset();
            }
        }
    }

    public void ordenador(){
        for(int index = 0; index <8; index ++){
            Circle[] linha = this.circulos[index];
            for(int i = 0; i < linha.length; i++){

                for (int j = 0; j < linha.length-1; j++){
                    String primColor = linha[i].getColor(), secondColor = linha[j].getColor();

                    if((primColor == "red" && (secondColor =="green" || secondColor =="blue" ))
                            || primColor == "green" && secondColor=="blue" ){
                        troca(index,j,i);
                    }
                }
            }
            this.circulos[index]=linha;
        }

    }

    public void intercalaCor() {
        // Não ta bombando
        for(int index = 0; index <8; index ++){
            Circle[] linha = this.circulos[index];
            int redAmount = colorAmountLine("red", index);
            int greenAmount = colorAmountLine("green", index);
            int blueAmount = colorAmountLine("blue", index);
            for(int i = 0; i < linha.length - 1; i++){
                String primColor = linha[i].getColor(), secondColor = linha[i+1].getColor();


            }
            this.circulos[index]=linha;
        }
    }

    public int colorPosition(String color, int actualIndex, Circle[] line){
        int aux = -1;
        for(int i = actualIndex; i < line.length; i++){
            if(aux > -1 || i == 8) break;
            if(line[i].getColor() == color) aux = i;
        }
        if(aux < 0) aux = 0;
        return aux;
    }

    public int colorAmountLine(String cor, int line) {
        int amount = 0;
        Circle[] linha = circulos[line];
        for(int i = 0; i < 8; i++){
            if(linha[i].getColor() == cor) amount++;
        }
        return amount;
    }
//    Ainda com  bolinhas e considerando a matriz gerada, modifique-a, criando  um método na classe adequada que intercala as bolinhas.
//    Toda linha é composta por uma sequência de bolinhas nas cores vermelha, verde e depois azul (Vermelha,Verde,Azul,Vermelha,Verde,Azul,...).
//    As cores das bolinhas não estarão em quantidades iguais;
//    portanto, ao final, respeite apenas a ordem de cor.  É proibido trocar apenas as cores das bolinhas.

}