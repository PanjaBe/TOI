package affichage;

import javax.swing.JOptionPane;
import objet.Serpent;
import snake.CanibalException;

public class MyThread extends Thread {
    /* Attributs */
    private Affichage affichage;

    /* Constructeur */
    public MyThread(Affichage aff) {
        this.affichage = aff;
    }
    
    
    /* Fonctions */
    public void run() {
            Serpent serpent = affichage.getSerpent();
            while(serpent.getEtat()){
                while(affichage.getPlay()) {
                    try {
                        Thread.sleep(serpent.getVitesse());
                        serpent.deplacer();
                    } catch(Exception e) {
                        if(e instanceof CanibalException) {
                            serpent.setEtat(false);
                            affichage.setPlay(false);
                            affichage.getContentPane().setEnabled(false);
                            JOptionPane.showMessageDialog(null, "<html><p style='color:red'>Vous avez perdu</p></html>", "Fin de la partie" ,JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
    }
}