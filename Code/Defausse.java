import java.util.ArrayList;

public class Defausse{
    ArrayList<Tuile> def;
    Defausse(){
        def = new ArrayList<>();
    }

    boolean estVide(){return def.isEmpty();}
}