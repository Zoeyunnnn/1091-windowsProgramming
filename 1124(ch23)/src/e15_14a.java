import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Calendar;
public class e15_14a extends JFrame implements ActionListener
{
    JLabel label;
    Calendar c1;
    Timer timer;
    public e15_14a()
    {
        super("JFrame");  //������N���O���غc�l
        this.setSize(300,100);
        Container c=getContentPane();  //���oContentPane����
        c.setLayout(new FlowLayout()); //�����t�m
        label=new JLabel();
        c.add(label);    //�s�W�����ContentPane
        timer=new Timer(100,this);
    }
    public static void main(String[] args)
    {
//        e15_2c frm=new e15_2c();
//        frm.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        frm.setVisible(true);
//        frm.timer.start();
    }
    public void actionPerformed(ActionEvent e) {
        c1=Calendar.getInstance();
        label.setText(c1.getTime().toString());
    }
}