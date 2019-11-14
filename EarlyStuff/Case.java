public class Case {
    Tuile t;

    Case(){
        t = null;
    }

    Tuile getTuile(){ return t;}
    boolean estVide(){return t == null;}
    void setTuile(Tuile t){this.t = t;}
}
