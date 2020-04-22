package monopoly;

import java.util.ArrayList;

public class Cup {
    private ArrayList<Dice> dices;
    private int totalValue;

    public Cup(int numberOfDice) {
        dices = new ArrayList<>();
        for (int i = 0; i < numberOfDice; ++i){
            dices.add(new Dice());
        }
    }

    public void roll() {
        totalValue = 0;
        for (Dice dice : dices) {
            dice.roll();
            totalValue += dice.getFaceValue();
        }
    }

    public int getTotal() {
        return totalValue;
    }
}
