/*
 -----------------------------------------------------------------------------------
 Laboratoire : 03
 Fichier     : RegularSquareTest.java
 Auteur(s)   : Junod Christophe, Maillefer Dalia, Teofanovic Stefan
 Date        : 22.04.2020

 But         : Classe RegularSquareTest ayant pour but de tester la classe RegularSquare.java

 Remarque(s) : -

 -----------------------------------------------------------------------------------
*/


package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RegularSquareTest {
    @BeforeAll
    void testClassExist(){
        try {
            Class.forName("monopoly.board.RegularSquare");
        } catch (ClassNotFoundException e) {
            Assertions.fail("Manque la classe RegularSquare");
        }
    }


}