/*
 -----------------------------------------------------------------------------------
 Laboratoire : 03
 Fichier     : BoardTest.java
 Auteur(s)   : Junod Christophe, M. D., Teofanovic Stefan
 Date        : 22.04.2020

 But         : Classe BoardTest ayant pour but de tester la classe Board.java

 Remarque(s) : -

 -----------------------------------------------------------------------------------
*/

package test;

import monopoly.board.Board;
import monopoly.board.Square;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BoardTest {
    Board board;

    @BeforeAll
    void testClassExist(){
        try {
            Class.forName("monopoly.board.Board");
        } catch (ClassNotFoundException e) {
            Assertions.fail("Manque la classe Board");
        }
        System.out.println("Crée le board et vérifie que son contenu existe");
        board = new Board(40);
        Assertions.assertEquals(40, board.getSize(), "Erreur : Le board n'a pas la bonne taille");
        for (int i = 0; i < board.getSize(); ++i) {
            Assertions.assertNotNull(board.getSquare(i), "Erreur : La position " + i + " du tableau est vide");
        }
    }

    @RepeatedTest(40)
    void testContentBoardAccessAbsolue(RepetitionInfo testInfo) {
        int indice = testInfo.getCurrentRepetition() - 1;
        Square location = board.getSquare(indice);

        System.out.println("La position " + indice + " contient la case " + location.getName());
        if (indice == 0) {
            Assertions.assertEquals("Go", location.getName());
        } else if (indice == 4) {
            Assertions.assertEquals("Income Tax", location.getName());
        } else if (indice == 30) {
            Assertions.assertEquals("GoToJail", location.getName());
        } else {
            Assertions.assertEquals("Square " +indice, location.getName());
        }
    }

    @Test
    void testContentBoardAccessRelative() {
        Square loc = board.getSquare(3);
        System.out.println("Vérification l'accès relatif des cases du plateau");
        Assertions.assertEquals("Square 3", board.getSquare(loc,0).getName());
        Assertions.assertEquals("Income Tax", board.getSquare(loc,1).getName());
        Assertions.assertEquals("Square 13", board.getSquare(loc,10).getName());
        Assertions.assertEquals("Square 39", board.getSquare(loc,-4).getName());
        Assertions.assertEquals("Square 13", board.getSquare(loc,50).getName());

    }
}