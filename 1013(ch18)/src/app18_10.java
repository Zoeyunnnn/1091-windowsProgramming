// app18_10, �HMouseMotionListener�����B�zMouseEvent�ƥ�
import java.awt.*;
import java.awt.event.*;
public class app18_10 extends Frame implements MouseMotionListener
{
    static app18_10 frm=new app18_10();
    static Label labx=new Label();
    static Label laby=new Label();
    static Label lab=new Label();
    public static void main(String agrs[])
    {
        frm.setLayout(null);
        frm.addMouseMotionListener(frm); // �]�wfrm���ƥ󪺶�ť��
        labx.setBounds(40,40,40,20);
        laby.setBounds(100,40,40,20);
        lab.setBounds(40,80,100,40);
        frm.setSize(200,150);
        frm.setTitle("Mouse Event");
        frm.add(labx);
        frm.add(laby);
        frm.add(lab);
        frm.setVisible(true);
    }
    public void mouseMoved(MouseEvent e)   // ��ƹ����ʮ�
    {
        labx.setText("x="+e.getX());     // ���x�y��
        laby.setText("y="+e.getY());     // ���y�y��
        lab.setText("Mouse Moved!!");    // ���"Mouse Moved!!"�r��
    }
    public void mouseDragged(MouseEvent e) // ��ƹ��즲��
    {
        labx.setText("x="+e.getX());     // ���x�y��
        laby.setText("y="+e.getY());     // ���y�y��
        lab.setText("Mouse Dragged!!");  // ���"Mouse Dragged!!"�r��
    }
}
