// app20_4, ²�檺ø��
import java.awt.*;
import java.awt.event.*;
public class app20_4 extends Frame  // �]�wapp20_4�~�Ӧ�Frame���O
{
    static app20_4 frm=new app20_4();         // �إߵ�������frm

    public static void main(String args[])
    {
        frm.setTitle("Drawing example");
        frm.setSize(200,150);
        frm.setVisible(true);
    }
    public void paint(Graphics g)
    {
        g.setFont(new Font("Arial",Font.ITALIC,18)); // �]�w�ϥΪ��r��
        g.drawString("Live and learn.",45,88);    // ø�X�r��
        g.setColor(Color.red);                 // �]�wø���C�⬰����
        g.drawRect(30,65,145,30);           // ø�X�����
    }
}
