// app19_5, �إߥ\���
import java.awt.*;
public class app19_5
{
    static Frame frm=new Frame("Menu Demo");
    static MenuBar mb=new MenuBar();       // �إ�MenuBar����
    static Menu menu1=new Menu("Color");
    static Menu menu2=new Menu("Exit");
    static MenuItem mi1=new MenuItem("Yellow");
    static MenuItem mi2=new MenuItem("Orange");
    static MenuItem mi3=new MenuItem("Pink");
    static MenuItem mi4=new MenuItem("Close window");

    public static void main(String args[])
    {
        mb.add(menu1);                   // �Nmenu1�[�Jmb��
        mb.add(menu2);                   // �Nmenu2�[�Jmb��
        menu1.add(mi1);                  // �Nmi1�[�Jmenu1��
        menu1.add(mi2);                  // �Nmi2�[�Jmenu1��
        menu1.add(mi3);                  // �Nmi3�[�Jmenu1��
        menu2.add(mi4);                  // �Nmi4�[�Jmenu2��
        frm.setMenuBar(mb);              // �]�wfrm���\���mb
        frm.setSize(200,150);
        frm.setVisible(true);
    }
}
