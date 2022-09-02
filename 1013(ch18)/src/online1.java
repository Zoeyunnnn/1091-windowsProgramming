import java.awt.*;
import java.awt.event.*;

public class online1 extends Frame implements TextListener,ActionListener,ItemListener{
    static online1 frm = new online1();
    static TextArea ta1;
    static TextArea ta2;
    static Checkbox ckb = new Checkbox("YES");
    static Checkbox ckb_se = new Checkbox("<=>");
    static Button btn1 = new Button("CLEAR");
    static Checkbox color_ckb1 = new Checkbox("Blue");
    static Checkbox color_ckb2 = new Checkbox("Red");
    static Checkbox color_ckb3 = new Checkbox("Green");


    public static void main(String[] args) {
        CheckboxGroup grp = new CheckboxGroup();

        ta1 = new TextArea("",6,10,TextArea.SCROLLBARS_NONE);
        ta2 = new TextArea("",6,10,TextArea.SCROLLBARS_NONE);
        frm.setSize(400,350);
        frm.setTitle("Text Online");
        frm.setLayout(new FlowLayout(FlowLayout.CENTER));
        ta1.addTextListener(frm);
        ta2.addTextListener(frm);
        ta2.setEditable(false);

        ckb.addItemListener(frm);
        ckb_se.addItemListener(frm);
        color_ckb1.addItemListener(frm);
        color_ckb2.addItemListener(frm);
        color_ckb3.addItemListener(frm);
        btn1.addActionListener(frm);

        frm.add(ta1);
        frm.add(ckb_se);
        frm.add(ta2);
        frm.add(ckb);
        color_ckb1.setCheckboxGroup(grp);
        color_ckb2.setCheckboxGroup(grp);
        color_ckb3.setCheckboxGroup(grp);

        frm.add(btn1);
        frm.add(color_ckb1);
        frm.add(color_ckb2);
        frm.add(color_ckb3);
        frm.setVisible(true);

        frm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void itemStateChanged(ItemEvent e){
        if(ckb.getState()==true){
            ta2.setEditable(true);
            ta1.setEditable(false);
        }else {
            ta2.setEditable(false);
            ta1.setEditable(true);
        }
        if(color_ckb1.getState()==true){
            int R = (int)(Math.random() * 255 + 1);
            int G = (int)(Math.random() * 255 + 1);
            int B = (int)(Math.random() * 255 + 1);
            Color Random_Color = new Color(R, G, B);
            ta1.setBackground(Random_Color);
        }else if(color_ckb2.getState()==true){
            int R = (int)(Math.random() * 255 + 1);
            int G = (int)(Math.random() * 255 + 1);
            int B = (int)(Math.random() * 255 + 1);
            Color Random_Color = new Color(R, G, B);
            ta1.setBackground(Random_Color);
        }else if (color_ckb3.getState()==true){
            int R = (int)(Math.random() * 255 + 1);
            int G = (int)(Math.random() * 255 + 1);
            int B = (int)(Math.random() * 255 + 1);
            Color Random_Color = new Color(R, G, B);
            ta1.setBackground(Random_Color);
        }

    }
    public void textValueChanged(TextEvent e) {
        if(ckb_se.getState()==true){
            ta2.setText(ta1.getText());
        }if(ckb.getState()==true){
            ta1.setText(ta2.getText());
        }

    }
    public void actionPerformed(ActionEvent e) {
        Button btn=(Button) e.getSource();
        if(btn==btn1){
            ta1.setText("");
            ta2.setText("");
        }
    }
}

