/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conteneurGenerique;

import java.io.*;
import java.util.*;

/**
 *
 * @author p1503940
 */
public class Conteneur<K extends Comparable<K> & Serializable, V extends Serializable> {
    
    private TreeMap<K, V> tM;
    private K cleCourante;
    
    public Conteneur()
    {
        tM = new TreeMap();
        cleCourante = null;
    }
    
    public Conteneur(TreeMap<K, V> t)
    {
        tM = t;
        cleCourante = tM.firstKey();
    }
    
    public boolean ajouter(K cle, V valeur)
    {
        if (tM.containsKey(cle))
            return false;
        tM.put(cle, valeur);
        cleCourante = cle;
        return true;
    }
    
    public void charger(String nomFic)
    {
        try{
            File f1 = new File(nomFic);
            FileInputStream fs = new FileInputStream(f1);
            ObjectInputStream feObj = new ObjectInputStream(fs);
            tM = (TreeMap<K, V>) feObj.readObject();
            feObj.close();
            if (!tM.isEmpty())
                cleCourante = tM.firstKey(); 
            
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public K cleCourante()
    {
        return cleCourante;
    }
    
    public K cleMax()
    {
        if (!tM.isEmpty())
            return tM.lastKey();
        return null;
    }
    
    public K cleMin()
    {
        if (!tM.isEmpty())
            return tM.firstKey();
        return null;
    }
    
    public K clePrecedente()
    {
        return tM.lowerKey(cleCourante);
    }
    
    public K cleSuivante()
    {
        return tM.higherKey(cleCourante);
    }
    
    public void dernier()
    {
        cleCourante = tM.lastKey();
    }
    
    public boolean estVide()
    {
        return tM.isEmpty();
    }
    
    public boolean existe(K cle)
    {
        return tM.containsKey(cle);
    }
    
    /*public TreeMap<K, V> getTreeMap(){
        return tM;
    }*/
    
    public int nbElements()
    {
        return tM.size();
    }
    
    public V obtenir(K cle)
    {
        if(!tM.isEmpty()) return tM.get(cle);
        return null;
    }
    
    public void positionner(K cle)
    {
        if (tM.containsKey(cle))
            cleCourante = cle;
    }
    
    public void precedent()
    {
        if (tM.lowerKey(cleCourante) != null)
            cleCourante = tM.lowerKey(cleCourante);
    }
    
    public void premier()
    {
        if(!tM.isEmpty())
            cleCourante = tM.firstKey();
    }
    
    public void sauvegarder(String nomFic)
    {
        try{
            File f1 = new File(nomFic);
            FileOutputStream fs = new FileOutputStream(f1);
            ObjectOutputStream fsObj = new ObjectOutputStream(fs);
            fsObj.writeObject(tM);
            fsObj.close();
            
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void suivant()
    {
        if (tM.higherKey(cleCourante) != null)
            cleCourante = tM.higherKey(cleCourante);
    }
    
    public void supprimer(K cle)
    {
        if (tM.containsKey(cle))
            cleCourante = tM.higherKey(cle);
            if(cleCourante == null)
                cleCourante = tM.lowerKey(cle);
            tM.remove(cle);
    }
    
    public void vider()
    {
        tM.clear();
        cleCourante = null;
    }
}
