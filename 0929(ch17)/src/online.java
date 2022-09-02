import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//public class online extends Frame {
//    static Frame frm = new Frame("my program");
//    static Label lab = new Label("108021589");
//    static Label lab1 = new Label("ZOE");
//    static Button btn = new Button("108021589");
//    static Button btn1 = new Button("yuyun");
//
//    public online(String str) {
//
//    }
//
//    public static void main(String args[]) {
//
//        frm.setSize(600,400);
//        frm.setLayout(null);
//        frm.setBackground(Color.red);
//        frm.setLocation(250,250);
//        frm.setVisible(true);
//
//        lab.setBounds(100,50,80,50);
//        lab.setBackground(Color.white);
//        frm.add(lab);
//        lab1.setBounds(280,50,80,50);
//        lab1.setBackground(Color.white);
//        frm.add(lab1);
//
//        btn.setBounds(100,130,80,50);
//        btn.setBackground(Color.yellow);
//        frm.add(btn);
//        btn1.setBounds(280,130,80,50);
//        btn1.setBackground(Color.yellow);
//        frm.add(btn1);
//
//        frm.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        });
//    }
//}

public class online extends Frame{
    static Frame frm = new Frame("ZOE");


    public static void main(String args[]) {
        GridLayout grid = new GridLayout(4,6);
        frm.setLayout(grid);
        frm.setSize(300,250);
        for(int i=1;i<=4;i++){
            for (int j=1;j<=6;j++){
                Button btn = new Button((Integer.toString(i)+"."+Integer.toString(j)));

                if(i%2==0){
                    if (j%2==0) btn.setBackground(Color.black);
                    else btn.setBackground(Color.red);
                }else {
                    if (j%2==0) btn.setBackground(Color.red);
                    else btn.setBackground(Color.black);
                }
                btn.setForeground(Color.white);
                frm.add(btn);
            }

        }
        frm.setVisible(true);
        frm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
