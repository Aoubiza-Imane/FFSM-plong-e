
package FFSSM;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aoubiza imane
 */
public class TestPlongee {
    private Plongeur p;
    private Licence l2;
    private Club c1;
    private Moniteur m1;
    private Site s1;
    private Plongee pl1;// L'objet à tester

    @BeforeEach
    public void setUp() {
        // Initialiser les objets utilisés dans les tests
        m1 = new Moniteur("CSCS", "Jean", "Claude", "rue des roses", "3630", LocalDate.of(2006, 6, 6), 3, 456, GroupeSanguin.BPLUS);
        c1 = new Club(m1, "Blue wave", "222");
        p = new Plongeur("KJ", "Laura", "Capucine", "rue des coquelicots", "232", LocalDate.of(1800, 4, 25), 0, GroupeSanguin.AMOINS);
        Licence l1;
        l1 = new Licence(m1,"5663", LocalDate.of(2020,12,31), c1);
        s1= new Site("La vallée des dauphins", "vallée profonde");
        pl1= new Plongee (s1, m1, LocalDate.of(2021,01,01), 5000, 30);

    }
    
    @Test
    public void TestEstConforme(){
        // licence valide 
        l2=new Licence(p,"4585", LocalDate.of(2020,12,12), c1);
        pl1.ajouteParticipant(l2);
        assertTrue(pl1.estConforme(), "La plongée est censée être conforme.");
    }
    
    @Test
    public void TestPasConforme(){
        // licence invalide 
        l2=new Licence(p,"7474", LocalDate.of(2018,12,31), c1);
        pl1.ajouteParticipant(l2);
        assertFalse(pl1.estConforme(), "La plongée est censée ne pas être conforme.");
    }
}