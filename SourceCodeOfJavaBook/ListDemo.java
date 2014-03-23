import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ListDemo extends JFrame
{
	private String[] comedyTitles={"comedy1","comedy2","comedy3","comedy4","comedy5","comedy6","comedy7","comedy8","comedy9"};
	private JList jlst=new JList(comedyTitles);
	private ImageIcon[] comedyImage={new ImageIcon("comedy/1.gif"),new ImageIcon("comedy/2.gif"),new ImageIcon("comedy/3.gif"),new ImageIcon("comedy/4.gif"),new ImageIcon("comedy/5.gif"),new ImageIcon("comedy/6.gif"),new ImageIcon("comedy/7.gif"),new ImageIcon("comedy/8.gif"),new ImageIcon("comedy/9.gif") };
	private JLabel[] jlbImageViewer=new JLabel[9];

	public ListDemo()
	{
		System.out.println(jlst.getSelectionMode());
		jlst.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		jlst.setSelectionForeground(Color.RED);
		jlst.setSelectionBackground(Color.BLUE);
		//jlst.setVisibleRowCount(4);
		System.out.println(jlst.getSelectionMode());
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(3,3,5,5));
		for(int i=0;i<9;i++)
		{
			p.add(jlbImageViewer[i]=new JLabel());
			jlbImageViewer[i].setHorizontalAlignment(SwingConstants.CENTER);
		}
		setLayout(new BorderLayout());
		add(new JScrollPane(jlst),BorderLayout.WEST);
		add(p,BorderLayout.CENTER);

		jlst.addListSelectionListener(new ListSelectionListener()
				{
					public void valueChanged(ListSelectionEvent e)
					{
						int[] indices=jlst.getSelectedIndices();
	
						int i;
						for(i=0;i<indices.length;i++)
						{
							jlbImageViewer[i].setIcon(comedyImage[indices[i]]);
						}
						for(;i<9;i++)
						{
							jlbImageViewer[i].setIcon(null);
						}
					}
				});
	}
	public static void main(String[] args)
	{
		ListDemo frame=new ListDemo();
		frame.pack();
		frame.setTitle("list demo");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
