/*
 -----------------------------------------------------------------------------------
 Laboratoire : 03
 Fichier     : Player.java
 Auteur(s)   : Junod Christophe, Maillefer Dalia, Teofanovic Stefan
 Date        : 22.04.2020

 But         : Classe Player ayant pour but de gérer les players et leur action

 Remarque(s) : -

 -----------------------------------------------------------------------------------
*/

package monopoly;

import monopoly.board.Board;
import monopoly.board.Square;

public class Player {
    private Square location;
    private Cup cup;
    private Board board;
    private int cash;
    private String name;

    /**
     * Constructeur permettant de définir un joueur
     * @param board le plateau de jeu
     * @param cup le cup contenant les dés
     * @param name le nom du joueur
     */
    public Player(Board board, Cup cup, String name){
        this.board = board;
        this.location = board.getSquare(0);
        this.cup = cup;
        this.cash = 1500;
        this.name = name;
    }

    /**
     * Getter retournant le nom du joueur
     * @return nom du joueur
     */
    public String getName() {
        return name;
    }

    /**
     * Setter permettant d'ajouter un income au montant total du joueur
     * @param income somme d'argent
     */
    public void addCash(int income) {
        this.cash += income;
    }

    /**
     * Méthode takeTurn définissant les actions que doit faire un joueur
     */
    public void takeTurn() {
        cup.roll();
        int result = cup.getTotal();
        System.out.println(name + " rolled " + result);
        Square newLoc = board.getSquare(location, result);
        location = newLoc;
        System.out.println(name + " landed on " + location.getName());
        newLoc.landedOn(this);
    }

    /**
     * Setter définissant la nouvelle position
     * @param location la case
     */
    public void setLocation(Square location) {
        this.location = location;
    }

    /**
     * Getter retournant le montant actuel net
     * @return le montant
     */
    public int getNetWorth() {
        return cash;
    }

    /**
     * Méthode reduceCash permettant de retirer l'argent du montant du joueur
     * On suppose que si ce montant est négative, cela devient alors une dette
     * @param money montant à soustraire
     */
    public void reduceCash(int money) {
        this.cash -= money;
    }
}