import java.util.ArrayList;

public class Defausse extends Zone{
    ArrayList<Tuile> def;
    Defausse(){
        def = new ArrayList<>();
    }

    boolean estVide(){return def.isEmpty();}
}