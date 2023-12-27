/*
 -----------------------------------------------------------------------------------
 Laboratoire : 03
 Fichier     : GoSquareTest.java
 Auteur(s)   : Junod Christophe, M. D., Teofanovic Stefan
 Date        : 22.04.2020

 But         : Classe GoSquareTest ayant pour but de tester la classe GoSquare.java

 Remarque(s) : -

 -----------------------------------------------------------------------------------
*/

package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GoSquareTest {
    @BeforeAll
    void testClassExist(){
        try {
            Class.forName("monopoly.board.GoSquare");
        } catch (ClassNotFoundException e) {
            Assertions.fail("Manque la classe GoSquare");
        }
    }
}