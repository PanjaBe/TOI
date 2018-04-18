package listener;

import affichage.Affichage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMenuListener implements ActionListener {
    /* Attributs */
    private Affichage affichage;
    
    /* Constructeur */
    public MyMenuListener(Affichage aff) {
        affichage = aff;
        affichage.getJMenuBar().getMenu(0).getItem(0).addActionListener(this);
        affichage.getJMenuBar().getMenu(0).getItem(1).addActionListener(this);
        affichage.getHaut().addActionListener(this);
        affichage.getBas().addActionListener(this);
        affichage.getGauche().addActionListener(this);
        affichage.getDroite().addActionListener(this);
    }
        
    /* Fonctions */
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().compareTo("Pauser(P)")==0 || e.getActionCommand().compareTo("Continuer(P)")==0) {
            affichage.pauser();
        }
        else if(e.getActionCommand().compareTo("W")==0) {
            try {
                affichage.getSerpent().setSens(8);
            } catch(Exception ex) {}
        }
        else if(e.getActionCommand().compareTo("S")==0) {
            try {
                affichage.getSerpent().setSens(2);
            } catch(Exception ex) {}
        }
        else if(e.getActionCommand().compareTo("A")==0) {
            try {
                affichage.getSerpent().setSens(4);
            } catch(Exception ex) {}
        }
        else if(e.getActionCommand().compareTo("D")==0) {
            try {
                affichage.getSerpent().setSens(6);
            } catch(Exception ex) {}
        }
        else {
            try {
            affichage.rejouer();
            } catch(Exception ex) {}
        }
    }
}
