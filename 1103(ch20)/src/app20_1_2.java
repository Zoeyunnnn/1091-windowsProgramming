/**
 * @(#)app20_1_2.java
 *
 * app20_1_2 application
 *
 * @author
 * @version 1.00 2015/11/17
 */

import java.awt.*;
import java.awt.event.*;

import java.util.concurrent.TimeUnit;

public class app20_1_2 extends Frame implements ActionListener
{
    static app20_1_2 frm=new app20_1_2();
    static Button btn=new Button("Draw");

    public static void main(String args[])
    {
        BorderLayout br=new BorderLayout();
        frm.setTitle("Drawing example");
        frm.setLayout(br);
        //frm.setSize(200,150);
        frm.setSize(500,450);
        frm.add(btn,br.SOUTH);
        btn.addActionListener(frm);
        frm.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        Graphics g=getGraphics();        // 取得視窗的繪圖區
        for (int i=1;i<=100;++i){
            g.drawRect(100+i,50+i,70+i,55+i);        // 繪出長方形
            try {
                wait(1000);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
} // End of public class app20_1_2