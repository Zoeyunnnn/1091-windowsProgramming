// app19_4, �U�Կ�檺�ƥ�B�z�d��
import java.awt.*;
import java.awt.event.*;
class app19_4 extends Frame implements ItemListener
{
    static app19_4 frm=new app19_4();
    static Choice chc=new Choice();   // �إߤU�Ԫ�檫��chc
    public static void main(String args[])
    {
        BorderLayout br=new BorderLayout();
        frm.setLayout(br);
        frm.setTitle("Select a color");
        chc.add("yellow");         // �[�J�ﶵ��U�Ԫ�檫��chc��
        chc.add("orange");
        chc.add("pink");
        chc.add("cyan");
        chc.addItemListener(frm);     // �]�wfrm��chc���ƥ��ť��
        frm.setSize(200,150);
        frm.add(chc,br.NORTH);
        frm.setVisible(true);
    }
    public void itemStateChanged(ItemEvent e)
    {
        String color=chc.getSelectedItem();
        if(color=="yellow")        // ���yellow�ﶵ
            frm.setBackground(Color.yellow);
        else if(color=="orange")      // ���orange�ﶵ
            frm.setBackground(Color.orange);
        else if(color=="pink")        // ���pink�ﶵ
            frm.setBackground(Color.pink);
        else if(color=="cyan")        // ���cyan�ﶵ
            frm.setBackground(Color.cyan);
        frm.setTitle("you select "+color);
    }
}
