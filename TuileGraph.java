import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TuileGraph extends JPanel {
    public String couleur;
    public ImageIcon img;
    public JLabel lab;


    TuileGraph(String c){
        couleur = c;
        img = new ImageIcon("imageTuiles/" + couleur + ".png");
        lab = new JLabel(img, JLabel.CENTER);
        add(lab);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Tuile " + couleur + " cliquée.");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    boolean estVide(){
        return couleur.toLowerCase().equals("empty");
    }
}
