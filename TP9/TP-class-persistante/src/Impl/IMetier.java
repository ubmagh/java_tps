package Impl;

import Entities.Departement;
import Entities.Professeur;
import java.util.List;

public interface IMetier {

    public void ajouterProfesseur(Professeur professeure);
    public void supprimerProfesseur(Professeur professeure);
    public void modifierProfesseur(Professeur professeure);
    public void affecterProfesseurDepartement( Professeur professeure, Departement departement);
    public List<Professeur> getAllProfesseurs();

    public void ajouterDepartement( Departement departement);
    public List<Departement> getDepartements();
    public void supprimerDepartement( Departement departement);
    public void modifierDepartement( Departement departement);
    public List<Professeur> getProfesseursByDepartement(Departement departement);

}
