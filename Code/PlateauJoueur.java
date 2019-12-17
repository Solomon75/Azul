public class PlateauJoueur extends Zone{
    private Case[] plancher;
    private int score;

    /*PlateauJoueur(){
        plancher = new Case[7];
        mur = new Case [5][5];
        lignesMotif = new Case[5][];
        for (int i = 0; i < lignesMotif.length; i++) {
            lignesMotif[i] = new Case[i+1];
        }
    }

    public boolean lignePleine(int i){
        for(Case c : lignesMotif[i]){
            if (c.estVide()) return false;
        }
        return true;
    }

    public void remplirMur(){
        for (int i = 0; i < lignesMotif.length; i++){
            if (lignePleine(i)){
                for(Case c : mur[i]){
                    if (c.getTuile().getCouleur().equals(lignesMotif[i][0].getTuile().getCouleur()))
                        c.setTuile(lignesMotif[i][0].getTuile());
                }
            }
        }
    }*/

}
