public class Jeu {
    Sac sac;
    Defausse def;
    Plateau plate;

    Jeu(){
        System.out.println("Combien de joueurs voulez vous ?");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String nb = sc.next();
        System.out.println("Il y aura donc " + nb + " joueurs.");
        plate = new Plateau();
        sac = new Sac();
        def = new Defausse();
    }

    public boolean allEmpty(){return sac.estVide() && def.estVide();}
    public void sacAjout(){
        for(Fabrique f : plate.getFabs()){
            if(!sac.estVide()) {
                f.ajouter(sac);
            }
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
