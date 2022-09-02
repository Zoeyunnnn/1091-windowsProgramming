import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.*;

public class online1208_2 extends JFrame{
    static online1208_2 f = new online1208_2();
    static JButton btn = new JButton("New Frame"); // 建立JButton物件

    static Container cp = f.getContentPane();   // 取得內容層
    static JDesktopPane jdp=new JDesktopPane();

    static Button [][] btn_Array= new Button[4][4];

    public static void main(String[] args) {
        cp.setLayout(new BorderLayout());
        cp.add(btn,BorderLayout.SOUTH);
        cp.add(jdp);

        btn.addActionListener(new ActLis());
        f.setSize(600,500);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    static class ActLis implements ActionListener{
        static int count=1;
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==btn){
                GridLayout grid = new GridLayout(4,4);
                JInternalFrame jif;
                jif = new JInternalFrame("Frame "+(count++),true,true,true,true);
                Container icp = jif.getContentPane();
                icp.setLayout(grid);
                for(int i=0;i<4;i++){
                    for(int j=0;j<4;j++){
                        btn_Array[i][j] = new Button(Integer.toString(i)+"-" +Integer.toString(j));
                        icp.add(btn_Array[i][j]);
                        btn_Array[i][j].addActionListener(new ActLis());
                    }
                }
                jdp.add(jif);
                jif.setSize(300,250);
                jif.setVisible(true);
            }else {
                for(int i=0;i<4;i++){
                    for(int j=0;j<4;j++){
                        if(e.getSource()==btn_Array[i][j]){
                            int R = (int)(Math.random() * 255 + 1);
                            int G = (int)(Math.random() * 255 + 1);
                            int B = (int)(Math.random() * 255 + 1);
                            btn_Array[i][j].setBackground(new Color(R,G,B));
                        }
                    }
                }
            }
        }
    }
}
