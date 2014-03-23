import java.awt.*;
import javax.swing.*;

public class SixImages extends JFrame
{
	public SixImages()
	{
		Image image1=new ImageIcon("image/1.jpg").getImage();
		Image image2=new ImageIcon("image/2.jpg").getImage();
		Image image3=new ImageIcon("image/3.jpg").getImage();
		Image image4=new ImageIcon("image/4.jpg").getImage();
		Image image5=new ImageIcon("image/5.jpg").getImage();
		Image image6=new ImageIcon("image/6.jpg").getImage();
		
		setLayout(new GridLayout(2,3));
		add(new ImageViewer(image1));
		add(new ImageViewer(image2));
		add(new ImageViewer(image3));
		add(new ImageViewer(image4));
		add(new ImageViewer(image5));
		add(new ImageViewer(image6));
	}
	public static void main(String[] args)
	{
		SixImages frame=new SixImages();
		frame.setSize(600,400);
		frame.setTitle("six images");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
