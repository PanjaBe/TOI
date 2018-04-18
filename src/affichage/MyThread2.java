package affichage;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import objet.Membre;
import objet.Nourriture;
import objet.Serpent;

public class MyThread2 extends Thread {
    /* Attributs */
    private Affichage affichage;

    /* Getters */
    public MyThread2(Affichage aff) {
        this.affichage = aff;
    }
    
    /* Fonctions */
    public void run() {
        Serpent serpent = affichage.getSerpent();
        Nourriture bouffe = affichage.getNourriture();
        ArrayList<Membre> points = serpent.getPoints();
        JPanel point = points.get(0);
        JLabel longueur = affichage.getLongueur();
        JLabel score = affichage.getScore();
        while(serpent.getEtat()){
            if(point.getX() == bouffe.getX() && point.getY() == bouffe.getY()) {
                System.out.print("huhu");
                serpent.ralonger();
                points = serpent.getPoints();
                int tailleSerp = points.size();
                affichage.getTerrain().add(points.get(tailleSerp-1));
                affichage.setNourriture();
                Integer integer = Integer.valueOf(longueur.getText());
                integer ++;
                longueur.setText(""+integer);
                integer = Integer.valueOf(score.getText());
                integer ++;
                score.setText(""+integer);
            }
            else if(point.getX()>380 || point.getX()<1 || point.getY()>380 || point.getY()<1) {
                serpent.setEtat(false);
                affichage.setPlay(false);
                affichage.getContentPane().setEnabled(false);
                JOptionPane.showMessageDialog(null, "<html><p style='color:red'>Vous avez perdu</p></html>", "Fin de la partie" ,JOptionPane.ERROR_MESSAGE);
            }
            if(points.size()==14) {
                serpent.setEtat(false);
                affichage.setPlay(false);
                affichage.getContentPane().setEnabled(false);
                JOptionPane.showMessageDialog(null, "<html><p style='color:green'>Vous avez gagné</p></html>", "Fin de la partie" ,JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
}
