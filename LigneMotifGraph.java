import javax.swing.*;
import java.awt.*;

public class LigneMotifGraph extends JPanel{
    public TuileGraph[][] tuiles = new TuileGraph[5][] ;
    public JPanel[] lignes= new JPanel[5];
    JPanel panel= new JPanel();

    public LigneMotifGraph() {
        panel.setLayout(new GridLayout(5,0));
        for (int i = 0; i < 5; i++) {
            tuiles[i] = new TuileGraph[i+1];
            lignes[i]= new JPanel();
            lignes[i].setLayout(new GridLayout(0,5));
            for(int j = 0; j <= i ; j++){
                tuiles[i][j] = new TuileGraph("empty");
                tuiles[i][j].lab.setBorder(BorderFactory.createLineBorder(Color.white, 3));
                tuiles[i][j].lab.setTransferHandler(new TransferHandler("icon"));
                lignes[i].add(tuiles[i][j].lab);
            }
            lignes[i].setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            panel.add(lignes[i]);
        }

        this.add(panel);
        this.setBackground(Color.PINK);
    }

    public void miseAJour(int ligne, String couleur, int nombre) {
        int nom;
        nom = nombre + casesRemplie(ligne, couleur);
        lignes[ligne].removeAll();
        for (int i = 0; i < this.tuiles[ligne].length; i++) {
            if (nom != 0) {
                tuiles[ligne][i] = new TuileGraph(couleur);
                tuiles[ligne][i].setTransferHandler(new TransferHandler("icon"));
                nom--;

            } else {
                tuiles[ligne][i] = new TuileGraph("empty");
            }
            lignes[ligne].add(tuiles[ligne][i].lab);
            tuiles[ligne][i].setTransferHandler(new TransferHandler("icon"));
        }
    }

    public String viderLigne(int i){
        String couleur = tuiles[i][0].couleur;
        lignes[i].removeAll();
        for(int j = 0; j < tuiles[i].length; j++){
            tuiles[i][j]= new TuileGraph("empty");
            lignes[i].add(this.tuiles[i][j].lab);
        }
        return couleur;
    }

    public int casesRemplie(int ligne, String cou){
        int nb = 0;
        for(TuileGraph gh : this.tuiles[ligne]){
            if(gh.couleur.equals(cou)){
                nb++;
            }
        }
        return nb;
    }
}
