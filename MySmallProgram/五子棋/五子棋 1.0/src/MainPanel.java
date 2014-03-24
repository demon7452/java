import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;


/*
*��MainPanel��Ҫ������¹��ܣ�
*1������һ����壬�ڸ�����ϻ������̣�
*2�������ڸ������ϵ�����¼��������������������Ҽ����������϶��ȣ�
**/
class MainPanel extends JPanel 
implements MouseListener,MouseMotionListener{
private int width,height;//���̵Ŀ�Ⱥ͸߶�
private ChessModel cm;

//��������ģʽ�趨���Ĵ�С
MainPanel(ChessModel mm){
   cm=mm;
   width=cm.getWidth();
   height=cm.getHeight();
   addMouseListener(this);
}
   
    //��������ģʽ�趨���̵Ŀ�Ⱥ͸߶�
public void setModel(ChessModel mm){
   cm = mm;
   width = cm.getWidth();
   height = cm.getHeight();
}

//���������������̷������ӵ���Ϣ������ӻ��Ǻ��ӣ���
//Ȼ�����draw�����������ϻ�����Ӧ������
public void paintComponent(Graphics g){
   super.paintComponent(g);
   for(int j = 0; j <= height; j++){
    for(int i = 0; i <= width; i++){
     int v = cm.getarrMapShow()[i][j];
   draw(g, i, j, v);
    }
   }
}

//�����ṩ��������Ϣ����ɫ�����꣩������
public void draw(Graphics g, int i, int j, int v){
   int x = 20 * i+20;
   int y = 20 * j+20;
   //������
   if(i!=width && j!=height){
    g.setColor(Color.white);
    g.drawRect(x,y,20,20);
   }
   //����ɫ����
   if(v == 1 ){
    g.setColor(Color.gray);
    g.drawOval(x-8,y-8,16,16);
    g.setColor(Color.black);
    g.fillOval(x-8,y-8,16,16);
   }
   //����ɫ����
   if(v == 2 ){
    g.setColor(Color.gray);
    g.drawOval(x-8,y-8,16,16);
    g.setColor(Color.white);
    g.fillOval(x-8,y-8,16,16);
   }
   if(v ==3){
    g.setColor(Color.cyan);
    g.drawOval(x-8,y-8,16,16);
   }
}

//��Ӧ���ĵ���¼����������ĵ�������壬
//���������ж�ʤ����
public void mousePressed(MouseEvent evt){
   int x = (evt.getX()-10) / 20;
   int y = (evt.getY()-10) / 20;
   System.out.println(x+" "+y);
   if (evt.getModifiers()==MouseEvent.BUTTON1_MASK){
   cm.play(x,y);
    System.out.println(cm.getisOdd()+" "+cm.getarrMapShow()[x][y]);
    repaint();
    if(cm.judgeSuccess(x,y,cm.getisOdd())){
     cm.showSuccess(this);
     evt.consume();
     ChessFrame.iscomputer=false;
    }
    //�ж��Ƿ�Ϊ�˻�����
    if(ChessFrame.iscomputer&&!cm.getisExist()){
     cm.computerDo(cm.getWidth(),cm.getHeight());
    repaint();
     if(cm.judgeSuccess(cm.getX(),cm.getY(),cm.getisOdd())){
      cm.showDefeat(this);
    evt.consume();
   }
    }
   }
}

public void mouseClicked(MouseEvent evt){}
public void mouseReleased(MouseEvent evt){}
public void mouseEntered(MouseEvent mouseevt){}
public void mouseExited(MouseEvent mouseevent){}
public void mouseDragged(MouseEvent evt){}
    
    //��Ӧ�����϶��¼�
public void mouseMoved(MouseEvent moveevt){
   int x = (moveevt.getX()-10) / 20;
   int y = (moveevt.getY()-10) / 20;
   cm.readyplay(x,y);
   repaint();
} 
}