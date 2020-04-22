package test;

import monopoly.Cup;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CupTest {
    @BeforeAll
    void testClassExist(){
        System.out.println("Vérification de l'existance de la class et initialisation");
        try {
            Class.forName("monopoly.Cup");
        } catch (ClassNotFoundException e) {
            Assertions.fail("Manque la classe Cup");
        }

    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 5})
    void testRoll(int dice){
        System.out.println("Execution du test répété sur roll pour " + dice + " dés");
        int MAX_FACE_VALUE = 6 * dice;
        int MIN_FACE_VALUE = 1 * dice;

        for (int i = 0; i < 20; ++i) {
            Cup cup = new Cup(dice);
            cup.roll();
            System.out.println("Face Value : " + cup.getTotal() + " | MIN : " + MIN_FACE_VALUE + " MAX : " + MAX_FACE_VALUE);
            Assertions.assertFalse(cup.getTotal() > MAX_FACE_VALUE, "Error, roll to high");
            Assertions.assertFalse(cup.getTotal() < MIN_FACE_VALUE, "Error, roll to low");
        }
    }
}