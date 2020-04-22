/*
 -----------------------------------------------------------------------------------
 Laboratoire : 03
 Fichier     : Board.java
 Auteur(s)   : Junod Christophe, Maillefer Dalia, Teofanovic Stefan
 Date        : 22.04.2020

 But         : Classe Board ayant pour but de gérer la création du plateau avec ces cases

 Remarque(s) : -

 -----------------------------------------------------------------------------------
*/

package monopoly.board;

import java.util.ArrayList;
import java.util.Arrays;

public class  Board {
    private ArrayList<Square> squares;

    /**
     * Constructeur Board qui crée le plateau et les cases qu'elles soient régulières ou spéciales
     * @param size nombre de cases du plateau
     */
    public Board(int size){
        this.squares = new ArrayList<>(Arrays.asList(new Square[40]));
        for (int i = 1; i < size; ++i) {
            if (i != 4 && i != 30) {
                squares.set(i, new RegularSquare("Square " + i));
            }
        }
        squares.set(0, new GoSquare("Go"));
        squares.set(4, new IncomeTaxSquare("Income Tax",10, 200));
        squares.set(30, new GoToJailSquare("GoToJail", squares.get(10)));
    }

    /**
     * Méthode getSquare permettant d'obtenir la case en fonction d'une position relative
     * @param originLocation la position d'origine
     * @param valueOffset la valeur
     * @return la case
     */
    public Square getSquare(Square originLocation, int valueOffset) {
        return this.getSquare((squares.indexOf(originLocation) + valueOffset) % squares.size());
    }

    /**
     * Méthode getSquare permettant d'obtenir la case en fonction d'une position absolue
     * @param num le numéro
     * @return la case
     */
    public Square getSquare(int num) {
        return squares.get(num);
    }
}
