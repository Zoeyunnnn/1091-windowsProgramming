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
        super("JFrame");  //執行父代類別的建構子
        this.setSize(300,100);
        Container c=getContentPane();  //取得ContentPane物件
        c.setLayout(new FlowLayout()); //版面配置
        label=new JLabel();
        c.add(label);    //新增元件至ContentPane
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