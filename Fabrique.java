import java.util.Arrays;

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

    int sameColor(int i){
        int nb = 1;
        for(int j = 0; j < fab.length; j++){
            if (j != i)
                if (fab[j].getTuile().getCouleur().equals(fab[i].getTuile().getCouleur())) nb++;
        }
        return nb;
    }

    boolean remplirLigneMotif(Joueur.LigneMotif l, int ligne, Case c){
                l.remplirLigne(c.getTuile(), ligne);
                c.setTuile(null);
        if (c.estVide()) return true;
        return false;
    }

    void remplirCentre(Centre c){
        for(Case ca : fab){
            if(!ca.estVide()) c.remplirCentre(ca.getTuile());
            ca.setTuile(null);
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

    public String toString(){
        String ret = "";
        for(int i = 0; i < fab.length-1; i++){
            ret = ret + fab[i] + " " ;
        }
        ret = ret + fab[fab.length-1];
        return ret;
    }

    public static void main(String[] args) {
        Sac s = new Sac();
        Fabrique f = new Fabrique();
        System.out.println(s.taille());
        f.ajouter(s);
        System.out.println(f);
    }
}
