package app17_17;
//app17_17, GridLayout類別的使用
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.*;

//public class app17_17_jdwang extends Frame implements ActionListener
public class app17_17 extends JFrame implements ActionListener {
    static app17_17 frm=new app17_17();
    //static Frame frm=new Frame("Grid Layout");
    static int GridNum = 5;
    //static Button [][] btn_Array= new Button[10][10];
    static Button [][] btn_Array= new Button[GridNum][GridNum];

    public static void main(String args[])
    {
        GridLayout grid=new GridLayout(GridNum,GridNum);      // 3列5行的配置
        frm.setLayout(grid);
        frm.setSize(400,550);

        for(int i=0;i<GridNum;i++){
            for(int j=0;j<GridNum;j++){
                //frm.add(new Button(Integer.toString(i)));    // 加入按鈕
                btn_Array[i][j] = new Button(Integer.toString(i)+"-" +Integer.toString(j));
                frm.add(btn_Array[i][j]);    // 加入按鈕
            } // End of for(int j=0;j<10;j++)
        } // End of for(int i=0;i<10;i++){

        for(int i=0;i<GridNum;i++){
            for(int j=0;j<GridNum;j++){
                btn_Array[i][j].addActionListener(frm);     // 把事件傾聽者frm向btn3註冊
            } // End of for(int j=0;j<10;j++)
        } // End of for(int i=0;i<10;i++){

        frm.setVisible(true);
    } // End of public static void main(String args[])

    public void actionPerformed(ActionEvent e)
    {
        Button btn=(Button) e.getSource();     // 取得事件來源的物件

        for(int i=0;i<GridNum;i++){
            for(int j=0;j<GridNum;j++){
                if(btn==btn_Array[i][j]){
                    //btn_Array[i][j].setBackground(Color.red);
                    int R = (int )(Math.random() * 255 + 1);
                    int G = (int )(Math.random() * 255 + 1);
                    int B = (int )(Math.random() * 255 + 1);
                    Color Random_Color = new Color(R, G, B);
                    btn_Array[i][j].setBackground(Random_Color);
                }
            } // End of for(int j=0;j<10;j++)
        } // End of for(int i=0;i<10;i++){
    }
} // End of public class app17_17_jdwang
