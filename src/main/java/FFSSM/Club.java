/**
 * @(#) Club.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Club {

    public Moniteur president;

    public String nom;

    public String adresse;

    public String telephone;

    public Set<Plongee> myPlongees;
    
    private List<Embauche> myEmplois = new ArrayList<>();

    public Club(Moniteur president, String nom, String telephone) {
        this.setPresident(president);
        this.nom = nom;
        this.telephone = telephone;
        this.myPlongees = new HashSet<>();
    }

    /**
     * Calcule l'ensemble des plongées non conformes organisées par ce club. Une
     * plongée est conforme si tous les plongeurs de la palanquée ont une
     * licence valide à la date de la plongée
     *
     * @return l'ensemble des plongées non conformes
     */
    public Set<Plongee> plongeesNonConformes() {
        Set<Plongee> pNonConformes = new HashSet<>();
        for(Plongee p : this.myPlongees) {
            if (!p.estConforme()) {
                pNonConformes.add(p);
            }

        }
        return pNonConformes;
    }

    /**
     * Enregistre une nouvelle plongée organisée par ce club
     *
     * @param p la nouvelle plongée
     */
    public void organisePlongee(Plongee p) {
        this.myPlongees.add(p);
    }

    public Moniteur getPresident() {
        return president;
    }

    public void setPresident(Moniteur president) {
        if (null == president)
            // Le président est inconnu, sans plus d'informations
            this.president=new Moniteur("Inconnu", "Inconnu", "Inconnu", "Inconnu", "Inconnu", LocalDate.EPOCH,0,0,null);
        this.president = president;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Club{" + "président=" + president + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }

}