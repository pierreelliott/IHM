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
public abstract class Personnel {
    private final String numPers;
    private final String nomPers;
    private final String numTel;
    
    private static int nbPers = 1000;
    
    public Personnel(String nom, String tel){
        nbPers ++;
        this.nomPers = nom;
        this.numTel = tel;
        this.numPers = ("M"+nbPers);
    }
    
    public abstract float calculPaie();
    
    public String getNumPers(){
        return this.numPers;
    }
    
    public String getNomPers(){
        return this.nomPers;
    }
    
    public String getNumTel(){
        return this.numTel;
    }
    
    
    /* #######################################*/
    // Comparaisons
    
    public boolean equals(Personnel p){
        if(p == null) return false;
        if(p == this) return true;
        return (this.numPers.equals(p.numPers));
    }
    
    public int compareTo(Personnel p){
        return this.numPers.compareTo(p.numPers);
    }
    
    @Override
    public String toString(){
       return this.getClass().getName()/*+" "+this.nomPers*/;
    }
}


class VerifInfos{
    protected static void verifNumTel(){
        
    }
}