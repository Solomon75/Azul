public class Jeu {
    Sac sac;
    Defausse def;
    Plateau plate;

    Jeu(){
        //plate = new Plateau();
        sac = new Sac();
        def = new Defausse();
        jouer();
    }


    public void jouer(){
        while(!plate.partieFinie()){
            
        }
    }

    public boolean allEmpty(){return sac.estVide() && def.estVide();}

    public static void main(String[] args) {
        Jeu j = new Jeu();
    }
}
