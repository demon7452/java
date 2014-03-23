import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MultipleWindowsDemo extends JFrame
{
	private JTextArea jta;
	private JButton jbtShowHistogram = new JButton("Show Histogram");
	private Histogram histogram = new Histogram();

	//create a new frame to hold the histogram panel
	private JFrame histogramFrame = new JFrame();

	public static void main(String[] args)
	{
		MultipleWindowsDemo frame = new MultipleWindowsDemo();
		frame.setTitle("multiple windows demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}

	public MultipleWindowsDemo()
	{
		// store text area in a scroll pane
		JScrollPane scrollPane = new JScrollPane(jta = new JTextArea());
		scrollPane.setPreferredSize(new Dimension(300, 200));
		jta.setWrapStyleWord(true);
		jta.setLineWrap(true);

		//place scroll pane and button in the frame
		add(scrollPane, BorderLayout.CENTER);
		add(jbtShowHistogram, BorderLayout.SOUTH);

		//set the frame to show histogram
		histogramFrame.add(histogram);
		histogramFrame.pack();
		histogramFrame.setTitle("histogram");
		//histogramFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//register listener
		jbtShowHistogram.addActionListener(new ActionListener()
				{
					/** handle the button action */
					public void actionPerformed(ActionEvent e)
					{
						//count the letters in the text area
						int[] count = countLetters();

						//set the letter count to histogram for display
						histogram.showHistogram(count);

						//show the frame
						histogramFrame.setVisible(true);
					}
				});
	}
	/** 	count the letters in the text area */
	private int[] countLetters()
	{
		//count for 26 letters
		int[] count = new int[26];
		
		//get contents from the text area
		String text = jta.getText();

		//count occurrence of each letter (case insensitive)
		for(int i = 0; i < text.length(); i++)
		{
			char character = text.charAt(i);
			if((character >= 'A') && (character <= 'Z'))
				count[(int)(character - 'A')]++;
			else if((character >= 'a') && (character <= 'z'))
				count[(int)(character - 'a')]++;
		}
		return count;//return the count array
	}
}
