import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Mywork{
    private static JFrame f = new JFrame();
    private static Input in = new Input();
    private static JTextArea Wtxa,Htxa;
    private static JButton check_btn = new JButton("產生");
    private static Label W,H;
    private static int width=0,height=0;

    private static MenuBar mb = new MenuBar();
    private static Menu mn = new Menu("圖形選擇");
    private static MenuItem me1 = new MenuItem("矩形");
    private static MenuItem me2 = new MenuItem("橢圓");
    private static Menu me = new Menu("操作");
    private static MenuItem mi = new MenuItem("動畫重來");
    private static Menu mu = new Menu("速度選擇");
    private static MenuItem mt1 = new MenuItem("兩倍速");
    private static MenuItem mt2 = new MenuItem("四倍速");

    private static JButton color_btn = new JButton("圖形顏色");
    private static Color clr;
    private static int cho_img=0;
    private static int x = 0,y = 0,speed=1;
    public static void main(String[] args) {
        MyPnl mw = new MyPnl();
        mw.setBackground(Color.WHITE);
        in.setBackground(Color.PINK);
        W = new Label("輸入寬");
        H = new Label("輸入長");
        Wtxa = new JTextArea("",1,5);
        Htxa = new JTextArea("",1,5);

        check_btn.addActionListener(new btnlisten());
        color_btn.addActionListener(new btnlisten());

        in.add(W);
        in.add(Wtxa);
        in.add(H);
        in.add(Htxa);
        in.add(color_btn);
        in.add(check_btn);
        f.add(in,BorderLayout.NORTH);

        mn.add(me1);
        mn.add(me2);
        me1.addActionListener(new btnlisten());
        me2.addActionListener(new btnlisten());
        me.add(mi);
        mi.addActionListener(new btnlisten());
        mu.add(mt1);
        mu.add(mt2);
        mt1.addActionListener(new btnlisten());
        mt2.addActionListener(new btnlisten());
        mb.add(mn);
        mb.add(me);
        mb.add(mu);
        f.setMenuBar(mb);

        f.setBounds(350,150,500,500);
        f.add(in,BorderLayout.NORTH);
        f.add(mw,BorderLayout.CENTER);
        f.setTitle("My Image Cartoon");
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true){
            mw.display();
            try {
                Thread.sleep(300);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    static class btnlisten implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (e.getSource()==check_btn){
                height = Integer.parseInt(Htxa.getText());
                width = Integer.parseInt(Wtxa.getText());
            }else if (e.getSource()==me1){
                cho_img=0;
            }else if (e.getSource()==me2){
                cho_img=1;
                H.setText("高直徑");
                W.setText("寬直徑");
            }else if(e.getSource()==color_btn){
                clr = JColorChooser.showDialog(null,"???你喜?的?色" ,clr);
                if (clr==null) clr=Color.lightGray;
            }else if (e.getSource()==mi){
                x=0;
                y=0;
            }
            else if (e.getSource()==mt1) speed=2;
            else if (e.getSource()==mt2) speed=4;
        }
    }
    static class Input extends JPanel{
        private Label lab = new Label();

    }
    static class MyPnl extends JPanel{
        private Image img;
        private Graphics g;

        public void display(){
            x+=speed;
            y+=speed;

            if(g==null){
                img = this.createImage(this.getWidth(),this.getHeight());
                if(img != null)g = img.getGraphics();
            }
            if(g != null){
                super.paint(g);
                g.setColor(clr);
                if (cho_img==0) g.fill3DRect(x, y, width, height, true);
                else if(cho_img==1)g.fillOval(x, y, width, height);
            }
            this.repaint();
        }
        public void paint(Graphics g){
            g.drawImage(img,0,0,this);
        }
    }
}