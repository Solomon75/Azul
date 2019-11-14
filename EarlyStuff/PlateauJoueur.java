public class PlateauJoueur {
    private Tuile [] plancher;
    private Tuile [][] mur;
    private Tuile [][] lignesMotif;

    PlateauJoueur(){
        plancher = new Tuile[7];
        mur = new Tuile [5][5];
        lignesMotif = new Tuile[5][];
        for (int i = 0; i < lignesMotif.length; i++) {
            lignesMotif[i] = new Tuile[i+1];
        }
    }

    public static void main (String[]args){
        PlateauJoueur j = new PlateauJoueur();
        for (Tuile [] t:j.lignesMotif) {
           System.out.println(t.length);
        }
    }
}
