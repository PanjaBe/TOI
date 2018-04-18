package objet;

import javax.swing.JPanel;

public class Membre extends JPanel {
    /* Attributs */
    private int nextX;
    private int nextY;

    /* Getters */

    public int getNextX() {
        return nextX;
    }

    public void setNextX(int nextX) {
        this.nextX = nextX;
    }

    /* Setters */
    public int getNextY() {
        return nextY;
    }

    public void setNextY(int nextY) {
        this.nextY = nextY;
    }
    
    /* Fonctions */
    public void deplacer() {
        setLocation(nextX,nextY);
    }
}
