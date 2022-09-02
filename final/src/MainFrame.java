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
    /*-----------------MenuBar(���}�ɮץ\��B��ܱƧǪk)---------------------*/
    private JMenuBar mb = new JMenuBar();
    private JMenu menu1 = new JMenu("File");
    private JMenuItem m1 = new JMenuItem("open",KeyEvent.VK_I);
    private JFileChooser file = new JFileChooser(".");

    private JMenu menu2 = new JMenu("Sort");
    private JMenuItem me1 = new JMenuItem("��w�ƧǪk");
    private JMenuItem me2 = new JMenuItem("���J�ƧǪk");
    private JMenuItem me3 = new JMenuItem("��ܱƧǪk");
    private JMenuItem me4 = new JMenuItem("�X�ֱƧǪk");
    private JMenuItem me5 = new JMenuItem("�ֳt�ƧǪk");

    private JMenu menu3 = new JMenu("Add Node");
    private JMenuItem mn1 = new JMenuItem("�쵲��C");
    private JMenuItem mn2 = new JMenuItem("��w�Ƨ�");
    /*-----------------input Panel(��J��ƪ��ݤf��\��)---------------------*/
    private JPanel input_jpn = new JPanel(new GridLayout(1,4,3,3));
    private JTextField txf = new JTextField();
    private JButton jbtnAdd= new JButton("Add");
    private JButton jbtnDel= new JButton("Del");
    private JButton jbtnExit= new JButton("Exit");
    /*-----------------output Panel(��X�Ƨǫ���)---------------------*/
    private JPanel output_jpn = new JPanel(new GridLayout(1,1,3,3));
    private JScrollPane srlPal;
    private JTextArea txa = new JTextArea();
    /*-----------------sorting tools(�Ω�P�_���ܼơB�ƧǪk�禡)---------------------*/
    private String type="";
    private LinkList linklist;
    private Bubble bubble;
    private Insertion insertion;
    private Selection selection;
    private Merge merge;
    private Quick quick;
    /*-----------------time tools(�ƧǪk�Ĳv��ﵲ�G�e�{)---------------------*/
    private JDialog jdl;
    private ImageIcon icons[] = new ImageIcon[5];
    private Map dictionary = new HashMap();

    public MainFrame(){ //MainFrame ���غc��
        init();
    }
    private void init(){    //��m�D�nFrame���e
        cp = this.getContentPane();     //JFrame���D�ج[
        cp.setLayout(new BorderLayout(3,3));
        this.setTitle("��@��ƱƧǻP�į���");
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
                txa.append("����-------- �� �w �� �� �k --------����\n");
                type = "Bubble";
                dictionary.put("Bubble","img\\bubble.jpg");
            }
        });
        menu2.add(me1);
        me2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txa.append("����-------- �� �J �� �� �k --------����\n");
                type = "Insertion";
                dictionary.put("Insertion","img\\insertion.jpg");
            }
        });
        menu2.add(me2);
        me3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txa.append("����-------- �� �� �� �� �k --------����\n");
                type = "Selection";
                dictionary.put("Selection","img\\select.jpg");
            }
        });
        menu2.add(me3);
        me4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txa.append("����-------- �X �� �� �� �k --------����\n");
                type = "Merge";
                dictionary.put("Merge","img\\merge.jpg");
            }
        });
        menu2.add(me4);
        me5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txa.append("����-------- �� �t �� �� �k --------����\n");
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
                txa.append("����-------- �� �� �� �C --------����\n");
            }
        });
        menu3.add(mn1);
        mn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type = "Bubble";
                txa.append("����-------- �� �� �� �i �� �� �w �� �� --------����\n");
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

    /**--------�}�үS�w�ɮ׶i��Ƨ�--------**/
    private void readfile() {
        int state = file.showOpenDialog(this);
        if (state == JFileChooser.APPROVE_OPTION) {
            String fname = file.getSelectedFile().getAbsolutePath();    // ���o�ɮ׸��|�P�W��
            try {
                FileInputStream fi = new FileInputStream(fname);
                byte ba[] = new byte[fi.available()];
                fi.read(ba);    // Ū�J�ɮפ��e��byte�}�C��
                String t = new String(ba, StandardCharsets.UTF_8);  //�s�X�ഫ
                String str[] = t.split("\n");   //�̾ڴ�����Ω�Jstr[]
                fi.close();

                sorting(str);
            } catch (IOException ie) {
                System.out.println(ie);
            }
        }
    }
    /**--------�I�s�ƧǪk�ÿ�X���G--------**/
    private void sorting(String[] str){

        /**----�@���@����J�`�INode----**/
        long startTime=0,endTime = 0;
        /**Bubble Sorting**/
        if (type.equals("Bubble")) {
            startTime = System.nanoTime();     //���o�}�l�ɪ��`�̬�ɶ�
            if (bubble == null) {
                bubble = new Bubble();
            }
            for (int i=0;i<str.length;i++){
                if (str[i].startsWith("\uFEFF")) {  //�h��csv�ɼg�J�ɲĤ@��X�{�ݸ������p
                    str[i] = str[i].replace("\uFEFF", "");
                }
                bubble.addNode(Integer.parseInt(str[i].trim()));    //trim():�R���r��e�᪺�ť�
            }
            endTime = System.nanoTime();       //���o�����ɪ��`�̬�ɶ�
            txa.append(bubble.showList());  //�N�w�ƧǦn����ƩԦ^�ӧe�{
        }
        /**Insertion Sorting**/
        else if (type.equals("Insertion")){
            startTime = System.nanoTime();     //���o�}�l�ɪ��`�̬�ɶ�
            if (insertion == null){
                insertion = new Insertion();
            }for (int i=0;i<str.length;i++){
                if (str[i].startsWith("\uFEFF")) {  //�h��csv�ɼg�J�ɲĤ@��X�{�ݸ������p
                    str[i] = str[i].replace("\uFEFF", "");
                }
                insertion.addNode(Integer.parseInt(str[i].trim()));    //trim():�R���r��e�᪺�ť�
            }
            endTime = System.nanoTime();       //���o�����ɪ��`�̬�ɶ�
            txa.append(insertion.showList());
        }
        /**----���x�s�ܰ}�C��I�s������k�}�l�Ƨ�----**/
        /**Selection Sorting**/
        else if (type.equals("Selection")){
            startTime = System.nanoTime();     //���o�}�l�ɪ��`�̬�ɶ�
            if (selection == null){
                selection = new Selection();
            }
            int[] arr = new int[str.length];
            for (int i=0;i<str.length;i++){
                if (str[i].startsWith("\uFEFF")) {  //�h��csv�ɼg�J�ɲĤ@��X�{�ݸ������p
                    str[i] = str[i].replace("\uFEFF", "");
                }
                arr[i] = Integer.parseInt(str[i].trim());
            }
            endTime = System.nanoTime();       //���o�����ɪ��`�̬�ɶ�
            selection.Selectsort(arr);
            txa.append(selection.showList());
        }
        /**Merge Sorting**/
        else if (type.equals("Merge")){
            startTime = System.nanoTime();     //���o�}�l�ɪ��`�̬�ɶ�
            if (merge == null){
                merge = new Merge();
            }
            int[] arr = new int[str.length];
            for (int i=0;i<str.length;i++){
                if (str[i].startsWith("\uFEFF")) {  //�h��csv�ɼg�J�ɲĤ@��X�{�ݸ������p
                    str[i] = str[i].replace("\uFEFF", "");
                }
                arr[i] = Integer.parseInt(str[i].trim());
            }
            endTime = System.nanoTime();       //���o�����ɪ��`�̬�ɶ�
            merge.mergeSort(arr);
            txa.append(merge.showList());
        }
        /**Quick Sorting**/
        else if (type.equals("Quick")){
            startTime = System.nanoTime();     //���o�}�l�ɪ��`�̬�ɶ�
            if (quick == null){
                quick = new Quick();
            }
            int[] arr = new int[str.length];
            for (int i=0;i<str.length;i++){
                if (str[i].startsWith("\uFEFF")) {  //�h��csv�ɼg�J�ɲĤ@��X�{�ݸ������p
                    str[i] = str[i].replace("\uFEFF", "");
                }
                arr[i] = Integer.parseInt(str[i].trim());
            }
            endTime = System.nanoTime();       //���o�����ɪ��`�̬�ɶ�
            quick.quicksort(arr);
            txa.append(quick.showList());
        }

        String time = String.valueOf((endTime - startTime) / 1000000);      //���o�p���O���@��

        imgPal(time);
    }

    /**--------ø�s�X�ӱƧǪk���u������--------**/
    private void imgPal(String time){
        jdl = new JDialog();
        jdl.setTitle("Frame"+type);  //�]�m�u������
        Container icp = jdl.getContentPane();
        icp.setLayout(new BorderLayout());
        JPanel tool = new JPanel(new GridLayout(4,2,3,3));

        JLabel lab = null,k1 = null, k2 = null,k = null;
        JLabel t = new JLabel(time);
        JLabel text = new JLabel("Execution time in milliseconds : ");
        JLabel sit1 = new JLabel("�ƧǪk�̨ήɶ������� : ");
        JLabel sit2 = new JLabel("�ƧǪk�̮t�ɶ������� : ");
        JLabel sit = new JLabel("�ƧǪk�����ɶ������� : ");

            /**Bubble Dialog**/
        if (type.equals("Bubble")){
            String tmp = (String) dictionary.get("Bubble");  //�I�sMap��Bubble�Ϥ������|
            icons[0] = new ImageIcon(tmp);      //�إ�iconImage
            icons[0].setImage(icons[0].getImage().getScaledInstance(450, 380, Image.SCALE_SMOOTH));     //�]�m�j�p�B�ݩ�
            lab = new JLabel(icons[0]);     //�Hlabel�Φ��e�{

            k1 = new JLabel("O(n)");
            k2 = new JLabel("O(n^2)");
            k = new JLabel("O(n^2)");
        }
            /**Insertion Dialog**/
        else if (type.equals("Insertion")){
            String tmp = (String) dictionary.get("Insertion");  //�I�sMap��Insertion�Ϥ������|
            icons[1] = new ImageIcon(tmp);      //�إ�iconImage
            icons[1].setImage(icons[1].getImage().getScaledInstance(450, 380, Image.SCALE_SMOOTH));     //�]�m�j�p�B�ݩ�
            lab = new JLabel(icons[1]);     //�Hlabel�Φ��e�{

            k1 = new JLabel("O(n)");
            k2 = new JLabel("O(n^2)");
            k = new JLabel("O(n^2)");
        }
            /**Selection Dialog**/
        else if (type.equals("Selection")){
            String tmp = (String) dictionary.get("Selection");  //�I�sMap��Selection�Ϥ������|
            icons[2] = new ImageIcon(tmp);      //�إ�iconImage
            icons[2].setImage(icons[2].getImage().getScaledInstance(450, 380, Image.SCALE_SMOOTH));     //�]�m�j�p�B�ݩ�
            lab = new JLabel(icons[2]);     //�Hlabel�Φ��e�{

            k1 = new JLabel("O(n^2)");
            k2 = new JLabel("O(n^2)");
            k = new JLabel("O(n^2)");
        }
            /**Merge Dialog**/
        else if (type.equals("Merge")){
            String tmp = (String) dictionary.get("Merge");  //�I�sMap��Selection�Ϥ������|
            icons[3] = new ImageIcon(tmp);      //�إ�iconImage
            icons[3].setImage(icons[3].getImage().getScaledInstance(450, 380, Image.SCALE_SMOOTH));     //�]�m�j�p�B�ݩ�
            lab = new JLabel(icons[3]);     //�Hlabel�Φ��e�{

            k1 = new JLabel("O(nlog n)");
            k2 = new JLabel("O(nlog n)");
            k = new JLabel("O(nlog n)");
        }
            /**Quick Dialog**/
        else if (type.equals("Quick")){
            String tmp = (String) dictionary.get("Quick");  //�I�sMap��Selection�Ϥ������|
            icons[4] = new ImageIcon(tmp);      //�إ�iconImage
            icons[4].setImage(icons[4].getImage().getScaledInstance(450, 380, Image.SCALE_SMOOTH));     //�]�m�j�p�B�ݩ�
            lab = new JLabel(icons[4]);     //�Hlabel�Φ��e�{

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