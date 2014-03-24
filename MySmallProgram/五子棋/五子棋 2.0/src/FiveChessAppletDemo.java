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
		frame.setTitle("ȷ���˳���");
		frame.setLocation(100,100);
		frame.setSize(200,100);
		frame.pack();
		frame.setVisible(true);
	}
	
}
//���һ�����洰�ڣ�ȷ���Ƿ��˳�
class WarnFrame extends JFrame
{
	public WarnFrame()
	{
		setLayout(new GridLayout(1,2,5,5));
		//���������ť
		JButton sure = new JButton("ȷ��");
		JButton cancel = new JButton("ȡ��");
		add(sure);
		add(cancel);
		sure.setFont(new Font("Serif",Font.BOLD,25));
		cancel.setFont(new Font("Serif",Font.BOLD,25));
		//ȷ����ť�����������ȷ�����˳�
		ActionListener sureListener = new SureListener();
		sure.addActionListener(sureListener);
		
		//ȡ����ť�����������ȡ��������ʾ
		ActionListener cancelListener = new CancelListener();
		cancel.addActionListener(cancelListener);
	
	}
	//ע�������sure listener
	private class SureListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
	//ע�������sure listener
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


