/*
 -----------------------------------------------------------------------------------
 Laboratoire : 03
 Fichier     : PlayerTest.java
 Auteur(s)   : Junod Christophe, Maillefer Dalia, Teofanovic Stefan
 Date        : 22.04.2020

 But         : Classe PlayerTest ayant pour but de tester la classe Player.java

 Remarque(s) : -

 -----------------------------------------------------------------------------------
*/


package test;

import monopoly.Cup;
import monopoly.Player;
import monopoly.board.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PlayerTest {
    private Player player;
    private Board board;

    @BeforeAll
    void testClassExist(){
        try {
            Class.forName("monopoly.Player");
        } catch (ClassNotFoundException e) {
            Assertions.fail("Manque la classe Player");
        }
        board = new Board(40);
        player = new Player(board, new Cup(2), "Player");
    }

    @Test
    void testPlayerCash() {
        System.out.println("Vérification des modifications de l'argent du joueur");
        Assertions.assertEquals(1500, player.getNetWorth());
        player.addCash(1000);
        Assertions.assertEquals(2500, player.getNetWorth());
        player.reduceCash(250);
        Assertions.assertEquals(2250, player.getNetWorth());
    }

    @Test
    void testPlayerMove() {
        System.out.println("Vérification des déplacements du joueur");
        Assertions.assertAll(
                () -> player.setLocation(new RegularSquare("nouvelle case")),
                () -> player.setLocation(new GoSquare("Go")),
                () -> player.setLocation(new GoToJailSquare("GoToJail", new RegularSquare("Jail"))),
                () -> player.setLocation(new IncomeTaxSquare("Income Tax", 10, 200)));
    }

    @Test
    void testPlayerTurn() {
        System.out.println("Vérification du tour du joueur");
        Assertions.assertAll(() -> player.takeTurn());
    }
}