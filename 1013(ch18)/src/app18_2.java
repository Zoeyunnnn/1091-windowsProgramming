// app18_2, ²�檺�ƥ�B�z�d��(�w�[�J�ƥ�B�z)
import java.awt.*;
import java.awt.event.*;
public class app18_2 extends Frame implements ActionListener
{
    static app18_2 frm=new app18_2();
    static Button btn=new Button("Click Me");

    public static void main(String args[])
    {
        btn.addActionListener(frm);            // ��frm�Vbtn���U
        frm.setLayout(new FlowLayout());
        frm.setTitle("Action Event");
        frm.setSize(200,150);
        frm.add(btn);
        frm.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) // �ƥ�o�ͪ��B�z�ʧ@
    {
        frm.setBackground(Color.yellow);
    }
}
