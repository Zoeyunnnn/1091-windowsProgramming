// app18_3, �w�q�������O����ť��
import java.awt.*;
import java.awt.event.*;
public class app18_3       // �D���O�A�`�N�����O�����~��Frame���O
{
    static Frame frm=new Frame("Action Event");
    static Button btn=new Button("Click Me");

    public static void main(String args[])
    {
        btn.addActionListener(new ActLis());
        frm.setLayout(new FlowLayout());
        frm.setSize(200,150);
        frm.add(btn);
        frm.setVisible(true);
    }
    // �w�q�������OActLis�A�ù�@ActionListener����
    static class ActLis implements ActionListener
    {
        public void actionPerformed(ActionEvent e)   // �ƥ�o�ͪ��B�z�ʧ@
        {
            frm.setBackground(Color.yellow);
        }
    }
}
