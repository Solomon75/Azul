import javax.swing.*;
import java.awt.*;

public class VueBis extends JFrame {
    Plateau plate;

    public VueBis(Plateau p){
        /**********Fenêtre principale***************/

        setSize(new Dimension(1280, 720));
        setVisible(true);
        setDefaultCloseOperation(3);
        setLayout(new GridLayout(2, 1));

        /***********Cadrage des objets**************/

        //Grille des éléments hors joueurs
        JPanel FabCentre = new JPanel(new GridLayout(2, 1));

        //Fabriques

        JPanel fabriques = new JPanel(new GridLayout(1, p.getFabs().length, 10, 10));
        int fabs = 0;
        for (Fabrique ignored : p.getFabs()){
            JLabel [] fabrique = new JLabel[4];
            JPanel fab = new JPanel(new GridLayout(2, 2));
            fab.setBackground(Color.pink);
            for(JLabel jl : fabrique){
                jl = new JLabel("Tuile");
                fab.add(jl);
            }
            fabriques.add(fab);
            fabs++;
        }
        //fabriques.setVisible(true);
        FabCentre.add(fabriques);

        //Centre
        JPanel centre = new JPanel();
        JLabel center = new JLabel("Centre");
        center.setAlignmentX((JComponent.CENTER_ALIGNMENT));
        center.setAlignmentY((JComponent.CENTER_ALIGNMENT));
        center.setForeground(Color.WHITE);
        centre.add(center);
        centre.setBackground(Color.BLACK);
        FabCentre.add(centre);

        //Joueurs

        JPanel joueurs;

        int j = 0;
        int nbJoueurs = p.getJoueurs().length;
        if(nbJoueurs == 2){
            joueurs = new JPanel(new GridLayout(1, 2));
        } else {
            joueurs = new JPanel(new GridLayout(2, 2));
        }
        for(Joueur ignored : p.getJoueurs()){
            joueurs.add(new JLabel("Joueur" + (j+1)));
            j++;
        }
        //Ajout final
        getContentPane().add(FabCentre);
        getContentPane().add(joueurs);
    }

    public static void main(String[] args) {
        Plateau p = new Plateau();
        SwingUtilities.invokeLater(new Runnable() { public void run() { VueBis v = new VueBis(p); }});
    }
}
