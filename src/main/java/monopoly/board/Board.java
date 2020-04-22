package monopoly.board;

import java.util.ArrayList;
import java.util.Arrays;

public class  Board {
    private ArrayList<Square> squares;

    public Board(int size){
        this.squares = new ArrayList<>(Arrays.asList(new Square[40]));
        for (int i = 1; i < size; ++i) {
            if (i != 4 && i != 30) {
                squares.set(i, new RegularSquare("Square " + i));
            }
        }
        squares.set(0, new GoSquare("Go"));
        squares.set(4, new IncomeTaxSquare("Income Tax",10, 200));
        squares.set(30, new GoToJailSquare("GoToJail", squares.get(10)));
    }

    public int getSize() {
        return squares.size();
    }

    // Position relatif
    public Square getSquare(Square originLocation, int valueOffset) {
        return this.getSquare(Math.floorMod(squares.indexOf(originLocation) + valueOffset, squares.size()));
    }

    // Position absolue
    public Square getSquare(int num) throws IndexOutOfBoundsException {
        return squares.get(num);
    }
}