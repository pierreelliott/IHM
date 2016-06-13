/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author p1402690
 */
public class Employe extends Personnel{
    private final float tauxHoraire;
    private final float nbHeures;
    
    public Employe(String mat, String nom, String tel, float txHoraire, float nbH)
    {
        super(mat, nom, tel);
        this.tauxHoraire = txHoraire;
        this.nbHeures = nbH;
    }
    
    public Employe(String nom, String tel, float txHoraire, float nbH){
        super(nom,tel);
        this.tauxHoraire = txHoraire;
        this.nbHeures = nbH;
    }
    
    public float getTauxHoraire(){
        return this.tauxHoraire;
    }
    
    public float getNbHeures(){
        return this.nbHeures;
    }
    
    @Override
    public float calculPaie(){
        return this.nbHeures*this.tauxHoraire;
    }
}
