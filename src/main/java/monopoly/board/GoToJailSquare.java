/*
 -----------------------------------------------------------------------------------
 Laboratoire : 03
 Fichier     : GoToJailSquare.java
 Auteur(s)   : Junod Christophe, Maillefer Dalia, Teofanovic Stefan
 Date        : 22.04.2020

 But         : Classe GoToJailSquare ayant pour but de gérer la case de la prison

 Remarque(s) : -

 -----------------------------------------------------------------------------------
*/

package monopoly.board;

import monopoly.Player;

public class GoToJailSquare extends Square {

    private Square jail;

    /**
     * Constructeur permettant de créer la case Prison
     * @param name nom de la case
     * @param jail position de la case Prison
     */
    public GoToJailSquare(String name, Square jail) {
        super(name);
        this.jail = jail;
    }

    /**
     * Méthode décrivant l'action à faire lorsque player tombe sur la case GoToJail
     * @param player un joueur
     */
    @Override
    public void landedOn(Player player) {
        System.out.println(player.getName() + " go to jail");
        player.setLocation(jail);
    }
}
