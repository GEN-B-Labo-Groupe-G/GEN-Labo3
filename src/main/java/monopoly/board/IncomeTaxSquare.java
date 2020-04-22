/*
 -----------------------------------------------------------------------------------
 Laboratoire : 03
 Fichier     : IncomeTaxSquare.java
 Auteur(s)   : Junod Christophe, Maillefer Dalia, Teofanovic Stefan
 Date        : 22.04.2020

 But         : Classe IncomeTaxSquare ayant pour but de gérer la case de gain de taxes

 Remarque(s) : -

 -----------------------------------------------------------------------------------
*/

package monopoly.board;

import monopoly.Player;

public class IncomeTaxSquare extends Square {
    int moneyMin;
    int percentMoney;

    /**
     * Constructeur de la case de taxes
     * @param name nom de la case
     * @param incomePercentToPay montant en pourcentage à verser
     * @param minMoneyToPay montant en dollar à verser au minimum
     */
    public IncomeTaxSquare(String name, int incomePercentToPay ,int minMoneyToPay) {
        super(name);
        this.percentMoney = incomePercentToPay;
        this.moneyMin = minMoneyToPay;
    }

    /**
     * Méthode décrivant l'action à faire lorsque player tombe sur la case IncomeTax
     * @param player un joueur
     */
    @Override
    public void landedOn(Player player) {
        int money = player.getNetWorth();
        money = Math.min(moneyMin, percentMoney*money/100); //Définir le minimum entre le montant et le pourcentage
        System.out.println(player.getName() + " must pay $" + money);
        player.reduceCash(money); //retire l'argent
        System.out.println(player.getName() + " money is now $" + player.getNetWorth());
    }
}
