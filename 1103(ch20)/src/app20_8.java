// app20_8, �񺡶꩷�P���
import java.awt.*;
public class app20_8 extends Frame
{
    static app20_8 frm=new app20_8();

    public static void main(String args[])
    {
        frm.setTitle("Arc & Oval");
        frm.setSize(200,150);
        frm.setVisible(true);
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.pink);       // �]�wø���C�⬰����
        g.fillArc(20,50,70,70,30,300);   // �񺡶꩷
        g.setColor(Color.red);        // �]�wø���C�⬰����
        for(int x=70;x<=170;x=x+20)
            g.fillOval(x,80,10,10);    // ø�X���Ӥp��
    }
}
