
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;
import java.util.*;

public class Try extends Frame implements ActionListener{
    static Try frm = new Try();
    static FileDialog fdlg = new FileDialog(frm,"Open");
    static Button btn = new Button("Open");
    static BufferedImage image = null;
    static File fi;
    static int x=50,y=50;
    static class imgPnl extends JPanel{

        private Graphics g;
        public imgPnl(){
            try{
                image = ImageIO.read(fi);
//            ImageIO.write(image, "jpg", new File("I:/output.jpg"));
            }
            catch(IOException ioe){
            }
        }
        public void display() throws IOException {
            x++;
            y++;
            this.setLocation(x,y);
            this.repaint();
        }
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters
            frm.setVisible(true);
        }
    }
    private static imgPnl pnl = new imgPnl();
    public static void main(String args[]) throws IOException {
        BorderLayout br=new BorderLayout();
        pnl.setBackground(Color.BLUE);
        pnl.setVisible(true);
        frm.add(pnl);
        frm.setVisible(true);

        frm.setLayout(br);
        frm.setTitle("Select a color");
        frm.setSize(500,350);
        frm.setVisible(true);

        frm.add(btn,br.SOUTH);
        btn.addActionListener(frm);
        frm.setVisible(true);
        while (true){
            pnl.display();
            try {
                Thread.sleep(300);
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        fdlg.setVisible(true);
        String fname = fdlg.getDirectory()+fdlg.getFile();
        fi = new File(fname);
    }


}