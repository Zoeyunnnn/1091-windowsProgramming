// app17_15, CardLayout���O���Ϊk
import java.awt.*;
public class app17_15
{
    static Frame frm=new Frame("Card Layout");
    public static void main(String args[])
    {
        CardLayout card=new CardLayout(5,10);      // �ϥΦh�h�����t�m
        frm.setLayout(card);
        frm.setSize(200,150);
        frm.add(new Button("Button 1"),"c1");
        frm.add(new Button("Button 2"),"c2");
        frm.add(new Button("Button 3"),"c3");
        card.show(frm,"c2");
        card.show(frm,"c3");
        frm.setVisible(true);
    }
}
