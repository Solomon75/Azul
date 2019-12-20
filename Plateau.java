public class Plateau {
    private Fabrique[]fabs;
    private Centre centre;
    private Joueur[] joueurs;

    public Plateau(){
        while(fabs == null) {
            System.out.println("Combien de joueurs ? (De 2 à 4)");
            java.util.Scanner sc = new java.util.Scanner(System.in);
            String s = sc.next();
            joueurs = new Joueur[Integer.parseInt(s)];
            switch (s) {
                case "2":
                    fabs = new Fabrique[5];
                    break;
                case "3":
                    fabs = new Fabrique[7];
                    break;
                case "4":
                    fabs = new Fabrique[9];
                    break;
                default:
                    System.out.println("Nombre incorrect");
                    break;
            }
        }
        centre = new Centre(4*fabs.length+1);
    }

    public Centre getCentre() {
        return centre;
    }

    public Fabrique[] getFabs() {
        return fabs;
    }

    public Joueur[] getJoueurs() {
        return joueurs;
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
}
