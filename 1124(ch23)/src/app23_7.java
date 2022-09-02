// app23_7, JList���m�ߡ]�G�^
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;         // ���Jutil���O�w�̪�Vector���O

public class app23_7
{
    static JFrame frm=new JFrame("JList demo");
    static Container cp=frm.getContentPane();
    static JList<String> lst1=new JList<String>();  // �إ�lst1����
    static JList<String> lst2=new JList<String>();  // �إ�lst2����
    static String s[]={"RED","GREEN","BLUE","PINK","YELLOW","CYAN","GRAY"};
    static String s1[] = {};
    static Vector<String> v=new Vector<String>(); // �إ�Vector���O������v

    public static void main(String args[])
    {
        cp.setLayout(new GridLayout(1,2));
        cp.add(new JScrollPane(lst1));   // �NJScrollPane�[�Jcp��
        cp.add(new JScrollPane(lst2));   // �NJScrollPane�[�Jcp��
        lst1.setListData(s);                // �]�wlst1���󪺿��
        lst1.addMouseListener(new MouseLis());    // �]�wlst1���󪺶�ť��
        frm.setSize(200,155);
        frm.setVisible(true);
    }
    static class MouseLis extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e)
        {
            if(e.getSource()==lst1)          // �Y�Olst1����Q���U
                if(e.getClickCount()==2)         // �p�G�s��Q���F��U
                {
                    int index = lst1.getSelectedIndex();
                    String str=s[index];
                    v.add(str);                   // �N�r��str�[�J�V�qv
                    lst2.setListData(v);    // �]�w�V�qv��lst2���󪺿��
                    s[index]=null;
                    lst1.setListData(s);
                }
        }
    }
}
