<<<<<<< HEAD
import java.util.Arrays;

=======
>>>>>>> 633e055c3788e5a2b60e364200b30e2b61352b23
public class Centre {
    private Case[] centre;

    Centre(int taille){
        centre = new Case[taille];
<<<<<<< HEAD
        for(int i = 0; i < centre.length; i++){
            centre[i] = new Case();
        }
=======
        for(Case c : centre) c = new Case();
>>>>>>> 633e055c3788e5a2b60e364200b30e2b61352b23
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
<<<<<<< HEAD

    public String toString(){
        return Arrays.toString(centre);
    }

    int taille(){return centre.length;}
=======
>>>>>>> 633e055c3788e5a2b60e364200b30e2b61352b23
}
