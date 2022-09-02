import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.MenuListener;
import java.io.*;

public class MyEditor extends JFrame {
    JTextArea txt ;
    JFileChooser file = new JFileChooser(".");

    public static void main(String[] args) {
        MyEditor f = new MyEditor();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(240,240);
        f.setVisible(true);
    }

    public MyEditor() {
        txt = new JTextArea(80,80);
        JScrollPane p = new JScrollPane(txt);

        Container contentPane = getContentPane();
        JMenuBar mb = new JMenuBar();
        contentPane.add(buildMenu(),"North");
        contentPane.add(p,"Center");
    }

    // �إߥ\����e����k
    public JMenuBar buildMenu() {
        JMenuBar mbar = new JMenuBar();
        JMenu menu = new JMenu("�ɮ� (F)");
        menu.setMnemonic(KeyEvent.VK_F);
        JMenu me = new JMenu("Ū�J���(E)");
        me.setMnemonic(KeyEvent.VK_E);
        mbar.add(menu);
        mbar.add(me);

        JMenuItem item = new JMenuItem("�g�J (I)", KeyEvent.VK_I);
        item.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                readfile();
            }
        });
        me.add(item);

        // �]�w�ɮץ\�������
        // �}���ɮ�
        item = new JMenuItem("�}�� (O)", KeyEvent.VK_O);
        item.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                readfile();
            }
        });
        menu.add(item);

        // �x�s�ɮ�
        item = new JMenuItem("�x�s (S)", KeyEvent.VK_S);
        item.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                writefile();
            }
        });
        menu.add(item);

        item = new JMenuItem("�R�� (N)", KeyEvent.VK_N);
        item.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deletefile();
            }
        });
        menu.add(item);

        // �����{��
        item = new JMenuItem("���� (X)", KeyEvent.VK_X);
        item.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(item);

        return mbar;
    }

    public void readfile() {
        int state = file.showOpenDialog(this);
        if (state == JFileChooser.APPROVE_OPTION) {
            File f = file.getSelectedFile();
            try {
                // Ū���ɮ�
                txt.read(new FileReader(f), "");
            } catch (IOException ie) {
                System.out.println(ie);
            }
            setTitle(f.getName());    // �N�������D�]���ɮצW��
        }
    }

    public void writefile () {
        int state = file.showSaveDialog(this);
        if (state == JFileChooser.APPROVE_OPTION) {
            File f = file.getSelectedFile();
            try {
                // �g�J�ɮ�
                txt.write(new FileWriter(f));
            } catch (IOException ie) {
                System.out.println(ie);
            }
        }
    }
    public void deletefile(){
        int state = file.showSaveDialog(this);
        if (state == JFileChooser.APPROVE_OPTION) {
            File f = new File(file.getSelectedFile().getAbsolutePath());
            f.delete();
        }
    }
}
