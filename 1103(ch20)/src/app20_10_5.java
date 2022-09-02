package app20_10_5;

/**
 * @(#)app20_10_5.java
 *
 * app20_10_5 application
 *
 * jdwang@asia.edu.tw
 * @version 1.00 2015/11/24
 */
//import javax.sound.sampled.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.awt.geom.Line2D;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.util.Calendar;

//public class app20_10_1 extends Frame implements MouseMotionListener,MouseListener
public class app20_10_5 extends Frame implements MouseMotionListener,MouseListener, ActionListener
{
    static app20_10_5 frm=new app20_10_5();

    static Button btn = new Button("Save(image)");
    //static Button btn0 = new Button("");
    static TextField tx = new TextField();
    static Button btn1 = new Button("Pop(Icon)");
    static Button btn2 = new Button("Sound 1");
    static Button btn3 = new Button("Clear");

    int width = 500, height = 500;
    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics2D g2d = bufferedImage.createGraphics();


    int x1,x2,y1,y2;
    public static void main(String args[]) throws IOException
    {
        frm.setTitle("Free drawing");
        frm.setSize(400,350);
        frm.addMouseListener(frm);    // 設定MouseListener
        frm.addMouseMotionListener(frm); // 設定MouseMotionListener

        //frm.add(btn);
        BorderLayout br = new BorderLayout();
        frm.setLayout(br);
        frm.add(btn,br.SOUTH);
        //frm.add(btn0,br.CENTER);
        frm.add(tx,br.NORTH);
        frm.add(btn2,br.EAST);
        frm.add(btn3,br.WEST);

        btn.setActionCommand("Save(image)");
//        btn1.setActionCommand("pink");
        btn2.setActionCommand("red");
        btn3.setActionCommand("Clear");

        btn.addActionListener(frm);
        btn1.addActionListener(frm);
        btn2.addActionListener(frm);
        btn3.addActionListener(frm);

        frm.setVisible(true);
    }
    public void mousePressed(MouseEvent e)
    {
        x1=e.getX();   // 取得滑鼠按下時的x座標 (繪圖起始點的x座標)
        y1=e.getY();   // 取得滑鼠按下時的y座標 (繪圖起始點的y座標)
    }
    public void mouseDragged(MouseEvent e)
    {
        Graphics g=getGraphics();

        x2=e.getX();               // 取得拖曳滑鼠時的x座標
        y2=e.getY();               // 取得拖曳滑鼠時的y座標
        g.drawLine(x1,y1,x2,y2);      // 繪出(x1,y1)到(x2,y2)的連線
        //g2d.drawLine(x1,y1,x2,y2);      // 繪出(x1,y1)到(x2,y2)的連線

        //Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setPaint(Color.gray);
        g2d.draw(new Line2D.Double(x1,y1,x2,y2));

        x1=x2;                  // 更新繪圖起始點的x座標
        y1=y2;                  // 更新繪圖起始點的y座標
    }
    public void mouseMoved(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}

    public void actionPerformed(ActionEvent e){
        String cmd = e.getActionCommand();
        if (cmd == "Save(image)") {
            //btn0.setBackground(Color.green);

            // TYPE_INT_ARGB specifies the image format: 8-bit RGBA packed
            // into integer pixels
            // Constructs a BufferedImage of one of the predefined image types.
            try {
                String str = tx.getText();
                LocalDateTime dt = LocalDateTime.now();
                ImageIO.write(bufferedImage, "PNG", new File(str+"_"+dt.getYear()+"_"+dt.getMonthValue()+"_"+dt.getDayOfMonth()+"_"+dt.getHour()+"H-"+dt.getMinute()+"M-"+dt.getSecond()+"S"+".PNG"));
                ImageIO.write(bufferedImage, "JPEG", new File(str+"_"+dt.getYear()+"_"+dt.getMonthValue()+"_"+dt.getDayOfMonth()+"_"+dt.getHour()+"H-"+dt.getMinute()+"M-"+dt.getSecond()+"S"+".JPG"));
                ImageIO.write(bufferedImage, "gif", new File(str+"_"+dt.getYear()+"_"+dt.getMonthValue()+"_"+dt.getDayOfMonth()+"_"+dt.getHour()+"H-"+dt.getMinute()+"M-"+dt.getSecond()+"S"+".GIF"));
                ImageIO.write(bufferedImage, "BMP", new File(str+"_"+dt.getYear()+"_"+dt.getMonthValue()+"_"+dt.getDayOfMonth()+"_"+dt.getHour()+"H-"+dt.getMinute()+"M-"+dt.getSecond()+"S"+".BMP"));
            } catch (Exception ex) {}
        }
        if (cmd == "pink") {
            btn1.setBackground(Color.pink);
        }
        if (cmd == "red") {
            btn2.setBackground(Color.red);
        }
        if (cmd == "Clear") {
            //btn3.setBackground(Color.black);
            repaint();
        }
    } // End of public void actionPerformed(ActionEvent e)
} // end of public class app20_10_3 extends Frame
