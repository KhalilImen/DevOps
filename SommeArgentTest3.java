package monprojet;


import org.junit.*;
import junit.framework.TestCase;
import org.junit.Test;


public class SommeArgentTest3 {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("1er passage avant exécution d'une méthode de test");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("1er passage APRES exécution d'une méthode de test");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("2e passage avant exécution d'une méthode de test");
        // Initialisations communes à chaque méthode de test
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("2e passage APRES exécution d'une méthode de test");
        // Code commun après chaque méthode de test
    }

    @Test
    public void testEqualsMethod() {
        System.out.println("Exécution du testEqualsMethod");

        SommeArgent m12CHF = new SommeArgent(12, "CHF");
        SommeArgent m14CHF = new SommeArgent(14, "CHF");
        SommeArgent m14USD = new SommeArgent(14, "USD");

        Assert.assertTrue(!m12CHF.equals(null));
        Assert.assertEquals(m12CHF, m12CHF);
        Assert.assertEquals(m12CHF, new SommeArgent(12, "CHF"));
        Assert.assertTrue(!m12CHF.equals(m14CHF));
        Assert.assertTrue(!m14USD.equals(m14CHF));
    }

    @Test
    public void testAdditionSommeArgent() throws UniteDistincteException {
        System.out.println("Exécution du testAdditionSommeArgent");

        SommeArgent m12CHF = new SommeArgent(12, "CHF");
        SommeArgent m14CHF = new SommeArgent(14, "CHF");
        SommeArgent m14USD = new SommeArgent(14, "USD");

        SommeArgent result1 = m12CHF.add(m14CHF);
        Assert.assertEquals(new SommeArgent(26, "CHF"), result1);

        SommeArgent result2 = m14USD.add(m14CHF);
        Assert.assertEquals(new SommeArgent(14, "USD"), result2);
    }
}
