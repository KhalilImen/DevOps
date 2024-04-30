package monprojet;

import static org.junit.Assert.*;

import monprojet.SommeArgent;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class SommeArgentTest2 {

    private SommeArgent m12CHF;
    private SommeArgent m14CHF;
    private SommeArgent m14USD;

    @Before
    public void setUp() {
        m12CHF = new SommeArgent(12, "CHF");
        m14CHF = new SommeArgent(14, "CHF");
        m14USD = new SommeArgent(14, "USD");
    }

    @Test
    public void testEqualsMethod() {
        assertTrue(!m12CHF.equals(null));
        assertEquals(m12CHF, m12CHF);
        assertEquals(m12CHF, new SommeArgent(12, "CHF")); // (1)
        assertTrue(!m12CHF.equals(m14CHF));
        assertTrue(!m14USD.equals(m14CHF));
    }

    @Test
    public void testAdditionSommeArgent() throws UniteDistincteException {
        SommeArgent result1 = m12CHF.add(m14CHF);
        assertEquals(new SommeArgent(26, "CHF"), result1);

        SommeArgent result2 = m14USD.add(m14CHF);
        // Ajoutez d'autres assertions pour les cas d'addition selon vos besoins
    }
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testAdditionSommeArgentWithDistinctUnits() throws UniteDistincteException {
        exceptionRule.expect(UniteDistincteException.class);
        exceptionRule.expectMessage("unité distincte : CHF != USD");

        m12CHF.add(m14USD);
    }

    @Test
    public void testAdditionSommeArgentWithSameUnits() throws UniteDistincteException {
        SommeArgent result1 = m12CHF.add(m14CHF);
        assertEquals(new SommeArgent(26, "CHF"), result1);
    }
    @Test
    public void testAdditionSommeArgentWithDistinctUnits2() {
        try {
            m12CHF.add(m14USD);
            // Si aucune exception n'est levée, le test échouera
            fail("Devrait lever une UniteDistincteException");
        } catch (UniteDistincteException e) {
            System.out.println("Exception capturée : " + e.toString());

            // Ajoutez des sorties de console pour vérifier les valeurs
            System.out.println("Chaîne attendue : unité distincte : CHF != USD");
            System.out.println("Valeur réelle : " + e.toString());

            assertEquals("unité distincte : CHF != USD", e.toString());
        }
    }













































































    @Test
    public void testAdditionSommeArgentWithSameUnits2() throws UniteDistincteException {
        SommeArgent result1 = m12CHF.add(m14CHF);
        assertEquals(new SommeArgent(26, "CHF"), result1);
    }

}
