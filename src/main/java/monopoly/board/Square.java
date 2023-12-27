/*
 -----------------------------------------------------------------------------------
 Laboratoire : 03
 Fichier     : Square.java
 Auteur(s)   : Junod Christophe, M. D., Teofanovic Stefan
 Date        : 22.04.2020

 But         : Classe abstraite GoSquare définissant les méthodes pour ses classes filles

 Remarque(s) : -

 -----------------------------------------------------------------------------------
*/

package monopoly.board;

import monopoly.Player;

public abstract class Square {

    private String name;

    /**
     * Constructeur permettant de créer une case
     * @param name un nom
     */
    public Square(String name) {
        this.name = name;
    }

    /**
     * Getter permettant de récupérer le nom de la case
     * @return le nom
     */
    public String getName() {
        return name;
    }

    /**
     * Méthode abstraite définie dans ses classes filles respective
     * @param player un joueur
     */
    public abstract void landedOn(Player player);
}
