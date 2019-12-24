public class Jeu {
    Sac sac;
    Defausse def;
    Plateau plate;

    Jeu() {
        plate = new Plateau();
        sac = new Sac();
        def = new Defausse();
        jouer();
    }

    public static void main(String[] args) {
        Jeu j = new Jeu();
    }

    public void jouer() {
        sacAjout();
        while(!plate.partieFinie()) {
            int joueur = plate.premierJoueur();
            int premierJoueur = plate.premierJoueur();
            while (joueur != premierJoueur-1){
                System.out.println(joueur);
                plate.action(joueur);
                joueur = (joueur+1)%plate.getJoueurs().length;
            }
        }
    }

    public boolean allEmpty() {
        return sac.estVide() && def.estVide();
    }

    public void sacAjout() {
        for (Fabrique f : plate.getFabs()) {
            if (!sac.estVide()) {
                f.ajouter(sac);
            }
        }
    }

    public void remplirSac() {
        if (sac.estVide()) {
            while (!def.estVide()) {
                def.envoyer();
            }
        }
    }
}
