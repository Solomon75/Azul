import java.util.ArrayList;

public abstract class Zone {
    protected ArrayList<Tuile> tuilesListe;

    public Zone(){
        tuilesListe = new ArrayList<>();
    }

    public void moveToAnotherZone(Tuile t, Zone z){
        if(!tuilesListe.isEmpty()){
            if (tuilesListe.indexOf(t) != -1){
                z.add(tuilesListe.remove(tuilesListe.indexOf(t)));
            }
        }
    }

    public void add(Tuile t){
        this.tuilesListe.add(t);
    }

}

/*
    Keep this function it can help us after.
public Tuile moveToAnotherZone(Tuile t){
        boolean verif = false;
        Tuile returnTuile = null;
        if(!tuilesListe.isEmpty()){
            verif = tuilesListe.remove(t);
            if (verif){
                returnTuile = tuilesListe.get(tuilesListe.indexOf(t));
            }
        }
        return returnTuile;
    }

 */