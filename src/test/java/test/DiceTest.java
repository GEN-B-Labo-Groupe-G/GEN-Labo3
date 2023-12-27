/*
 -----------------------------------------------------------------------------------
 Laboratoire : 03
 Fichier     : DiceTest.java
 Auteur(s)   : Junod Christophe, M. D., Teofanovic Stefan
 Date        : 22.04.2020

 But         : Classe DiceTest ayant pour but de tester la classe Dice.java

 Remarque(s) : -

 -----------------------------------------------------------------------------------
*/

package test;

import monopoly.Dice;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DiceTest {
    private Dice dice;

    @BeforeAll
    void init(){
        System.out.println("Vérification de l'existance de la class et initialisation");
        try {
            Class.forName("monopoly.Dice");
        } catch (ClassNotFoundException e) {
            Assertions.fail("Manque la Dice Board");
        }
        dice = new Dice();
    }

    @RepeatedTest(20)
    void testRoll(){
        int MAX_FACE_VALUE = 6;
        int MIN_FACE_VALUE = 1;
        System.out.println("Execution du test répété sur roll");
        dice.roll();
        System.out.println("Face Value : " + dice.getFaceValue() + " | MIN : " + MIN_FACE_VALUE + " MAX : " + MAX_FACE_VALUE);
        Assertions.assertFalse( dice.getFaceValue() > MAX_FACE_VALUE, "Error, roll to high");
        Assertions.assertFalse( dice.getFaceValue() < MIN_FACE_VALUE, "Error, roll to low");
    }
}