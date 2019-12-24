public class Jeu {
    Sac sac;
    Defausse def;
    Plateau plate;

<<<<<<< HEAD
    Jeu() {
=======
    Jeu(){
>>>>>>> 633e055c3788e5a2b60e364200b30e2b61352b23
        plate = new Plateau();
        sac = new Sac();
        def = new Defausse();
        jouer();
<<<<<<< HEAD
=======
    }


    public void jouer(){
        while(!plate.partieFinie()){
            
        }
>>>>>>> 633e055c3788e5a2b60e364200b30e2b61352b23
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

<<<<<<< HEAD
    public void remplirSac() {
        if (sac.estVide()) {
            while (!def.estVide()) {
=======
    public void remplirSac(){
        if(sac.estVide()){
            while(!def.estVide()){
>>>>>>> 633e055c3788e5a2b60e364200b30e2b61352b23
                def.envoyer();
            }
        }
    }

    public static void main(String[] args) {
        Jeu j = new Jeu();
    }
}
