// app23_8, JColorChooser�ܽd�m��
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class app23_8
{
    static JFrame frm=new JFrame("JColorChooser");
    static Container cp=frm.getContentPane();
    static JButton btn=new JButton("Get Color");
    static JColorChooser JCC=new JColorChooser();  // �إ�JCC����
    static Color color;           // �ŧiColor���A���ܼ�color

    public static void main(String args[])
    {
        cp.setLayout(new BorderLayout());
        cp.add(btn,BorderLayout.SOUTH);
        btn.addActionListener(new ActLis());
        cp.setBackground(Color.YELLOW);
        frm.setSize(200,150);
        frm.setVisible(true);
    }
    static class ActLis implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            color=JCC.showDialog(frm,"JColorChooser",Color.pink);
            cp.setBackground(color);         // �N�����I���]��color
        }
    }
}
