// app17_13, TextArea���O������
import java.awt.*;
public class app17_13
{
    static Frame frm=new Frame("TextArea class");
    static TextArea txa;

    public static void main(String args[])
    {
        txa=new TextArea("demo",8,14,TextArea.SCROLLBARS_BOTH);
        frm.setLayout(null);             // ���ϥΪ����t�m
        txa.setBounds(30,45,140,80);        // �]�w��r�Ϫ��j�p
        frm.setSize(200,150);
        frm.add(txa);
        frm.setVisible(true);
    }
}
