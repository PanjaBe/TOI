package objet;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Nourriture extends JPanel {
    public static int generateRandom(int lim) {
        Double d = Math.random()*400;
        int ret = d.intValue();
        if(ret%10!=0 || ret==lim || ret<50 || ret>330) {
            return generateRandom(lim);
        }
        return ret;
    }
    
    public Nourriture(int limX,int limY) {
        setBorder(new LineBorder(Color.GREEN, 10, true));
        setBounds(generateRandom(limX),generateRandom(limY),10,10);
        setForeground(Color.GREEN);
    }
}
