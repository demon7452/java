import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonDemo extends JFrame
{
	protected MessagePanel messagePanel=new MessagePanel("welocme to java");
	private JButton jbtLeft=new JButton("<=");
	private JButton jbtRight=new JButton("=>");
	private JButton jbtUp=new JButton("upW");
	private JButton jbtDown=new JButton("down");
	private JButton jbtCenter=new JButton("center");
	
	public ButtonDemo()
	{
		//set the background color of messagePanel
		messagePanel.setBackground(Color.WHITE);
		messagePanel.setForeground(Color.RED);
		messagePanel.setFont(new Font("Times",Font.BOLD,20));
		messagePanel.setCentered(true);

		//create panel jbP to hold four buttons 
		JPanel jbP=new JPanel();
		jbP.setLayout(new BorderLayout());
		jbP.add(jbtLeft,BorderLayout.WEST);
		jbP.add(jbtDown,BorderLayout.CENTER);
		jbP.add(jbtRight,BorderLayout.EAST);
		jbP.add(jbtUp,BorderLayout.NORTH);
		jbP.add(jbtCenter,BorderLayout.SOUTH);

		//set keyboard mnemeonics
		jbtLeft.setMnemonic('a');
		jbtRight.setMnemonic('d');
		jbtUp.setMnemonic('W');
		jbtDown.setMnemonic('S');

		//set tool tip text on the buttons
		jbtLeft.setToolTipText("move message to left");

		//place panels int the frame
		setLayout(new BorderLayout());
		add(messagePanel,BorderLayout.CENTER);
		add(jbP,BorderLayout.SOUTH);

		//reqister listeners with the buttons
		jbtLeft.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						messagePanel.setCentered(false);
						if(messagePanel.getXCoordinate()>0)
							messagePanel.moveLeft();
					}
				});
		messagePanel.addMouseListener(new MouseAdapter()
				{
					public void mousePressed(MouseEvent e)
					{
						messagePanel.setCentered(false);
						if(messagePanel.getXCoordinate()>0)
							messagePanel.moveLeft();
					}
				});
		jbtRight.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						messagePanel.setCentered(false);
						if(messagePanel.getXCoordinate()<(messagePanel.getWidth()-20))
							messagePanel.moveRight();
					}
				});
		jbtUp.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						messagePanel.setCentered(false);
						if(messagePanel.getYCoordinate()>20)
							messagePanel.moveUp();
					}
				});
		jbtDown.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						messagePanel.setCentered(false);
						if(messagePanel.getYCoordinate()<(messagePanel.getHeight()-5))
							messagePanel.moveDown();
					}
				});
		jbtCenter.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						messagePanel.setCentered(true);
					}
				});
	}
	public static void main(String[] args)
	{
		ButtonDemo frame=new ButtonDemo();
		frame.setTitle("butto demo");
		frame.setSize(400,500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
