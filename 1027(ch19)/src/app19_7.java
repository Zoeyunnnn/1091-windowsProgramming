// app19_7, ���b���������
import java.awt.*;
import java.awt.event.*;
public class app19_7 extends Frame implements AdjustmentListener
{
    static app19_7 frm=new app19_7();
    static Scrollbar scr=new Scrollbar();  // �إ߫������bscr
    static Label lab1=new Label("Silence is golden.",Label.CENTER);
    static Label lab2=new Label("size=20",Label.CENTER);

    public static void main(String args[])
    {
        BorderLayout br=new BorderLayout(5,5);
        frm.setTitle("Scrollbar Demo");
        frm.setSize(300,150);
        scr.addAdjustmentListener(frm);  // �Hfrm��scr����ť��
        scr.setValues(20,4,12,40);          // �]�wscr�������ƭ�
        frm.add(scr,br.EAST);
        frm.add(lab1,br.CENTER);
        frm.add(lab2,br.SOUTH);
        lab1.setFont(new Font("Dialog",Font.PLAIN,20));
        lab2.setBackground(Color.orange);
        frm.setVisible(true);
    }
    public void adjustmentValueChanged(AdjustmentEvent e)
    {
        int size=scr.getValue();      // ���oscr���ƭ�
        lab1.setFont(new Font("Dialog",Font.PLAIN,size));   // �]�w�r���˦�
        lab2.setText("size="+size);      // ��ܦr��j�p
    }
}
