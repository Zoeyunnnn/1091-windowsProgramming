// app20_3, app20_2���ק睊
import java.awt.*;
import java.awt.event.*;
public class app20_3 extends Frame implements ActionListener
{
    static app20_3 frm=new app20_3();
    static Button btn=new Button("Draw");
    boolean clicked=false;    // �ŧiboolean�ܼơA�ΨӧP�O���s�O�_���U

    public static void main(String args[])
    {
        BorderLayout br=new BorderLayout();
        frm.setTitle("Drawing example");
        frm.setLayout(br);
        frm.setSize(200,150);
        frm.add(btn,br.SOUTH);
        btn.addActionListener(frm);
        frm.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        clicked=true;                 // �]�w���s�w�Q���U
        Graphics g=getGraphics();        // ���o������ø�ϰ�
        paint(g);
    }
    public void paint(Graphics g)
    {
        if(clicked)                   // �p�G���s�Q���U
            g.drawRect(100,50,70,55);        // ø�X�����
    }
}
