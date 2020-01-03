import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CentreGraph extends JPanel {
    ArrayList<TuileGraph> tuiles= new ArrayList<>();
    JPanel centre;
    TuileGraph tuilePremierJoueur;

    CentreGraph(){
        centre= new JPanel();
        centre.setBackground(Color.LIGHT_GRAY);
        setBackground(Color.LIGHT_GRAY);
        add(centre);
        setSize(new Dimension(200,100));
    }

    public void vider (String couleur){
        if(couleur.equals("first")){
            System.out.println("tuileprems");
            tuiles.remove(tuilePremierJoueur);
            this.tuilePremierJoueur= null;

        }
        tuiles.removeIf(t -> t.couleur.equals(couleur));
        centre.removeAll();
        if(!tuiles.isEmpty()){
            for(TuileGraph tui: tuiles){
                centre.add(tui.lab);
            }
        }
    }



    public void remplir (TuileGraph[] tuiles) {
        centre.setLayout(new GridLayout(5, 5));
        for (TuileGraph t : tuiles) {
            TuileGraph tu = new TuileGraph(t.couleur);
            this.tuiles.add(tu);
            centre.add(tu.lab);
        }
    }

    public boolean estVide(){
        return tuiles.size() == 0;
    }
}

