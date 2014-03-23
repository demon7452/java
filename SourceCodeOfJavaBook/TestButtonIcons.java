import javax.swing.*;
import java.awt.*;
public class TestButtonIcons extends JFrame
{
	public TestButtonIcons()
	{
		ImageIcon icon1=new ImageIcon("image/1.jpg");
		ImageIcon icon2=new ImageIcon("image/2.jpg");
		ImageIcon icon3=new ImageIcon("image/3.jpg");

		JButton jbt=new JButton("click it",icon1);
		jbt.setPressedIcon(icon2);
		jbt.setRolloverIcon(icon3);
		JPanel p=new JPanel();
		p.add(jbt);
		JPanel p2=new JPanel();
		setLayout(new BorderLayout(5,10));
		add(new ButtonIcon(),BorderLayout.WEST);
		add(p,BorderLayout.EAST);
		add(new ImageIcons(),BorderLayout.CENTER);
	}
	public static void main(String[] args)
	{
		JFrame frame=new TestButtonIcons();
		frame.setTitle("button icons");
		frame.setSize(300,200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	class ImageIcons extends JPanel
	{
		private ImageIcon icon=new ImageIcon("image/2.jpg");
		private Image image=icon.getImage();
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(image,0,0,getWidth(),getHeight(),this);
		}
	}
	class ButtonIcon extends JPanel
	{
		private ImageIcon icon=new ImageIcon("image/1.jpg");
		public ButtonIcon()
		{
			JButton button=new JButton("test",icon);
			add(button);
		}
	}
}
