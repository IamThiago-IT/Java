import java.util.Scanner;

public class jogoVelha {
    static String[][] tabuleiro = new String[3][3];
    
    public static boolean verJogada(String simbolo, int x, int y){
       boolean vencedor = false;
       if(x==0 && y==0){
           if((tabuleiro[0][1].equals(simbolo) && tabuleiro[0][2].equals(simbolo)) ||
              (tabuleiro[1][0].equals(simbolo) && tabuleiro[2][0].equals(simbolo)) ||
              (tabuleiro[1][1].equals(simbolo) && tabuleiro[2][2].equals(simbolo))){
               vencedor = true;
           }
       }
       if(x==0 && y==1){
           if((tabuleiro[0][0].equals(simbolo) && tabuleiro[0][2].equals(simbolo)) ||
              (tabuleiro[1][1].equals(simbolo) && tabuleiro[2][1].equals(simbolo))){
               vencedor = true;
           }
           
       }
       if(x==0 && y==2){
           if((tabuleiro[0][1].equals(simbolo) && tabuleiro[0][0].equals(simbolo)) ||
              (tabuleiro[1][2].equals(simbolo) && tabuleiro[2][2].equals(simbolo)) ||
              (tabuleiro[1][1].equals(simbolo) && tabuleiro[2][0].equals(simbolo))){
               vencedor = true;
           }
       }
       
       if(x==1 && y==0){
           if((tabuleiro[0][0].equals(simbolo) && tabuleiro[2][0].equals(simbolo)) ||
              (tabuleiro[1][1].equals(simbolo) && tabuleiro[1][2].equals(simbolo))){
               vencedor = true;
           }
       }
       if(x==1 && y==1){
           if((tabuleiro[0][1].equals(simbolo) && tabuleiro[2][1].equals(simbolo)) ||
              (tabuleiro[1][0].equals(simbolo) && tabuleiro[1][2].equals(simbolo)) ||
              (tabuleiro[0][0].equals(simbolo) && tabuleiro[2][2].equals(simbolo)) ||
              (tabuleiro[0][2].equals(simbolo) && tabuleiro[2][0].equals(simbolo))){
               vencedor = true;
           }
       }
       if(x==1 && y==2){
           if((tabuleiro[0][2].equals(simbolo) && tabuleiro[2][2].equals(simbolo)) ||
              (tabuleiro[1][1].equals(simbolo) && tabuleiro[1][0].equals(simbolo))){
               vencedor = true;
           }
       }
       
       if(x==2 && y==0){
           if((tabuleiro[0][0].equals(simbolo) && tabuleiro[1][0].equals(simbolo)) ||
              (tabuleiro[2][1].equals(simbolo) && tabuleiro[2][2].equals(simbolo)) ||
              (tabuleiro[1][1].equals(simbolo) && tabuleiro[0][2].equals(simbolo))){
               vencedor = true;
           }
       }
       if(x==2 && y==1){
           if((tabuleiro[2][0].equals(simbolo) && tabuleiro[2][2].equals(simbolo)) ||
              (tabuleiro[1][1].equals(simbolo) && tabuleiro[0][1].equals(simbolo))){
               vencedor = true;
           }
       }
       if(x==2 && y==2){
           if((tabuleiro[2][1].equals(simbolo) && tabuleiro[2][0].equals(simbolo)) ||
              (tabuleiro[1][2].equals(simbolo) && tabuleiro[0][2].equals(simbolo)) ||
              (tabuleiro[1][1].equals(simbolo) && tabuleiro[0][0].equals(simbolo))){
               vencedor = true;
           }
       }
       return vencedor;
    }

    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        int jogador = 1;
        boolean vencedor = false;
        int jogadas = 0;

        // preenche os índices da matriz com uma string vazia
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = "-";
            }
        }

        while (!vencedor && jogadas < 9) {
            java.util.Scanner s = new Scanner(System.in);
            System.out.println("X (Linha): ");
            x = s.nextInt();
            while(x<0 || x>2){
                System.out.println("Índice da linha inválido\nX (Linha): ");
                s = new Scanner(System.in);
                x = s.nextInt();
            }
            s = new Scanner(System.in);
            System.out.println("Y (Coluna): ");
            y = s.nextInt();
            while(y<0 || y>2){
                System.out.println("Índice da coluna inválido\nY (Coluna): ");
                s = new Scanner(System.in);
                y = s.nextInt();
            }
            
            boolean jogada = false;

            if (jogador == 1) {
                try {
                    if (!tabuleiro[x][y].equals("X") && !tabuleiro[x][y].equals("Y")) {
                        tabuleiro[x][y] = "X";
                        jogada = true;
                        jogadas++;
                        vencedor = verJogada("X", x, y);
                    } else {
                        System.out.println("\n Posição já preenchida. \n");
                        jogada = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    if (!tabuleiro[x][y].equals("X") && !tabuleiro[x][y].equals("Y")) {
                        tabuleiro[x][y] = "O";
                        jogada = true;
                        jogadas++;
                        vencedor = verJogada("O", x, y);
                    } else {
                        System.out.println("\nPosição já preenchida.");
                        jogada = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            
            if (jogada && !vencedor) {
                if (jogador == 1) {
                    jogador = 2;
                } else {
                    jogador = 1;
                }
            }

            String matriz = "\n";
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    matriz += tabuleiro[i][j] + " ";
                }
                matriz += "\n";
            }
            System.out.println(matriz);
        }
        
        if(vencedor){
            System.out.println("Jogador "+jogador+" foi o vencedor.");
        }else{
            System.out.println("Jogo terminou empatado.");
        }
        
        
    }

}
