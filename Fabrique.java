public class Fabrique {
    Case[]fab;

    public Fabrique(){
        fab = new Case[4];
        for (int i = 0; i < fab.length; i++){
            fab[i] = new Case();
        }
    }

    Case getCase(int t){
        return fab[t];
    }

    boolean remplirLigneMotif(Joueur.LigneMotif l, int ligne, Tuile t){
        for(Case c : fab){
            if (t.getCouleur().equals(c.getTuile().getCouleur())){
                l.remplirLigne(c.getTuile(), ligne);
            }
        }
        if (estVide()) return true;
        return false;
    }

    void remplirCentre(Centre c){
        for(Case ca : fab){
            if(!ca.estVide()) c.remplirCentre(ca.getTuile());
        }
    }

    boolean estPleine(){
        for (Case a : fab) {
            if (a.estVide()) return false;
        }
        return true;
    }

    public void ajouter(Sac s){
        int i = 0;
        while(!estPleine()){
            if(fab[i].estVide()) fab[i].setTuile(s.envoyer());
            i++;
        }
    }

    boolean estVide(){
        return !(estPleine());
    }

    public static void main(String[] args) {
        Sac s = new Sac();
        Fabrique f = new Fabrique();
        System.out.println(s.taille());
        f.ajouter(s);
        for(Case c : f.fab) System.out.println(c);
        System.out.println(s.taille());

    }
}
