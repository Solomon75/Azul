import javax.swing.*;
import java.awt.*;

public class Vue extends JFrame {
    int espace = 5;
    int nbJoueur = 1;
    public Vue(){
        setSize(1300,840);
        setResizable(false);
        murScore();
        Board b = new Board();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(b);
    }

    public void murScore(){
        Box b;
        b = new Box(0);
        b.setBackground(Color.BLACK);
        add(b);
    }

    public void lignesMotif(){

    }

    public void Plancher(){

    }

    public class Board extends JPanel{
        public void paintComponent(Graphics g){
            g.setColor(Color.DARK_GRAY);
            g.fillRect(0,0,1300,840);
            g.setColor(Color.gray);
            for (int i = 0; i < 16; i++){
                for (int j = 0; j < 9; j++){
                    g.fillRect((espace+i*40)/nbJoueur,(espace+j*40+40)/nbJoueur,(40-nbJoueur*espace)/nbJoueur,(40-nbJoueur*espace)/nbJoueur);
                }
            }
        }
    }

    public static void main(String[] args) {
        Vue v = new Vue();
        v.setVisible(true);
    }

}
