package snake;

import affichage.Affichage;
import affichage.MyThread;
import affichage.MyThread2;
import listener.AffichageListener;
import listener.MyMenuListener;

public class Snake {
    public static void main(String[] args) {
        Affichage affichage = new Affichage();
        affichage.setVisible(true);
        AffichageListener listener = new AffichageListener(affichage);
        MyMenuListener menuListener = new MyMenuListener(affichage);
        MyThread thread = new MyThread(affichage);
        MyThread2 thread2 = new MyThread2(affichage);
        thread.start();
        thread2.start();
    }
}
