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
public class Directeur extends Personnel{
    private final float indemnites;
    
    public Directeur(String nom, String tel, float indemn){
        super(nom,tel);
        this.indemnites = indemn;
    }
    
    @Override
    public float calculPaie(){
        return this.indemnites;
    }
    
    public float getIndemnites(){
        return this.indemnites;
    }
}
