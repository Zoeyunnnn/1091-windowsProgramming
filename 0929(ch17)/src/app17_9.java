// app17_9, �]�w���s���j�p
import java.awt.*;
public class app17_9
{
    static Frame frm=new Frame("Button class");
    static Button btn=new Button("Push Me!!");

    public static void main(String args[])
    {
        frm.setLayout(null);          // ���ϥΪ����t�m
        btn.setBounds(45,65,100,40);     // �]�w���s���j�p�P��m
        frm.setSize(200,150);
        frm.add(btn);
        frm.setVisible(true);
    }
}
