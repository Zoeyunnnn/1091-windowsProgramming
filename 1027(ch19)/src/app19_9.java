// app19_9, FileDialog���O���ϥ�
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class app19_9 extends Frame implements ActionListener
{
    static app19_9 frm=new app19_9();
    static FileDialog fdlg=new FileDialog(frm,"Open"); // �إ�fdlg����
    static Button btn=new Button("Open");
    static TextArea txa=new TextArea();

    public static void main(String args[])
    {
        BorderLayout br=new BorderLayout();
        frm.setTitle("Dialog Demo");
        frm.setLayout(br);
        frm.setSize(200,150);
        frm.add(txa,br.CENTER);
        frm.add(btn,br.SOUTH);
        btn.addActionListener(frm);   // �]�wfrm��btn���ƥ��ť��
        frm.setVisible(true);
    }
    // ��Open���s���U�ɡA����U�C���{���X
    public void actionPerformed(ActionEvent e)
    {
        fdlg.setVisible(true);        // ����ɮ׹�ܤ��
        // �H�U���{���X�O���U�ɮ׹�ܤ�������u�}�ҡv�s����A�~�|����
        String fname=fdlg.getDirectory()+fdlg.getFile(); // ���o���|�P�W��
        try
        {
            FileInputStream fi=new FileInputStream(fname);
            byte ba[]=new byte[fi.available()];
            fi.read(ba);         // Ū�J�ɮפ��e��byte�}�C��
            txa.setText(new String(ba)); // �Nbyte�}�C�����e�g��txa�����
            fi.close();
        }
        catch(IOException ioe){};
    }
}
