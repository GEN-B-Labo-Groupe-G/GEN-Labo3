/*
 -----------------------------------------------------------------------------------
 Laboratoire : 03
 Fichier     : SquareTest.java
 Auteur(s)   : Junod Christophe, Maillefer Dalia, Teofanovic Stefan
 Date        : 22.04.2020

 But         : Classe SquareTest ayant pour but de tester la classe Square.java

 Remarque(s) : -

 -----------------------------------------------------------------------------------
*/
package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SquareTest {
    @BeforeAll
    void testClassExist(){
        try {
            Class.forName("monopoly.board.Square");
        } catch (ClassNotFoundException e) {
            Assertions.fail("Manque la classe Square");
        }
    }
}