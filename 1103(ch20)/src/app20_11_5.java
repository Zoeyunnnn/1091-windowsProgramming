/**
 * @(#)app20_11_5.java
 *
 * app20_11_5 application
 *
 * @author
 * @version 1.00 2015/12/2
 */

// app20_11, �Q�ηƹ����ʶ��
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

//public class app20_11_2 extends Frame implements MouseMotionListener,MouseListener
// jdwang
public class app20_11_5 extends Frame implements MouseMotionListener,MouseListener, ActionListener, KeyListener
{
    static app20_11_5 frm=new app20_11_5();
    static MenuBar mb = new MenuBar();
    static Menu menu = new Menu("Color");
    static MenuItem m1 = new MenuItem("Pink");
    static MenuItem m2 = new MenuItem("Blue");
    static MenuItem m3 = new MenuItem("Yellow");
    static Menu menu2 = new Menu("Size");
    static MenuItem me1 = new MenuItem("Big");
    static MenuItem me2 = new MenuItem("Small");
    static Menu menu3 = new Menu("Color2");
    static MenuItem mn1 = new MenuItem("Pink");
    static MenuItem mn2 = new MenuItem("Blue");
    static MenuItem mn3 = new MenuItem("Yellow");
    static Menu menu4 = new Menu("Size2");
    static MenuItem mu1 = new MenuItem("Big");
    static MenuItem mu2 = new MenuItem("Small");
    static Color clr = Color.blue;
    static int a = 15;
    static Color clr2 = Color.black;
    static int b = 50;
    int x=70,y=60,posX=70,posY=60,dx,dy;


    // jdwang
//    static Button btn = new Button("Clear(jdwang)");

    public static void main(String args[]) {

        m1.addActionListener(frm);
        m2.addActionListener(frm);
        m3.addActionListener(frm);
        menu.add(m1);
        menu.add(m2);
        menu.add(m3);
        mb.add(menu);
        me1.addActionListener(frm);
        me2.addActionListener(frm);
        menu2.add(me1);
        menu2.add(me2);
        mb.add(menu2);
        mn1.addActionListener(frm);
        mn2.addActionListener(frm);
        mn3.addActionListener(frm);
        menu3.add(mn1);
        menu3.add(mn2);
        menu3.add(mn3);
        mb.add(menu3);
        mu1.addActionListener(frm);
        mu2.addActionListener(frm);
        menu4.add(mu1);
        menu4.add(mu2);
        mb.add(menu4);
        frm.setMenuBar(mb);
        frm.setTitle("Dragging a circle");
        //frm.setSize(200,150);
        frm.setSize(800,600);
        frm.addKeyListener(frm);
        frm.addMouseListener(frm);
        frm.addMouseMotionListener(frm);
        frm.setVisible(true);

        // jdwang
        BorderLayout br = new BorderLayout();
        frm.setLayout(br);
//        frm.add(btn,br.SOUTH);
//        frm.add(tx,br.NORTH);
//        frm.add(txa,br.WEST);
//        btn.addActionListener(frm);

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            Graphics g = getGraphics();
            g.setColor(clr2);
            g.fillOval(x,y,b,b);
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }

    public void mousePressed(MouseEvent e) {
        dx=e.getX()-posX;       // ���o�ƹ����U���I�P����Ix��V���Z��
        dy=e.getY()-posY;       // ���o�ƹ����U���I�P����Iy��V���Z��
    }
    public void mouseDragged(MouseEvent e)
    {
      /*
      x=e.getX()-dx;          // ���o�즲�ɪ�����Ix�y��
      y=e.getY()-dy;          // ���o�즲�ɪ�����Iy�y��
      if(dx>0 && dx<50 && dy>0 && dy<50) // �p�G���и��b����ΰϰ줺
      {
         Graphics g=getGraphics();
         //update(g);           // �M�ŵe�����I���C��A�A�I�spaint()
         paint(g);
      }
      */
    }
    public void paintComponent(){
        Graphics g = getGraphics();
        Image img = null;
        try {
            img = ImageIO.read(new File("subin.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(img, 0, 0, null);
    }
    public void paint(Graphics g) {
        Image img = null;
        try {
            img = ImageIO.read(new File("subin.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(img, 0, 0, null);

        g.setColor(Color.pink);  // �]�wø���C�⬰����
        //g.fillOval(x,y,50,50);   // �H����I���ϧΪ����W��ø�X���

        // �e�X���
        g.drawArc(x,y,50,50,0,360);

        // �e�X+ => �����u
        g.drawLine(x,y+25,x+50,y+25);

        // �e�X+ => �����u
        g.drawLine(x+25,y,x+25,y+50);

        posX=x;              // ��s����I��x�y��
        posY=y;              // ��s����I��y�y��
    }
    public void mouseMoved(MouseEvent e){
        x=e.getX()-dx;          // ���o�즲�ɪ�����Ix�y��
        y=e.getY()-dy;          // ���o�즲�ɪ�����Iy�y��
        if(dx>0 && dx<50 && dy>0 && dy<50) // �p�G���и��b����ΰϰ줺
        {
            Graphics g=getGraphics();
            update(g);           // �M�ŵe�����I���C��A�A�I�spaint()
//            paint(g);
        }
    }
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){
    }
    public void mouseExited(MouseEvent e){}
    public void mouseClicked(MouseEvent e){
        Graphics g=getGraphics();

        g.setColor(clr);
        g.fillOval(x+20,y+20,a,a);   // �H����I���ϧΪ����W��ø�X���
        //g.fillOval(x,y,10,10);   // �H����I���ϧΪ����W��ø�X���
    }


    public void actionPerformed(ActionEvent e){
        if (e.getSource()==m1) clr=Color.pink;
        else if (e.getSource()==m2) clr=Color.blue;
        else if (e.getSource()==m3) clr=Color.yellow;
        if (e.getSource()==me1) a=30;
        else if (e.getSource()==me2) a=10;
        if (e.getSource()==mn1) clr=Color.pink;
        else if (e.getSource()==mn2) clr2=Color.blue;
        else if (e.getSource()==mn3) clr2=Color.yellow;
        if (e.getSource()==mu1) b=60;
        else if (e.getSource()==mu2) b=20;

        //btn.setBackground(Color.green);
        // jdwang
        Graphics g=getGraphics();
        update(g);           // �M�ŵe�����I���C��A�A�I�spaint()

    }
}
