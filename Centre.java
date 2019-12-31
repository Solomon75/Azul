public class Centre {
    private Case[] centre;

    Centre(int taille){
        centre = new Case[taille];
        for(Case c : centre) c = new Case();
    }

    boolean remplirCentre(Tuile t){
        for(Case c : centre){
            if (c.estVide()){
                c.setTuile(t);
                return true;
            }
        }
        return false;
    }

    public Case[] getCentre() {
        return centre;
    }
}
