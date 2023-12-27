/*
 -----------------------------------------------------------------------------------
 Laboratoire : 03
 Fichier     : IncomeTaxSquareTest.java
 Auteur(s)   : Junod Christophe, M. D., Teofanovic Stefan
 Date        : 22.04.2020

 But         : Classe IncomeTaxSquareTest ayant pour but de tester la classe IncomeTaxSquare.java

 Remarque(s) : -

 -----------------------------------------------------------------------------------
*/

package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IncomeTaxSquareTest {
    @BeforeAll
    void testClassExist(){
        try {
            Class.forName("monopoly.board.IncomeTaxSquare");
        } catch (ClassNotFoundException e) {
            Assertions.fail("Manque la classe IncomeTaxSquare");
        }
    }
}