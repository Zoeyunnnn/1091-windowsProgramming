// app20_9, ø�s�h���
import java.awt.*;
class app20_9 extends Frame
{
    static app20_9 frm=new app20_9();

    public static void main(String args[])
    {
        frm.setTitle("Polygon");
        frm.setSize(200,150);
        frm.setVisible(true);
    }

    public void paint(Graphics g)
    {
        int x[]={44,65,97,139,58}; // �x�s�Ҧ����Ix�y�Ъ��@���}�C
        int y[]={34,55,40,109,127};   // �x�s�Ҧ����Iy�y�Ъ��@���}�C
        g.setColor(Color.pink);       // ø���C��]��������
        g.fillPolygon(x,y,5);      // ø�X�h��ΡA�ö񺡯�����
        g.setColor(Color.black);   // ø���C��]���¦�
        g.drawPolygon(x,y,5);         // �ζ¦�ø�X�h���
    }
}
