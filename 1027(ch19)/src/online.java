import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

//public class online extends Frame implements ActionListener, ItemListener{
//
//    static online frm = new online();
//    static FileDialog fdlg = new FileDialog(frm,"Open");
//    static Button btn = new Button("Open");
//    static TextArea txa = new TextArea();
//    static Choice chc = new Choice();
//
//    static MenuItem mi1 = new MenuItem("�m�W");
//    static MenuItem mi2 = new MenuItem("�Ǹ�+�m�W");
//    static MenuItem mi3 = new MenuItem("�t�O+�Ǹ�+�m�W");
//    public static void main(String[] args) {
//        BorderLayout br=new BorderLayout();
//        frm.setLayout(br);
//        frm.setTitle("Select a color");
//        frm.setSize(500,350);
//        frm.setVisible(true);
//
//        chc.addItemListener(frm);
//        frm.add(chc,br.NORTH);
//        frm.add(txa,br.CENTER);
//        frm.add(btn,br.SOUTH);
//        btn.addActionListener(frm);
//        frm.setVisible(true);
//        frm.add(txa);
//    }
//    public void itemStateChanged(ItemEvent e) {
//        String c = chc.getSelectedItem();
//        txa.setText(c);
//    }
//    public void actionPerformed(ActionEvent e) {
//        fdlg.setVisible(true);
//        String fname = fdlg.getDirectory()+fdlg.getFile();
//        try{
//            FileInputStream fi = new FileInputStream(fname);
//            byte ba[] = new byte[fi.available()];
//            fi.read(ba);
//            String str = new String(ba, StandardCharsets.UTF_8);
//            String s[] = str.split("\n");
//            for(int i=0;i<s.length;i++){
//                chc.add(s[i]);
//            }
//            fi.close();
//        }
//        catch(IOException ioe){};
//    }
//}
public class online extends Frame implements ActionListener, ItemListener{
    static online frm = new online();
    static TextArea txa = new TextArea();

    static Dialog dlg = new Dialog(frm);
    static Dialog dlg1 = new Dialog(frm);
    static Dialog dlg2 = new Dialog(frm);
    static Dialog dlg3 = new Dialog(frm);
    static Dialog dlg4 = new Dialog(frm);
    static Dialog dlg5 = new Dialog(frm);
    static Label la1 = new Label("108021589������");
    static Button Cancel_btn = new Button("Cancel");

    static List lst = new List();
    static Choice chc = new Choice();

    static MenuBar mb=new MenuBar();
    static Menu menu1=new Menu("M1");
    static Menu menu2=new Menu("M2");
    static Menu menu3=new Menu("M3");
    static MenuItem me1 = new MenuItem("Dialog");
    static MenuItem me2 = new MenuItem("File");
    static MenuItem mi1 = new MenuItem("Choise");
    static MenuItem mi2 = new MenuItem("List");
    static MenuItem mn1 = new MenuItem("5");
    static MenuItem mn2 = new MenuItem("10");
    static MenuItem mn3 = new MenuItem("100");
    public static void main(String[] args) {
        BorderLayout br = new BorderLayout();
        frm.setLayout(new FlowLayout(FlowLayout.CENTER,5,30));
        frm.setTitle("Online");
        frm.setSize(500, 350);
        frm.setBackground(Color.pink);

        menu1.add(me1);
        menu1.add(me2);
        menu2.add(mi1);
        menu2.add(mi2);
        menu3.add(mn1);
        menu3.add(mn2);
        menu3.add(mn3);
        me1.addActionListener(frm);
        me2.addActionListener(frm);
        mi1.addActionListener(frm);
        mi2.addActionListener(frm);
        mn1.addActionListener(frm);
        mn2.addActionListener(frm);
        mn3.addActionListener(frm);
        mb.add(menu1);
        mb.add(menu2);
        mb.add(menu3);

        Cancel_btn.setBounds(85,70,50,20);
        Cancel_btn.addActionListener(frm);
        Cancel_btn.setForeground(Color.yellow);

        frm.add(txa,br.CENTER);
        frm.setMenuBar(mb);
        frm.setVisible(true);
    }
    public void itemStateChanged(ItemEvent e) {
        String c = chc.getSelectedItem();
        txa.setText(c);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == me1) {
            dlg.setTitle("Dialog"); // �]�w��ܤ�������D
            dlg.setSize(150, 120);   // �]�w��ܤ�����j�p
            dlg.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 7));
            dlg.add(Cancel_btn);
            dlg.add(la1);
            dlg.setLocation(120, 80);
            dlg.setVisible(true);
        } else if (e.getSource() == me2) {
            FileWriter fw = null;
            try {
                fw = new FileWriter("D:/1091/1091FrameCode/1027(ch19)/108021589_������.txt", true);
                fw.write("108021589������\n�U�ҤF");
                fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }else if(e.getSource()==mi1){
            dlg1.setTitle("Dialog"); // �]�w��ܤ�������D
            dlg1.setSize(150, 120);   // �]�w��ܤ�����j�p
            dlg1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 7));
            chc.add("��");
            chc.add("�ڬO");
            chc.add("������");
            dlg1.add(chc);
            dlg1.add(Cancel_btn);
            dlg1.setLocation(120, 80);
            dlg1.setVisible(true);
        }else if(e.getSource()==mi2){
            dlg2.setTitle("Dialog"); // �]�w��ܤ�������D
            dlg2.setSize(150, 120);   // �]�w��ܤ�����j�p
            dlg2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 7));
            lst.add("��");
            lst.add("�ڬO");
            lst.add("������");
            dlg2.add(lst);
            dlg2.add(Cancel_btn);
            dlg2.setLocation(120, 80);
            dlg2.setVisible(true);
        }else if(e.getSource()==mn1) {
            Button[] btnarr = new Button[5];
            for(int i=0;i<5;i++){
                btnarr[i] = new Button("108021589������"+Integer.toString(i+1));
                dlg3.setTitle("Dialog");
                dlg3.setSize(150, 120);
                dlg3.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 7));
                dlg3.add(btnarr[i]);
                dlg3.add(Cancel_btn);
                dlg3.setLocation(120, 80);
                dlg3.setVisible(true);
            }
        }else if(e.getSource()==mn2) {
            Button[] btnarr = new Button[10];
            for(int i=0;i<10;i++){
                btnarr[i] = new Button("108021589������"+Integer.toString(i+1));
                dlg4.setTitle("Dialog");
                dlg4.setSize(150, 120);
                dlg4.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 7));
                dlg4.add(btnarr[i]);
                dlg4.add(Cancel_btn);
                dlg4.setLocation(120, 80);
                dlg4.setVisible(true);
            }
        }else if(e.getSource()==mn3) {
            Button[] btnarr = new Button[100];
            for(int i=0;i<100;i++){
                btnarr[i] = new Button("108021589������"+Integer.toString(i+1));
                dlg5.setTitle("Dialog");
                dlg5.setSize(150, 120);
                dlg5.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 7));
                dlg5.add(btnarr[i]);
                dlg5.add(Cancel_btn);
                dlg5.setLocation(120, 80);
                dlg5.setVisible(true);
            }
        }else if(e.getSource()==Cancel_btn) {
            dlg.setVisible(false);
            dlg1.setVisible(false);
            dlg2.setVisible(false);
            dlg3.setVisible(false);
            dlg4.setVisible(false);
            dlg5.setVisible(false);
        }
    }
}