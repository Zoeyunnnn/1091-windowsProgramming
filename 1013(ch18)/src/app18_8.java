// app18_8, �HKeyAdapter���O�ƥ�B�zKeyEvent�ƥ�
import java.awt.*;
import java.awt.event.*;
public class app18_8 extends Frame   // ���ݹ�@KeyListener����
{
    static app18_8 frm=new app18_8();
    static TextField txf=new TextField(18);
    static TextArea txa=new TextArea("",4,19,TextArea.SCROLLBARS_NONE);
    public static void main(String args[]) {
        frm.setSize(200,150);
        frm.setTitle("Key Event");
        frm.setLayout(new FlowLayout(FlowLayout.CENTER));
        txf.addKeyListener(new KeyLis());
        txa.setEditable(false);
        frm.add(txf);
        frm.add(txa);
        frm.setVisible(true);
    }
    // �w�q KeyLis��static���O�A���~�Ӧ�KeyAdapter���O
    static class KeyLis extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            txa.setText("");     // �M��txa�̪���r
            if(e.isActionKey())  // �p�G�OAction key
                txa.append("Action key is pressed\n");
            else                 // �p�G���OAction key�A�h�L�X�r��
                txa.append(e.getKeyChar()+" is pressed\n");
        }
    }
}