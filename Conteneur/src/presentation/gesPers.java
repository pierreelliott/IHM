/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;
import conteneurGenerique.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import static javax.swing.JOptionPane.DEFAULT_OPTION;
import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import metier.*;

/**
 *
 * @author p1402690
 */
public class gesPers extends javax.swing.JFrame {

    private Conteneur<String, Personnel> cont;
    
    private enum TypePersonnel {EMPLOYE, COMMERCIAL, DIRECTEUR};
    private TypePersonnel typePersonnel;
    private enum ModeCourant {AFFICHAGE, SAISIE, RECHERCHE};
    private ModeCourant modeCourant;
    
    private boolean modif = false;
    
    /**
     * Creates new form gesPers
     */
    public gesPers() {
        initComponents();
        typePersonnel = TypePersonnel.EMPLOYE;
        
        cont = new Conteneur<>();
        labelNbObjets.setText("0");
        /*
        menuNouveau.addActionListener(new EcouteurMenu());
        menuSauvegarder.addActionListener(new EcouteurMenu());
        menuQuitter.addActionListener(new EcouteurMenu());
        menuCharger.addActionListener(new EcouteurMenu());
        menuFermerConteneur.addActionListener(new EcouteurMenu());
        menuAPropos.addActionListener(new EcouteurMenu());
        menuAide.addActionListener(new EcouteurMenu());
        */
        this.modeAffichage();
        this.afficher();
    }
    
    private void modeAffichage()
    {
        modeCourant = ModeCourant.AFFICHAGE;
        labelMode.setText("MODE AFFICHAGE");
        
        boutonChercher.setEnabled(true);
        boutonSuppr.setEnabled(true);
        boutonCreer.setEnabled(true);
        boutonDebut.setEnabled(true);
        boutonPrec.setEnabled(true);
        boutonSuiv.setEnabled(true);
        boutonFin.setEnabled(true);
        
        boutonRecherche.setVisible(false);
        boutonSuppr.setText("Supprimer");
        boutonCreer.setText("Créer");
        
        champNom.setEnabled(false);
        champTel.setEnabled(false);
        champMatricule.setEnabled(false);
        champTH.setEnabled(false);
        champNbHeures.setEnabled(false);
        champIndemnite.setEnabled(false);
        champVentes.setEnabled(false);
        champPourcentage.setEnabled(false);
        champMB.setEnabled(false);
        
        rBoutonEmp.setEnabled(false);
        rBoutonComm.setEnabled(false);
        rBoutonDir.setEnabled(false);
    }
    
    private void modeSaisie()
    {
        modeCourant = ModeCourant.SAISIE;
        labelMode.setText("MODE SAISIE");
        
        boutonChercher.setEnabled(false);
        boutonSuppr.setEnabled(true);
        boutonCreer.setEnabled(true);
        boutonDebut.setEnabled(false);
        boutonPrec.setEnabled(false);
        boutonSuiv.setEnabled(false);
        boutonFin.setEnabled(false);
        
        boutonRecherche.setVisible(false);
        boutonChercher.setEnabled(false);
        boutonSuppr.setText("Annuler");
        boutonCreer.setText("Ajouter");
        boutonCreer.setToolTipText("Ajouter ce personnel");

        champNom.setEnabled(true);
        champTel.setEnabled(true);
        champMatricule.setEnabled(false);
        
        rBoutonEmp.setEnabled(true);
        rBoutonEmp.setSelected(true);
        
        typePersonnel = TypePersonnel.EMPLOYE;
        
        rBoutonComm.setEnabled(true);
        rBoutonDir.setEnabled(true);
        
        champMB.setEnabled(false);
        
        if(!champNom.isFocusable())
            champNom.setFocusable(true);
        
        champNom.requestFocus();
    }
    
    private void modeRecherche()
    {
        modeCourant = ModeCourant.RECHERCHE;
        labelMode.setText("MODE RECHERCHE");
        
        this.effacer();
        
        boutonChercher.setEnabled(true);
        boutonSuppr.setEnabled(true);
        boutonCreer.setEnabled(false);
        boutonDebut.setEnabled(false);
        boutonPrec.setEnabled(false);
        boutonSuiv.setEnabled(false);
        boutonFin.setEnabled(false);
        
        boutonRecherche.setVisible(true);
        boutonRecherche.setEnabled(true);
        boutonSuppr.setText("Annuler");

        champNom.setEnabled(false);
        champTel.setEnabled(false);
        champMatricule.setEnabled(true);
        champTH.setEnabled(false);
        champNbHeures.setEnabled(false);
        champIndemnite.setEnabled(false);
        champVentes.setEnabled(false);
        champPourcentage.setEnabled(false);
        champMB.setEnabled(false);
        
        champMatricule.setText("M");
        if(!champMatricule.isFocusable())
            champMatricule.setFocusable(true);
        
        champMatricule.requestFocus();
    }
    
    private void effacer()
    {
        champNom.setText("");
        champTel.setText("");
        champMatricule.setText("");
        champTH.setText("");
        champNbHeures.setText("");
        champIndemnite.setText("");
        champVentes.setText("");
        champPourcentage.setText("");
        champMB.setText("");
    }
    
    private void afficher()
    {
        this.effacer();
        
        labelNbObjets.setText(Integer.toString(cont.nbElements()));
        
        if(!cont.estVide())
        {
            Personnel pers = cont.obtenir(cont.cleCourante());
            
            champNom.setText(pers.getNomPers());
            champTel.setText(pers.getNumTel());
            champMatricule.setText(pers.getNumPers());
            
            if(pers instanceof Employe)
            {
                champNbHeures.setText(Float.toString(((Employe)pers).getNbHeures()));
                champTH.setText(Float.toString(((Employe)pers).getTauxHoraire()));
            }
            if(pers instanceof Commercial)
            {/*
                champNbHeures.setText(Float.toString(((Commercial)pers).getNbHeures()));
                champTH.setText(Float.toString(((Commercial)pers).getTauxHoraire()));*/
                champPourcentage.setText(Float.toString(((Commercial)pers).getPourcentage()));
                champVentes.setText(Float.toString(((Commercial)pers).getTotalVentes()));
            }
            if(pers instanceof Directeur)
            {
                champIndemnite.setText(Float.toString(((Directeur)pers).getIndemnites()));
            }
            
            champMB.setText(Float.toString(pers.calculPaie()));
        }
    }
    
    private void saisir()
    {
        champIndemnite.setEnabled(false);
        champPourcentage.setEnabled(false);
        champVentes.setEnabled(false);
        champTH.setEnabled(false);
        champNbHeures.setEnabled(false);
        
        switch(typePersonnel)
        {
            case COMMERCIAL :
                champPourcentage.setEnabled(true);
                champVentes.setEnabled(true);
            case EMPLOYE :
                champTH.setEnabled(true);
                champNbHeures.setEnabled(true);
                break;
            case DIRECTEUR :
                champIndemnite.setEnabled(true);
                break;
        }
    }
    
    private void rechercher()
    {
        if(cont.existe(champMatricule.getText()))
        {
            cont.positionner(champMatricule.getText());
            this.modeAffichage();
            this.afficher();
        }
        else
        {
            showMessageDialog(this, "Ce matricule n'existe pas !", "Matricule inexistant", DEFAULT_OPTION);
        }
    }
    
    private void ajouter()
    {
        String nom = champNom.getText();
        String tel = champTel.getText();
        float th;
        float nbh;
        float pourc;
        float ventes;
        float indemn;
        
        switch(typePersonnel)
        {
            case EMPLOYE :
                th = Float.parseFloat(champTH.getText());
                nbh = Float.parseFloat(champNbHeures.getText());
                
                Employe emp = new Employe(nom, tel, th, nbh);
                cont.ajouter(emp.getNumPers(), emp);
                break; 
            case COMMERCIAL :
                th = Float.parseFloat(champTH.getText());
                nbh = Float.parseFloat(champNbHeures.getText());
                pourc = Float.parseFloat(champPourcentage.getText());
                ventes = Float.parseFloat(champVentes.getText());
                
                Commercial com = new Commercial(nom, tel, th, nbh, pourc, ventes);
                cont.ajouter(com.getNumPers(), com);
                break;
            case DIRECTEUR :
                indemn = Float.parseFloat(champIndemnite.getText());
                
                Directeur dir =  new Directeur(nom, tel, indemn);
                cont.ajouter(dir.getNumPers(), dir);
                break;
        }   
    }
    
    /*class EcouteurMenu implements ActionListener {
        private int choix;
        private JFileChooser d;
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == menuNouveau)
            {
                cont.vider();
                afficher();
            }
            else if(e.getSource() == menuCharger)
            {
                d = new JFileChooser(new File("."));
                d.setDialogTitle("Charger ...");
                // Continuer l'implémentation
            }
            else if(e.getSource() == menuSauvegarder)
            {
                d = new JFileChooser(new File("."));
                d.setDialogTitle("Sauvegarder ...");
            }
            else if(e.getSource() == menuQuitter)
            {
                
            }
            else
            {
                // A faire : le reste :D
            }
        }
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupeBEmp = new javax.swing.ButtonGroup();
        labelImgTeam = new javax.swing.JLabel();
        labelImgGerPer = new javax.swing.JLabel();
        panelInfoGene = new javax.swing.JPanel();
        champNom = new javax.swing.JTextField();
        champTel = new javax.swing.JFormattedTextField();
        champMatricule = new javax.swing.JFormattedTextField();
        labelNom = new javax.swing.JLabel();
        labelTel = new javax.swing.JLabel();
        labelMatricule = new javax.swing.JLabel();
        boutonRecherche = new javax.swing.JButton();
        panelTypeEmp = new javax.swing.JPanel();
        rBoutonEmp = new javax.swing.JRadioButton();
        rBoutonComm = new javax.swing.JRadioButton();
        rBoutonDir = new javax.swing.JRadioButton();
        panelInfoRemune = new javax.swing.JPanel();
        champTH = new javax.swing.JFormattedTextField();
        champNbHeures = new javax.swing.JFormattedTextField();
        champIndemnite = new javax.swing.JFormattedTextField();
        labelTH = new javax.swing.JLabel();
        labelNbHeures = new javax.swing.JLabel();
        labelIndemnite = new javax.swing.JLabel();
        champMB = new javax.swing.JFormattedTextField();
        champPourcentage = new javax.swing.JFormattedTextField();
        labelMB = new javax.swing.JLabel();
        labelPourcentage = new javax.swing.JLabel();
        champVentes = new javax.swing.JFormattedTextField();
        labelVentes = new javax.swing.JLabel();
        panelGestionCont = new javax.swing.JPanel();
        boutonChercher = new javax.swing.JButton();
        boutonSuppr = new javax.swing.JButton();
        boutonCreer = new javax.swing.JButton();
        labelTexte = new javax.swing.JLabel();
        labelNbObjets = new javax.swing.JLabel();
        panelNavCont = new javax.swing.JPanel();
        boutonDebut = new javax.swing.JButton();
        boutonPrec = new javax.swing.JButton();
        boutonSuiv = new javax.swing.JButton();
        boutonFin = new javax.swing.JButton();
        labelMode = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        menuFichier = new javax.swing.JMenu();
        menuNouveau = new javax.swing.JMenuItem();
        menuCharger = new javax.swing.JMenuItem();
        menuSauvegarder = new javax.swing.JMenuItem();
        menuFermerConteneur = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuQuitter = new javax.swing.JMenuItem();
        menuAutre = new javax.swing.JMenu();
        menuAPropos = new javax.swing.JMenuItem();
        sepMenuAutre = new javax.swing.JPopupMenu.Separator();
        menuAide = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(237, 237, 214));
        setResizable(false);

        labelImgTeam.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelImgTeam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImgTeam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo1_team.gif"))); // NOI18N
        labelImgTeam.setToolTipText("");
        labelImgTeam.setBorder(javax.swing.BorderFactory.createBevelBorder(1));

        labelImgGerPer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelImgGerPer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImgGerPer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo2_gesper.gif"))); // NOI18N

        panelInfoGene.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations générales", 0, 0, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(10, 66, 255))); // NOI18N

        champNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                champNomActionPerformed(evt);
            }
        });

        champMatricule.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        champMatricule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                champMatriculeActionPerformed(evt);
            }
        });

        labelNom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNom.setText("Nom");

        labelTel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTel.setText("Téléphone");

        labelMatricule.setText("Matricule");

        boutonRecherche.setText("Recherche");
        boutonRecherche.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        boutonRecherche.setEnabled(false);
        boutonRecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonRechercheActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInfoGeneLayout = new javax.swing.GroupLayout(panelInfoGene);
        panelInfoGene.setLayout(panelInfoGeneLayout);
        panelInfoGeneLayout.setHorizontalGroup(
            panelInfoGeneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoGeneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoGeneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelTel, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(labelNom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(panelInfoGeneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelInfoGeneLayout.createSequentialGroup()
                        .addComponent(champTel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelMatricule))
                    .addComponent(champNom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInfoGeneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boutonRecherche)
                    .addComponent(champMatricule, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelInfoGeneLayout.setVerticalGroup(
            panelInfoGeneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoGeneLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelInfoGeneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNom, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(champNom)
                    .addComponent(boutonRecherche))
                .addGap(18, 18, 18)
                .addGroup(panelInfoGeneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTel)
                    .addComponent(champTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMatricule)
                    .addComponent(champMatricule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        panelTypeEmp.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Choix du type de l'employé", 0, 0, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(10, 66, 255))); // NOI18N

        groupeBEmp.add(rBoutonEmp);
        rBoutonEmp.setSelected(true);
        rBoutonEmp.setText("Employé");
        rBoutonEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBoutonEmpActionPerformed(evt);
            }
        });

        groupeBEmp.add(rBoutonComm);
        rBoutonComm.setText("Commercial");
        rBoutonComm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBoutonCommActionPerformed(evt);
            }
        });

        groupeBEmp.add(rBoutonDir);
        rBoutonDir.setText("Directeur");
        rBoutonDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBoutonDirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTypeEmpLayout = new javax.swing.GroupLayout(panelTypeEmp);
        panelTypeEmp.setLayout(panelTypeEmpLayout);
        panelTypeEmpLayout.setHorizontalGroup(
            panelTypeEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTypeEmpLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(rBoutonEmp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rBoutonComm)
                .addGap(58, 58, 58)
                .addComponent(rBoutonDir)
                .addGap(76, 76, 76))
        );
        panelTypeEmpLayout.setVerticalGroup(
            panelTypeEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTypeEmpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTypeEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rBoutonEmp)
                    .addComponent(rBoutonComm)
                    .addComponent(rBoutonDir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelInfoRemune.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations pour le calcul de la rémunération", 0, 0, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(10, 66, 255))); // NOI18N

        labelTH.setText("Taux horaire");

        labelNbHeures.setText("Nombre d'heures");

        labelIndemnite.setText("Indemnités");

        labelMB.setText("Montant brut");

        labelPourcentage.setText("Pourcentage");

        labelVentes.setText("Ventes");

        javax.swing.GroupLayout panelInfoRemuneLayout = new javax.swing.GroupLayout(panelInfoRemune);
        panelInfoRemune.setLayout(panelInfoRemuneLayout);
        panelInfoRemuneLayout.setHorizontalGroup(
            panelInfoRemuneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoRemuneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoRemuneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelTH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelNbHeures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelIndemnite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelInfoRemuneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(champNbHeures, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(champTH)
                    .addComponent(champIndemnite))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(panelInfoRemuneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelInfoRemuneLayout.createSequentialGroup()
                        .addComponent(labelMB)
                        .addGap(18, 18, 18)
                        .addComponent(champMB, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInfoRemuneLayout.createSequentialGroup()
                        .addComponent(labelVentes, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(champVentes, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInfoRemuneLayout.createSequentialGroup()
                        .addComponent(labelPourcentage, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(champPourcentage, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );
        panelInfoRemuneLayout.setVerticalGroup(
            panelInfoRemuneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoRemuneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoRemuneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoRemuneLayout.createSequentialGroup()
                        .addGroup(panelInfoRemuneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(champTH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTH))
                        .addGap(18, 18, 18)
                        .addGroup(panelInfoRemuneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(champNbHeures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNbHeures))
                        .addGap(18, 18, 18)
                        .addGroup(panelInfoRemuneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(champIndemnite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelIndemnite)))
                    .addGroup(panelInfoRemuneLayout.createSequentialGroup()
                        .addGroup(panelInfoRemuneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(champVentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelVentes))
                        .addGap(18, 18, 18)
                        .addGroup(panelInfoRemuneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(champPourcentage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPourcentage))
                        .addGap(18, 18, 18)
                        .addGroup(panelInfoRemuneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(champMB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMB))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelGestionCont.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestion du conteneur", 0, 0, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(10, 66, 255))); // NOI18N

        boutonChercher.setText("Chercher");
        boutonChercher.setMaximumSize(new java.awt.Dimension(90, 23));
        boutonChercher.setMinimumSize(new java.awt.Dimension(90, 23));
        boutonChercher.setPreferredSize(new java.awt.Dimension(90, 23));
        boutonChercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonChercherActionPerformed(evt);
            }
        });

        boutonSuppr.setText("Supprimer");
        boutonSuppr.setMaximumSize(new java.awt.Dimension(90, 23));
        boutonSuppr.setMinimumSize(new java.awt.Dimension(90, 23));
        boutonSuppr.setPreferredSize(new java.awt.Dimension(90, 23));
        boutonSuppr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonSupprActionPerformed(evt);
            }
        });

        boutonCreer.setText("Créer");
        boutonCreer.setToolTipText("Créer une nouvelle instance");
        boutonCreer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        boutonCreer.setMaximumSize(new java.awt.Dimension(90, 23));
        boutonCreer.setMinimumSize(new java.awt.Dimension(90, 23));
        boutonCreer.setPreferredSize(new java.awt.Dimension(90, 23));
        boutonCreer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonCreerActionPerformed(evt);
            }
        });

        labelTexte.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        labelTexte.setText("Nombre d'objets présents dans le conteneur :");

        labelNbObjets.setText("0");

        javax.swing.GroupLayout panelGestionContLayout = new javax.swing.GroupLayout(panelGestionCont);
        panelGestionCont.setLayout(panelGestionContLayout);
        panelGestionContLayout.setHorizontalGroup(
            panelGestionContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGestionContLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(boutonChercher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(boutonSuppr, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boutonCreer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(panelGestionContLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(labelTexte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelNbObjets)
                .addContainerGap(136, Short.MAX_VALUE))
        );
        panelGestionContLayout.setVerticalGroup(
            panelGestionContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGestionContLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGestionContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutonChercher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonSuppr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonCreer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelGestionContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTexte)
                    .addComponent(labelNbObjets))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelNavCont.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Navigation dans le conteneur", 0, 0, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(10, 66, 255))); // NOI18N

        boutonDebut.setText("Début");
        boutonDebut.setMaximumSize(new java.awt.Dimension(70, 23));
        boutonDebut.setMinimumSize(new java.awt.Dimension(70, 23));
        boutonDebut.setPreferredSize(new java.awt.Dimension(70, 23));
        boutonDebut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonDebutActionPerformed(evt);
            }
        });

        boutonPrec.setText("<<");
        boutonPrec.setMaximumSize(new java.awt.Dimension(70, 23));
        boutonPrec.setMinimumSize(new java.awt.Dimension(70, 23));
        boutonPrec.setPreferredSize(new java.awt.Dimension(70, 23));
        boutonPrec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonPrecActionPerformed(evt);
            }
        });

        boutonSuiv.setText(">>");
        boutonSuiv.setToolTipText("Employé suivant");
        boutonSuiv.setMaximumSize(new java.awt.Dimension(70, 23));
        boutonSuiv.setMinimumSize(new java.awt.Dimension(70, 23));
        boutonSuiv.setPreferredSize(new java.awt.Dimension(70, 23));
        boutonSuiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonSuivActionPerformed(evt);
            }
        });

        boutonFin.setText("Fin");
        boutonFin.setMaximumSize(new java.awt.Dimension(70, 23));
        boutonFin.setMinimumSize(new java.awt.Dimension(70, 23));
        boutonFin.setPreferredSize(new java.awt.Dimension(70, 23));
        boutonFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonFinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelNavContLayout = new javax.swing.GroupLayout(panelNavCont);
        panelNavCont.setLayout(panelNavContLayout);
        panelNavContLayout.setHorizontalGroup(
            panelNavContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNavContLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(boutonDebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(boutonPrec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(boutonSuiv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(boutonFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        panelNavContLayout.setVerticalGroup(
            panelNavContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNavContLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNavContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutonDebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonPrec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonSuiv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelMode.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelMode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMode.setText("MODE AFFICHAGE");
        labelMode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        menuFichier.setText("Fichier");

        menuNouveau.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menuNouveau.setText("Nouveau...");
        menuNouveau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNouveauActionPerformed(evt);
            }
        });
        menuFichier.add(menuNouveau);

        menuCharger.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuCharger.setText("Charger...");
        menuCharger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuChargerActionPerformed(evt);
            }
        });
        menuFichier.add(menuCharger);

        menuSauvegarder.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuSauvegarder.setText("Sauvegarder...");
        menuSauvegarder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSauvegarderActionPerformed(evt);
            }
        });
        menuFichier.add(menuSauvegarder);

        menuFermerConteneur.setText("Fermer le conteneur courant");
        menuFermerConteneur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFermerConteneurActionPerformed(evt);
            }
        });
        menuFichier.add(menuFermerConteneur);
        menuFichier.add(jSeparator2);

        menuQuitter.setText("Quitter");
        menuQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuQuitterActionPerformed(evt);
            }
        });
        menuFichier.add(menuQuitter);

        menu.add(menuFichier);

        menuAutre.setText("?");

        menuAPropos.setText("À propos...");
        menuAutre.add(menuAPropos);
        menuAutre.add(sepMenuAutre);

        menuAide.setText("Aide...");
        menuAutre.add(menuAide);

        menu.add(menuAutre);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panelNavCont, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelGestionCont, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelInfoRemune, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelTypeEmp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelInfoGene, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(labelImgTeam)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(labelImgGerPer))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(labelMode, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelImgTeam))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(labelMode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelImgGerPer, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(panelInfoGene, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelTypeEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelInfoRemune, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelGestionCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelNavCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void champNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_champNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_champNomActionPerformed

    private void menuNouveauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNouveauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuNouveauActionPerformed

    private void menuSauvegarderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSauvegarderActionPerformed
        JFileChooser jfc = new JFileChooser(new File("."));
        jfc.showSaveDialog(this);
        cont.sauvegarder(jfc.getName(jfc.getSelectedFile()));
    }//GEN-LAST:event_menuSauvegarderActionPerformed

    private void rBoutonEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBoutonEmpActionPerformed
        typePersonnel = TypePersonnel.EMPLOYE;
        this.saisir();
    }//GEN-LAST:event_rBoutonEmpActionPerformed

    private void champMatriculeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_champMatriculeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_champMatriculeActionPerformed

    private void boutonSuivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonSuivActionPerformed
        cont.suivant();
        this.afficher();
    }//GEN-LAST:event_boutonSuivActionPerformed

    private void boutonChercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonChercherActionPerformed
        this.modeRecherche();
    }//GEN-LAST:event_boutonChercherActionPerformed

    private void boutonDebutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonDebutActionPerformed
        cont.premier();
        this.afficher();
    }//GEN-LAST:event_boutonDebutActionPerformed

    private void boutonCreerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonCreerActionPerformed
        if(boutonCreer.getText().equals("Créer"))
        {
            this.effacer();
            this.modeSaisie();
            this.saisir();
        }
        else
        {
            this.ajouter();
            this.modeAffichage();
            this.afficher();
            modif = true;
        }
    }//GEN-LAST:event_boutonCreerActionPerformed

    private void boutonRechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonRechercheActionPerformed
        this.rechercher();
    }//GEN-LAST:event_boutonRechercheActionPerformed

    private void boutonSupprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonSupprActionPerformed
        if(modeCourant == ModeCourant.AFFICHAGE)
        {
            if(showConfirmDialog(this, "Êtes-vous sûr(e) de vouloir supprimer ce personnel ?", "Supprimer ...", YES_NO_OPTION) == YES_OPTION)
            {
                cont.supprimer(champMatricule.getText());
                modif = true;
            }
        }
        
        this.modeAffichage();
        this.afficher();
    }//GEN-LAST:event_boutonSupprActionPerformed

    private void menuQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuQuitterActionPerformed
        if(modif)
        {
            switch(showConfirmDialog(this, "Voulez-vous sauvegarder votre travail ?", "Quitter ...", YES_NO_CANCEL_OPTION))
            {
                case YES_OPTION :
                    this.menuSauvegarderActionPerformed(evt);
                case NO_OPTION :
                    System.exit(0); 
            }
        }
        else
            System.exit(0);
    }//GEN-LAST:event_menuQuitterActionPerformed

    private void menuFermerConteneurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFermerConteneurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuFermerConteneurActionPerformed

    private void rBoutonCommActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBoutonCommActionPerformed
        typePersonnel = TypePersonnel.COMMERCIAL;
        this.saisir();
    }//GEN-LAST:event_rBoutonCommActionPerformed

    private void rBoutonDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBoutonDirActionPerformed
        typePersonnel = TypePersonnel.DIRECTEUR;
        this.saisir();
    }//GEN-LAST:event_rBoutonDirActionPerformed

    private void boutonPrecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonPrecActionPerformed
        cont.precedent();
        this.afficher();
    }//GEN-LAST:event_boutonPrecActionPerformed

    private void boutonFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonFinActionPerformed
        cont.dernier();
        this.afficher();
    }//GEN-LAST:event_boutonFinActionPerformed

    private void menuChargerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuChargerActionPerformed
        JFileChooser jfc = new JFileChooser(new File("."));
        jfc.showOpenDialog(this);
        cont.charger(jfc.getName(jfc.getSelectedFile()));
        this.modeAffichage();
        this.afficher();
    }//GEN-LAST:event_menuChargerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gesPers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gesPers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gesPers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gesPers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gesPers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutonChercher;
    private javax.swing.JButton boutonCreer;
    private javax.swing.JButton boutonDebut;
    private javax.swing.JButton boutonFin;
    private javax.swing.JButton boutonPrec;
    private javax.swing.JButton boutonRecherche;
    private javax.swing.JButton boutonSuiv;
    private javax.swing.JButton boutonSuppr;
    private javax.swing.JFormattedTextField champIndemnite;
    private javax.swing.JFormattedTextField champMB;
    private javax.swing.JFormattedTextField champMatricule;
    private javax.swing.JFormattedTextField champNbHeures;
    private javax.swing.JTextField champNom;
    private javax.swing.JFormattedTextField champPourcentage;
    private javax.swing.JFormattedTextField champTH;
    private javax.swing.JFormattedTextField champTel;
    private javax.swing.JFormattedTextField champVentes;
    private javax.swing.ButtonGroup groupeBEmp;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel labelImgGerPer;
    private javax.swing.JLabel labelImgTeam;
    private javax.swing.JLabel labelIndemnite;
    private javax.swing.JLabel labelMB;
    private javax.swing.JLabel labelMatricule;
    private javax.swing.JLabel labelMode;
    private javax.swing.JLabel labelNbHeures;
    private javax.swing.JLabel labelNbObjets;
    private javax.swing.JLabel labelNom;
    private javax.swing.JLabel labelPourcentage;
    private javax.swing.JLabel labelTH;
    private javax.swing.JLabel labelTel;
    private javax.swing.JLabel labelTexte;
    private javax.swing.JLabel labelVentes;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenuItem menuAPropos;
    private javax.swing.JMenuItem menuAide;
    private javax.swing.JMenu menuAutre;
    private javax.swing.JMenuItem menuCharger;
    private javax.swing.JMenuItem menuFermerConteneur;
    private javax.swing.JMenu menuFichier;
    private javax.swing.JMenuItem menuNouveau;
    private javax.swing.JMenuItem menuQuitter;
    private javax.swing.JMenuItem menuSauvegarder;
    private javax.swing.JPanel panelGestionCont;
    private javax.swing.JPanel panelInfoGene;
    private javax.swing.JPanel panelInfoRemune;
    private javax.swing.JPanel panelNavCont;
    private javax.swing.JPanel panelTypeEmp;
    private javax.swing.JRadioButton rBoutonComm;
    private javax.swing.JRadioButton rBoutonDir;
    private javax.swing.JRadioButton rBoutonEmp;
    private javax.swing.JPopupMenu.Separator sepMenuAutre;
    // End of variables declaration//GEN-END:variables
}
