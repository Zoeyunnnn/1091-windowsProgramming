// app20_5, RGB color�ⶥ������
import java.awt.*;
import java.awt.event.*;
public class app20_5 extends Frame implements AdjustmentListener
{
    static app20_5 frm=new app20_5();
    static Scrollbar scr1=new Scrollbar(Scrollbar.VERTICAL);
    static Scrollbar scr2=new Scrollbar(Scrollbar.HORIZONTAL);
    static Scrollbar scr3=new Scrollbar(Scrollbar.VERTICAL);

    public static void main(String args[])
    {
        BorderLayout br=new BorderLayout(5,5);
        frm.setTitle("Display colors");
        frm.setSize(200,150);
        frm.add(scr1,br.WEST);           // scr1���b�A�Ψӱ������
        frm.add(scr2,br.SOUTH);          // scr2���b�A�Ψӱ�����
        frm.add(scr3,br.EAST);           // scr3���b�A�Ψӱ����Ŧ�
        scr1.setValues(255,45,0,300);    // �]�wscr1�������ƭ�
        scr2.setValues(255,45,0,300);    // �]�wscr2�������ƭ�
        scr3.setValues(140,45,0,300);    // �]�wscr3�������ƭ�
        scr1.addAdjustmentListener(frm);
        scr2.addAdjustmentListener(frm);
        scr3.addAdjustmentListener(frm);
        frm.setVisible(true);
    }
    public void adjustmentValueChanged(AdjustmentEvent e)
    {
        Graphics g=getGraphics();
        paint(g);
    }

    public void paint(Graphics g)
    {
        int red=scr1.getValue();         // ���o���bscr1����
        int green=scr2.getValue();    // ���o���bscr2����
        int blue=scr3.getValue();     // ���o���bscr3����
        String str="Color("+red+","+green+","+blue+")";
        g.setColor(new Color(red,green,blue));    // �]�wø���C��
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.black);         // �]�wø���C�⬰�¦�
        g.drawString(str,45,80);         // ��(45,80)�B�g�W�r��
    }
}
