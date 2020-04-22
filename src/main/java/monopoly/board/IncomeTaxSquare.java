package monopoly.board;

import monopoly.Player;

public class IncomeTaxSquare extends Square {
    int moneyMin;
    int percentMoney;

    public IncomeTaxSquare(String name, int incomePercentToPay ,int minMoneyToPay) {
        super(name);
        this.percentMoney = incomePercentToPay;
        this.moneyMin = minMoneyToPay;
    }

    @Override
    public void landedOn(Player player) {
        int money = player.getNetWorth();
        money = Math.min(moneyMin, percentMoney*money/100);
        System.out.println(player.getName() + " must pay $" + money);
        player.reduceCash(money);
        System.out.println(player.getName() + " money is now $" + player.getNetWorth());
    }
}
