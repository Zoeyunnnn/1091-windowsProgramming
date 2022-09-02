// app18_12, WindowAdapter���O�ӳB�z�����ƥ�
import java.awt.*;
import java.awt.event.*;
public class app18_12 extends Frame
{
    static app18_12 frm=new app18_12();
    static WinLis wlis=new WinLis();    // ����WinLis���O������wlis

    public static void main(String args[])
    {
        frm.setSize(200,150);
        frm.setTitle("Window Event");
        frm.addWindowListener(wlis);     // �]�wwlis��frm���ƥ��ť��
        frm.setVisible(true);
    }
    // �w�q WinLis��static�A���~�Ӧ�WindowAdapter���O
    static class WinLis extends WindowAdapter
    {
        public void windowClosing(WindowEvent e)  // ���U���������s
        {
            System.out.println("windowClosing() called");
            System.out.println("Closing window...");
            frm.dispose();                      // ��������������귽
            System.out.println("window closed...");
        }
        public void windowClosed(WindowEvent e)   // ��������
        {
            System.out.println("windowClosed() called");
        }
        public void windowDeactivated(WindowEvent e)    // �ܦ��D�@�Τ�����
        {
            System.out.println("windowDeactivated() called");
        }
        public void windowActivated(WindowEvent e)   // �ܦ��@�Τ�����
        {
            System.out.println("windowActivated() called");
        }
        public void windowDeiconified(WindowEvent e)    // �����٭�
        {
            System.out.println("windowDeiconified() called");
        }
        public void windowIconified(WindowEvent e)      // �����̤p��
        {
            System.out.println("windowIconified() called");
        }
        public void windowOpened(WindowEvent e)      // �}�ҵ���
        {
            System.out.println("windowOpened() called");
        }
    }
}
