// app17_5, �إߵ�������
import java.awt.*;
public class app17_5
{
    static Frame frm=new Frame("Frame class");

    public static void main(String args[])
    {
        frm.setSize(500,600);      // �]�w�������j�p��200*150
        frm.setLocation(100,50);      // �]�w������m��(100,50)
        frm.setVisible(true);      // �]�w�������i��
        frm.setResizable(false);

        System.out.println("state="+frm.getState());
        System.out.println("title="+frm.getTitle());
        System.out.println("visible="+frm.isVisible());
    }
}

/* app17_5 OUTPUT---
state=0
title=Frame class
visible=true
------------------*/