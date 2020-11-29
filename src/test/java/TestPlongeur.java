
package FFSSM;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author agath
 */
public class TestPlongeur {

    private Plongeur p; // L'objet à tester
    private Licence l1;
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
    public void TestAjoutLicence() {
        l1 = new Licence(p, "2525", LocalDate.of(2020, 12, 31), c1);
        p.ajouteLicence(l1.getNumero(), l1.getDelivrance(), l1.getClub());
        assertTrue(p.licences.contains(l1), "La licence n'a pas été bien ajoutée");
    }

    @Test
    public void TestNumInseeNull() {
        try {
            p = new Plongeur(null, "Bastide", "Rémi", "dans une maison", "112", LocalDate.of(1800, 4, 25), 0, GroupeSanguin.AMOINS);
            fail();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

}