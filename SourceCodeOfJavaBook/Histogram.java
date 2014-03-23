import javax.swing.*;
import java.awt.*;

public class Histogram extends JPanel
{
	//count the occurrence of 26 letters
	private int[] count;

	/**set the count and display histogram*/
	public void showHistogram(int[] count)
	{
		this.count = count;
		repaint();
	}

	/**paint the histogram*/
	protected void paintComponent(Graphics g)
	{
		//no display if count is null
		if(count == null)
			return;
		
		//find the panel size and bar width and interval dynamically
 		int width = getWidth();
		int height = getHeight();
		int interval = (width - 40) / count.length;
		int individualWidth = (int)(((width - 40) / 24) * 0.60);

		//find the maximum count, the maximum count has the highest bar
		int maxCount = 0;
		for(int i = 0; i < count.length; i++)
		{
			if(maxCount < count[i])
				maxCount = count[i];
		}

		//x is the start position for the first bar in the histogram
		int x = 30;

		//draw a horizontal base line
		g.drawLine(10, height - 45, width - 10, height - 45);
		for(int i = 0; i < count.length; i++)
		{
			//find the bar height
			int barHeight = (int)(((double)count[i] / (double)maxCount) * (height - 55));

			//display a bar
			g.setColor(Color.RED);
			g.fillRect(x, height - 45 - barHeight, individualWidth, barHeight);

			//display a letter under the base line
			g.setColor(Color.BLACK);
			g.drawString((char)(65 + i) + "", x, height - 30);

			//move x for displaying the next character
			x += interval;
		}
	}
	/** override getPreferredSize */
	public Dimension getPreferredSize()
	{
		return new Dimension(300, 300);
	}
}
