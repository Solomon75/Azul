import java.util.ArrayList;
import java.util.Collections;
public class Sac {
    private ArrayList<Tuile> sac;

    public Sac(){
        sac = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            if(i < 20){
                sac.add(new Tuile("blue"));
            } if (i <= 40 && i >= 20) {
                sac.add(new Tuile("yellow"));
            } if (i <= 60 && i > 40){
                sac.add(new Tuile("red"));
            } if (i <= 80 && i > 60){
                sac.add(new Tuile("black"));
            } if (i > 80){
                sac.add(new Tuile("white"));
            }
        }
        Collections.shuffle(sac);
    }
    boolean estVide(){return sac.isEmpty();}
    Tuile envoyer(){ return sac.remove(0); }
    int taille(){return sac.size();}
}
