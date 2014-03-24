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
public class FiveChessAppletDemo 
{
	public static void main(String args[])
	{
		ChessFrame cf = new ChessFrame();
		cf.setLocation(200, 200);
		cf.setVisible(true);
	}
	public void sort(double[] list, int high)
	{
		if(high > 1)
		{
			//find the largest number and its index
			int indexOfMax = 0;
			double max = list[0];
			for(int i = 1; i <= high; i++)
			{
				if(list[i] > max)
				{
					max = list[i];
					indexOfMax = i;
				}
			}
			//swap the largest with the last number in the list
			list[indexOfMax] = list[high];
			list[high] = max;
			//sort the remaining list
			sort(list,high-1);
		}
	}
	public int recursive(int[] list, int key, int low, int high)
	{
		if(low > high)
			return -low - 1;
		int mid = (low + high)/2;
		if(key < list[mid])
			return recursive(list,key,low,high);
		else 
			return recursive(list,key,mid+1,high);	
	}

}

class ChessWindowEvent extends WindowAdapter
{	
	public void windowClosing(WindowEvent e)
	{
		WarnFrame frame = new WarnFrame();
		frame.setTitle("确定退出吗？");
		frame.setLocation(100,100);
		frame.setSize(200,100);
		frame.pack();
		frame.setVisible(true);
	}
	
}
//添加一个警告窗口，确定是否退出
class WarnFrame extends JFrame
{
	public WarnFrame()
	{
		setLayout(new GridLayout(1,2,5,5));
		//添加两个按钮
		JButton sure = new JButton("确定");
		JButton cancel = new JButton("取消");
		add(sure);
		add(cancel);
		sure.setFont(new Font("Serif",Font.BOLD,25));
		cancel.setFont(new Font("Serif",Font.BOLD,25));
		//确定按钮监听器，点击确定即退出
		ActionListener sureListener = new SureListener();
		sure.addActionListener(sureListener);
		
		//取消按钮监听器，点击取消重新显示
		ActionListener cancelListener = new CancelListener();
		cancel.addActionListener(cancelListener);
	
	}
	//注册监听器sure listener
	private class SureListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
	//注册监听器sure listener
	private class CancelListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			setVisible(false);
			ChessFrame cf = new ChessFrame();
			cf.setLocation(200, 200);
			cf.setVisible(true);
		}
	}
	public void sort(double[] list, int high)
	{
		if(high > 1)
		{
			//find the largest number and its index
			int indexOfMax = 0;
			double max = list[0];
			for(int i = 1; i <= high; i++)
			{
				if(list[i] > max)
				{
					max = list[i];
					indexOfMax = i;
				}
			}
			//swap the largest with the last number in the list
			list[indexOfMax] = list[high];
			list[high] = max;
			//sort the remaining list
			sort(list,high-1);
		}
	}
}


