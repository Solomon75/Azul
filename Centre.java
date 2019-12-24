import java.util.Arrays;

public class Centre {
    private Case[] centre;

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

    public String toString(){
        return Arrays.toString(centre);
    }

    int taille(){return centre.length;}
}
