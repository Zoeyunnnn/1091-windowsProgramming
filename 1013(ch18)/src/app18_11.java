// app18_11, �HMouseAdapter���O�ƥ�B�zMouseEvent�ƥ�
import java.awt.*;
import java.awt.event.*;
public class app18_11 extends Frame
{
    static app18_11 frm=new app18_11();
    static Button btn=new Button(" Click Me!! ");
    static TextArea txa=new TextArea("",2,5,TextArea.SCROLLBARS_NONE);
    static MouseLis mlis=new MouseLis();     // �إ�MouseLis���O������
    public static void main(String args[])
    {
        BorderLayout br=new BorderLayout(2,5);
        frm.setSize(200,150);
        frm.setTitle("Mouse Event");
        frm.setLayout(br);
        btn.addMouseListener(mlis);      // �Hmlis���󰵬�btn����ť��
        txa.setEditable(false);
        frm.add(btn,br.WEST);
        frm.add(txa,br.CENTER);
        frm.setVisible(true);
    }
    // �w�q MouseLis��static���O�A���~�Ӧ�MouseAdapter���O
    static class MouseLis extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e)
        {
            int x=e.getX();            // ���ox�y��
            int y=e.getY();            // ���oy�y��
            txa.append("clicked at ("+x+","+y+")\n");
        }
    }
}
