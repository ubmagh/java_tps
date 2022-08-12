package Impl;

import Entities.Departement;
import Entities.Professeur;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IMetierImplementation implements IMetier {

    private Connection connection;

    public IMetierImplementation() {
        connection = SignletonConnexionDB.getConnection();
    }

    @Override
    public void ajouterProfesseur(Professeur professeure) {
        try{
            PreparedStatement ajoutPreStatement = connection.prepareStatement("INSERT INTO professeur( nom, prenom, email, telephone, adresse, cin, id_depart, date_recrutement) VALUES( ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ajoutPreStatement.setString( 1, professeure.getNom());
            ajoutPreStatement.setString( 2, professeure.getPrenom());
            ajoutPreStatement.setString( 3, professeure.getEmail());
            ajoutPreStatement.setString( 4, professeure.getTelephone());
            ajoutPreStatement.setString( 5, professeure.getAdresse());
            ajoutPreStatement.setString( 6, professeure.getCin());
            ajoutPreStatement.setInt( 7, professeure.getDepartement().getId_depart());
            ajoutPreStatement.setDate( 8, professeure.getDate_recrutement());
            ajoutPreStatement.executeUpdate();
            ResultSet rs = ajoutPreStatement.getGeneratedKeys();
            if( rs.next() )
                professeure.setId_prof( rs.getInt(1) );
        }catch(Exception exc){
            System.err.print("\n[IMetierImp::ajouterProfesseur]Exception> "+exc.getMessage());
            exc.printStackTrace();
        }
    }

    @Override
    public void supprimerProfesseur(Professeur professeure) {
        try{
            PreparedStatement supprissionPreStatement = connection.prepareStatement("DELETE FROM professeur WHERE id_prof=?");
            supprissionPreStatement.setInt(1, professeure.getId_prof());
            supprissionPreStatement.executeUpdate();
        }catch(Exception exc){
            System.err.print("\n[IMetierImp::supprimerProfesseur]Exception> "+exc.getMessage());
            exc.printStackTrace();
        }
    }

    @Override
    public void modifierProfesseur(Professeur professeure) {
        try{
            PreparedStatement modifyPreStatement = connection.prepareStatement("UPDATE professeur SET nom=?, prenom=?, email=?, telephone=?, adresse=?, cin=?, id_depart=?, date_recrutement=? WHERE id_prof=?");
            modifyPreStatement.setString( 1, professeure.getNom());
            modifyPreStatement.setString( 2, professeure.getPrenom());
            modifyPreStatement.setString( 3, professeure.getEmail());
            modifyPreStatement.setString( 4, professeure.getTelephone());
            modifyPreStatement.setString( 5, professeure.getAdresse());
            modifyPreStatement.setString( 6, professeure.getCin());
            modifyPreStatement.setInt( 7, professeure.getDepartement().getId_depart());
            modifyPreStatement.setDate( 8, professeure.getDate_recrutement());
            modifyPreStatement.setInt(9, professeure.getId_prof());
            modifyPreStatement.executeUpdate();
        }catch(Exception exc){
            System.err.print("\n[IMetierImp::modifierProfesseur]Exception> "+exc.getMessage());
            exc.printStackTrace();
        }
    }


    @Override
    public void affecterProfesseurDepartement(Professeur professeure, Departement departement) {
        try{
            PreparedStatement affectationPreStatement = connection.prepareStatement("UPDATE professeur SET id_depart=? WHERE id_prof=?");
            affectationPreStatement.setInt( 1, departement.getId_depart() );
            affectationPreStatement.setInt(2, professeure.getId_prof());
            affectationPreStatement.executeUpdate();
            professeure.setDepartement(departement);
        }catch(Exception exc){
            System.err.print("\n[IMetierImp::affecterProfesseurDepartement]Exception> "+exc.getMessage());
            exc.printStackTrace();
        }
    }

    @Override
    public List<Professeur> getAllProfesseurs() {
        List<Professeur> profs = new ArrayList<Professeur>();
        Departement dep;
        Professeur prof;
        try{
            PreparedStatement getProfesseursPreStatement = connection.prepareStatement("SELECT professeur.*, departement.id_depart as iddepart, departement.nom as nomdepart FROM professeur, departement WHERE professeur.id_depart=departement.id_depart");
            ResultSet rs = getProfesseursPreStatement.executeQuery();
            while( rs.next() ){
                dep = new Departement( rs.getInt("iddepart"), rs.getString("nomdepart"));
                prof = new Professeur( rs.getInt("id_prof"), rs.getString("nom"), rs.getString("prenom"), rs.getString("cin"), rs.getString("adresse"), rs.getString("telephone"), rs.getString("email"), rs.getDate("date_recrutement"), dep );
                profs.add( prof );
            }
        }catch(Exception exc){
            System.err.print("\n[IMetierImp::getAllProfesseurs]Exception> "+exc.getMessage());
            exc.printStackTrace();
        }
        return profs;
    }

    @Override
    public void ajouterDepartement(Departement departement) {
        try{
            PreparedStatement ajoutPreStatement = connection.prepareStatement("INSERT INTO departement( nom ) VALUES( ? )", Statement.RETURN_GENERATED_KEYS);
            ajoutPreStatement.setString(1, departement.getNom());
            ajoutPreStatement.executeUpdate();
            ResultSet rs = ajoutPreStatement.getGeneratedKeys();
            if( rs.next() )
                departement.setId_depart( rs.getInt(1) );
        }catch(Exception exc){
            System.err.print("\n[IMetierImp::ajouterDepartement]Exception> "+exc.getMessage());
            exc.printStackTrace();
        }
    }

    @Override
    public List<Departement> getDepartements() {
        List<Departement> departements = new ArrayList<Departement>();
        Departement dep;
        List<Professeur> profs;
        PreparedStatement getProfsStatement;
        ResultSet rs_profs;
        try{
            PreparedStatement getDepartementsStatement = connection.prepareStatement("SELECT * FROM departement");
            ResultSet rs = getDepartementsStatement.executeQuery();
            while( rs.next() ){
                dep = new Departement( rs.getInt("id_depart"), rs.getString("nom"));
                profs = new ArrayList<Professeur>();
                getProfsStatement = connection.prepareStatement("SELECT * FROM professeur WHERE id_depart=?");
                getProfsStatement.setInt( 1, rs.getInt("id_depart") );
                rs_profs = getProfsStatement.executeQuery();
                while( rs_profs.next() ){
                    profs.add( new Professeur( rs_profs.getInt("id_prof"), rs_profs.getString("nom"), rs_profs.getString("prenom"), rs_profs.getString("cin"),
                            rs_profs.getString("adresse"), rs_profs.getString("telephone"), rs_profs.getString("email"),
                            rs_profs.getDate("date_recrutement")) );
                }
                dep.setProfesseurs(profs);
                departements.add(dep);
            }
        }catch(Exception exc){
            System.err.print("\n[IMetierImp::getDepartements]Exception> "+exc.getMessage());
            exc.printStackTrace();
        }
        return departements;
    }

    @Override
    public void supprimerDepartement(Departement departement) {
        try{
            PreparedStatement supprissionPreStatement = connection.prepareStatement("DELETE FROM departement WHERE id_depart=?");
            supprissionPreStatement.setInt(1, departement.getId_depart() );
            supprissionPreStatement.executeUpdate();
        }catch(Exception exc){
            System.err.print("\n[IMetierImp::supprimerDepartement]Exception> "+exc.getMessage());
            exc.printStackTrace();
        }
    }

    @Override
    public void modifierDepartement(Departement departement) {
        try{
            PreparedStatement supprissionPreStatement = connection.prepareStatement("UPDATE departement SET nom=? WHERE id_depart=?");
            supprissionPreStatement.setString(1, departement.getNom() );
            supprissionPreStatement.setInt(2, departement.getId_depart() );
            supprissionPreStatement.executeUpdate();
        }catch(Exception exc){
            System.err.print("\n[IMetierImp::modifierDepartement]Exception> "+exc.getMessage());
            exc.printStackTrace();
        }
    }

    @Override
    public List<Professeur> getProfesseursByDepartement(Departement departement) {
        List<Professeur> profs= new ArrayList<Professeur>();
        Professeur prof;
        try{
            PreparedStatement profsByDepPreStatement = connection.prepareStatement("SELECT * FROM professeur WHERE id_depart=? ");
            profsByDepPreStatement.setInt( 1, departement.getId_depart());
            ResultSet rs = profsByDepPreStatement.executeQuery();
            while( rs.next() ){
                prof = new Professeur( rs.getInt("id_prof"), rs.getString("nom"), rs.getString("prenom"), rs.getString("cin"), rs.getString("adresse"), rs.getString("telephone"), rs.getString("email"), rs.getDate("date_recrutement"), departement);
                profs.add( prof );
            }
        }catch(Exception exc){
            System.err.print("\n[IMetierImp::getProfesseursByDepartement]Exception> "+exc.getMessage());
            exc.printStackTrace();
        }
        return profs;
    }
}
