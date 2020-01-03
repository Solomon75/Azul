public class Plateau {
    Sac sac;
    Fabrique[]fabs;
    Centre centre;
    Joueur[] joueurs;
    Defausse def;

    public Plateau(int nbjoueurs){
        def = new Defausse();
        sac = new Sac();
        joueurs = new Joueur[nbjoueurs];
        for(int i = 0; i < joueurs.length; i++){
            joueurs[i] = new Joueur();
        }
            switch (nbjoueurs) {
                case 2:
                    fabs = new Fabrique[5];
                    break;
                case 3:
                    fabs = new Fabrique[7];
                    break;
                case 4:
                    fabs = new Fabrique[9];
                    break;
                default:
                    System.out.println("Nombre incorrect");
                    break;
        }
        assert fabs != null;
        for(int i = 0; i < fabs.length; i++){
            fabs[i] = new Fabrique();
        }
        centre = new Centre(3*fabs.length+1);
    }

    public Centre getCentre() {
        return centre;
    }

    public Fabrique[] getFabs() {
        return fabs;
    }

    public boolean partieFinie(){
        for(Joueur j : joueurs){
            for(int i = 0; i < j.getLigne().taille(); i++) {
                if (j.getLigne().lignePleine(i)){
                    return true;
                }
            }
        }
        return false;
    }

    public void sacAjout(){
        for(Fabrique f : fabs){
            while(!sac.estVide() && !f.estPleine()) {
                f.ajouter(sac);
            }
            remplirSac();
        }
    }

    public void remplirSac(){
        if(sac.estVide()){
            while(!def.estVide()){
                def.envoyer();
            }
        }
    }

}
