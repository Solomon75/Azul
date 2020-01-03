public class Case {
    protected Tuile t;

    Case(){
        t = new Tuile("empty");
    }

    Tuile getTuile(){ return t;}
    boolean estVide(){ return t.getCouleur().equals("empty"); }
    void setTuile(Tuile t){this.t = t;}
    void clear(Defausse d){d.ajouter(t); t = new Tuile("empty");}

    public String toString(){
        if (estVide()) return "Case vide";
        else return t.getCouleur();
    }
}
