/*
 -----------------------------------------------------------------------------------
 Laboratoire : 03
 Fichier     : MonopolyGame.java
 Auteur(s)   : Junod Christophe, Maillefer Dalia, Teofanovic Stefan
 Date        : 22.04.2020

 But         : Modéliser les itérations 1 et 2 du jeu de rôle Monopoly

 Remarque(s) : -

 -----------------------------------------------------------------------------------
*/

package monopoly;

import monopoly.board.Board;
import java.util.ArrayList;
import java.util.Scanner;

public class MonopolyGame {
    private final int MAX_ROUNDS = 20;
    private int roundCount;
    private ArrayList<Player> players = new ArrayList<>();
    private Board board;
    private Cup cup;

    /**
     * Méthode init permettant à l'utilisateur, s'il n'a renseigné aucun argument en paramètre,
     * de définir le nombre de joueur (seul cas où le programme requiert l'input de l'utilisateur
     * @return le nombre de joueur
     */
    public static int init() {
        int numberOfPlayer;
        while(true) {
            System.out.println("Select the number of player between 2 and 8");
            Scanner scanner = new Scanner(System.in);
            if(scanner.hasNextInt()) { //Tant que ce n'est pas un entier, boucler
                numberOfPlayer = Integer.parseInt(scanner.nextLine());
                break;
            }
        }
        return numberOfPlayer;
    }

    /**
     * Constructeur MonopolyGame permettant de créer le jeu Monopoly
     * @param nbPlayer nombre de joueur
     */
    public MonopolyGame(int nbPlayer){

        //Lancer ce jeu en tant que simulation requiert aucune entrée utilisateur, autre que
        //le nombre de joueurs.
        if(nbPlayer < 2 || nbPlayer > 8) {
            throw new RuntimeException("Number must be between 2 and 8");
        }
        this.roundCount = 0;
        this.board = new Board(40);
        this.cup = new Cup(2);
        for(int i = 0; i < nbPlayer; ++i) {
            players.add(new Player(board, cup,i+1));
        }
    }

    /**
     * Méthode playGame permettant de lancer le jeu
     */
    public void playGame(){
        System.out.println("New Game");
        System.out.println("Number of player : " + players.size());
        System.out.println("Game Start");
        for(roundCount = 1; roundCount <= this.MAX_ROUNDS; ++roundCount){
            System.out.println("\nRound : " + roundCount);
            this.playRound();
        }
        System.out.println("Game Over");
    }

    /**
     * Méthode playRound permettant la gestion des tours pour chacun des joueurs
     */
    private void playRound(){
        for(Player player : this.players){
            player.takeTurn();
        }
    }

    public static void main(String... args){
        int numberOfPlayer = (args.length == 1) ? Integer.parseInt(args[0]) : init();
        MonopolyGame MpG = new MonopolyGame(numberOfPlayer);
        MpG.playGame();
    }
}