public class Case {
    protected Tuile t;

    Case(){
        t = null;
    }

    Tuile getTuile(){ return t;}
    boolean estVide(){ return t == null; }
    void setTuile(Tuile t){this.t = t;}

    public String toString(){
        if (t == null) return "Vide";
        else return t.getCouleur();
    }
}
