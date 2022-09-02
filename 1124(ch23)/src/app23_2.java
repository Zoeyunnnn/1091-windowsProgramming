// app23_2, JInternalFrame���O���m��
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class app23_2
{
    static JFrame frm=new JFrame("JInternalFrame");
    static JButton btn=new JButton("New Frame"); // �إ�JButton����

    static Container cp=frm.getContentPane();   // ���o���e�h
    static JDesktopPane jdp=new JDesktopPane(); // �إ߮ୱ�h����

    public static void main(String args[])
    {
        cp.setLayout(new BorderLayout());
        cp.add(btn,BorderLayout.SOUTH);
        cp.add(jdp);        // �N�ୱ�h�[�줺�e�h��

        btn.addActionListener(new ActLis());
        frm.setSize(400,300);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static class ActLis implements ActionListener
    {
        static int count=1;     // �ŧicount�ܼơA�ΨӰO���l�������`��
        public void actionPerformed(ActionEvent e)
        {
            JInternalFrame jif;  // �إߤl��������jif
            jif=new JInternalFrame("Frame "+(count++),true,true,true,true);
            Container icp=jif.getContentPane();  // ���ojif�����e�h
            JButton ibtn=new JButton("JInternalFrame Button");
            icp.add(ibtn,BorderLayout.SOUTH);       // �Nibtn���s�[�Jicp��
            jdp.add(jif);        // �N�l��������jif�[��ୱ�h��
            jif.setSize(200,150);
            jif.setVisible(true);
        }
    }
}
