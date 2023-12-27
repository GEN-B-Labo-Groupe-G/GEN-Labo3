/*
 -----------------------------------------------------------------------------------
 Laboratoire : 03
 Fichier     : GoSquare.java
 Auteur(s)   : Junod Christophe, M. D., Teofanovic Stefan
 Date        : 22.04.2020

 But         : Classe GoSquare ayant pour but de gérer la case de départ

 Remarque(s) : -

 -----------------------------------------------------------------------------------
*/

package monopoly.board;

import monopoly.Player;

public class GoSquare extends Square {

    /**
     * Constructeur GoSquare
     * @param name Nom de la case GoSquare
     */
    public GoSquare(String name) {
        super(name);
    }

    /**
     * Méthode décrivant l'action à faire lorsque player tombe sur la case Go
     * @param player un joueur
     */
    @Override
    public void landedOn(Player player) {
        int money = 200;
        System.out.println(player.getName() + " collect $" + money);
        player.addCash(money);
        System.out.println(player.getName() + " money is now $" + player.getNetWorth());
    }
}
