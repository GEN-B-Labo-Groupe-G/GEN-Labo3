/*
 -----------------------------------------------------------------------------------
 Laboratoire : 03
 Fichier     : Dice.java
 Auteur(s)   : Junod Christophe, Maillefer Dalia, Teofanovic Stefan
 Date        : 22.04.2020

 But         : Classe Dice ayant pour but de gérer les dés et leur action

 Remarque(s) : -

 -----------------------------------------------------------------------------------
*/

package monopoly;

import java.util.Random;

public class Dice {
    private int faceValue;

    /**
     * Méthode roll permettant de choisir aléatoirement un nombre entre 1 et 6
     */
    public void roll(){
        this.faceValue = new Random().nextInt(6) + 1;
    }

    /**
     * Getter retournant la valeur de la face
     * @return valeur du dés
     */
    public int getFaceValue(){
        return faceValue;
    }
}
