// app17_2, AWT²�檺�d�� (�G)
import java.awt.*;            // ���Jjava.awt���O�w�̪��Ҧ����O
public class app17_2 {
    public static void main(String args[]) {
        Frame frm = new Frame("my first AWT program");
        Label lab = new Label("Hello Java!!");
        frm.setSize(220,150);
        frm.setBackground(Color.pink);
        frm.setLocation(250,250);
        frm.add(lab);
        frm.setVisible(true);
    }
}
