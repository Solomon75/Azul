public class Jeu {
    Sac sac;
    Defausse def;

    Jeu(){
        System.out.println("Combien de joueurs voulez vous ?");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String nb = sc.next();
        System.out.println("Il y aura donc " + nb + " joueurs.");
    }

    public boolean allEmpty(){return sac.estVide() && def.estVide();}
}
