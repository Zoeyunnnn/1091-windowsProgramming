// app23_4, JButton�PJLabel����X����
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class app23_4
{
    static JFrame frm=new JFrame("JButton & JLabel");
    static Container cp=frm.getContentPane();

    static ImageIcon pic[]=new ImageIcon[4];  // �إ�ImageIcon�}�C

    static ImageIcon left=new ImageIcon("img\\left.gif");
    static ImageIcon right=new ImageIcon("img\\right.gif");

    static JButton btn1=new JButton(" �e�@�i ",left);
    static JButton btn2=new JButton(" ��@�i ",right);
    static JLabel lab=new JLabel();

    static int index=0;         // index�ܼơA�ΨӰO�����@�i�v�����Q���

    public static void main(String args[])
    {
        pic[0]=new ImageIcon("img\\pic0.jpg"); // ���J�v��
        pic[1]=new ImageIcon("img\\pic1.jpg");
        pic[2]=new ImageIcon("img\\pic2.jpg");
        pic[3]=new ImageIcon("img\\pic3.jpg");

        cp.setLayout(new FlowLayout());
        btn2.setHorizontalTextPosition(JButton.LEFT); // �]�w��r������m
        cp.add(btn1);
        cp.add(btn2);
        cp.add(lab);
        lab.setIcon(pic[0]);
        lab.setText("pic0.jpg");
        lab.setHorizontalTextPosition(JLabel.CENTER); // �]�w��r������m
        lab.setVerticalTextPosition(JLabel.BOTTOM); // �]�w��r������m

        btn1.addActionListener(new ActLis());
        btn2.addActionListener(new ActLis());

        frm.setSize(400,350);
        frm.setVisible(true);
    }

    static class ActLis implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JButton btn=(JButton) e.getSource();   // ���o�Q���U�����s
            int num=pic.length;

            if(btn==btn1 && index>0)    // �Ybtn1�Q���U�A�Bindex>0
                index--;
            if(btn==btn2 && index<num-1) // �Ybtn2�Q���U�A�Bindex<num-1
                index++;

            lab.setText("pic"+ index%num +".jpg");  // �]�w���D�W��
            lab.setIcon(pic[index%num]);
        }
    }
}
