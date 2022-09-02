/**
 * @(#)app20_1_1.java
 *
 * app20_1_1 application
 *
 * @author
 * @version 1.00 2015/11/17
 */

// app20_1_1, 簡單的繪圖
import java.awt.*;
import java.awt.event.*;
public class app20_1_1 extends Frame implements ActionListener
{
    static app20_1_1 frm=new app20_1_1();
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
        }
    }
} // End of public class app20_1_1


