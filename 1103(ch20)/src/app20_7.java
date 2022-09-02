// app20_7, �C�X�t�ΩҴ��Ѫ��r��
import java.awt.*;
import java.awt.event.*;
class app20_7 extends Frame implements ItemListener
{
    static app20_7 frm=new app20_7();
    static List lst=new List();      // �إߤ@��List����
    String str="Arial";        // �]�w�r�ꪺ���

    public static void main(String args[])
    {
        BorderLayout br=new BorderLayout(5,5);
        frm.add(lst,br.NORTH);
        frm.setBackground(Color.yellow);
        frm.setTitle("Font List");
        lst.addItemListener(frm);
        frm.setSize(300,150);
        GraphicsEnvironment ge;
        ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
        String fnt[]=ge.getAvailableFontFamilyNames();
        for(int i=2;i<fnt.length-2;i++)
            lst.add(fnt[i]);
        frm.setVisible(true);
    }
    public void itemStateChanged(ItemEvent e)
    {
        str=lst.getSelectedItem(); // ���o��ܪ��̳Q���������
        Graphics g=getGraphics();
        update(g);
    }
    public void paint(Graphics g)
    {
        g.setFont(new Font(str,Font.PLAIN,20));   // �]�w�r��
        g.setColor(Color.black);               // �]�w�C��
        g.drawString(str,20,110);     // �Ϋ��w���C��P�r���g�W�r��
    }
}
