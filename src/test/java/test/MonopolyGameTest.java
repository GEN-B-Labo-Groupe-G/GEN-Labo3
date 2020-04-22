/*
 -----------------------------------------------------------------------------------
 Laboratoire : 03
 Fichier     : MonopolyGameTest.java
 Auteur(s)   : Junod Christophe, Maillefer Dalia, Teofanovic Stefan
 Date        : 22.04.2020

 But         : Classe MonopolyGameTest ayant pour but de tester la classe MonopolyGame.java

 Remarque(s) : -

 -----------------------------------------------------------------------------------
*/

package test;

import monopoly.MonopolyGame;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MonopolyGameTest {

    @BeforeAll
    void testClassExist(){
        try {
            Class.forName("monopoly.MonopolyGame");
        } catch (ClassNotFoundException e) {
            Assertions.fail("Manque la classe MonopolyGame");
        }
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, -4, 5, 9 })
    void testCreateNewGameFail(int input) {
        if (input < 2 || input > 8)
            assertThrows(RuntimeException.class, () -> new MonopolyGame(input));
    }

}