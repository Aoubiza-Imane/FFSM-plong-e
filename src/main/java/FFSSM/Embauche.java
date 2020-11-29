package FFSSM;

import java.time.LocalDate;

public class Embauche {

    private LocalDate debut;

    private LocalDate fin;

    private final Moniteur employe;

    private final Club employeur;

    public Embauche(LocalDate debut, Moniteur employe, Club employeur) {
        this.debut = debut;
        this.employe = employe;
        this.employeur = employeur;
    }

    /**
     * Termine cette embauche
     * @param dateFin la date à laquelle cette embauche est terminée
     */
    public void terminer(LocalDate dateFin) {
         this.fin=dateFin;
         if (this.employeur.getPresident().equals(this.employe))
             this.employeur.setPresident(null);
    }
    
    /**
     * Est-ce que cette embauche est achevée ?
     * @return vrai si terminée, faux sinon.
     */
    public boolean estTerminee() {
        return (fin != null);
    }
    /**
     * Récupère la valeur de l'employeur
     *
     * @return la valeur de l'employeur
     */
    public Club getEmployeur() {
        return employeur;
    }

    /**
     * Récupère la valeur de l'employé
     *
     * @return valeur de l'employé
     */
    public Moniteur getEmploye() {
        return employe;
    }

    /**
     * Récupère la valeur de fin
     *
     * @return valeur de la fin
     */
    public LocalDate getFin() {
        return fin;
    }

    /**
     * Définit la valeur de fin
     *
     * @param fin nouvelle valeur de fin
     */
    public void setFin(LocalDate fin) {
        this.fin = fin;
    }

    /**
     * Récupère la valeur du début
     *
     * @return la valeur du début
     */
    public LocalDate getDebut() {
        return debut;
    }

    
}