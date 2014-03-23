import javax.swing.*;
import java.awt.*;

public class DisplayImage extends JFrame
{
	public DisplayImage()
	{
		add(new ImageCanvas());
	}
	public static void main(String[] args)
	{
		DisplayImage frame=new DisplayImage();
		frame.setTitle("display image");
		frame.setSize(300,500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
class ImageCanvas extends JPanel
{
	ImageIcon imageIcon=new ImageIcon("image/1.jpg");
	Image image=imageIcon.getImage();
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		if(image!=null)
			g.drawImage(image,0,0,getWidth(),getHeight(),this);
	}
}
