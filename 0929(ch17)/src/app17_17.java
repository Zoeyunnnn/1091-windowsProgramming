// app17_17, GridLayout���O���ϥ�
import java.awt.*;
public class app17_17
{
    static Frame frm=new Frame("Grid Layout");
    public static void main(String args[])
    {
        GridLayout grid=new GridLayout(3,5);      // 3�C5�檺�t�m
        frm.setLayout(grid);
        frm.setSize(200,150);
        for(int i=1;i<=15;i++)
            frm.add(new Button(Integer.toString(i)));    // �[�J���s
        frm.setVisible(true);
    }
}
