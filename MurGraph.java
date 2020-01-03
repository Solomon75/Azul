import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class MurGraph extends JPanel {
    JPanel panel;
    TuileGraph[][] mur;

    MurGraph(){
        mur = new TuileGraph[5][5];
        panel = new JPanel(new GridLayout(5, 5));
        LinkedList<String> couleurs = new LinkedList<>();
        couleurs.add("murblue");
        couleurs.add("muryellow");
        couleurs.add("murred");
        couleurs.add("murblack");
        couleurs.add("murwhite");
        String tmp = "";
        for (int i = 0; i < mur.length; i++) {
            for (int j = 0; j < mur[i].length; j++) {
                mur[i][j] = new TuileGraph(couleurs.get(j));
                panel.add(mur[i][j]);
            }
            tmp = couleurs.getLast();
            couleurs.remove(couleurs.getLast());
            couleurs.addFirst(tmp);
        }
        add(panel);
    }

    public void remplirCase(int ligne, String couleur){
        for(int j = 0; j < mur[ligne].length; j++){
            if(mur[ligne][j].couleur.equals("mur"+couleur)){
                mur[ligne][j].img=  new ImageIcon("imageTuiles/mur"+couleur+".png");
                mur[ligne][j].lab.setIcon(mur[ligne][j].img);
                mur[ligne][j].couleur= couleur;
            }
        }
    }
}
