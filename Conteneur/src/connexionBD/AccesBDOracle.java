/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexionBD;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import metier.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author p1402690
 */
public class AccesBDOracle {
    
    private static AccesBDOracle instance = null;
    
    private Connection instCo;
    private Statement instStat;
    private ResultSet result;

    private AccesBDOracle() {}
    
    public static AccesBDOracle getInstance(){
        if(instance == null)
            instance = new AccesBDOracle();
        return instance;
    }
    
    public void fermer() throws SQLException
    {
        instCo.close();
        System.out.println("deco ok");
    }
    
    public void charger(TreeMap<String, Personnel> tMap) throws SQLException
    {
        String query = "SELECT matricule, nom, numtel, categorie, tauxHoraire, NbHeures, indemnites, pourcentage, totalVentes FROM personnel order by matricule";
        Personnel elt;
        instStat = instCo.createStatement();
        result = instStat.executeQuery(query);
        while (result.next()) {
            String cle = result.getString(1);
            String cat = result.getString(4);
            switch (cat) {
                case "E":
                    elt = new Employe(cle, result.getString(2), result.getString(3), result.getFloat(5), result.getFloat(6));
                    break;
                case "C":
                    elt = new Commercial(cle, result.getString(2), result.getString(3), result.getFloat(5), result.getFloat(6), result.getFloat(8), result.getFloat(9));
                    break;
                case "D" :
                    elt = new Directeur(cle, result.getString(2), result.getString(3), result.getFloat(7));
                    break;
            }
            //à mettre dans le treemap
            //on ajoutera ce treemap dans l'attribut du conteneur
        }
    }
    
    public void supprimer()
    {
        
    }
    
    public void inserer()
    {
        
    }
    
    public Connection CreerConnexion() throws SQLException, Exception { 
        Properties props = new Properties(); 
        FileInputStream fichier = null;
        try{
            fichier = new FileInputStream("connexion.properties"); 
            props.load(fichier);
        }
        catch (FileNotFoundException e) {
            System.out.println("**** Fichier décrivant les propriétés d'accès à la BD non trouvé !"+e.getMessage());
        }
        catch (IOException ex) {
            Logger.getLogger(OracleConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                fichier.close();
            }
            catch (IOException ex) {
                Logger.getLogger(OracleConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
        OracleDataSource ods = new OracleDataSource(); 
        ods.setDriverType(props.getProperty("pilote")); 
        ods.setPortNumber(new Integer(props.getProperty("port")).intValue()); 
        ods.setServiceName(props.getProperty("service")); 
        ods.setUser(props.getProperty("user")); 
        ods.setPassword(props.getProperty("pwd")); 
        ods.setServerName(props.getProperty("serveur"));
        
        System.out.println("==> Connexion ORACLE établie...");
        
        return(ods.getConnection());
        }
        catch (Exception e) {
            System.err.println("Erreur de connexion au serveur ORACLE...");
            return null;
       }
   }

}
