// app19_6, �\����ƥ�B�z�d��
import java.awt.*;
import java.awt.event.*;
public class app19_6 extends Frame implements ActionListener
{
    static app19_6 frm=new app19_6();
    static Label lab=new Label("Tastes differ.",Label.CENTER);
    static MenuBar mb=new MenuBar();             // �إ�MenuBar����
    static Menu menu1=new Menu("Style");
    static Menu menu2=new Menu("Exit");
    static MenuItem mi1=new MenuItem("Plane");
    static MenuItem mi2=new MenuItem("Bold");
    static MenuItem mi3=new MenuItem("Italic");
    static MenuItem mi4=new MenuItem("Close window");
    public static void main(String args[])
    {
        frm.setTitle("Menu Demo");
        mb.add(menu1);
        mb.add(menu2);
        menu1.add(mi1);
        menu1.add(mi2);
        menu1.add(mi3);
        menu2.add(mi4);
        mi1.addActionListener(frm);   // �]�wfrm��mi1���ƥ��ť��
        mi2.addActionListener(frm);   // �]�wfrm��mi2���ƥ��ť��
        mi3.addActionListener(frm);   // �]�wfrm��mi3���ƥ��ť��
        mi4.addActionListener(frm);   // �]�wfrm��mi4���ƥ��ť��
        lab.setFont(new Font("Dialog",Font.PLAIN,24));
        frm.add(lab);
        frm.setSize(280,150);
        frm.setMenuBar(mb);
        frm.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)  // �ƥ�B�z���{���X
    {
        MenuItem mi=(MenuItem) e.getSource();     // ���oĲ�o�ƥ󪺪���
        if(mi==mi1)                         // mi1Ĳ�o�ƥ�
            lab.setFont(new Font("Dialog",Font.PLAIN,24));
        else if(mi==mi2)                 // mi2Ĳ�o�ƥ�
            lab.setFont(new Font("Dialog",Font.BOLD,24));
        else if(mi==mi3)                 // mi3Ĳ�o�ƥ�
            lab.setFont(new Font("Dialog",Font.ITALIC,24));
        else if(mi==mi4)                 // mi4Ĳ�o�ƥ�
            frm.dispose();                // ��������
    }
}
