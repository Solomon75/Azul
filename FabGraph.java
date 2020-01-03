import javax.swing.*;
import java.awt.*;

public class FabGraph extends JPanel {
    JPanel fabrique = new JPanel();
   TuileGraph[] tuilesFab = new TuileGraph[4];
   Fabrique fab;

   FabGraph(Fabrique f) {
       fab = f;
       fabrique.setLayout(new GridLayout(2, 2));
       for (int i = 0; i < 4; i++) {
           tuilesFab[i] = new TuileGraph("empty");
           tuilesFab[i].lab.setIcon(null);
           tuilesFab[i].lab.setBackground(Color.PINK);
           tuilesFab[i].lab.setTransferHandler(new TransferHandler("icon"));
           fabrique.add(tuilesFab[i].lab);
       }
       fabrique.setBackground(Color.PINK);
       setBackground(Color.PINK);
       add(fabrique);
   }

    public void retirer(String couleur){
        for(TuileGraph t : tuilesFab){
            if(t.couleur.equals(couleur)){
                t.lab.setIcon(null);
                t.lab.setBackground(Color.WHITE);
                t.couleur = null;
            }
        }
        revalidate();
    }

    public void vider(){  //Détruit toutes les tuiles de la fabrique.
        for(TuileGraph t: tuilesFab){
            t.lab.setIcon(null);
            t.lab.setBackground(Color.WHITE);
            t.couleur = null;
        }
        fabrique.setBackground(Color.PINK);
    }

    public boolean estVide(){
        for(TuileGraph t: tuilesFab){
            if(t.lab.getIcon() != null){
                return false;
            }
        }
        return true;
    }

    public void remplirCentre(CentreGraph centre, String couleur, int nombre, VueBis.GestionnaireEvenement gest){
        TuileGraph[] tui= new TuileGraph[4-nombre];
        int i=0;
        int j=0;
        while(i<4 && j< tui.length){
            if(!tuilesFab[i].couleur.equals(couleur)){
                tui[j]= tuilesFab[i];
                j++;
            }
            i++;
        }
        centre.remplir(tui);
        vider();
    }

    public void remplir(Fabrique f){
        fab = f;
        for(int i = 0; i < 4; i++){
            tuilesFab[i].lab.setIcon(new ImageIcon("imageTuiles/"+fab.getCase(i).getTuile().getCouleur()+".png"));
            tuilesFab[i].couleur = fab.getCase(i).getTuile().getCouleur();
        }
        revalidate();
    }
}
