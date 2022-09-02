/**
 * @(#)app20_1.java
 *
 * app20_1 application
 *
 * @author
 * @version 1.00 2015/11/17
 */

// app20_1, Â²³æªºÃ¸¹Ï
import java.awt.*;
import java.awt.event.*;
public class Online extends Frame implements ActionListener,ItemListener {
    static Online frm = new Online();
    static Button btn = new Button("Draw");
    static Choice ch = new Choice();
    static List lst = new List();
    static MenuBar mb = new MenuBar();
    static Menu menu = new Menu("Color");
    static MenuItem m1 = new MenuItem("Pink");
    static MenuItem m2 = new MenuItem("Blue");
    static MenuItem m3 = new MenuItem("Yellow");
    static int count=30,range=300;
    static Color clr = Color.black;

    public static void main(String args[]) {
        BorderLayout br=new BorderLayout();
        ch.add("1");
        ch.add("3");
        ch.add("5");
        ch.add("10");
        ch.add("20");
        ch.addItemListener(frm);
        lst.add("300x300");
        lst.add("400x400");
        lst.add("500x500");
        lst.addItemListener(frm);
        m1.addActionListener(frm);
        m2.addActionListener(frm);
        m3.addActionListener(frm);
        menu.add(m1);
        menu.add(m2);
        menu.add(m3);
        mb.add(menu);
        frm.setMenuBar(mb);
        frm.setTitle("Drawing example");
        frm.setLayout(br);
        frm.setSize(1300,750);
        frm.add(btn,br.SOUTH);
        frm.add(ch,br.NORTH);
        frm.add(lst,br.EAST);
//        frm.add(txa,br.WEST);
        btn.addActionListener(frm);
        frm.setVisible(true);
    }
    public void itemStateChanged(ItemEvent e){
        String a = ch.getSelectedItem();
        String b = lst.getSelectedItem();
        if(a.equals("1")) count=1;
        else if (a.equals("3")) count=3;
        else if (a.equals("5")) count=5;
        else if (a.equals("10")) count=10;
        else if (a.equals("20")) count=20;
        if (b.equals("300x300")) range=300;
        else if (b.equals("400x400")) range=400;
        else if (b.equals("500x500")) range=500;
        this.repaint();
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==m1) clr=Color.pink;
        else if (e.getSource()==m2) clr=Color.blue;
        else if (e.getSource()==m3) clr=Color.yellow;

        Graphics g=getGraphics();
        g.setColor(clr);
        g.drawLine(0,range,range+range,range);
        g.drawLine(range,0,range,range+range);

        for (int i=0;i<=range;i+=count){
            g.drawLine(range,i,range+i,range);
        }
        for (int i=0;i>=-range;i-=count){
            g.drawLine(range,-i,range+i,range);
        }
        for (int i=0;i<=range;i+=count){
            g.drawLine(range,range+range-i,range+i,range);
        }
        for (int i=0;i<=range;i+=count){
            g.drawLine(range,range+range-i,range-i,range);
        }
    }
}

