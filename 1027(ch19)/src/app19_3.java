// app19_3, �إ߿�ܪ��
import java.awt.*;
public class app19_3 extends Frame
{
    static app19_3 frm=new app19_3();
    static Choice chc=new Choice();     // �إߤU�Կ�檫��chc
    public static void main(String args[])
    {
        frm.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        frm.setTitle("Choice class");
        for(int i=0;i<=4;i++)            // �Q��for�j��[�J�ﶵ
            chc.add("Choice Item "+i);
        frm.add(chc);
        frm.setSize(200,150);
        frm.setBackground(Color.yellow);
        frm.setVisible(true);
    }
}
