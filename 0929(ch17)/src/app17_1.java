import java.awt.*;            // 載入java.awt類別庫裡的所有類別
public class app17_1 {
    static Frame frm=new Frame("my first AWT program");
    static Label lab=new Label("Hello Java!!");

    public static void main(String args[])
    {
        frm.setSize(700,300);      // 設定視窗的寬為220、高為150個像素
        frm.setBackground(Color.pink);  // 設定黃色的背景
        frm.setLocation(250,250);        // 設定視窗的位置
        frm.add(lab);                    // 將標籤物件lab加入視窗中
        frm.setVisible(true);               // 將視窗顯示出來
    }
}
