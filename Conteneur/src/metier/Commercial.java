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
public class Commercial extends Employe{
    private final float pourcentage;
    private float totalVentes = 0;
    
    public Commercial(String nom, String tel, float txHoraire, float nbH, float pourcent, float totVentes){
        super(nom,tel,txHoraire,nbH);
        this.pourcentage = pourcent;
        this.totalVentes = totVentes;
    }
    
    public float getPourcentage(){
        return this.pourcentage;
    }
    
    public float getTotalVentes(){
        return this.totalVentes;
    }
    
    @Override
    public float calculPaie(){
        return super.calculPaie()+this.pourcentage*this.totalVentes;
    }
}
