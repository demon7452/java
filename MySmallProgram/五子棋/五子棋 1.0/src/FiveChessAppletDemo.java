import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.io.PrintStream;
import javax.swing.JComponent;
import javax.swing.JPanel;

/*
*main方法创建了ChessFrame类的一个实例对象（cf），
*并启动屏幕显示显示该实例对象。
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

