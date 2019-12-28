import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class Vue extends JFrame {
    
    JPanel imageDeFond = new JPanel();
    Image img = ImageIO.read(new File("imageTuiles\\backTile.png"));
    //Image plateauJoueur = ImageIO.read(new File("E:\\Users\\Medine\\Bureau\\imageTuiles\\PlateauJoueur.png"));

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
        JPanel jp = lignesMotifs();
        jp.setBounds(0,0,150,150);
        jp.setBorder(BorderFactory.createLineBorder(Color.GREEN,1));
        lignesMotifContainer.add(jp);

        murTuilesContainer.setBorder(BorderFactory.createLineBorder(Color.MAGENTA,10));
        murTuilesContainer.setBounds(150,100,150,150);

        plancherContainer.setBorder(BorderFactory.createLineBorder(Color.red,10));
        plancherContainer.setBounds(0,250,300,100);
        return plateauJoueurContainer;
    }


    /*
        permet (provisoirement) de créer les lignes motifs et de les placer dans un JPanel qu'on retourne ensuite.
     */
    public JPanel lignesMotifs(){
        JLabel lignesMotif [] = new JLabel[15];
        for (int i = 0; i < 15; i++){
            lignesMotif[i] = new JLabel();
        }

        JPanel containerLignesMotif = new JPanel();
        // Ici il y a une erreur avec le gridLayout(), je reglerai ça plus tard !
        containerLignesMotif.setLayout(new GridLayout(5,5));

        for (JLabel l : lignesMotif){
            l.setSize(5,5);
            l.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
            containerLignesMotif.add(l);
            l.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    l.setOpaque(true);
                    l.setBackground(Color.BLACK);
                    System.out.println("Simple test");
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
            });
        }


        return containerLignesMotif;
    }



    public static void main(String[] args) throws IOException {
        new Vue();
    }

}
