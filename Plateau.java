import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Plateau {
    private Fabrique[]fabs;
    private Centre centre;
    private Joueur[] joueurs;

    public Plateau(){
        while(fabs == null) {
            System.out.println("Combien de joueurs ? (De 2 à 4)");
            java.util.Scanner sc = new java.util.Scanner(System.in);
            String s = sc.next();
            switch (s) {
                case "2":
                    fabs = new Fabrique[5];
                    joueurs = new Joueur[Integer.parseInt(s)];
                    break;
                case "3":
                    fabs = new Fabrique[7];
                    joueurs = new Joueur[Integer.parseInt(s)];
                    break;
                case "4":
                    fabs = new Fabrique[9];
                    joueurs = new Joueur[Integer.parseInt(s)];
                    break;
                default:
                    System.out.println("Nombre incorrect");
                    break;
            }
        }
        for(int i = 0; i < joueurs.length; i++){
            joueurs[i] = new Joueur();
        }
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

    public Joueur[] getJoueurs() {
        return joueurs;
    }

    int premierJoueur(){
        Random rd = new Random();
        return rd.nextInt((joueurs.length-1) + 1);
    }

    public boolean partieFinie(){
        for(Joueur j : joueurs){
            for(int i = 0; i < 5; i++) {
                if (j.getMur().lignePleine(i)){
                    return true;
                }
            }
        }
        return false;
    }

    public String toString(){
        String fabriques = Arrays.toString(fabs);
        return "Nombre de joueurs : " + joueurs.length +
                "\nNombre de fabriques : " + fabs.length +
                "\nLe centre peut contenir " + centre.taille() + " tuiles." +
                "\nLes fabriques sont : " + "\n" + fabriques;
    }

    void action(int player){
        System.out.println("Voulez vous placer une tuile dans votre ligne ?");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        if(s.toLowerCase().equals("oui")){
            System.out.println("Quelle fabrique choisissez vous ?" + "\n" + Arrays.toString(fabs));
            s = sc.next();
            while(Integer.parseInt(s) > fabs.length || Integer.parseInt(s) < 0){
                System.out.println("Nombre invalide");
                System.out.println("Quelle fabrique choisissez vous ?" + "\n" + Arrays.toString(fabs));
                s = sc.next();
            }
            int fabrik = Integer.parseInt(s) - 1;
            System.out.println("Quelle tuile voulez vous prendre ? (Numéro de la tuile)" + "\n" + (fabs[fabrik]));
            s = sc.next();
            while(Integer.parseInt(s) > 4 || Integer.parseInt(s) < 0){
                System.out.println("Nombre invalide");
                System.out.println("Quelle tuile voulez vous prendre ?" + "\n" + Arrays.toString(fabs));
                s = sc.next();
            }
            int tuile = Integer.parseInt(s) - 1;
            while(fabs[fabrik].getCase(tuile).estVide()){
                System.out.println("Malheureusement la case est vide, choisissez en une autre !");
                tuile = Integer.parseInt(sc.next());
            }
            System.out.println("Vous avez choisi la tuile " + fabs[fabrik].getCase(tuile) + ".");
            System.out.println("Sur quelle ligne voulez vous la placer ? (Nombre de 1 à 5)");
            s = sc.next();
            while (Integer.parseInt(s) < 1 || Integer.parseInt(s) > 5){
                System.out.println("Nombre invalide");
                System.out.println("Sur quelle ligne voulez vous la placer ? (Nombre de 1 à 5)");
                s = sc.next();
            }
            int ligne = Integer.parseInt(s)-1;
            int tuiles = fabs[fabrik].sameColor(tuile);
            while(joueurs[player].getLigne().taille(ligne) < tuiles){
                System.out.println("Cette ligne est trop petite pour les " + tuiles + " tuiles que vous aurez à déplacer.");
                System.out.println("Sur quelle ligne voulez vous la placer ? (Nombre de 1 à 5)");
                s = sc.next();
                ligne = Integer.parseInt(s)-1;
            }
            if (tuiles > 1){
                System.out.println("Vous allez donc déplacer les tuiles sur la ligne numéro " + (ligne+1) + " de taille " + joueurs[player].getLigne().taille(ligne) + ". " + "\nÇa vous convient ?");
                s = sc.next();
                if(s.toLowerCase().equals("oui")){
                    Tuile tmp = fabs[fabrik].getCase(tuile).getTuile();
                    for(int i = 0; i < 4; i++){
                        if (tmp.sameCol(fabs[fabrik].getCase(i).getTuile())){
                            fabs[fabrik].remplirLigneMotif(joueurs[player].getLigne(), ligne, fabs[fabrik].getCase(i));
                        }
                    }
                    fabs[fabrik].remplirCentre(centre);
                }
            } else{
                System.out.println("Vous allez donc déplacer la tuile sur la ligne numéro " + (ligne+1) + " de taille " + joueurs[player].getLigne().taille(ligne) + ". " + "\nÇa vous convient ?");
                s = sc.next();
                if(s.toLowerCase().equals("oui")){
                    fabs[fabrik].remplirLigneMotif(joueurs[player].getLigne(), ligne, fabs[fabrik].getCase(tuile));
                    fabs[fabrik].remplirCentre(centre);
                }
            }
            System.out.println(fabs[fabrik]);
            System.out.println(joueurs[player].getLigne());
            System.out.println(centre);
        } else if(s.toLowerCase().equals("non"))
            System.out.println("Bah super. Dites le si vous voulez pas jouer bordel.");
        else {
            System.out.println("Hein ? On la refait, OK ?");
            action(player);
        }
    }
}
