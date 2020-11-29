/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Moniteur extends Plongeur {

    public int numeroDiplome;

    private LinkedList<Embauche> myEmployeurs = new LinkedList<>();

    /** noter les paramètres
     *
     * @param numeroINSEE
     * @param nom
     * @param prenom
     * @param adresse
     * @param telephone
     * @param naissance
     * @param niveau
     * @param numeroDiplome
     * @param groupe
     */
    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, int numeroDiplome, GroupeSanguin groupe) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, niveau, groupe); // super est utilisé pour hériter des attributs de la classe 
        this.numeroDiplome = numeroDiplome;
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est
     * terminée, ce moniteur n'a pas d'employeur.
     *
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() {
        System.out.println("Taille : " + this.myEmployeurs.size()); // on montre la taille de la liste des employeurs
        if (this.myEmployeurs.isEmpty() || this.myEmployeurs.peekLast().estTerminee()) { // si la liste d'employeurs ou si le dernier contrat est terminé
            return Optional.empty(); // renvoie null
        }
        return Optional.of(this.myEmployeurs.peekLast().getEmployeur()); // renvoie le dernier employeur encore sur le contrat
    }

    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     *
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {
        this.myEmployeurs.add(new Embauche(debutNouvelle, this, employeur));
    }

    public List<Embauche> emplois() {
        return this.myEmployeurs;
    }

    public void terminerEmbauche(LocalDate fin) {
        if (this.employeurActuel().isEmpty()) {

            throw new IllegalArgumentException(this.nom + " " + this.prenom + " n'est pas employé.");

        } else {
            this.myEmployeurs.peekLast().terminer(fin); // pour l'ordre d'appel des méthodes, faire d'abord les méthodes "natives" puis celles implémentées par moi

        }
    }

    public int getNumeroDiplome() {
        return numeroDiplome;
    }

    public LinkedList<Embauche> getEmployeurs() {
        return myEmployeurs;
    }

}