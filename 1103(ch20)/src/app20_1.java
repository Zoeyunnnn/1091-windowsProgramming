/**
 * @(#)app20_1.java
 *
 * app20_1 application
 *
 * @author
 * @version 1.00 2015/11/17
 */

// app20_1, 簡單的繪圖
import java.awt.*;
import java.awt.event.*;
public class app20_1 extends Frame implements ActionListener {
    static app20_1 frm = new app20_1();
    static Button btn = new Button("Draw");

    public static void main(String args[])
    {
        BorderLayout br=new BorderLayout();
        frm.setTitle("Drawing example");
        frm.setLayout(br);
        frm.setSize(800,600);
        frm.add(btn,br.SOUTH);
        btn.addActionListener(frm);
        frm.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        Graphics g=getGraphics();        // 取得視窗的繪圖區
//        g.drawRect(100,50,70,55);        // 繪出長方形
        g.drawLine(0,300,600,300);
        g.drawLine(300,0,300,600);

        for (int i=0;i<=300;i+=30){
            g.drawLine(300,i,300+i,300);
        }
        for (int i=0;i>=-300;i-=30){
            g.drawLine(300,-i,300+i,300);
        }
        for (int i=0;i<=300;i+=30){
            g.drawLine(300,600-i,300+i,300);
        }
        for (int i=0;i<=300;i+=30){
            g.drawLine(300,600-i,300-i,300);
        }
    }
}

