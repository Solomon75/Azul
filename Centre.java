import java.util.ArrayList;

public class Centre {
    private Case[] centre;
    Tuile premierJoueur;

    Centre(int taille){
        centre = new Case[taille];
        for(int i = 0; i < centre.length; i++){
            centre[i] = new Case();
        }
    }

    boolean remplirCentre(Tuile t){
        for(Case c : centre){
            if (c.estVide()){
                c.setTuile(t);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Tuile> prendre(String couleur){
        ArrayList<Tuile> t= new ArrayList<>();
        for(Case ca : centre){
            if(ca.getTuile().getCouleur().equals(couleur)){
                t.add(ca.getTuile());
            }
        }
        return t;
    }

    public void vider(String couleur){
        for(Case ca : centre){
            if(ca.getTuile().getCouleur().equals(couleur))
                ca.setTuile(null);
        }
    }

    boolean estVide(){
        for(Case c : centre){
            if(!c.estVide()) return false;
        }
        return true;
    }

    public Case[] getCentre() {
        return centre;
    }
}
