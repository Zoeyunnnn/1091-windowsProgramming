// app17_3, AWT²�檺�d�� (�T)
import java.awt.*;
public class app17_3 extends Frame { // ���wapp17_3�~�Ӧ�Frame���O
    public static void main(String args[]) {
        app17_3 frm = new app17_3();     // ��app17_3���O����frm����

        Label lab = new Label("Hello Java!!");
        frm.setTitle("my first AWT program");      // �b�������[�J���D
        frm.setSize(220,150);
        frm.setBackground(Color.pink);
        frm.setLocation(250,250);
        frm.add(lab);
        frm.setVisible(true);
    }
}
