import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class SliderBarDemo extends JFrame
{
	//create horizonal and vertical sliders
	private JSlider jslHort = new JSlider(JSlider.HORIZONTAL);
	private JSlider jslVert = new JSlider(JSlider.VERTICAL);

	//create a MessagePanel
	private MessagePanel messagePanel=new MessagePanel("welcome to java");

	public static void main(String[] args)
	{
		SliderBarDemo frame = new SliderBarDemo();
		frame.setTitle("slider bar demo");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public SliderBarDemo()
	{
		//add sliders and message panel to the frame
		setLayout(new BorderLayout());
		add(messagePanel,BorderLayout.CENTER);
		add(jslHort,BorderLayout.SOUTH);
		add(jslVert,BorderLayout.EAST);

		//set properties for sliders
		jslHort.setMaximum(50);
		jslHort.setPaintLabels(true);
		jslHort.setPaintTicks(true);
		jslHort.setPaintTrack(false);
		jslHort.setMajorTickSpacing(5);
		jslHort.setMinorTickSpacing(1);

		jslVert.setInverted(true);
		jslVert.setMaximum(10);
		jslVert.setPaintLabels(true);
		jslVert.setPaintTicks(true);
		jslVert.setMajorTickSpacing(10);
		jslVert.setMinorTickSpacing(1);
		//register listener for the sliders
		jslHort.addChangeListener(new ChangeListener()
				{
					public void stateChanged(ChangeEvent e)
					{
						//getValue() and getMaximum() return int,but for better precision,use double
						double value = jslHort.getValue();
						double maximumValue = jslHort.getMaximum();
						double newX = (value / maximumValue) * messagePanel.getWidth();
						messagePanel.setXCoordinate((int)newX);
					}
				});
		jslVert.addChangeListener(new ChangeListener()
				{
					public void stateChanged(ChangeEvent e)
					{
						//getValue() and getMaximum() return int,but for better precision,use double
						double value = jslVert.getValue();
						double maximumValue = jslVert.getMaximum();
						double newY = (value / maximumValue) * messagePanel.getHeight();
						messagePanel.setYCoordinate((int)newY);
					}
				});
	}
}
