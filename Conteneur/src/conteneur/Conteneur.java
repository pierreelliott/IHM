/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conteneur;

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
    }
    
    public Conteneur(java.util.TreeMap<K, V> t)
    {
        tM = t;
    }
    
    public boolean ajouter(K cle, V valeur)
    {
        
    }
    
    public void charger(java.lang.String nomFic)
    {
        
    }
    
    public K cleCourante()
    {
        return cleCourante;
    }
    
    public K cleMax()
    {
        return tM.lastKey();
    }
    
    public K cleMin()
    {
        return tM.firstKey();
    }
    
    public K clePrecedente()
    {
        return tM.lowerKey(cleCourante);
    }
    
    public K cleSuivante()
    {
        
    }
    
    public void dernier()
    {
        
    }
    
    public boolean estVide()
    {
        
    }
    
    public boolean existe(K cle)
    {
        
    }
    
    public int nbElements()
    {
        
    }
    
    public V obtenir(K cle)
    {
        
    }
    
    public void positionner(K cle)
    {
        
    }
    
    public void precedent()
    {
        
    }
    
    public void premier()
    {
        
    }
    
    public void sauvegarder(java.lang.String nomFic)
    {
        
    }
    
    public void suivant()
    {
        
    }
    
    public void supprimer(K cle)
    {
        
    }
    
    public void vider()
    {
        
    }
}
