package com.Hafiza;

import java.util.Scanner;

public class Main {

    private static Card[][]  cards = new Card[4][4]; // Kartların metodda gözükmesi için buraya eklendi

    public static void main(String[] args) {




        cards [0][0] = new Card('E');
        cards [0][1] = new Card('A');
        cards [0][2] = new Card('B');
        cards [0][3] = new Card('F');
        cards [1][0] = new Card('G');
        cards [1][1] = new Card('A');
        cards [1][2] = new Card('D');
        cards [1][3] = new Card('H');
        cards [2][0] = new Card('F');
        cards [2][1] = new Card('C');
        cards [2][2] = new Card('D');
        cards [2][3] = new Card('H');
        cards [3][0] = new Card('E');
        cards [3][1] = new Card('G');
        cards [3][2] = new Card('B');
        cards [3][3] = new Card('C');

        while (finish() == false){
            game();
            guess();
        }
    }

    public static void guess(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("1. Tahmin: Tahminleri bir boşluklu giriniz..");
        int i1 = scanner.nextInt();
        int j1 = scanner.nextInt();

        cards[i1][j1].setGuess(true);
        game();

        System.out.print("2. Tahmin: Tahminleri bir boşluklu giriniz..");
        int i2 = scanner.nextInt();
        int j2 = scanner.nextInt();
        cards[i2][j2].setGuess(true);
        game();





        if (cards[i1][j1].getValue() == cards[i2][j2].getValue()){
            System.out.println("Doğru Tahmin. Tebrikler!");
            cards[i2][j2].setGuess(true);
        }
        else {
            cards[i1][j1].setGuess(false);
            cards[i2][j2].setGuess(false);
            System.out.println("Yanlış Tahmin...");
        }
    }
    public static boolean finish(){
        for (int i = 0 ; i < 4 ; i++){
            for (int j = 0 ; j < 4 ; j++){
                if (cards[i][j].isGuess()==false){
                    return false;
                }
            }
        }
        return true;
    }
    public static void game(){

        for (int i = 0; i < 4 ; i++){
            for (int j = 0 ; j < 4 ; j++){
                if (cards[i][j].isGuess()){
                    System.out.print("   " + cards[i][j].getValue()+" ");
                }
                else {
                    System.out.print("  *  ");
                }

            }
            System.out.println("    ");
        }

    }
}
