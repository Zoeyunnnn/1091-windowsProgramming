import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Vector;
import javax.swing.*;

public class Main {
    static JFrame frm = new JFrame("Online");
    static Container cp = frm.getContentPane();
    static JList<String> lst1 = new JList<String>();
    static JList<String> lst2 = new JList<String>();
    static String s[] = {"RED","GREEN","BLUE","PINK","YELLOW","CYAN","GRAY"};
    static String s1[] = {};
    static Vector<String> v = new Vector<String>();
    static Vector<String> v1 = new Vector<String>();
    static FileDialog fdlg = new FileDialog(frm,"Open");
    static Button btn = new Button("Open");
    static Button btnn = new Button("Random");
    static JComboBox jCB = new JComboBox();

    public static void main(String[] args) {
        cp.setLayout(new GridLayout(2,2));
        cp.add(new JScrollPane(lst1));
        cp.add(new JScrollPane(lst2));
        cp.add(btn);
        cp.add(btnn);
        jCB.addItem("1");
        jCB.addItem("2");
        jCB.addItem("3");
        jCB.addItem("4");
        jCB.addItem("5");
        jCB.addItem("6");
        jCB.addItem("7");
        jCB.addItem("8");
        jCB.addItem("9");
        jCB.addItem("10");
        cp.add(jCB);

        lst1.setListData(v);
        lst1.addMouseListener(new MouseLis());
        lst2.addMouseListener(new MouseLis());
        btn.addActionListener(new MouseClick());
        btnn.addActionListener(new MouseClick());
        frm.setSize(200,155);
        frm.setVisible(true);
    }
    static class MouseLis extends MouseAdapter {
        public void mouseClicked(MouseEvent e){
            if(e.getSource()==lst1){
                if (e.getClickCount()==2){
                    int index = lst1.getSelectedIndex();
                    v1.add(v.get(index));
                    v.remove(index);
                    lst1.setListData(v);
                    lst2.setListData(v1);
                }
            }
            else if (e.getSource()==lst2){
                if (e.getClickCount()==2){
                    int index = lst2.getSelectedIndex();
                    v.add(v1.get(index));
                    v1.remove(index);
                    lst1.setListData(v);
                    lst2.setListData(v1);
                }
            }
        }
    }
    static class MouseClick implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==btn){
                fdlg.setVisible(true);
                String fname = fdlg.getDirectory()+fdlg.getFile();

                try{
                    FileInputStream fi = new FileInputStream(fname);
                    byte ba[] = new byte[fi.available()];
                    fi.read(ba);
                    String str = new String(ba, StandardCharsets.UTF_8);
                    String s[] = str.split("\n");
                    for(int i=0;i<s.length;i++){
                        v.add(s[i]);
                    }
                    lst1.setListData(v);
                    fi.close();
                }
                catch(IOException ioe){};
            }else if(e.getSource()==btnn){
                for (int i=0;i<Integer.parseInt((String) jCB.getSelectedItem());i++){
                    int n = (int) (Math.random() * 10);
                    v1.add(v.get(n));
                    v.remove(n);
                    lst1.setListData(v);
                    lst2.setListData(v1);
                }
//                String genderSel = (String) jCB.getSelectedItem();
//                int n;
//                switch (genderSel) {
//                    case "1":
//                        n = (int) (Math.random() * 10) + 1;
//                        v1.add(v.get(n));
//                        v.remove(n);
//                        lst1.setListData(v);
//                        lst2.setListData(v1);
//                        break;
//                    case "2":
//                        for (int i = 0; i < 2; i++) {
//                            n = (int) (Math.random() * 10) + 1;
//                            v1.add(v.get(n));
//                            v.remove(n);
//                            lst1.setListData(v);
//                            lst2.setListData(v1);
//                        }
//                        break;
//                    case "3":
//                        for (int i = 0; i < 3; i++) {
//                            n = (int) (Math.random() * 10) + 1;
//                            v1.add(v.get(n));
//                            v.remove(n);
//                            lst1.setListData(v);
//                            lst2.setListData(v1);
//                        }
//                        break;
//                    case "4":
//                        for (int i = 0; i < 4; i++) {
//                            n = (int) (Math.random() * 10) + 1;
//                            v1.add(v.get(n));
//                            v.remove(n);
//                            lst1.setListData(v);
//                            lst2.setListData(v1);
//                        }
//                        break;
//                    case "5":
//                        for (int i = 0; i < 5; i++) {
//                            n = (int) (Math.random() * 10) + 1;
//                            v1.add(v.get(n));
//                            v.remove(n);
//                            lst1.setListData(v);
//                            lst2.setListData(v1);
//                        }
//                        break;
//                    case "6":
//                        for (int i = 0; i < 6; i++) {
//                            n = (int) (Math.random() * 10) + 1;
//                            v1.add(v.get(n));
//                            v.remove(n);
//                            lst1.setListData(v);
//                            lst2.setListData(v1);
//                        }
//                        break;
//                    case "7":
//                        for (int i = 0; i < 7; i++) {
//                            n = (int) (Math.random() * 10) + 1;
//                            v1.add(v.get(n));
//                            v.remove(n);
//                            lst1.setListData(v);
//                            lst2.setListData(v1);
//                        }
//                        break;
//                    case "8":
//                        for (int i = 0; i < 8; i++) {
//                            n = (int) (Math.random() * 10) + 1;
//                            v1.add(v.get(n));
//                            v.remove(n);
//                            lst1.setListData(v);
//                            lst2.setListData(v1);
//                        }
//                        break;
//                    case "9":
//                        for (int i = 0; i < 9; i++) {
//                            n = (int) (Math.random() * 10) + 1;
//                            v1.add(v.get(n));
//                            v.remove(n);
//                            lst1.setListData(v);
//                            lst2.setListData(v1);
//                        }
//                        break;
//                    case "10":
//                        for (int i = 0; i < 10; i++) {
//                            n = (int) (Math.random() * 10) + 1;
//                            v1.add(v.get(n));
//                            v.remove(n);
//                            lst1.setListData(v);
//                            lst2.setListData(v1);
//                        }
//                        break;
//                }
            }
        }
    }
}
