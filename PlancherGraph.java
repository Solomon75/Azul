import javax.swing.*;
import java.awt.*;

public class PlancherGraph extends JPanel {
    JPanel p;
    TuileGraph[] tuiles = new TuileGraph[7];

    PlancherGraph(){
        p = new JPanel();
        p.setLayout(new GridLayout(0,7));
        for (int i = 0; i <7; i++) {
            tuiles[i] = new TuileGraph("empty");
            switch (i) {
                case 0:
                case 1:
                    tuiles[i].lab.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.ORANGE, 3, true), "-1", 2, 0));
                    tuiles[i].lab.setTransferHandler(new TransferHandler("icon"));
                    break;
                case 2:
                case 3:
                case 4:
                    tuiles[i].lab.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.ORANGE, 3, true), "-2", 2, 0));
                    tuiles[i].lab.setTransferHandler(new TransferHandler("icon"));
                    break;
                case 5:
                case 6:
                    tuiles[i].lab.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.ORANGE, 3, true), "-3", 2, 0));
                    tuiles[i].lab.setTransferHandler(new TransferHandler("icon"));
                    break;

            }
            p.add(tuiles[i].lab);
            p.setBackground(Color.PINK);
            add(p);
        }
    }

    void clear(){
        for(TuileGraph tG : tuiles){
            tG.img = new ImageIcon("imageTuiles/empty.png");
            tG.lab.setIcon(tG.img);
            tG.couleur= "empty";
        }
        repaint();
        revalidate();
    }

    int casesLibres(){
        int i = 0;
        for(TuileGraph tG : tuiles){
            if (tG.couleur.equals("empty")) i++;
        }
        return i;
    }
    void update(int nb, String color){
        for(TuileGraph tG : tuiles){
            if(nb != 0){
                if(tG.couleur.equals("empty")){
                    tG.couleur = color;
                    tG.lab.setIcon(new ImageIcon("imagesTuile/" + color + ".png"));
                    nb--;
                }
            }
        }
    }
}
