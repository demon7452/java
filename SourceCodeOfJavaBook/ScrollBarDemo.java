import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ScrollBarDemo extends JFrame
{
	private JScrollBar jscbHort=new JScrollBar(JScrollBar.HORIZONTAL);
	private JScrollBar jscbVert=new JScrollBar(JScrollBar.VERTICAL);
	private MessagePanel messagePanel=new MessagePanel("welcome to java");

	public static void main(String[] args)
	{
		ScrollBarDemo frame=new ScrollBarDemo();
		frame.setTitle("ScrollBarDemo");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	public ScrollBarDemo()
	{
		//add scroll bars and message panel to the frame
		setLayout(new BorderLayout());
		add(messagePanel,BorderLayout.CENTER);
		add(jscbHort,BorderLayout.SOUTH);
		add(jscbVert,BorderLayout.EAST);

		//register listener for the scroll bars
		jscbHort.addAdjustmentListener(new AdjustmentListener()
				{
					public void adjustmentValueChanged(AdjustmentEvent e)
					{
						//getValue() and getMaximumValue() return int ,but for better precision, use double
						double value=jscbHort.getValue();
						double maximumValue=jscbHort.getMaximum();
						double newX = value * messagePanel.getWidth() / maximumValue;
						messagePanel.setXCoordinate((int)newX);
					}
				});
		jscbVert.addAdjustmentListener(new AdjustmentListener()
				{
					public void adjustmentValueChanged(AdjustmentEvent e)
					{
						//getValue() and getMaximumValue() return int,but for better precision,use double
						double value = jscbVert.getValue();
						double maximumValue = jscbVert.getMaximum();
						double newY = value * messagePanel.getHeight() / maximumValue;
						messagePanel.setYCoordinate((int)newY);
					}
				});
	}
}
