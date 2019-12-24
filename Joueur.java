import java.util.LinkedList;
import java.util.Scanner;

public class Joueur {
    private Plancher p;
    private Mur m;
    private LigneMotif l;
    private int score; //Chaque joueur possède un score qui lui est propre


    Joueur() {
        m = new Mur();
        l = new LigneMotif();
        p = new Plancher();
        score = 0;
    }

    public static void main(String[] args) {
        Joueur j = new Joueur();
    }

    LigneMotif getLigne() {
        return l;
    }

    Mur getMur() {
        return m;
    }

    /*void printWall(){
        for (CaseMur[] c: m.m) {
            for(CaseMur ca : c){
                System.out.print(ca+" ");
            }
            System.out.println();
            System.out.println();
        }
    }*/

    Plancher getPlancher() {
        return p;
    }

    void updateScore() {
        score = m.scoreMur() - p.retrait();
    }

    int getScore() {
        return score;
    }

    void setScore(int n) {
        score = n;
    }

    class Mur { //Le mur du joueur est une classe interne étant donné qu'il n'est accessible que par le biais du joueur directement
        CaseMur[][] m;

        Mur() {
            m = new CaseMur[5][5];
            LinkedList<String> couleurs = new LinkedList<>();
            couleurs.add("bleu");
            couleurs.add("jaune");
            couleurs.add("rouge");
            couleurs.add("noir");
            couleurs.add("blanc");
            String tmp = "";
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[i].length; j++) {
                    m[i][j] = new CaseMur(couleurs.get(j));
                }
                tmp = couleurs.getLast();
                couleurs.remove(couleurs.getLast());
                couleurs.addFirst(tmp);
            }
        }

        boolean lignePleine(int i) {
            for (Case c : m[i]) {
                if (c.estVide()) return false;
            }
            return true;
        } // On peut vérifier si la ligne du mur est pleine pour arrêter la partie.

        boolean colonnePleine(int j) {
            for (int i = 0; i < m.length; i++) {
                if (m[i][j].estVide()) return false;
            }
            return true;
        } //On peut vérifier si une colonne est pleine afin d'ajouter les points bonus nécessaires.

        int adjacent(int i, int j) {
            int nb = 0;
            //Commence par la partie horizontale
            if (j < m.length && j > 0) {
                if (!m[i][j - 1].estVide()) {
                    System.out.println("Adjacence horizontale");
                    nb++;
                }
                if (!m[i][j + 1].estVide()) {
                    System.out.println("Adjacence horizontale");
                    nb++;
                }
            } else if (j == 0) {
                nb++;
            } else if (j == m.length - 1)
                nb++;
            // Vient maintenant la partie verticale
            if (i < m.length && i > 0) {
                if (!m[i - 1][j].estVide()) {
                    System.out.println("Adjacence verticale");
                    nb++;
                }
                if (!m[i + 1][j].estVide()) {
                    System.out.println("Adjacence verticale");
                    nb++;
                }
            } else if (i == 0)
                nb++;
            else if (i == m.length - 1)
                nb++;
            return nb;
        } //On compte par combien la case spécifiée a de tuiles adjacentes.

        int scoreLigne(int i) {
            int sco = 0;
            for (Case c : m[i]) {
                if (!c.estVide()) sco++;
            }
            for (int j = 0; j < m[i].length; j++) {
                sco += adjacent(i, j) * 2;
            }
            return sco;
        } //Ça nous permet de compter le score d'une ligne.

        int scoreMur() {
            int sco = 0;
            for (int i = 0; i < m.length; i++) {
                sco += scoreLigne(i);
            }
            for (int i = 0; i < m.length; i++) {
                if (colonnePleine(i)) {
                    sco += 7;
                }
            }
            return sco;
        }

        boolean estRemplie(int ligne, String couleur) { //Vérifie que la ligne "ligne" du mur n'a pas déjà été remplie avec une certaine couleur
            for (CaseMur c : m[ligne]) {
                if (c.couleur.equals(couleur)) if (!c.estVide()) return true;
            }
            return false;
        }

        boolean remplirCase(Tuile t, LigneMotif l) {
            for (int i = 0; i < m.length; i++) {
                for (CaseMur c : m[i]) {
                    if (c.sameColor(t) && !estRemplie(i, c.getCouleur())) {
                        c.setTuile(l.li[i][0].getTuile());
                        return true;
                    }
                }
            }
            return false;
        }
    }

    class LigneMotif {
        Case[][] li;

        LigneMotif() {
            li = new Case[5][];
            for(int i = 0; i < li.length; i++){
                li[i] = new Case[i+1];
                for(int j = 0; j < li[i].length; j++){
                    li[i][j] = new Case();
                }
            }
        }

        int taille(int i) {
            return li[i].length;
        }

        boolean estVide(int ligne) {
            for (Case c : li[ligne]) {
                if (!c.estVide()) return false;
            }
            return true;
        }

        String couleurLigne(int i) {
            for (int j = 0; j < li[i].length; j++) {
                if (!li[i][j].estVide()) return li[i][j].getTuile().getCouleur();
            }
            return "vide";
        }

        boolean remplirLigne(Tuile t, int ligne) {
            if (!estVide(ligne)) {
                if (couleurLigne(ligne).equals(t.getCouleur())) {
                    if (!(m.estRemplie(ligne, t.getCouleur()))) {
                        if (!lignePleine(ligne)) {
                            for (Case c : li[ligne]) {
                                if (c.estVide()) {
                                    c.setTuile(t);
                                    return true;
                                }
                            }
                        }
                    }
                }
            } else {
                for (Case c : li[ligne]) {
                    if (c.estVide()) {
                        c.setTuile(t);
                        return true;
                    }
                }
            }
            return false;
        }

        boolean lignePleine(int i) {
            for (Case c : li[i]) {
                if (!c.estVide()) return false;
            }
            return true;
        }

        public String toString(){
            String ret = "";
            for(int j = 0; j < li.length; j++){
                for(int i = 0; i < li[j].length; i++){
                    ret = ret + li[j][i] + " ";
                }
                ret = ret + "\n";
            }
            return ret;
        }
    }

    class Plancher {
        private CasePlancher[] p;

        Plancher() {
            p = new CasePlancher[7];
            for (int i = 0; i < p.length; i++) {
                if (i < 2) p[i] = new CasePlancher(1);
                if (i >= 2 && i < 4) p[i] = new CasePlancher(2);
                if (i >= 4) p[i] = new CasePlancher(3);
            }
        }

        int retrait() {
            int ret = 0;
            for (CasePlancher c : p) {
                if (!c.estVide()) ret += c.getRedux();
            }
            return ret;
        }
    }
}
