// app17_7, ���w���Ҫ��󪺤j�p
import java.awt.*;
public class app17_7
{
    static Frame frm=new Frame("Label class");
    static Label lab=new Label();

    public static void main(String args[])
    {
        frm.setLayout(null);             // ���������t�m
        frm.setSize(200,150);
        frm.setBackground(Color.pink);
        lab.setText("Hello Java");
        lab.setBackground(Color.white);
        lab.setAlignment(Label.CENTER);
        lab.setForeground(Color.blue);
        lab.setLocation(60,50);          // �]�w���Ҧ�m
        lab.setSize(120,20);             // �]�w���Ҥj�p
        lab.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
        frm.add(lab);
        frm.setVisible(true);
    }
}
