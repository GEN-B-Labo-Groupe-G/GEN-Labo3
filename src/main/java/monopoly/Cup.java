/*
 -----------------------------------------------------------------------------------
 Laboratoire : 03
 Fichier     : Cup.java
 Auteur(s)   : Junod Christophe, Maillefer Dalia, Teofanovic Stefan
 Date        : 22.04.2020

 But         : Classe Cup permettant de gérer un cup contenant des dés

 Remarque(s) : -

 -----------------------------------------------------------------------------------
*/
package monopoly;

import java.util.ArrayList;

public class Cup {
    private ArrayList<Dice> dices;
    private int totalValue;

    /**
     * Constructeur permettant de créer un cup
     * @param numberOfDice le nombre de dés
     */
    public Cup(int numberOfDice) {
        dices = new ArrayList<>();
        for (int i = 0; i < numberOfDice; ++i){
            dices.add(new Dice());
        }
    }

    /**
     * Méthode roll permettant de lancer chacun des dés dans le cup
     */
    public void roll() {
        totalValue = 0;
        for (Dice dice : dices) {
            dice.roll();
            totalValue += dice.getFaceValue();
        }
    }

    /**
     * Getter retournant la somme des dés
     * @return le résultat
     */
    public int getTotal() {
        return totalValue;
    }
}
