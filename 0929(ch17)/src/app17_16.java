// app17_16, FlowLayout���O���ϥ�
import java.awt.*;
public class app17_16
{
    static Frame frm=new Frame("Flow Layout");
    public static void main(String args[])
    {
        FlowLayout flow=new FlowLayout(FlowLayout.CENTER,5,10);
        frm.setLayout(flow);                // �]�w�����t�m���y�ʦ�
        frm.setSize(200,150);
        frm.setBackground(Color.yellow);
        frm.add(new TextField("This",8));            // �[�J��r���
        frm.add(new TextField("is",6));           // �[�J��r���
        frm.add(new TextField("Flow Layout",16));       // �[�J��r���
        frm.setVisible(true);
    }
}
