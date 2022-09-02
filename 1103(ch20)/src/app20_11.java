// app20_11, �Q�ηƹ����ʶ��
import java.awt.*;
import java.awt.event.*;
public class app20_11 extends Frame implements MouseMotionListener,MouseListener
{
    static app20_11 frm=new app20_11();
    int x=70,y=60,posX=70,posY=60,dx,dy;
    public static void main(String args[])
    {
        frm.setTitle("Dragging a circle");
        frm.setSize(200,150);
        frm.addMouseListener(frm);
        frm.addMouseMotionListener(frm);
        frm.setVisible(true);
    }
    public void mousePressed(MouseEvent e)
    {
        dx=e.getX()-posX;       // ���o�ƹ����U���I�P����Ix��V���Z��
        dy=e.getY()-posY;       // ���o�ƹ����U���I�P����Iy��V���Z��
    }
    public void mouseDragged(MouseEvent e)
    {
        x=e.getX()-dx;          // ���o�즲�ɪ�����Ix�y��
        y=e.getY()-dy;          // ���o�즲�ɪ�����Iy�y��
        if(dx>0 && dx<50 && dy>0 && dy<50) // �p�G���и��b����ΰϰ줺
        {
            Graphics g=getGraphics();
            update(g);           // �M�ŵe�����I���C��A�A�I�spaint()
        }
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.pink);  // �]�wø���C�⬰����
        g.fillOval(x,y,50,50);   // �H����I���ϧΪ����W��ø�X���
        posX=x;              // ��s����I��x�y��
        posY=y;              // ��s����I��y�y��
    }
    public void mouseMoved(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
}
