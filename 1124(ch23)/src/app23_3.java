// app23_3, JButton�v���ϥܪ��ܤ�
import java.awt.*;
import javax.swing.*;

public class app23_3
{
    static JFrame frm=new JFrame("JButton ����");
    static Container cp=frm.getContentPane();

    static ImageIcon general=new ImageIcon("img\\01.jpg");
    static ImageIcon rollover=new ImageIcon("img\\02.jpg");
    static ImageIcon pressed=new ImageIcon("img\\03.jpg");
    static JButton btn=new JButton("JButton");  // �إ�JButton����

    public static void main(String args[])
    {
        cp.setLayout(new FlowLayout());
        cp.add(btn);  // �N���s�[�J���e�h��

        btn.setRolloverEnabled(true);   // �]�w�ƹ����лP���s�����ʮĪG
        btn.setIcon(general);     // �]�w�b�@�뱡�p�U�A���s���ϥ�
        btn.setRolloverIcon(rollover);  // �]�w���Цb���s�W��ɪ��ϥ�
        btn.setPressedIcon(pressed); // �]�w�ƹ�������U�ɪ��ϥ�

        frm.setSize(200,130);
        frm.setVisible(true);
    }
}
