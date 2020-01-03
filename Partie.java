public interface Partie {
    void jbInit();

    int ordre();

    void debutManche();

    void reset();

    boolean finDePartie();

    void finManche();

    boolean finDeManche();
}
