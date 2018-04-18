package objet;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.border.LineBorder;
import snake.CanibalException;

public class Serpent {
    private ArrayList<Membre> points;
    private int sens = 6;
    private boolean etat = true;
    private int vitesse = 200;
    
    /* Getters */
    public ArrayList<Membre> getPoints() {
        return points;
    }
    
    public int getSens() {
        return sens;
    }
    
    public boolean getEtat() {
        return etat;
    }
    
    public int getVitesse() {
        return vitesse;
    }

    /* Setters */
    public void setPoints(ArrayList<Membre> points) {
        this.points = points;
    }
    
    public void setSens(int sen) throws Exception {
        if(sen!=6 && sen!=4 && sen!=8 && sen!=2) {
            throw new Exception("Sens inexistant");
        }
        if((sens == 6 && sen == 4) || (sens == 4 && sen == 6) || (sens == 8 && sen == 2) || (sens == 2 && sen == 8)) {
            throw new Exception("Retour interdit");
        }
        sens = sen;
    }
    
    public void setEtat(boolean bool) {
        etat = bool;
    }

    /* Constructeur */
    public Serpent() {
        points = new ArrayList();
        Membre point;
        for(int i=5;i>0;i--) {
            point = new Membre();
            point.setBounds(50+(10*i), 50, 10, 10);
            point.setBorder(new LineBorder(Color.BLACK, 10, true));
            point.setForeground(Color.BLACK);
            points.add(point);
        }
    }
    
    /* Fonctions */
    public void deplacer() throws Exception {
        int taille = points.size();
        int i;
        for(i=1;i<taille;i++) {
            points.get(i).setNextX(points.get(i-1).getX());
            points.get(i).setNextY(points.get(i-1).getY());
        }
        Membre point = points.get(0);
        if(sens == 6) {
            point.setLocation(point.getX()+10,point.getY());
        }
        else if(sens == 4) {
            point.setLocation(point.getX()-10,point.getY());
        }
        else if(sens == 8) {
            point.setLocation(point.getX(),point.getY()-10);
        }
        else {
            point.setLocation(point.getX(),point.getY()+10);
        }
        Membre pointSuiv;
        for(i=1;i<taille;i++) {
            pointSuiv = points.get(i);
            pointSuiv.deplacer();
        }
        for(i=1;i<taille;i++) {
            pointSuiv = points.get(i);
            if(point.getX()==pointSuiv.getX() && point.getY()==pointSuiv.getY()) {
                throw new CanibalException();
            }
        }
    }
    
    public void ralonger() {
        int taille = points.size();
        Membre point = new Membre();
        point.setBounds(points.get(0).getX()-(10*taille), points.get(0).getY(), 10, 10);
        point.setBorder(new LineBorder(Color.BLACK, 10, true));
        point.setForeground(Color.BLACK);
        points.add(point);
        vitesse -= 20;
    }
}
