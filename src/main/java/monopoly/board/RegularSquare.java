/*
 -----------------------------------------------------------------------------------
 Laboratoire : 03
 Fichier     : RegularSquare.java
 Auteur(s)   : Junod Christophe, Maillefer Dalia, Teofanovic Stefan
 Date        : 22.04.2020

 But         : Classe RegularSquare ayant pour but de gérer une case régulière (non-spéciale)

 Remarque(s) : -

 -----------------------------------------------------------------------------------
*/

package monopoly.board;

import monopoly.Player;

public class RegularSquare extends Square {

    /**
     * Constructeur permettant la création d'une case régulière
     * @param name nom de la case
     */
    public RegularSquare(String name) {
        super(name);
    }

    /**
     * Méthode landedOn définissant l'action à faire lorsque le joueur tombe sur
     * une case normale. Ne définit rien de particulier donc aucune action
     * @param player
     */
    @Override
    public void landedOn(Player player) {
        // no action
    }
}
