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

    // 建立功能表內容的方法
    public JMenuBar buildMenu() {
        JMenuBar mbar = new JMenuBar();
        JMenu menu = new JMenu("檔案 (F)");
        menu.setMnemonic(KeyEvent.VK_F);
        JMenu me = new JMenu("讀入表格(E)");
        me.setMnemonic(KeyEvent.VK_E);
        mbar.add(menu);
        mbar.add(me);

        JMenuItem item = new JMenuItem("寫入 (I)", KeyEvent.VK_I);
        item.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                readfile();
            }
        });
        me.add(item);

        // 設定檔案功能表的項目
        // 開啟檔案
        item = new JMenuItem("開啟 (O)", KeyEvent.VK_O);
        item.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                readfile();
            }
        });
        menu.add(item);

        // 儲存檔案
        item = new JMenuItem("儲存 (S)", KeyEvent.VK_S);
        item.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                writefile();
            }
        });
        menu.add(item);

        item = new JMenuItem("刪除 (N)", KeyEvent.VK_N);
        item.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deletefile();
            }
        });
        menu.add(item);

        // 結束程式
        item = new JMenuItem("結束 (X)", KeyEvent.VK_X);
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
                // 讀取檔案
                txt.read(new FileReader(f), "");
            } catch (IOException ie) {
                System.out.println(ie);
            }
            setTitle(f.getName());    // 將視窗標題設為檔案名稱
        }
    }

    public void writefile () {
        int state = file.showSaveDialog(this);
        if (state == JFileChooser.APPROVE_OPTION) {
            File f = file.getSelectedFile();
            try {
                // 寫入檔案
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
