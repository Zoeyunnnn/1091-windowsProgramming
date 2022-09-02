import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MainFrame extends JFrame {
    private Container cp;
    /*-----------------MenuBar(打開檔案功能、選擇排序法)---------------------*/
    private JMenuBar mb = new JMenuBar();
    private JMenu menu1 = new JMenu("File");
    private JMenuItem m1 = new JMenuItem("open",KeyEvent.VK_I);
    private JFileChooser file = new JFileChooser(".");

    private JMenu menu2 = new JMenu("Sort");
    private JMenuItem me1 = new JMenuItem("氣泡排序法");
    private JMenuItem me2 = new JMenuItem("插入排序法");
    private JMenuItem me3 = new JMenuItem("選擇排序法");
    private JMenuItem me4 = new JMenuItem("合併排序法");
    private JMenuItem me5 = new JMenuItem("快速排序法");

    private JMenu menu3 = new JMenu("Add Node");
    private JMenuItem mn1 = new JMenuItem("鏈結串列");
    private JMenuItem mn2 = new JMenuItem("氣泡排序");
    /*-----------------input Panel(輸入資料的端口跟功能)---------------------*/
    private JPanel input_jpn = new JPanel(new GridLayout(1,4,3,3));
    private JTextField txf = new JTextField();
    private JButton jbtnAdd= new JButton("Add");
    private JButton jbtnDel= new JButton("Del");
    private JButton jbtnExit= new JButton("Exit");
    /*-----------------output Panel(輸出排序後資料)---------------------*/
    private JPanel output_jpn = new JPanel(new GridLayout(1,1,3,3));
    private JScrollPane srlPal;
    private JTextArea txa = new JTextArea();
    /*-----------------sorting tools(用於判斷的變數、排序法函式)---------------------*/
    private String type="";
    private LinkList linklist;
    private Bubble bubble;
    private Insertion insertion;
    private Selection selection;
    private Merge merge;
    private Quick quick;
    /*-----------------time tools(排序法效率比對結果呈現)---------------------*/
    private JDialog jdl;
    private ImageIcon icons[] = new ImageIcon[5];
    private Map dictionary = new HashMap();

    public MainFrame(){ //MainFrame 的建構元
        init();
    }
    private void init(){    //放置主要Frame內容
        cp = this.getContentPane();     //JFrame的主框架
        cp.setLayout(new BorderLayout(3,3));
        this.setTitle("實作資料排序與效能比較");
        this.setBounds(400,200,600,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //-----Set MenuBar-----//
            /**Menu1**/
        m1.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                readfile();
            }
        });
        menu1.add(m1);
        mb.add(menu1);

            /**Menu2**/
        me1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txa.append("／＊-------- 氣 泡 排 序 法 --------＊／\n");
                type = "Bubble";
                dictionary.put("Bubble","img\\bubble.jpg");
            }
        });
        menu2.add(me1);
        me2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txa.append("／＊-------- 插 入 排 序 法 --------＊／\n");
                type = "Insertion";
                dictionary.put("Insertion","img\\insertion.jpg");
            }
        });
        menu2.add(me2);
        me3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txa.append("／＊-------- 選 擇 排 序 法 --------＊／\n");
                type = "Selection";
                dictionary.put("Selection","img\\select.jpg");
            }
        });
        menu2.add(me3);
        me4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txa.append("／＊-------- 合 併 排 序 法 --------＊／\n");
                type = "Merge";
                dictionary.put("Merge","img\\merge.jpg");
            }
        });
        menu2.add(me4);
        me5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txa.append("／＊-------- 快 速 排 序 法 --------＊／\n");
                type = "Quick";
                dictionary.put("Quick","img\\quick.jpg");
            }
        });
        menu2.add(me5);
        mb.add(menu2);
            /**Menu3**/
        mn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type = "Linklist";
                txa.append("／＊-------- 鏈 結 串 列 --------＊／\n");
            }
        });
        menu3.add(mn1);
        mn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type = "Bubble";
                txa.append("／＊-------- 建 立 時 進 行 氣 泡 排 序 --------＊／\n");
            }
        });
        menu3.add(mn2);
        mb.add(menu3);

        this.setJMenuBar(mb);

        //-----Set output_jpn-----//
        txa.setEditable(false);
        srlPal = new JScrollPane(txa);
        cp.add(srlPal,BorderLayout.CENTER);

        //-----Set input_jpn-----//
        input_jpn.add(txf);
        input_jpn.add(jbtnAdd);
        input_jpn.add(jbtnDel);
        input_jpn.add(jbtnExit);
        cp.add(input_jpn,BorderLayout.NORTH);

        //-----btn exit-----//
        jbtnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        //-----when jbtnAdd onclick-----//
        jbtnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (type.equals("Linklist")){
                    if (linklist == null) {
                        linklist = new LinkList();
                    }
                    linklist.addNode(Integer.parseInt(txf.getText()));
                    txa.append(linklist.showList());
                }else if (type.equals("Bubble")){
                    if (bubble == null) {
                        bubble = new Bubble();
                    }
                    bubble.addNode(Integer.parseInt(txf.getText()));
                    txa.append(bubble.showList());
                }

                txf.setText("");
            }
        });
        jbtnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (type.equals("Linklist")) {
                    if (linklist == null) {
                        txa.append("Error!No Data!!");
                    }
                    linklist.deleteNode(Integer.parseInt(txf.getText()));
                    txa.append(linklist.showList());
                }else if (type.equals("Bubble")){
                    if (bubble == null) {
                        txa.append("Error!No Data!!");
                    }
                    bubble.deleteNode(Integer.parseInt(txf.getText()));
                    txa.append(bubble.showList());
                }

                txf.setText("");
            }
        });
    }

    /**--------開啟特定檔案進行排序--------**/
    private void readfile() {
        int state = file.showOpenDialog(this);
        if (state == JFileChooser.APPROVE_OPTION) {
            String fname = file.getSelectedFile().getAbsolutePath();    // 取得檔案路徑與名稱
            try {
                FileInputStream fi = new FileInputStream(fname);
                byte ba[] = new byte[fi.available()];
                fi.read(ba);    // 讀入檔案內容到byte陣列裡
                String t = new String(ba, StandardCharsets.UTF_8);  //編碼轉換
                String str[] = t.split("\n");   //依據換行切割放入str[]
                fi.close();

                sorting(str);
            } catch (IOException ie) {
                System.out.println(ie);
            }
        }
    }
    /**--------呼叫排序法並輸出結果--------**/
    private void sorting(String[] str){

        /**----一筆一筆放入節點Node----**/
        long startTime=0,endTime = 0;
        /**Bubble Sorting**/
        if (type.equals("Bubble")) {
            startTime = System.nanoTime();     //取得開始時的奈米秒時間
            if (bubble == null) {
                bubble = new Bubble();
            }
            for (int i=0;i<str.length;i++){
                if (str[i].startsWith("\uFEFF")) {  //去除csv檔寫入時第一行出現問號的狀況
                    str[i] = str[i].replace("\uFEFF", "");
                }
                bubble.addNode(Integer.parseInt(str[i].trim()));    //trim():刪除字串前後的空白
            }
            endTime = System.nanoTime();       //取得結束時的奈米秒時間
            txa.append(bubble.showList());  //將已排序好的資料拉回來呈現
        }
        /**Insertion Sorting**/
        else if (type.equals("Insertion")){
            startTime = System.nanoTime();     //取得開始時的奈米秒時間
            if (insertion == null){
                insertion = new Insertion();
            }for (int i=0;i<str.length;i++){
                if (str[i].startsWith("\uFEFF")) {  //去除csv檔寫入時第一行出現問號的狀況
                    str[i] = str[i].replace("\uFEFF", "");
                }
                insertion.addNode(Integer.parseInt(str[i].trim()));    //trim():刪除字串前後的空白
            }
            endTime = System.nanoTime();       //取得結束時的奈米秒時間
            txa.append(insertion.showList());
        }
        /**----先儲存至陣列後呼叫相應方法開始排序----**/
        /**Selection Sorting**/
        else if (type.equals("Selection")){
            startTime = System.nanoTime();     //取得開始時的奈米秒時間
            if (selection == null){
                selection = new Selection();
            }
            int[] arr = new int[str.length];
            for (int i=0;i<str.length;i++){
                if (str[i].startsWith("\uFEFF")) {  //去除csv檔寫入時第一行出現問號的狀況
                    str[i] = str[i].replace("\uFEFF", "");
                }
                arr[i] = Integer.parseInt(str[i].trim());
            }
            endTime = System.nanoTime();       //取得結束時的奈米秒時間
            selection.Selectsort(arr);
            txa.append(selection.showList());
        }
        /**Merge Sorting**/
        else if (type.equals("Merge")){
            startTime = System.nanoTime();     //取得開始時的奈米秒時間
            if (merge == null){
                merge = new Merge();
            }
            int[] arr = new int[str.length];
            for (int i=0;i<str.length;i++){
                if (str[i].startsWith("\uFEFF")) {  //去除csv檔寫入時第一行出現問號的狀況
                    str[i] = str[i].replace("\uFEFF", "");
                }
                arr[i] = Integer.parseInt(str[i].trim());
            }
            endTime = System.nanoTime();       //取得結束時的奈米秒時間
            merge.mergeSort(arr);
            txa.append(merge.showList());
        }
        /**Quick Sorting**/
        else if (type.equals("Quick")){
            startTime = System.nanoTime();     //取得開始時的奈米秒時間
            if (quick == null){
                quick = new Quick();
            }
            int[] arr = new int[str.length];
            for (int i=0;i<str.length;i++){
                if (str[i].startsWith("\uFEFF")) {  //去除csv檔寫入時第一行出現問號的狀況
                    str[i] = str[i].replace("\uFEFF", "");
                }
                arr[i] = Integer.parseInt(str[i].trim());
            }
            endTime = System.nanoTime();       //取得結束時的奈米秒時間
            quick.quicksort(arr);
            txa.append(quick.showList());
        }

        String time = String.valueOf((endTime - startTime) / 1000000);      //取得計算花費的毫秒

        imgPal(time);
    }

    /**--------繪製出該排序法的彈跳視窗--------**/
    private void imgPal(String time){
        jdl = new JDialog();
        jdl.setTitle("Frame"+type);  //設置彈跳視窗
        Container icp = jdl.getContentPane();
        icp.setLayout(new BorderLayout());
        JPanel tool = new JPanel(new GridLayout(4,2,3,3));

        JLabel lab = null,k1 = null, k2 = null,k = null;
        JLabel t = new JLabel(time);
        JLabel text = new JLabel("Execution time in milliseconds : ");
        JLabel sit1 = new JLabel("排序法最佳時間複雜度 : ");
        JLabel sit2 = new JLabel("排序法最差時間複雜度 : ");
        JLabel sit = new JLabel("排序法平均時間複雜度 : ");

            /**Bubble Dialog**/
        if (type.equals("Bubble")){
            String tmp = (String) dictionary.get("Bubble");  //呼叫Map中Bubble圖片的路徑
            icons[0] = new ImageIcon(tmp);      //建立iconImage
            icons[0].setImage(icons[0].getImage().getScaledInstance(450, 380, Image.SCALE_SMOOTH));     //設置大小、屬性
            lab = new JLabel(icons[0]);     //以label形式呈現

            k1 = new JLabel("O(n)");
            k2 = new JLabel("O(n^2)");
            k = new JLabel("O(n^2)");
        }
            /**Insertion Dialog**/
        else if (type.equals("Insertion")){
            String tmp = (String) dictionary.get("Insertion");  //呼叫Map中Insertion圖片的路徑
            icons[1] = new ImageIcon(tmp);      //建立iconImage
            icons[1].setImage(icons[1].getImage().getScaledInstance(450, 380, Image.SCALE_SMOOTH));     //設置大小、屬性
            lab = new JLabel(icons[1]);     //以label形式呈現

            k1 = new JLabel("O(n)");
            k2 = new JLabel("O(n^2)");
            k = new JLabel("O(n^2)");
        }
            /**Selection Dialog**/
        else if (type.equals("Selection")){
            String tmp = (String) dictionary.get("Selection");  //呼叫Map中Selection圖片的路徑
            icons[2] = new ImageIcon(tmp);      //建立iconImage
            icons[2].setImage(icons[2].getImage().getScaledInstance(450, 380, Image.SCALE_SMOOTH));     //設置大小、屬性
            lab = new JLabel(icons[2]);     //以label形式呈現

            k1 = new JLabel("O(n^2)");
            k2 = new JLabel("O(n^2)");
            k = new JLabel("O(n^2)");
        }
            /**Merge Dialog**/
        else if (type.equals("Merge")){
            String tmp = (String) dictionary.get("Merge");  //呼叫Map中Selection圖片的路徑
            icons[3] = new ImageIcon(tmp);      //建立iconImage
            icons[3].setImage(icons[3].getImage().getScaledInstance(450, 380, Image.SCALE_SMOOTH));     //設置大小、屬性
            lab = new JLabel(icons[3]);     //以label形式呈現

            k1 = new JLabel("O(nlog n)");
            k2 = new JLabel("O(nlog n)");
            k = new JLabel("O(nlog n)");
        }
            /**Quick Dialog**/
        else if (type.equals("Quick")){
            String tmp = (String) dictionary.get("Quick");  //呼叫Map中Selection圖片的路徑
            icons[4] = new ImageIcon(tmp);      //建立iconImage
            icons[4].setImage(icons[4].getImage().getScaledInstance(450, 380, Image.SCALE_SMOOTH));     //設置大小、屬性
            lab = new JLabel(icons[4]);     //以label形式呈現

            k1 = new JLabel("O(nlog n)");
            k2 = new JLabel("O(n^2)");
            k = new JLabel("O(nlog n)");
        }
        
        tool.add(text);
        tool.add(t);
        tool.add(sit1);
        tool.add(k1);
        tool.add(sit2);
        tool.add(k2);
        tool.add(sit);
        tool.add(k);
        icp.add(lab,BorderLayout.CENTER);
        icp.add(tool,BorderLayout.SOUTH);
        jdl.setBounds(700,300,500,450);
        jdl.setResizable(false);
        jdl.setVisible(true);
    }
}