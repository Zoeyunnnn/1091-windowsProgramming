import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class StartFrame extends JFrame {
    private Container cp;
    private JLabel title = new JLabel("實作資料排序與效能比較");
    private JButton btn = new JButton("START");
    private ImageIcon icon = new ImageIcon("img\\background.jpg");
    JDesktopPane dp = new JDesktopPane();
    JLabel lab = new JLabel(icon);
    JPanel pnl = new JPanel();


    public StartFrame(){
        init();
    }
    private void init(){
        cp = this.getContentPane();     //JFrame的主框架
        cp.setLayout(new BorderLayout(3,3));
        this.setBounds(400,200,600,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        lab.setBounds(0,0,600,500);
        pnl.setOpaque(false);
        pnl.setBounds(0,0,600,500);

        pnl.add(title);
        pnl.add(btn);
        dp.add(lab,new Integer(50));
        dp.add(pnl,new Integer(350));
        cp.add(dp);
        setLayeredPane(dp);
        this.setResizable(false);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);

                MainFrame mFrm = new MainFrame();
                mFrm.setVisible(true);
            }
        });
    }
}

