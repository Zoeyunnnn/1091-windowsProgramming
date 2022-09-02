import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class online1208_3 extends JFrame{
    static online1208_3 f = new online1208_3();
    static Container cp = f.getContentPane();
    static Button [][] btn_Array= new Button[4][4];
//    static int[] rand = new int[16];
    static int time=0;
    static int[] bt=new int[2];
    static int[] rand = {6,1,4,8,5,3,2,5,1,7,2,4,8,6,7,3};
    static int tmp_i,tmp_j;
    static boolean flag = false;

    //    private static void random(){
//        int i=0,j=0,count=0;
//        boolean flag = true;
//        while (i<16){
//            flag=true;
//            rand[i] = (int)(Math.random()*7)+1;
//
//            for(int t=count;t<i;t++){
//                if(rand[i]==rand[t]) {
//                    flag = false;
//                    break;
//                }
//            }if (flag) {
//                j++;
//                i++;
//            }
//
//            if (j==8){
//                j=0;
//                count=8;
//            }
//        }
//    }
    public static void main(String[] args) {
//        random();
        GridLayout grid = new GridLayout(4,4);
        cp.setLayout(grid);
        for(int m=0;m<4;m++){
            for(int n=0;n<4;n++){
                btn_Array[m][n] = new Button();
                cp.add(btn_Array[m][n]);
                btn_Array[m][n].addActionListener(new ActLis());
            }
        }
        f.setSize(600,500);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    static class ActLis implements ActionListener{
        public void actionPerformed(ActionEvent e){
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    if(e.getSource()==btn_Array[i][j]){
                        btn_Array[i][j].setLabel(String.valueOf(rand[i+j]));
                        if (time==0){
                            tmp_i=i;tmp_j=j;
                            bt[time] = rand[i+j];
                            time++;
                        }else if (time==1){
                            bt[time] = rand[i+j];
                            time=0;
                            if (bt[0]==bt[1]){
                                Timer timer = new Timer();
                                int finalI1 = i;
                                int finalJ1 = j;
                                TimerTask task = new TimerTask () {
                                    public void run() {
                                        btn_Array[tmp_i][tmp_j].setBackground(Color.BLACK);
                                        btn_Array[finalI1][finalJ1].setBackground(Color.BLACK);
                                    }
                                };
                                timer.schedule(task,500);
                            }else {
                                Timer timer = new Timer();
                                int finalI = i;
                                int finalJ = j;
                                TimerTask task = new TimerTask (){
                                    public void run() {
                                        btn_Array[tmp_i][tmp_j].setLabel("");
                                        btn_Array[finalI][finalJ].setLabel("");
                                    }
                                };
                                timer.schedule(task,500);
                            }
                        }
                    }
                }
            }
        }
    }

//    private static void end(int i,int j){
//        btn_Array[tmp_i][tmp_j].setLabel("");
//        btn_Array[i][j].setLabel("");
//    }
}
