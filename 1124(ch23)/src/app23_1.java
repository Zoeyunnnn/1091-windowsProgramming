// app23_1, JFrame���O���m��
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;         // ���Jjavax.swing���O�w�̪��Ҧ����O

public class app23_1 extends JFrame implements ActionListener
{
    static app23_1 frm=new app23_1();
    static Button btn=new Button("Click Me");
    static Container cp=frm.getContentPane();       // ���o�����e��

    public static void main(String args[])
    {
        cp.add(btn);                    // �N���sbtn�[�J���e�h��
        cp.setLayout(new FlowLayout());    // �]�w���e�h�������t�m
        cp.setBackground(Color.pink);      // �]�w���e�h���C��
        btn.addActionListener(frm);
        frm.setTitle("JFrame ����");
        frm.setSize(200,150);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    // ���Ubtn���s���ƥ�B�z
    public void actionPerformed(ActionEvent e)
    {
        if(cp.getBackground()==Color.pink)
            cp.setBackground(Color.yellow);
        else
            cp.setBackground(Color.pink);
    }
}
