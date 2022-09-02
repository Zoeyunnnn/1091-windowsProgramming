import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.MenuListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;

public class online1 extends JFrame implements ActionListener{
    JTextArea txt;
    JScrollPane p;
    Container contentPane;
    JFileChooser file = new JFileChooser(".");
    Calendar c1;
    Timer timer;
    static online1 f = new online1();

    public online1() {
        super("JFrame");  //������N���O���غc�l
        this.setSize(300,100);
        txt = new JTextArea(80,80);
        p = new JScrollPane(txt);

        contentPane = getContentPane();
        JMenuBar mb = new JMenuBar();
        contentPane.add(buildMenu(),"North");
        contentPane.add(p,"Center");
        timer = new Timer(100, this);
    }

    public static void main(String[] args) {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(240,240);
        f.setVisible(true);
        f.timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        c1 = Calendar.getInstance();
        f.setTitle(c1.getTime().toString());
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
                readtable();
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

    public void readtable(){
        int state = file.showOpenDialog(this);
        if (state == JFileChooser.APPROVE_OPTION) {
//            File f = file.getSelectedFile();
            String fname = file.getSelectedFile().getAbsolutePath();
            try {
                FileInputStream fi = new FileInputStream(fname);
                String[] s = {"�Ǹ�", "�m�W", "�D��"};
                byte ba[] = new byte[fi.available()];
                String str = new String(ba, StandardCharsets.UTF_8);
                String t[] = str.split("\n");
                String[][] a = new String[t.length][3];
                for (int i=0;i<t.length;i++){
                    for (int j=0;j<3;j++){
                        a[i][j] = t[i].split(",")[j];
                    }
                }

                JTable table1 = new JTable(a, s);
                contentPane.remove(p);
                p = new JScrollPane(table1);

                contentPane.add(p,"Center");
            } catch (IOException ie) {
                System.out.println(ie);
            }
//            setTitle(f.getName());
        }
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
