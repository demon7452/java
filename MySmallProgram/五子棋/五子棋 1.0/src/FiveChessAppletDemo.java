import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.io.PrintStream;
import javax.swing.JComponent;
import javax.swing.JPanel;

/*
*main����������ChessFrame���һ��ʵ������cf����
*��������Ļ��ʾ��ʾ��ʵ������
**/
public class FiveChessAppletDemo {
public static void main(String args[]){
   ChessFrame cf = new ChessFrame();
   cf.show();
}
}



class ChessWindowEvent extends WindowAdapter{
public void windowClosing(WindowEvent e){
   System.exit(0);
}

ChessWindowEvent()

{
}
}

