import java.awt.*;
import java.awt.event.*;

public class online2 extends Frame implements ActionListener{
    static online2 frm = new online2();
    static TextField tf = new TextField(16);
    static TextArea txa = new TextArea("",4,20,TextArea.SCROLLBARS_NONE);

    static Button btnn = new Button("ZOE");
    static Button[] btnarr = new Button[100];
    static private int count=0;
//    static private int numC=0;
    static private int num[] = {49,51,53,55,57};
    static private int teacher[] = {74,68,87,65,78,71};
    static private int tC=0;

    public static void main(String[] args) {
        frm.setSize(400,350);
        frm.setTitle("Text Online");
//        frm.setLayout(new FlowLayout(FlowLayout.CENTER));
        frm.setLayout(new GridLayout(10,10));
        tf.addKeyListener(new KeyLis());
        btnn.addActionListener(frm);
        txa.setEditable(false);
        frm.setVisible(true);

        frm.add(tf);
        frm.add(btnn);
        frm.add(txa);

        frm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    static class KeyLis extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            int keyCode = e.getKeyCode();
//            char keyChar = e.getKeyChar();
//            String keyString = e.getSource();
            txa.setText(Integer.toString(keyCode));

            if(keyCode==num[0] || keyCode==num[1] || keyCode==num[2] || keyCode==num[3] || keyCode==num[4]){
                count++;
                btnarr[count] = new Button(Integer.toString(count));
                int R = (int) (Math.random() * 255 + 1);
                int G = (int) (Math.random() * 255 + 1);
                int B = (int) (Math.random() * 255 + 1);
                Color Random_Color = new Color(R, G, B);
                btnarr[count].setBackground(Random_Color);
                frm.add(btnarr[count]);
            }else if (keyCode==teacher[tC]){
                if (tC==5){
//                    btnarr[1].setBackground(Color.white);
                    for (int i=1;i<=count;i++){
                        btnarr[i].setBackground(Color.white);
                    }
                    tC=0;
                }
                tC++;
            }else{
                tC=0;
            }
            frm.setVisible(true);
        }
//        public void keyTyped(KeyEvent e){
//
//        }
    }
    public void actionPerformed(ActionEvent e) {
        Button btn=(Button) e.getSource();
        if(btn==btnn){
            btnn.setLabel("Game Over");
            btnn.setBackground(Color.red);
        }
//        for(int i=0;i<btnarr.length;i++){
//
//        }
    }
}
