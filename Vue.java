import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class Vue extends JFrame {
    Controleur controleur = new Controleur();
    Joueur j = new Joueur();
    Joueur.LigneMotif ligneMotif = j.new LigneMotif();

    Image img = ImageIO.read(new File("imageTuiles\\backTile.png"));
    //Image plateauJoueur = ImageIO.read(new File("E:\\Users\\Medine\\Bureau\\imageTuiles\\PlateauJoueur.png"));
    Image tuile = ImageIO.read(new File("imageTuiles\\blue.png"));
    Image red = ImageIO.read(new File("imageTuiles\\red.png"));

    public Vue() throws IOException {
        this.setSize(1000,1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        initBackgroundImage();
        this.setLayout(null);
        this.add(PlateauJoueur(50,50));
        /*
        JPanel jp = lignesMotifs();
        jp.setBounds(300,300,250,250);
        jp.setBorder(BorderFactory.createLineBorder(Color.red,1));
        this.add(jp);
        */
    }

    // Permet de mettre une image en backgroun et d'occuper la totalité de la fenetre.
    public void initBackgroundImage(){

        this.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, this.getWidth(),this.getHeight(),this);
            }
        });
        this.getContentPane().setLayout(null);
    }

    /*
        Créer un plateau Joueur avec tous les JPanel bien placé, j'ai mis
        des borderLines pour qu'on s'y retrouve. Les parametres x et y
        permettent de définir la position d'un plateau joueur sur notre Vue.
    */

    public JPanel PlateauJoueur(int x, int y){
        JPanel plateauJoueurContainer = new JPanel(null);
        JPanel pisteDeScoreContainer = new JPanel(null);
        JPanel lignesMotifContainer = new JPanel(null);
        JPanel murTuilesContainer = new JPanel(null);
        JPanel plancherContainer = new JPanel(null);
        plateauJoueurContainer.add(pisteDeScoreContainer);
        plateauJoueurContainer.add(lignesMotifContainer);
        plateauJoueurContainer.add(murTuilesContainer);
        plateauJoueurContainer.add(plancherContainer);

        pisteDeScoreContainer.setBorder(BorderFactory.createLineBorder(Color.GREEN,10));
        plateauJoueurContainer.setBounds(x,y,300,350);

        plateauJoueurContainer.setBorder(BorderFactory.createLineBorder(Color.BLACK,10));
        pisteDeScoreContainer.setBounds(0,0,300,100);

        lignesMotifContainer.setBorder(BorderFactory.createLineBorder(Color.BLUE,10));
        lignesMotifContainer.setBounds(0,100,150,150);
        JPanel jp = initContainerLigneMotif();
        jp.setBounds(0,0,150,150);
        jp.setBorder(BorderFactory.createLineBorder(Color.GREEN,1));
        lignesMotifContainer.add(jp);

        murTuilesContainer.setBorder(BorderFactory.createLineBorder(Color.MAGENTA,10));
        murTuilesContainer.setBounds(150,100,150,150);

        plancherContainer.setBorder(BorderFactory.createLineBorder(Color.red,10));
        plancherContainer.setBounds(0,250,300,100);
        return plateauJoueurContainer;
    }

    public JPanel initContainerLigneMotif(){
        int i;
        int id = 0;
        JPanel jp = new JPanel(new GridLayout(5,0));
        LigneMotif line;
        Case uneCase;
        for (i = 1; i <= 5; i++){
            line = new LigneMotif(id);
            line.setLayout(new GridLayout(1,i));

            for (int j = 0; j < i; j++){
                uneCase = new Case();
                uneCase.setSize(10,10);
                line.add(uneCase);
                uneCase.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
            }
            jp.add(line);
            line.setBorder(BorderFactory.createLineBorder(Color.GREEN,1));
            id++;
        }
        return jp;
    }

    static class LigneMotif extends JPanel{
        int id;
        LigneMotif(int n){
            id = n;
        }
    }

    class Case extends JLabel implements MouseListener{

        private String color = "black";

        public String getColor() {
            return color;
        }

        Case(){
            addMouseListener(this);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
/**
 * Ici je cast l'événement source en case puis j'éffectue des opérations pour gerer
 * mes différents
 */
                Case b = (Case) e.getSource();
                // Permet de redimensionner l'image dans le jlabel
                Image dimg = tuile.getScaledInstance(b.getWidth(), b.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon imageIcon = new ImageIcon(dimg);
                // Jusque ici on redimensionne

                /**
                 * Ici on récupère le numero de la ligne sur laquelle on à mis
                 * une tuile.
                 */
                LigneMotif c = (LigneMotif) b.getParent();
                int id = c.id;
                j.getLigne().remplirLigne(new Tuile("rouge"),4);
                boolean verif = true;
                if (j.getLigne().couleurLigne(id).equals("blue")) {
                    System.out.println(j.getLigne().remplirLigne(new Tuile("bleu"),id));
                }
                System.out.println(verif);

                /**
                 * Des simples test que j'ai réalisé sans grandes importances.
                 */
                if (b.getColor().equals("w")) {
                    setOpaque(true);
                    setIcon(new ImageIcon(tuile));
                    System.out.println("Test");
                }
                else if(verif){
                    setOpaque(true);
                    setIcon(imageIcon);
                }
            }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }



    public static void main(String[] args) throws IOException {
        new Vue();
    }

}
