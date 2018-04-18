package listener;

import affichage.Affichage;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import objet.Serpent;

public class AffichageListener implements KeyListener {
    Affichage aff;
    Serpent serpent;
    
    public AffichageListener(Affichage aff) {
        this.aff = aff;
        aff.addKeyListener(this);
        serpent = aff.getSerpent();
    }
    
    public void keyTyped(KeyEvent e) {
        try
        {
            if(serpent.getEtat()) {
                if(e.getKeyChar()=='d') {
                    serpent.setSens(6);
                }
                else if(e.getKeyChar()=='a') {
                    serpent.setSens(4);
                }
                else if(e.getKeyChar()=='w') {
                    serpent.setSens(8);
                }
                else if(e.getKeyChar()=='s') {
                    serpent.setSens(2);
                }
            }
            if(e.getKeyChar()=='p') {
                aff.pauser();
            }
            if(e.getKeyChar()=='r') {
                aff.rejouer();
            }
        }
        catch(Exception exp)
        {
            System.out.println(exp.getMessage());
        }
    }
    
    public void keyReleased(KeyEvent e) {
    }
    
    public void keyPressed(KeyEvent e) {
    }
}
