package monopoly.board;

import monopoly.Player;

public class GoToJailSquare extends Square {

    private Square jail;

    public GoToJailSquare(String name, Square jail) {
        super(name);
        this.jail = jail;
    }

    @Override
    public void landedOn(Player player) {
        System.out.println(player.getName() + " go to jail");
        player.setLocation(jail);
    }
}
