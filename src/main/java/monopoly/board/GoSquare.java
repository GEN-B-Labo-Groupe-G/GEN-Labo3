package monopoly.board;

import monopoly.Player;

public class GoSquare extends Square {

    public GoSquare(String name) {
        super(name);
    }

    @Override
    public void landedOn(Player player) {
        int money = 200;
        System.out.println(player.getName() + " collect $" + money);
        player.addCash(money);
        System.out.println(player.getName() + " money is now $" + player.getNetWorth());
    }
}
