// app20_6, brighter()�Pdarker()���ϥ�
import java.awt.*;
import java.awt.event.*;
class app20_6 extends Frame implements ActionListener
{
    static app20_6 frm=new app20_6();
    static Button btn1=new Button("Brighter");   // Brighter���s
    static Button btn2=new Button("Darker");     // Darker���s
    Color co=new Color(255,255,255);       // �]�w�C�⪺���

    public static void main(String args[])
    {
        frm.setTitle("Brighter & Darker");
        frm.setLayout(new FlowLayout());
        frm.setSize(200,150);
        frm.add(btn1);
        frm.add(btn2);
        btn1.addActionListener(frm);
        btn2.addActionListener(frm);
        frm.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        Button btn=(Button) e.getSource();        // ���o�Q���U�����s
        if(btn==btn1)
            co=co.brighter();   // �p�G�O���Ubrighter�A�h�N�C���ܫG�@�I
        else if(btn==btn2)
            co=co.darker();     // �p�G�O���UDarker�A�h�N�C���ܷt�@�I
        Graphics g=getGraphics();
        paint(g);
    }
    public void paint(Graphics g)
    {
        g.setColor(co);                     // �Nø���C��]��co
        g.fillRect(0,0,getWidth(),getHeight());      // ���C��
    }
}
