// app18_1, ²�檺�ƥ�B�z�d��(���[�J�ƥ�B�z)
import java.awt.*;
public class app18_1 extends Frame // �]�wapp18_1���O�~�Ӧ�Frame���O
{
    static app18_1 frm=new app18_1(); // �إ�app18_1���O������frm
    static Button btn=new Button("Click Me");

    public static void main(String args[])
    {
        frm.setLayout(new FlowLayout());
        frm.setTitle("Action Event");
        frm.setSize(200,150);
        frm.add(btn);
        frm.setVisible(true);
    }
}
