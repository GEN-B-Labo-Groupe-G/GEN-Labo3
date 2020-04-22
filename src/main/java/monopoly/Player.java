package monopoly;

import monopoly.board.Board;
import monopoly.board.Square;

public class Player {
    private Square location;
    private Cup cup;
    private Board board;
    private int cash;
    private String name;

    public Player(Board board, Cup cup, String name){
        this.board = board;
        this.location = board.getSquare(0);
        this.cup = cup;
        this.cash = 1500;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCash(int income) {
        this.cash += income;
    }

    public void takeTurn() {
        cup.roll();
        int result = cup.getTotal();
        System.out.println(name + " rolled " + result);
        Square newLoc = board.getSquare(location, result);
        location = newLoc;
        System.out.println(name + " landed on " + location.getName());
        newLoc.landedOn(this);
    }

    public void setLocation(Square location) {
        this.location = location;
    }

    public int getNetWorth() {
        return cash;
    }

    //What if 0$ left ? debt I suppose ?
    public void reduceCash(int money) {
        this.cash -= money;
    }
}
© 2020 GitHub, Inc.