// app17_4, AWT²�檺�d�� (�|)
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class app17_4 extends Frame
{
    Label lab=new Label("Hello Java!!");   // �إ�lab����

    public app17_4(String str)             // �غc��app17_4()
    {
        super(str);             // �I�s�����O(Frame)���غc��
        add(lab);               // �N����lab ����[�J������

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
        app17_4 frm=new app17_4("my first AWT program"); // �I�sapp17_4()�غc��

        frm.setSize(220,150);
        frm.setBackground(Color.yellow);
        frm.setLocation(250,250);
        frm.setVisible(true);
    }
}
