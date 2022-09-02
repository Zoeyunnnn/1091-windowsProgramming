// app18_4, �[�J�i�������������s
import java.awt.*;
import java.awt.event.*;
public class app18_4 extends Frame implements ActionListener {
    static app18_4 frm=new app18_4();
    static Button btn1=new Button("Yellow");
    static Button btn2=new Button("Green");
    static Button btn3=new Button("Exit");

    public static void main(String args[])
    {
        btn1.addActionListener(frm);     // ��ƥ��ť��frm�Vbtn1���U
        btn2.addActionListener(frm);     // ��ƥ��ť��frm�Vbtn2���U
        btn3.addActionListener(frm);     // ��ƥ��ť��frm�Vbtn3���U

        frm.setTitle("Action Event");
        frm.setLayout(new FlowLayout(FlowLayout.CENTER));
        frm.setSize(200,150);
        frm.add(btn1);
        frm.add(btn2);
        frm.add(btn3);
        frm.setVisible(true);
        frm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e)
    {
        Button btn=(Button) e.getSource();     // ���o�ƥ�ӷ�������
        if(btn==btn1)                       // �p�G�O���Ubtn1���s
            frm.setBackground(Color.yellow);
        else if(btn==btn2)               // �p�G�O���Ubtn2���s
            frm.setBackground(Color.green);
        else                                // �p�G�O���Ubtn3���s
            System.exit(0);
    }
    public void mouseEntered(MouseEvent e){
        Button btn=(Button) e.getSource();
        frm.setBackground(new Color(255,255,0));
    }
}
