/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conteneur;

import java.util.TreeMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author p1402690
 */
public class ConteneurTest {
    
    public ConteneurTest() {
    }

    /**
     * Test of ajouter method, of class Conteneur.
     */
    @Test
    public void testAjouter() {
        System.out.println("ajouter");
        Conteneur<Integer, String> instance = new Conteneur<>();
        
        // cas où la clé n'existe pas
        boolean expResult = true;
        boolean result = instance.ajouter(1, "a");
        assertEquals(expResult, result);
        
        // cas où la clé existe déjà
        expResult = false;
        result = instance.ajouter(1, "b");
        assertEquals(expResult, result);
    }

    /**
     * Test of charger method, of class Conteneur.
     */
    @Test
    public void testCharger() {
        System.out.println("charger");
        String nomFic = "fichier.txt";
        Conteneur instance = new Conteneur();
        instance.charger(nomFic);
    }

    /**
     * Test of cleCourante method, of class Conteneur.
     */
    @Test
    public void testCleCourante() {
        System.out.println("cleCourante");
        Conteneur instance = new Conteneur();
        Object expResult = null;
        Object result = instance.cleCourante();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cleMax method, of class Conteneur.
     */
    @Test
    public void testCleMax() {
        System.out.println("cleMax");
        Conteneur instance = new Conteneur();
        Object expResult = null;
        Object result = instance.cleMax();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cleMin method, of class Conteneur.
     */
    @Test
    public void testCleMin() {
        System.out.println("cleMin");
        Conteneur instance = new Conteneur();
        Object expResult = null;
        Object result = instance.cleMin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clePrecedente method, of class Conteneur.
     */
    @Test
    public void testClePrecedente() {
        System.out.println("clePrecedente");
        
        TreeMap<Integer, String> t = new TreeMap<>();
        t.put(1, "a");
        t.put(2, "b");
        Conteneur<Integer, String> instance = new Conteneur<>(t);
        
        // cas où il y a une clé précédente
        Integer expResult = 1;
        Integer result = instance.clePrecedente();
        assertEquals(expResult, result);
                
        // cas où il n'y a pas de clé précédente
        expResult = null;
        result = instance.clePrecedente();
        assertEquals(expResult, result);
    }

    /**
     * Test of cleSuivante method, of class Conteneur.
     */
    @Test
    public void testCleSuivante() {
        System.out.println("cleSuivante");
        Conteneur instance = new Conteneur();
        Object expResult = null;
        Object result = instance.cleSuivante();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dernier method, of class Conteneur.
     */
    @Test
    public void testDernier() {
        System.out.println("dernier");
        Conteneur instance = new Conteneur();
        instance.dernier();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of estVide method, of class Conteneur.
     */
    @Test
    public void testEstVide() {
        System.out.println("estVide");
        Conteneur instance = new Conteneur();
        boolean expResult = false;
        boolean result = instance.estVide();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existe method, of class Conteneur.
     */
    @Test
    public void testExiste() {
        System.out.println("existe");
        Integer cle = null;
        Conteneur instance = new Conteneur();
        boolean expResult = false;
        boolean result = instance.existe(cle);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nbElements method, of class Conteneur.
     */
    @Test
    public void testNbElements() {
        System.out.println("nbElements");
        Conteneur instance = new Conteneur();
        int expResult = 0;
        int result = instance.nbElements();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenir method, of class Conteneur.
     */
    @Test
    public void testObtenir() {
        System.out.println("obtenir");
        Integer cle = null;
        Conteneur instance = new Conteneur();
        Object expResult = null;
        Object result = instance.obtenir(cle);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of positionner method, of class Conteneur.
     */
    @Test
    public void testPositionner() {
        System.out.println("positionner");
        Integer cle = null;
        Conteneur instance = new Conteneur();
        instance.positionner(cle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of precedent method, of class Conteneur.
     */
    @Test
    public void testPrecedent() {
        System.out.println("precedent");
        Conteneur instance = new Conteneur();
        instance.precedent();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of premier method, of class Conteneur.
     */
    @Test
    public void testPremier() {
        System.out.println("premier");
        Conteneur instance = new Conteneur();
        instance.premier();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sauvegarder method, of class Conteneur.
     */
    @Test
    public void testSauvegarder() {
        System.out.println("sauvegarder");
        String nomFic = "fichieerer.txt";
        Conteneur instance = new Conteneur();
        instance.sauvegarder(nomFic);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of suivant method, of class Conteneur.
     */
    @Test
    public void testSuivant() {
        System.out.println("suivant");
        Conteneur instance = new Conteneur();
        instance.suivant();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of supprimer method, of class Conteneur.
     */
    @Test
    public void testSupprimer() {
        System.out.println("supprimer");
        Integer cle = null;
        Conteneur instance = new Conteneur();
        instance.supprimer(cle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of vider method, of class Conteneur.
     */
    @Test
    public void testVider() {
        System.out.println("vider");
        Conteneur instance = new Conteneur();
        instance.vider();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
