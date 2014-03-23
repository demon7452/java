import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyEventDemo extends JFrame
{
	private KeyBoardPanel keyboardPanel=new KeyBoardPanel();
	public KeyEventDemo()
	{
		keyboardPanel.setFont(new Font("Times",Font.BOLD,20));
		keyboardPanel.setForeground(Color.RED);
		add(keyboardPanel);

		keyboardPanel.setFocusable(true);
	}
	public static void main(String[] args)
	{
		KeyEventDemo frame=new KeyEventDemo();
		frame.setTitle("key event demo");
		frame.setSize(400,300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	static class KeyBoardPanel extends JPanel
	{
		private int x=30;
		private int y=30;
		private char keyChar='A';

		public KeyBoardPanel()
		{
			addKeyListener(new KeyAdapter()
					{
						public void keyPressed(KeyEvent e)
						{
							switch(e.getKeyCode())
							{
								case KeyEvent.VK_DOWN:y+=10;break;
								case KeyEvent.VK_RIGHT:x+=10;break;
								case KeyEvent.VK_UP:y-=10;break;
								case KeyEvent.VK_LEFT:x-=10;break;
								default: keyChar=e.getKeyChar();
							}
							repaint();
						}
					});
			addMouseMotionListener(new MouseMotionAdapter()
			{
				public void mouseDragged(MouseEvent e)
				{
					x=e.getX();
					y=e.getY();
					repaint();
				}
			});
			addMouseListener(new MouseAdapter()
			{
				public void mousePressed(MouseEvent e)
				{
					x=e.getX();
					y=e.getY();
					repaint();
				}
			});
		}
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawString(String.valueOf(keyChar),x,y);
		}
	}
}

