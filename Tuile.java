public class Tuile {
    private String color;

    Tuile(String c){
        color = c;
    }

    String getCouleur(){return color;}

    boolean sameCol(Tuile t){
        return color.equals(t.color);
    }
}
