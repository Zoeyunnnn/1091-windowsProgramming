import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.*;

public class online1208 extends JFrame{
    static online1208 f = new online1208();
    Container contentPane;
    static JButton btn = new JButton("Get Color");
    static JColorChooser JCC = new JColorChooser();
    static Color color;
    static int GridNum = 5;
    static Button [][] btn_Array= new Button[GridNum][GridNum];

    public online1208(){
//        super("JFrame");  //執行父代類別的建構子
//        this.setSize(300,100);
//        contentPane = getContentPane();
//        contentPane.setLayout(new BorderLayout());
//        contentPane.add(btn,BorderLayout.SOUTH);
//        btn.addActionListener(new ActLis());
    }
    public static void main(String[] args) {
        GridLayout grid = new GridLayout(GridNum,GridNum);
        f.setLayout(grid);
        for(int i=0;i<GridNum;i++){
            for(int j=0;j<GridNum;j++){
                btn_Array[i][j] = new Button(Integer.toString(i)+"-" +Integer.toString(j));
                f.add(btn_Array[i][j]);
                btn_Array[i][j].addActionListener(new ActLis());
            }
        }
        f.setSize(500,650);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    static class ActLis implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for(int i=0;i<GridNum;i++){
                for(int j=0;j<GridNum;j++){
                    if(e.getSource()==btn_Array[i][j]){
                        int R = (int)(Math.random() * 255 + 1);
                        int G = (int)(Math.random() * 255 + 1);
                        int B = (int)(Math.random() * 255 + 1);
                        color = JCC.showDialog(f,"JColorChooser",new Color(R,G,B));
                        btn_Array[i][j].setBackground(color);
                    }
                }
            }
        }
    }
}
