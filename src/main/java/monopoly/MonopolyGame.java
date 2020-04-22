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


    public static int init() {
        int numberOfPlayer;
        while(true) {
            System.out.println("Select the number of player between 2 and 8");
            Scanner scanner = new Scanner(System.in);
            if(scanner.hasNextInt()) {
                numberOfPlayer = Integer.parseInt(scanner.nextLine());
                break;
            }
        }
        return numberOfPlayer;
    }

    public MonopolyGame(int nbPlayer){
        //Run the game as a simulation requiring no user input, other than the number of
        //players.
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