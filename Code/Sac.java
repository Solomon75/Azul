import java.util.ArrayList;
import java.util.Collections;
public class Sac extends Zone{
    private ArrayList<Tuile> sac;

    /*
    * tuilesListe est un attribut de type ArrayList présent dans la classe abstraite Zone.java.
    */
    public Sac(){
        tuilesListe = new ArrayList<>(100);
        for(int i = 0; i < 100; i++){
            if(i < 20){
                sac.add(new Tuile("bleu"));
            } else if (i < 40 && i >= 20) {
                sac.add(new Tuile("vert"));
            } else if (i < 60 && i >= 40){
                sac.add(new Tuile("rouge"));
            } else if (i < 80 && i >= 60){
                sac.add(new Tuile("noir"));
            } else if (i >= 80){
                sac.add(new Tuile("blanc"));
            }
        }
        Collections.shuffle(sac);
        tuilesListe = sac;
    }

    public ArrayList<Tuile> getSac() {
        return sac;
    }

    boolean estVide(){return sac.isEmpty();}
}