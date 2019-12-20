public class Plateau {
    private Fabrique[]fabs;
    private Case[]centre;
    private Joueur[] joueurs;

    public Plateau(){
        while(fabs == null) {
            System.out.println("Combien de joueurs ?");
            java.util.Scanner sc = new java.util.Scanner(System.in);
            String s = sc.next();
            joueurs = new Joueur[Integer.parseInt(s)];
            if (s.equals("2")) fabs = new Fabrique[5];
            if (s.equals("3")) fabs = new Fabrique[7];
            if (s.equals("4")) fabs = new Fabrique[9];
            else System.out.println("Nombre incorrect");
        }
        centre = new Case[4*fabs.length+1];
    }

    public Case[] getCentre() {
        return centre;
    }

    public Fabrique[] getFabs() {
        return fabs;
    }

    public Joueur[] getJoueurs() {
        return joueurs;
    }
}
