//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.Random;

public class Quadradinhos {
    private Square[][] quadrados = new Square[8][8];

    public Quadradinhos() {
        this.inicializa();
    }

    public void inicializa() {
        String[] cores = new String[]{"black", "blue"};
        Random gera = new Random();

        for(int i = 0; i < this.quadrados.length; ++i) {
            for(int j = 0; j < this.quadrados[i].length; ++j) {
                int k = gera.nextInt(cores.length);
                this.quadrados[i][j] = new Square();
                this.quadrados[i][j].moveUp();
                this.quadrados[i][j].moveLeft();
                this.quadrados[i][j].moveLeft();
                this.quadrados[i][j].changeColor(cores[k]);
                this.quadrados[i][j].moveVertical(i * 31);
                this.quadrados[i][j].moveHorizontal(31 * j);
                this.quadrados[i][j].makeVisible();
            }
        }
        resetaPosicoes();

    }
    public void resetaPosicoes() {
        for (int i = 0; i < quadrados.length; i++) {
            for (int j = 0; j < quadrados[i].length; j++) {
                quadrados[i][j].reset();
            }
        }
    }


    public void escreve() {
        for (int i = 0; i < quadrados.length; i++) {
            for (int j = 0; j < quadrados[i].length; j++) {
                quadrados[i][j].moveUp();
                quadrados[i][j].moveVertical(i * 31);
                quadrados[i][j].moveHorizontal(31 * j);
                quadrados[i][j].moveLeft();
                quadrados[i][j].moveLeft();
                quadrados[i][j].makeVisible();
            }
        }
    }

    public void troca(int linha1, int i1, int linha2, int i2){
        Square aux1 = quadrados[linha1][i1];
        quadrados[linha1][i1] = quadrados[linha2][i2];
        quadrados[linha2][i2] = aux1;
    }

    public void ordenaPorCor(){
        for(int i = 0; i < 100; i++){
            if(checkBlackOrder()){
                break;
            }
            int[] firstBlue = searchFirstBlue();
            int[] lastBlack = searchLastBlack();
            troca(firstBlue[0], firstBlue[1], lastBlack[0],lastBlack[1]);
        }
    }

    public boolean checkBlackOrder(){
        int blackAmount = blackAmount(), cont = 0;
        boolean isInOrder = false, aux = false;
        for(int index = 0; index < 8; index++) {
            for (int i = 0; i < 8; i++) {
                if (quadrados[index][i].getColor() == "blue"){
                    aux= true;
                    if(aux) break;
                } else cont ++;
            }
            if(aux) break;
        }
        if(cont == blackAmount) isInOrder = true;
        return isInOrder;
    }

    public int blackAmount(){
        int cont = 0;
        for(int index = 0; index < 8; index++) {
            for (int i = 0; i < 8; i++) {
                if (quadrados[index][i].getColor() == "black") cont++;
            }
        }
        return cont;
    }

    public int[] searchFirstBlue(){
        int[] position = new int[2];
        boolean aux = false;
        for(int index = 0; index < 8; index++){
            Square[] linha = this.quadrados[index];
            for(int i = 0; i < 8; i++){
                if(linha[i].getColor() == "blue"){
                    position[0] = index;
                    position[1] = i;
                    aux = true;
                }
                if(aux) break;
            }
            if(aux) break;
        }
        return  position;
    }

    public int[] searchLastBlack(){
        int[] position = new int[2];
        boolean aux = false;
        for(int index = 7; index >= 0; index--){
            Square[] linha = this.quadrados[index];
            for(int i =7; i >= 0; i--){
                if(linha[i].getColor() == "black"){
                    position[0] = index;
                    position[1] = i;
                    aux = true;
                }
                if(aux) break;
            }
            if(aux) break;
        }
        return position;
    }

    public int[][] contaCorPorLinha(){
        int[][] info = new int[8][2];
        for(int index = 0; index < 8; index++){
            for(int i = 0; i<8; i++){
                if(quadrados[index][i].getColor() == "black"){
                    info[index][0]++;
                }else{
                    info[index][1]++;
                }
            }
        }

        return info;
    }
}
