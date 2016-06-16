/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexionBD;

import conteneurGenerique.*;
import java.io.*;
import java.sql.*;
import java.sql.Types.*;
import java.util.*;
import java.util.logging.*;
import metier.*;
import oracle.jdbc.*;
import static oracle.jdbc.OracleTypes.*;
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
        System.out.println("Déconnexion O.K.");
    }
    
    public void charger(TreeMap<String, Personnel> tm) throws SQLException
    {
        instCo = instance.CreerConnexion();
        String query = "SELECT matricule, nom, numtel, categorie, tauxHoraire, NbHeures, indemnites, pourcentage, totalVentes FROM personnel order by matricule";
        Personnel elt = null;
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
            tm.put(cle, elt);
        }
        instance.fermer();
    }
    
    public void supprimer(Personnel p) throws SQLException
    {
        instCo = instance.CreerConnexion();
        PreparedStatement suppr = instCo.prepareStatement("Delete from personnel where matricule = ?");
        suppr.setString(1, p.getNumPers());
        suppr.executeUpdate();
        instance.fermer();
    }
    
    public void inserer(Personnel p) throws SQLException
    {
        instCo = instance.CreerConnexion();
        PreparedStatement inser = instCo.prepareStatement("Insert into personnel values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        inser.setString(1, p.getNumPers());
        inser.setString(2, p.getNomPers());
        inser.setInt(3, Integer.parseInt(p.getNumTel()));
        
        if(p instanceof Employe)
        {
            inser.setString(4, "E");
            inser.setDouble(5, ((Employe)p).getTauxHoraire());
            inser.setDouble(6, ((Employe)p).getNbHeures());
            inser.setNull(7, NUMBER);
            inser.setNull(8, NUMBER);
            inser.setNull(9, NUMBER);
        }
        if(p instanceof Commercial)
        {
            inser.setString(4, "C");
            inser.setDouble(8, ((Commercial)p).getPourcentage());
            inser.setDouble(9, ((Commercial)p).getTotalVentes());
            
        }
        if(p instanceof Directeur)
        {
            inser.setString(4, "D");
            inser.setNull(5, NUMBER);
            inser.setNull(6, NUMBER);
            inser.setDouble(7, ((Directeur)p).getIndemnites());
            inser.setNull(8, NUMBER);
            inser.setNull(9, NUMBER);
        }
        inser.executeUpdate();
        instance.fermer();
    }
    
    public Connection CreerConnexion() throws SQLException { 
        Properties props = new Properties(); 
        FileInputStream fichier = null;
        try{
            fichier = new FileInputStream("W:\\Mes documents\\IHM\\Conteneur\\src\\connexionBD\\connexion.properties"); 
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
