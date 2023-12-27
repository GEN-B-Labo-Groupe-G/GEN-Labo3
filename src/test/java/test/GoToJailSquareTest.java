/*
 -----------------------------------------------------------------------------------
 Laboratoire : 03
 Fichier     : GoToJailSquareTest.java
 Auteur(s)   : Junod Christophe, M. D., Teofanovic Stefan
 Date        : 22.04.2020

 But         : Classe GoToJailSquareTest ayant pour but de tester la classe GoToJailSquare.java

 Remarque(s) : -

 -----------------------------------------------------------------------------------
*/

package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GoToJailSquareTest {
    @BeforeAll
    void testClassExist(){
        try {
            Class.forName("monopoly.board.GoToJailSquare");
        } catch (ClassNotFoundException e) {
            Assertions.fail("Manque la classe GoToJailSquare");
        }
    }
}