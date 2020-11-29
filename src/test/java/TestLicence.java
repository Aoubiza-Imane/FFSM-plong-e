
package FFSSM;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aoubiza imane
 */
public class TestLicence {

    private Plongeur p; 
    private Licence l1;// L'objet à tester
    private Club c1;
    private Moniteur m1;

    @BeforeEach
    public void setUp() {
        // Initialiser les objets utilisés dans les tests
        m1 = new Moniteur("CSCS", "Jean", "Claude", "rue des roses", "3630", LocalDate.of(2006, 6, 6), 3, 456, GroupeSanguin.BPLUS);
        c1 = new Club(m1, "Blue wave", "222");
        p = new Plongeur("KJ", "Laura", "Capucine", "rue des coquelicots", "232", LocalDate.of(1800, 4, 25), 0, GroupeSanguin.AMOINS);
    }

    @Test
    public void setNumeroNull() {
        try {
            l1 = new Licence(p, null, LocalDate.of(2020, 12, 31), c1);
            fail();
        } catch (IllegalArgumentException e) {
            System.out.print(e);
        }
    }

    @Test
    public void TestLicenceValide() {
        l1 = new Licence(p, "2525", LocalDate.of(2020, 12, 31), c1);
        assertTrue(l1.estValide(LocalDate.of(2020, 11, 25)), "La licence est censée être valide");
    }

    @Test
    public void TestLicencePasValide() {
        l1 = new Licence(p, "2525", LocalDate.of(2020, 12, 31), c1);
        assertFalse(l1.estValide(LocalDate.of(2022, 1, 11)), "La licence est censée être invalide");
    }

    @Test
    public void TestLicenceValide2() {
        l1 = new Licence(p, "2525", LocalDate.of(2020, 12, 31), c1);
        assertTrue(l1.estValide(LocalDate.of(2020, 12, 31)), "La licence est censée être valide");
    }
}