// app19_2, ��ܪ�檺�ƥ�B�z�d��
import java.awt.*;
import java.awt.event.*;
public class app19_2 extends Frame implements ItemListener
{
    static app19_2 frm=new app19_2();
    static List lst=new List();            // �إ߿�ܪ�檫��lst
    public static void main(String args[])
    {
        frm.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));
        frm.setTitle("Select a color");
        lst.add("yellow");               // �[�J�ﶵ��lst��
        lst.add("orange");
        lst.add("pink");
        lst.add("cyan");
        lst.addItemListener(frm);        // �]�wfrm��lst����ť��
        frm.add(lst);
        frm.setSize(200,150);
        frm.setVisible(true);
    }
    public void itemStateChanged(ItemEvent e)    // �ƥ�B�z���{���X
    {
        String color=lst.getSelectedItem();    // ���o�Q������ﶵ�W��
        if(color=="yellow")              // �p�G�ﶵ�W�٬�yellow
            frm.setBackground(Color.yellow);
        else if(color=="orange")            // �p�G�ﶵ�W�٬�orange
            frm.setBackground(Color.orange);
        else if(color=="pink")              // �p�G�ﶵ�W�٬�pink
            frm.setBackground(Color.pink);
        else if(color=="cyan")              // �p�G�ﶵ�W�٬�cyan
            frm.setBackground(Color.cyan);
        frm.setTitle("you select "+color);     // �]�w����frm�����D
    }
}
