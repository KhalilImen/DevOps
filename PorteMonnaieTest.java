package monprojet;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class PorteMonnaieTest {

    private PorteMonnaie porteMonnaie;

    @Before
    public void setUp() {
        porteMonnaie = new PorteMonnaie();
    }

    @Test
    public void testAjouteSommeCoherence() throws UniteDistincteException {
        SommeArgent somme5Euro = new SommeArgent(5, "EUR");
        SommeArgent somme10Euro = new SommeArgent(10, "EUR");

        porteMonnaie.ajouteSomme(somme5Euro);
        porteMonnaie.ajouteSomme(somme5Euro);

        PorteMonnaie autrePorteMonnaie = new PorteMonnaie();
        autrePorteMonnaie.ajouteSomme(somme10Euro);

        PorteMonnaie expected = new PorteMonnaie();
        expected.ajouteSomme(somme5Euro);
        expected.ajouteSomme(somme10Euro);
        expected.getContenu();

        assertTrue(porteMonnaie.equals(autrePorteMonnaie));
        assertEquals(expected, porteMonnaie);
    }
}
