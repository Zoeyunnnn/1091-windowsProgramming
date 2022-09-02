// app17_14, BorderLayout���O���ϥ�
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class app17_14
{
    static Frame frm=new Frame("Border Layout");
    public static void main(String args[])
    {
        BorderLayout border=new BorderLayout(2,5);       // �غc��
        frm.setLayout(border);   // �N�����t�m�]�w��BorderLayout
        frm.setSize(200,150);
        frm.add(new Button("East"),border.EAST);
        frm.add(new Button("West"),border.WEST);
        frm.add(new Button("South"),border.SOUTH);
        frm.add(new Button("North"),border.NORTH);
        frm.add(new Button("Center"),border.CENTER);
        frm.setVisible(true);

        frm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
