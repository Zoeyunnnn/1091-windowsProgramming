import java.awt.*;
import javax.swing.*;
public class e15_13a extends JFrame {
    String[][] a = {{"aa", "80", "60"},
            {"bb", "90", "80"},
            {"cc", "70", "80"}};
    String[] s = {"姓名", "國文", "英文"};
    JTable table1 = new JTable(a, s);
    JScrollPane scrollPane1 = new JScrollPane(table1);

    e15_13a() {
        Container c = getContentPane();  //取得ContentPane物件
        c.setLayout(new BorderLayout());
        c.add(scrollPane1);
    }

    public static void main(String args[]) {
        e15_13a frm = new e15_13a();
        frm.setSize(200, 150);
        frm.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}