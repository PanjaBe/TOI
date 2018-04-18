package affichage;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;
import objet.Membre;
import objet.Nourriture;
import objet.Serpent;

public class Affichage extends JFrame {
    /* Attributs */
    private Serpent serpent;
    private Nourriture bouffe;
    private JPanel terrain;
    private JPanel tableau;
    private final JLabel libelleLong = new JLabel("Longueur :");
    private JLabel longueur = new JLabel();
    private final JLabel libelleScore = new JLabel("Score :");
    private JLabel score = new JLabel("0");
    private final JLabel libelleObj = new JLabel("Objectif :");
    private JLabel objectif = new JLabel("9");
    private boolean play = true;
    private JButton haut;
    private JButton bas;
    private JButton gauche;
    private JButton droite;
    
    /* Setters */
    public void setNourriture() {
        bouffe.setLocation(Nourriture.generateRandom(50),Nourriture.generateRandom(50));
    }
    
    public void setPlay(boolean bool) {
        play = bool;
    }
    
    /* Getters */
    public Serpent getSerpent() {
        return serpent;
    }

    public JPanel getTerrain() {
        return terrain;
    }
    
    public Nourriture getNourriture() {
        return bouffe;
    }
    
    public JLabel getLongueur() {
        return longueur;
    }
    
    public JLabel getScore() {
        return score;
    }
    
    public boolean getPlay() {
        return play;
    }

    public JButton getHaut() {
        return haut;
    }

    public JButton getBas() {
        return bas;
    }

    public JButton getGauche() {
        return gauche;
    }

    public JButton getDroite() {
        return droite;
    }
    
    /* Constructeur */
    public Affichage() {
        /* Initialisation */
        setTitle("Snake Panja S6");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 550, 450);
        getContentPane().setLayout(null);
        setResizable(false);
        
        /* Ajout de menu */
        JMenuItem pause =new JMenuItem("Pauser(P)");
        JMenuItem nouveau =new JMenuItem("Rejouer(R)");
        JMenu menu=new JMenu("Jeu");
        menu.add(pause);
        menu.add(nouveau);
        JMenuBar menubar=new JMenuBar();
        menubar.add(menu);
        setJMenuBar(menubar);
        
        /* Ajout du terrain */
        terrain = new JPanel();
        terrain.setBounds(0, 0, 400, 400);
        terrain.setBorder(new LineBorder(Color.BLACK, 1, true));
        terrain.setLayout(null);
        getContentPane().add(terrain);
        
        /* Ajout objets de jeu */
        serpent = new Serpent();
        ArrayList<Membre> points = serpent.getPoints();
        int taille = points.size();
        for(int i=0;i<taille;i++) {
            terrain.add(points.get(i));
        }
        bouffe = new Nourriture(50,50);
        terrain.add(bouffe);
        
        /* Ajout du tableau de score */
        tableau = new JPanel();
        tableau.setBounds(400, 0, 150, 400);
        tableau.setLayout(null);
        
        libelleLong.setHorizontalTextPosition(JLabel.LEFT);
        libelleLong.setBounds(0,0,60,20);
        
        libelleScore.setHorizontalTextPosition(JLabel.LEFT);
        libelleScore.setBounds(0,20,60,20);
        
        libelleObj.setHorizontalTextPosition(JLabel.LEFT);
        libelleObj.setBounds(0,40,60,20);
        
        longueur.setText(String.valueOf(serpent.getPoints().size()));
        longueur.setHorizontalTextPosition(JLabel.RIGHT);
        longueur.setBounds(65,0,35,20);
        
        score.setHorizontalTextPosition(JLabel.RIGHT);
        score.setBounds(65,20,35,20);
        
        objectif.setHorizontalTextPosition(JLabel.RIGHT);
        objectif.setBounds(65,40,35,20);
        
        haut = new JButton("W");
        haut.setFocusable(false);
        haut.setBounds(50,100,50,50);
        
        bas = new JButton("S");
        bas.setFocusable(false);
        bas.setBounds(50,150,50,50);
        
        gauche = new JButton("A");
        gauche.setFocusable(false);
        gauche.setBounds(0,150,50,50);
        
        droite = new JButton("D");
        droite.setFocusable(false);
        droite.setBounds(100,150,50,50);
        
        tableau.add(libelleLong);
        tableau.add(libelleScore);
        tableau.add(libelleObj);
        tableau.add(longueur);
        tableau.add(score);
        tableau.add(objectif);
        tableau.add(haut);
        tableau.add(bas);
        tableau.add(gauche);
        tableau.add(droite);
        getContentPane().add(tableau);
    }
    
    /* Fonctions */
    public void pauser() {
        if(play) {
            play = false;
            getJMenuBar().getMenu(0).getItem(0).setText("Continuer(P)");
        } else {
            play = true;
            getJMenuBar().getMenu(0).getItem(0).setText("Pauser(P)");
        }
    }
    
    public void rejouer() throws Exception {
        play = false;
        serpent.setEtat(false);
        terrain.remove(serpent.getPoints().get(0));
        terrain.remove(serpent.getPoints().get(1));
        serpent = new Serpent();
        /*ArrayList<JPanel> points = serpent.getPoints();
        int tailleSerp = points.size();
        for(int i=0;i<tailleSerp;i++) {
            terrain.add(points.get(i));
        }
        setNourriture();*/
    }
}