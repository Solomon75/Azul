public class CaseMur extends Case {
    String couleur;

    CaseMur(String c){
        super();
        couleur = c;
    }
    Tuile getTuile(){ return t;}
    boolean estVide(){return t == null;}
    void setTuile(Tuile t){this.t = t;}
    String getCouleur(){return couleur;}
    public String toString(){
        return couleur;
    }
    boolean sameColor(Tuile t){return couleur.equals(t.getCouleur());}
}
