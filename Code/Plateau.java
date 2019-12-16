public class Plateau {
    Fabrique[]fabs;
    Case[]centre;
    Joueur[] joueurs;

    public Plateau(){
        System.out.println("Combien de joueurs ?");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String s = sc.next();
        joueurs = new Joueur[Integer.parseInt(s)];
        if (s.equals("2")) fabs = new Fabrique[5];
        if (s.equals("3")) fabs = new Fabrique[7];
        if (s.equals("4")) fabs = new Fabrique[9];

    }
}
