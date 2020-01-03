import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class VueBis extends JFrame implements Partie {
    Plateau p;
    Joueur[] players;
    FabGraph[] fabriques;
    GestionnaireEvenement gest;
    GlassPane Glassy;
    int playing;
    int manche = 0;
    int nbJoueurs;

    JPanel content1 = new JPanel();
    JPanel content2 = new JPanel();
    JPanel content3 = new JPanel();
    JPanel content4 = new JPanel();
    JPanel content5 = new JPanel();
    JPanel content6 = new JPanel();
    JPanel content7 = new JPanel();
    JPanel content8 = new JPanel();
    JPanel content9 = new JPanel();
    JPanel FabCentre;
    JPanel panJoueurs;

    CentreGraph centre = new CentreGraph();

    public VueBis() {
        /**********Fenêtre principale***************/

        setSize(new Dimension(1280, 720));
        setVisible(true);
        setDefaultCloseOperation(3);
        setLayout(new BorderLayout());
        setTitle("Azul! Combien de joueurs ?");
        Glassy = new GlassPane();
        gest = new GestionnaireEvenement(Glassy);

        /*******************************************/
        JPanel choix = new JPanel();
        choix.setSize(getContentPane().getSize());
        choix.setBackground(Color.LIGHT_GRAY);
        int[] nbJ = {2, 3, 4};
        AtomicInteger nb = new AtomicInteger();
        JComboBox<Integer> players = new JComboBox<>();
        JToggleButton confirm = new JToggleButton("Jouer");
        for (int j : nbJ) {
            players.addItem(j);
        }
        choix.add(players);
        choix.add(confirm);
        getContentPane().add(choix);
        choix.setLayout(new GridBagLayout());
        confirm.addActionListener((event) -> {
            nb.set((int) players.getSelectedItem());
            nbJoueurs = nb.get();
            this.players = new Joueur[nbJoueurs];
            p = new Plateau(nbJoueurs);
            getContentPane().remove(choix);
            setTitle("Azul! " + nbJoueurs + " players!");
            setLayout(new GridLayout(2, 1));
            jbInit();
        });
    }

    @Override
    public void jbInit() {
        JPanel content= new JPanel();
        this.addMouseListener(gest);
        JPanel Fab;
        for(int i = 0; i < this.players.length; i++){
            this.players[i] = new Joueur();
        }
        switch (nbJoueurs){
            case 4:
                //panel des fabriques
                Fab = new JPanel();

                Fab.setLayout(new GridLayout(1,9));
                fabriques = new FabGraph[9];
                for(int i = 0; i < 9; i++){
                    fabriques[i]= new FabGraph(p.getFabs()[i]);
                    fabriques[i].addMouseListener(new MiniClass());
                    for(TuileGraph t: fabriques[i].tuilesFab){
                        t.lab.addMouseMotionListener(gest);
                        t.lab.addMouseListener(gest);
                    }
                    Fab.add(fabriques[i]);
                }
                centre = new CentreGraph();
                for(Joueur jo : this.players){
                    jo.murG = new MurGraph();
                    for(TuileGraph [] tG : jo.murG.mur){
                        for(TuileGraph t : tG){
                            t.lab.addMouseMotionListener(gest);
                            t.lab.addMouseListener(gest);
                        }
                    }
                    jo.pG = new PlancherGraph();
                    for(TuileGraph tG : jo.pG.tuiles){
                        tG.addMouseListener(gest);
                        tG.addMouseMotionListener(gest);
                    }
                    jo.lG = new LigneMotifGraph();
                    for(TuileGraph[] tG : jo.lG.tuiles){
                        for(TuileGraph t : tG){
                            t.lab.addMouseListener(gest);
                            t.lab.addMouseMotionListener(gest);
                        }
                    }
                }

                content5.setLayout(new GridLayout(1,5));
                content5.add(this.players[0].lG);
                content5.add(this.players[0].murG);

                content5.add(centre);
                content5.add(this.players[1].lG);
                content5.add(this.players[1].murG);


                content1.setLayout(new GridLayout(0,3));
                content1.add(this.players[0].pG);
                content2.setBackground(Color.PINK);
                content1.add(content2);
                content1.add(this.players[1].pG);

                content4.setLayout(new GridLayout(1,5));
                content4.add(this.players[2].lG);
                content4.add(this.players[2].murG);
                content3.setBackground(Color.PINK);
                content4.add(this.players[3].lG);
                content4.add(this.players[3].murG);


                content8.setLayout(new GridLayout(0,3));
                content8.add(this.players[2].pG);
                content8.setBackground(Color.PINK);
                content9.setBackground(Color.PINK);
                content8.add(content9);
                content8.add(this.players[3].pG);

                content7.add(Fab);
                content7.add(content5);
                content7.add(content1);
                content7.add(content4);
                content7.add(content8);
                content = content7;
                break;

            case 3:
                Fab = new JPanel();
                Fab.setLayout(new GridLayout(1,7));
                fabriques= new FabGraph[7];
                for(int i = 0; i < 7; i++){
                    fabriques[i] = new FabGraph(p.getFabs()[i]);
                    fabriques[i].addMouseListener(new MiniClass());
                    for(TuileGraph t: fabriques[i].tuilesFab){
                        t.lab.addMouseMotionListener(gest);
                        t.lab.addMouseListener(gest);
                    }
                    Fab.add(fabriques[i]);
                }
                centre = new CentreGraph();
                for(Joueur jo : this.players){
                    jo.murG = new MurGraph();
                    for(TuileGraph [] tG : jo.murG.mur){
                        for(TuileGraph t : tG){
                            t.lab.addMouseMotionListener(gest);
                            t.lab.addMouseListener(gest);
                        }
                    }
                    jo.pG = new PlancherGraph();
                    for(TuileGraph tG : jo.pG.tuiles){
                        tG.addMouseListener(gest);
                        tG.addMouseMotionListener(gest);
                    }
                    jo.lG = new LigneMotifGraph();
                    for(TuileGraph[] tG : jo.lG.tuiles){
                        for(TuileGraph t : tG){
                            t.lab.addMouseListener(gest);
                            t.lab.addMouseMotionListener(gest);
                        }
                    }
                }

                content5.setLayout(new GridLayout(1,5));
                content5.add(this.players[0].lG);
                content5.add(this.players[0].murG);

                content5.add(centre);
                content5.add(this.players[1].lG);
                content5.add(this.players[1].murG);


                content1.setLayout(new GridLayout(0,3));
                content1.add(this.players[0].pG);
                content2.setBackground(Color.PINK);
                content1.add(content2);
                content1.add(this.players[1].pG);

                content4.setLayout(new GridLayout(1,5));
                content4.add(this.players[2].lG);
                content4.add(this.players[2].murG);
                content3.setBackground(Color.PINK);
                content4.add(content3);
                content6.setBackground(Color.PINK);
                content4.add(content6);

                content8.setLayout(new GridLayout(0,3));
                content8.add(this.players[2].pG);
                content8.setBackground(Color.PINK);
                content8.add(content2);

                content7.add(Fab);
                content7.add(content5);
                content7.add(content1);
                content7.add(content4);
                content7.add(content8);
                content= content7;


                break;

            case 2:


                            /****Fabriques****/
                Fab = new JPanel(new GridLayout(1, 5));

                fabriques = new FabGraph[5];
                for(int i = 0; i < 5; i++){
                    fabriques[i] = new FabGraph(p.getFabs()[i]);
                    fabriques[i].addMouseListener(new MiniClass());
                    for(TuileGraph t: fabriques[i].tuilesFab){
                        t.lab.addMouseMotionListener(gest);
                        t.lab.addMouseListener(gest);
                    }
                    Fab.add(fabriques[i]);
                }
                    /****************Centre***********/
                centre = new CentreGraph();
                for(Joueur jo : this.players){
                    jo.murG = new MurGraph();
                    for(TuileGraph [] tG : jo.murG.mur){
                        for(TuileGraph t : tG){
                            t.lab.addMouseMotionListener(gest);
                            t.lab.addMouseListener(gest);
                        }
                    }

                    jo.pG = new PlancherGraph();
                    for(TuileGraph tG : jo.pG.tuiles){
                        tG.addMouseListener(gest);
                        tG.addMouseMotionListener(gest);
                    }
                    jo.lG = new LigneMotifGraph();
                    for(TuileGraph[] tG : jo.lG.tuiles){
                        for(TuileGraph t : tG){
                            t.lab.addMouseListener(gest);
                            t.lab.addMouseMotionListener(gest);
                        }
                    }
                }
                FabCentre = new JPanel(new GridLayout(2, 1));
                FabCentre.add(Fab);
                FabCentre.add(centre);

                panJoueurs = new JPanel(new GridLayout(1, 2));

                JPanel joueur1 = new JPanel(new BorderLayout());
                JPanel joueur2 = new JPanel(new BorderLayout());

                joueur1.add(this.players[0].lG, BorderLayout.WEST);
                joueur1.add(this.players[0].murG, BorderLayout.EAST);
                joueur1.add(this.players[0].pG, BorderLayout.SOUTH);

                joueur2.add(this.players[1].lG, BorderLayout.WEST);
                joueur2.add(this.players[1].murG, BorderLayout.EAST);
                joueur2.add(this.players[1].pG, BorderLayout.SOUTH);

                panJoueurs.add(joueur1);
                panJoueurs.add(joueur2);


                /*content5.setLayout(new GridLayout(1,5));
                content5.add(this.players[0].lG);
                content5.add(this.players[0].murG);

                content5.add(centre);
                content5.add(this.players[1].lG);
                content5.add(this.players[1].murG);


                content1.setLayout(new GridLayout(0,3));
                content1.add(this.players[0].pG);
                content2.setBackground(Color.PINK);
                content1.add(content2);
                content1.add(this.players[1].pG);

                content7.add(Fab);
                content7.add(content5);
                content7.add(content1);
                content = content7;*/
                break;
        }
        debutManche();
        content.setBackground(Color.PINK);
        getContentPane().add(FabCentre);
        getContentPane().add(panJoueurs);
        setGlassPane(Glassy);
        setVisible(true);
    }

    @Override
    public int ordre() {
        if (manche==0){
            return new Random().nextInt(nbJoueurs);
        } else {
            for(int i = 0; i < nbJoueurs; i++){
                if(this.players[i].prems) return i;
            }
        }
        return -1;
    }

    @Override
    public void debutManche() {
        p.sacAjout();
        for(int f = 0; f < fabriques.length; f++){
            fabriques[f].remplir(p.fabs[f]);
        }
        centre.tuilePremierJoueur = new TuileGraph("first");
        centre.tuiles.add(centre.tuilePremierJoueur);
        centre.tuilePremierJoueur.lab.addMouseListener(gest);
        centre.tuilePremierJoueur.lab.addMouseMotionListener(gest);
        playing = ordre();
        for(Joueur j : this.players){
            j.prems = false;
        }
        setTitle("C'est au joueur " + (playing+1));
        p.centre.premierJoueur = new Tuile("first");
        p.centre.remplirCentre(p.centre.premierJoueur);
        centre.centre.add(centre.tuilePremierJoueur.lab);
    }

    @Override
    public void reset() {
        removeAll();
        jbInit();
    }

    @Override
    public boolean finDePartie() {
        for(Joueur jo : this.players){
            for(int i = 0; i < 5; i++){
                if(jo.m.lignePleine(i)) return true;
            }
        }
        return false;
    }

    @Override
    public void finManche() {
        for(int i = 0; i < this.players.length; i++){
            for(int j = 0; j < 5; j++){
                if(this.players[i].l.videTuile(j, p.def, this.players[i].m)){
                    System.out.println("rury");
                    this.players[i].murG.remplirCase(j, this.players[i].lG.viderLigne(j));
                }
            }
            this.players[i].updateScore();
            System.out.println("Score du joueur " + (i+1) + " : " + this.players[i].getScore());
            this.players[i].p.clear(p.def);
            this.players[i].pG.clear();
        }
        this.revalidate();
    }

    @Override
    public boolean finDeManche() {
        for(int i = 0; i < fabriques.length; i++){
            if (fabriques[i].estVide() && p.getFabs()[i].estVide()){
                if(p.getCentre().estVide() && centre.estVide())
                    return true;
            }
            return false;
        }
        return false;
    }

    public  class GestionnaireEvenement extends MouseAdapter {

        boolean tuilePremier = false;
        String couleurActuelle = null;
        int fabActuelle;
        boolean deCentre = false;
        boolean deFab = false;
        int nombre;
        GlassPane glass;
        JLabel com;
        boolean operationReussie= false;
        boolean cheminPossible= false;
        int ligneActuelle;
        boolean surPlancher= false;
        boolean surLigne= false;

        GestionnaireEvenement(GlassPane gl){
            glass = gl;
        }


        public void mouseClicked(MouseEvent eve) {

        }

        public void mousePressed(MouseEvent eve) {
            deCentre = false;
            deFab = false;
            nombre = 0;
            fabActuelle = 0;
            couleurActuelle = null;
            com = null;
            operationReussie = false;
            tuilePremier = false;
            glass.premier = false;
            surPlancher = false;
            surLigne = false;


            //il faut déterminer sur quel label on a cliqué
            if (eve.getSource() instanceof JLabel) {
                //déterminer s'il s'agit de celles de fabrique ou du centre
                //on vérifie s'il s'agit d'une tuile du centre
                if (!centre.estVide()) {
                    for (TuileGraph t : centre.tuiles) {
                        if (eve.getSource() == t.lab) {
                            deCentre = true;
                            couleurActuelle = t.couleur;
                            nombre = 0;
                            for (TuileGraph tui : centre.tuiles) {
                                if (tui.couleur.equals(couleurActuelle)) {
                                    nombre++;
                                }
                            }
                            if(centre.tuilePremierJoueur != null){

                                tuilePremier = true;
                                glass.premier = true;
                            }
                            Point location = (Point) eve.getPoint().clone();
                            SwingUtilities.convertPointToScreen(location, t.lab);
                            SwingUtilities.convertPointFromScreen(location, glass);
                            BufferedImage imgu = new BufferedImage(t.lab.getWidth(), t.lab.getHeight(), BufferedImage.TYPE_INT_ARGB);
                            Graphics g = imgu.getGraphics();
                            t.lab.paint(g);
                            glass.setLocation(location);
                            glass.setNombre(nombre);
                            glass.setImage(imgu);
                            glass.setVisible(true);
                            centre.update(g);
                            //faire ce qu'il y'a à faire


                            break;
                        }
                    }
                }
                //si c'est la tuile premier joueur:
                if(eve.getSource() == centre.tuilePremierJoueur.lab){
                    deCentre = true;
                    couleurActuelle = centre.tuilePremierJoueur.couleur;
                    nombre = 1;
                    Point location = (Point) eve.getPoint().clone();
                    SwingUtilities.convertPointToScreen(location, centre.tuilePremierJoueur.lab);
                    SwingUtilities.convertPointFromScreen(location, glass);
                    BufferedImage imgu = new BufferedImage(centre.tuilePremierJoueur.lab.getWidth(), centre.tuilePremierJoueur.lab.getHeight(), BufferedImage.TYPE_INT_ARGB);
                    Graphics g= imgu.getGraphics();
                    centre.tuilePremierJoueur.lab.paint(g);
                    glass.setLocation(location);
                    glass.setNombre(nombre);
                    glass.setImage(imgu);
                    glass.setVisible(true);
                }
                if (!deCentre) {
                    deFab = true;
                    for (int h = 0; h < fabriques.length; h++) {
                        FabGraph f = fabriques[h];
                        //rechercher de la fabrique
                        for (TuileGraph t : f.tuilesFab) {
                            if (t.lab == eve.getSource()) {
                                fabActuelle = h;
                                couleurActuelle = t.couleur;
                                com = t.lab;
                                break;
                            }
                        }
                    }

                    if (deFab) {
                        for (TuileGraph t1 : fabriques[fabActuelle].tuilesFab) {
                            if (t1.couleur.equals(couleurActuelle)) {
                                nombre++;
                            }
                        }
                        Point location = (Point) eve.getPoint().clone();
                        SwingUtilities.convertPointToScreen(location, eve.getComponent());
                        SwingUtilities.convertPointFromScreen(location, glass);
                        BufferedImage imgu = new BufferedImage(eve.getComponent().getWidth(), eve.getComponent().getHeight(), BufferedImage.TYPE_INT_ARGB);
                        Graphics g = imgu.getGraphics();
                        eve.getComponent().paint(g);
                        glass.setLocation(location);
                        glass.setNombre(nombre);
                        glass.setImage(imgu);
                        glass.setVisible(true);

                    }
                }

            }


        }



        public void mouseDragged(MouseEvent eve) {
            if(deFab || deCentre) {
                Component nt = eve.getComponent();
                Point p = (Point) eve.getPoint().clone();
                SwingUtilities.convertPointToScreen(p, nt);
                SwingUtilities.convertPointFromScreen(p, glass);
                glass.setLocation(p);
                glass.repaint();
            }
        }

        public void mouseReleased(MouseEvent eve) {
            Component composant = eve.getComponent();

            //déterminer si on a placé la tuile sur une ligne motif ou bien un plancher
            if (cheminPossible) {
                Joueur j = players[playing];
                System.out.println("chemin possible ");
                //on vérifie si ce n'est pas une tuile de la ligneMotif
                if (deFab || deCentre) {


                    if (surLigne) {
                        ArrayList<Tuile> tuiles;
                        if (!deCentre) {
                            tuiles = p.getFabs()[fabActuelle].prendreTuile(couleurActuelle);
                            if (j.getLigne().remplirLigneG(tuiles, ligneActuelle, j.p, j.m, couleurActuelle)) {
                                int nb=0;
                                for(TuileGraph gh: j.lG.tuiles[ligneActuelle]){
                                    if(gh.couleur.equals("ligne")){
                                        nb++;
                                    }
                                }

                                j.lG.miseAJour(ligneActuelle, couleurActuelle, nombre);
                                for(TuileGraph[] t: j.lG.tuiles){
                                    for(TuileGraph tu: t){
                                        tu.lab.addMouseMotionListener(gest);
                                        tu.lab.addMouseListener(gest);
                                    }
                                }

                                if(nombre> nb){
                                    j.pG.update(nombre-nb, couleurActuelle);
                                }

                                p.getFabs()[fabActuelle].clear(couleurActuelle);
                                p.getFabs()[fabActuelle].remplirCentre(p.centre);

                                fabriques[fabActuelle].remplirCentre(centre, couleurActuelle, nombre, gest);
                                for(TuileGraph tu: centre.tuiles){
                                    tu.lab.addMouseListener(gest);
                                    tu.lab.addMouseMotionListener(gest);
                                }
                                playing = (playing+1) % nbJoueurs;
                                operationReussie = true;
                                if(finDeManche()) {
                                    System.out.println("FIN DE MANCHE");
                                    finManche();

                                    if(finDePartie()){
                                        System.out.println("La partie est terminé! Affichage des scores: ");
                                        for(int i=0; i< nbJoueurs; i++){
                                            System.out.println("Joueur "+i+1+" : "+ players[i].getScore());
                                        }
                                        System.out.println("Voulez-vous rejouer? Oui/Non");
                                        Scanner sc= new Scanner(System.in);
                                        String rep= sc.nextLine();
                                        if (rep.equals("Oui")) {

                                            reset();
                                        }
                                    }else {
                                        debutManche();
                                    }
                                }else{
                                    int m= playing+1;
                                    System.out.println("C'est au tour du joueur "+m);

                                }
                            }
                        } else {

                            tuiles = p.getCentre().prendre(couleurActuelle);
                            if (j.getLigne().remplirLigneG(tuiles, ligneActuelle, j.p, j.m, couleurActuelle)) {

                                int nb=0;
                                for(TuileGraph gh: j.lG.tuiles[ligneActuelle]){
                                    if(gh.couleur.equals("ligne")){
                                        nb++;
                                    }
                                }
                                j.lG.miseAJour(ligneActuelle, couleurActuelle, nombre);

                                for (TuileGraph[] t : j.lG.tuiles) {
                                    for (TuileGraph tu : t) {
                                        tu.lab.addMouseMotionListener(gest);
                                        tu.lab.addMouseListener(gest);
                                    }
                                }
                                if(nombre> nb){
                                    j.pG.update(nombre-nb, couleurActuelle);
                                }

                                p.centre.vider(couleurActuelle);
                                centre.vider(couleurActuelle);


                                if(tuilePremier) {
                                    //on a pris la tuile premier joueur
                                    j.prems = true;
                                    tuiles = p.centre.prendre("first");
                                    j.p.remplirPlancher(tuiles);
                                    j.pG.update(1, "first");
                                    centre.vider("first");
                                    centre.tuilePremierJoueur= null;

                                    p.centre.premierJoueur= null;

                                }
                                playing = (playing + 1) % nbJoueurs;
                                operationReussie = true;
                                tuilePremier = false;
                                surLigne= false;
                                if(finDeManche()) {

                                    finManche();

                                    if(finDePartie()){
                                        System.out.println("La partie est terminé! Affichage des scores: ");
                                        for(int i=0; i< nbJoueurs; i++){
                                            System.out.println("Joueur "+i+" : "+ players[i].getScore());
                                        }
                                        System.out.println("Voulez-vous rejouer? Oui/Non");
                                        Scanner sc= new Scanner(System.in);
                                        String rep= sc.nextLine();
                                        if (rep.equals("Oui")) {

                                            reset();
                                        }
                                    }else{
                                        debutManche();
                                    }
                                } else{
                                    int m= playing+1;
                                    System.out.println("C'est au tour du joueur "+m);

                                }
                            }
                        }
                    } else if (surPlancher) {
                        ArrayList<Tuile> tuiles = null;
                        if (!deCentre) {
                            tuiles = p.getFabs()[fabActuelle].prendreTuile(couleurActuelle);
                            if (players[playing].p.remplirPlancher(tuiles)) {
                                players[playing].pG.update(nombre, couleurActuelle);

                                playing = (playing+1) % nbJoueurs;

                                p.getFabs()[fabActuelle].clear(couleurActuelle);
                                p.getFabs()[fabActuelle].remplirCentre(p.centre);
                                fabriques[fabActuelle].remplirCentre(centre, couleurActuelle, nombre, gest);
                                operationReussie = true;
                                surPlancher= false;
                                if (finDeManche()) {
                                    finManche();

                                    if(finDePartie()){
                                        System.out.println("La partie est terminé! Affichage des scores: ");
                                        for(int i=0; i< nbJoueurs; i++){
                                            System.out.println("Joueur "+i+" : "+ players[i].getScore());
                                        }
                                        System.out.println("Voulez-vous rejouer? Oui/Non");
                                        Scanner sc= new Scanner(System.in);
                                        String rep= sc.nextLine();
                                        if (rep.equals("Oui")) {

                                            reset();
                                        }
                                    }else{
                                        debutManche();
                                    }

                                } else {
                                    int m= playing+1;
                                    System.out.println("C'est au tour du joueur " + m);

                                }
                            }
                        } else {
                            tuiles = p.centre.prendre(couleurActuelle);


                            if (players[playing].p.remplirPlancher(tuiles)) {
                                players[playing].pG.update(nombre, couleurActuelle);
                                p.centre.vider(couleurActuelle);
                                centre.vider(couleurActuelle);

                                if(eve.getSource()== centre.tuilePremierJoueur){
                                    players[playing].prems = true;
                                    centre.tuilePremierJoueur= null;
                                    p.centre.premierJoueur= null;
                                }
                                playing = (playing+1) % nbJoueurs;
                                operationReussie = true;
                                surPlancher= false;
                                if (finDeManche()) {
                                    finManche();

                                    if(finDePartie()){
                                        System.out.println("La partie est terminé! Affichage des scores: ");
                                        for(int i=0; i< nbJoueurs; i++){
                                            System.out.println("Joueur "+i+" : "+ players[i].getScore());
                                        }
                                        System.out.println("Voulez-vous rejouer? Oui/Non");
                                        Scanner sc= new Scanner(System.in);
                                        String rep= sc.nextLine();
                                        if (rep.equals("Oui")) {

                                            reset();
                                        }
                                    }else{
                                        debutManche();
                                    }
                                } else {
                                    int m= playing+1;
                                    System.out.println("C'est au tour du joueur " + m);

                                }

                            }
                        }
                    }
                    Point location = (Point) eve.getPoint().clone();

                    SwingUtilities.convertPointToScreen(location, composant);
                    SwingUtilities.convertPointFromScreen(location, glass);
                    glass.setLocation(location);
                }
            }
            glass.setImage(null);
            glass.setVisible(false);
        }



        public void mouseEntered(MouseEvent eve) {
            int ligne = 0;
            int colonne = 0;
            cheminPossible = false;
            surLigne = false;
            ligneActuelle = 0;

            if (couleurActuelle != null) {

                for (int i = 0; i < players[playing].lG.tuiles.length; i++) {
                    for (int j = 0; j < players[playing].lG.tuiles[i].length; j++) {
                        if (players[playing].lG.tuiles[i][j].lab == eve.getSource()) {
                            ligne = i;
                            this.surLigne = true;
                            break;
                        }
                    }
                }


                if (this.surLigne) {

                    Tuile t = new Tuile(couleurActuelle);
                    if (players[playing].l.possiblePath(ligne, t)) {
                        cheminPossible = true;
                        ligneActuelle= ligne;
                    }
                }else{
                    //on cherche la case correspondante sur le plancher
                    for(int i=0; i<7; i++){
                        if (players[playing].pG.tuiles[i].lab == eve.getSource()) {
                            this.surPlancher= true;
                            colonne= i;
                            break;
                        }
                    }

                    //vérifie si le chemin est possible:
                    if(players[playing].pG.casesLibres() >= nombre){
                        cheminPossible = true;
                    }



                }

            }
        }
    }

    class GlassPane extends JPanel {
        private BufferedImage img;
        private Point location;
        private Composite transparence;
        private int nombre;
        private boolean premier;

        public GlassPane() {
            setOpaque(false);
            transparence = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f);
        }

        public void setLocation(Point location) {
            this.location = location;
        }

        public void setImage(BufferedImage image) {
            img = image;
        }

        public void setNombre(int n) {
            nombre = n;
        }

        public void setPremier(boolean p) {
            premier = p;
        }

        public void paintComponent(Graphics g) {
            if (img == null) {
                return;
            }
            Graphics2D g2d = (Graphics2D) g;
            g2d.setComposite((transparence));
            int j = 0;
            for (int i = 1; i <= nombre; i++) {
                g2d.drawImage(img, (int) (location.getX() - (img.getWidth(this) / 2)) + j, (int) (location.getY() - (img.getHeight(this) / 2)) + j, null);
                j += 15;
            }
            if (premier) {
                BufferedImage bimg = new BufferedImage(centre.tuilePremierJoueur.lab.getWidth(), centre.tuilePremierJoueur.lab.getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics g2 = bimg.getGraphics();
                g2d = (Graphics2D) g2;
                g2d.drawImage(bimg, (int) (location.getX() - (img.getWidth(this) / 2)) + j + 15, (int) (location.getY() - (img.getHeight(this) / 2)) + j + 15, null);
            }
        }
    }

    private class MiniClass extends MouseAdapter{
        public void mouseEntered(MouseEvent e){
            if(e.getSource() instanceof FabGraph) {
                for (JPanel fa : fabriques) {
                    if (e.getSource() == fa) {
                        fa.setBackground(Color.ORANGE);
                    }
                }
            }
        }

        public void mouseExited(MouseEvent e){
            for(JPanel fa: fabriques){
                if(e.getSource() == fa){
                    fa.setBackground(Color.PINK);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { VueBis v = new VueBis(); });
    }
}
