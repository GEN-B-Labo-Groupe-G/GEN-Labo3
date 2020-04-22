package monopoly.board;

import monopoly.Player;

public class RegularSquare extends Square {

    public RegularSquare(String name) {
        super(name);
    }

    @Override
    public void landedOn(Player player) {
        // no action
    }
}
