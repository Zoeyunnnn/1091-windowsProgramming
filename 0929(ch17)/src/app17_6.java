// app17_6, �b�������[�J���Ҫ���
import java.awt.*;
public class app17_6
{
    static Frame frm=new Frame("Label class");
    static Label lab=new Label();          // �إ߼��Ҫ���lab

    public static void main(String args[])
    {
        frm.setSize(200,150);
        frm.setBackground(Color.pink);      // �]�w�������⬰������
        lab.setText("Hello Java");          // �b���Ҥ��[�W��r
        lab.setBackground(Color.white);     // �]�w���ҩ��⬰�զ�
        lab.setAlignment(Label.CENTER);        // �N���Ҥ�����r�m��
        lab.setForeground(Color.blue);      // �]�w���Ҥ�r���Ŧ�
        Font fnt=new Font("Serief",Font.ITALIC+Font.BOLD,18);
        lab.setFont(fnt);                // �]�w�r�����˦�
        frm.add(lab);
        frm.setVisible(true);
    }
}
