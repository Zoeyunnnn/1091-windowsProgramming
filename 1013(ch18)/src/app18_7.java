// app18_7, �HKeyListener�����B�zKeyEvent�ƥ�
import java.awt.*;
import java.awt.event.*;
public class app18_7 extends Frame implements KeyListener
{
    static app18_7 frm=new app18_7();
    static TextField txf=new TextField(18);
    static TextArea txa=new TextArea("",4,19,TextArea.SCROLLBARS_NONE);

    public static void main(String args[])
    {
        frm.setSize(200,150);
        frm.setTitle("Key Event");
        frm.setLayout(new FlowLayout(FlowLayout.CENTER));
        txf.addKeyListener(frm);      // �Nfrm�]��txf����ť��
        txa.setEditable(false);       // �Ntxa�]�����i�s��
        frm.add(txf);
        frm.add(txa);
        frm.setVisible(true);
    }
    // ��txf����Ĳ�oKeyEvent�ƥ�ɡA�̨ƥ��������U�C���{���X
    public void keyPressed(KeyEvent e)  // �������U��
    {
        txa.setText("");           // �M��txa�̪���r
        txa.append("keyPressed() called\n");
    }
    public void keyReleased(KeyEvent e) // ������}��
    {
        txa.append("keyReleased() called\n");
    }
    public void keyTyped(KeyEvent e) // ��J��r��
    {
        txa.append("keyTyped() called\n");
    }
}
