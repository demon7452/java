import java.awt.*;
import javax.swing.*;
import java.net.URL;
public class ImageCanvas extends JPanel
{
	private URL[] urls = {
	this.getClass().getResource("image/1.jpg"),
	this.getClass().getResource("image/2.jpg"),
	this.getClass().getResource("image/3.jpg"),
	this.getClass().getResource("image/4.jpg"),
	this.getClass().getResource("image/5.jpg")
	};
	//Declare an ImageIcon array for the images
	/**private ImageIcon[] images = {
		new ImageIcon("image/1.jpg"),
		new ImageIcon("image/2.jpg"),
		new ImageIcon("image/3.jpg"),
		new ImageIcon("image/4.jpg"),
		new ImageIcon("image/5.jpg")
	};*/
	private Image image;// = images[0].getImage();
	/** Draw image on the panel*/
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(image != null)
			g.drawImage(image,0,0,getWidth(),getHeight(),this);
	}
	
	/** Set a new value for property image */
	public void setImage (int num)
	{
		assert urls[num] != null : "the image "+(num+1)+".jpg does not exits!";
		ImageIcon images = new ImageIcon(urls[num]);
		image = images.getImage();
		repaint();
	}
}
