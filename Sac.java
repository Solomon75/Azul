import java.util.ArrayList;
import java.util.Collections;
public class Sac {
    private ArrayList<Tuile> sac;

    public Sac(){
        sac = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            if(i < 20){
                sac.add(new Tuile("bleu"));
            } if (i <= 40 && i >= 20) {
                sac.add(new Tuile("jaune"));
            } if (i <= 60 && i > 40){
                sac.add(new Tuile("rouge"));
            } if (i <= 80 && i > 60){
                sac.add(new Tuile("noir"));
            } if (i > 80){
                sac.add(new Tuile("blanc"));
            }
        }
        Collections.shuffle(sac);
    }
    boolean estVide(){return sac.isEmpty();}
    Tuile envoyer(){ return sac.remove(0); }
    int taille(){return sac.size();}
}
