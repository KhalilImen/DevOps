package monprojet;

import junit.framework.TestCase;
import org.junit.Assert;

public class SommeArgentTest extends TestCase {
    @Test
    public void testCreationSommeArgent() {
        SommeArgent somme = new SommeArgent(100, "USD");
        assertEquals(100, somme.getQuantite());
        assertEquals("USD", somme.getUnite());
    }

    @Test
    public void testAdditionSommeArgent() throws UniteDistincteException {
        SommeArgent somme1 = new SommeArgent(50, "EUR");
        SommeArgent somme2 = new SommeArgent(30, "EUR");
        SommeArgent result = somme1.add(somme2);

        assertEquals(new SommeArgent(80, "EUR"), result);
    }
@org.testng.annotations.Test
    public void testTessomme(){
        SommeArgent somme3  = new SommeArgent(50,"EUR");
        assertEquals(100, somme3.getQuantite());
    }
    @Test
    public void testAddition2SommeArgent() throws UniteDistincteException {
        SommeArgent m12CHF = new SommeArgent(12, "CHF");
        SommeArgent m14CHF = new SommeArgent(14, "CHF");
        SommeArgent expected = new SommeArgent(26, "CHF");
        SommeArgent result = m12CHF.add(m14CHF);

        // Utilisation de la méthode equals pour vérifier l'égalité
        assertTrue(expected.equals(result));
    }
    @Test
    public void testAdditionSomme3Argent() {
        SommeArgent m12CHF= new SommeArgent(12, "CHF");
        SommeArgent m14CHF= new SommeArgent(14, "CHF");
        SommeArgent m14USD= new SommeArgent(14, "USD");
        Assert.assertTrue(!m12CHF.equals(null));
        Assert.assertEquals(m12CHF, m12CHF);
        Assert.assertEquals(m12CHF, new SommeArgent(12, "CHF")); // (1)
        Assert.assertTrue(!m12CHF.equals(m14CHF));
        Assert.assertTrue(!m14USD.equals(m14CHF));
        Assert.assertTrue(!m14CHF.equals(m12CHF));
    }


}