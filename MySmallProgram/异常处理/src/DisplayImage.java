import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class DisplayImage extends JFrame
{

	//create panel for images
	private ImageCanvas jpImage = new ImageCanvas();
	//create panel for poetry text
	private PoetryText jpPoetry = new PoetryText();
	//create panel for buttons
	private JPanel jpButtons = new JPanel();

	//create 3 buttons
	private JButton jbtUP = new JButton("上一张");
	private JButton jbtDown = new JButton("下一张"); 
	private JButton jbtSure = new JButton("确定");
	
	//create  text field
	private JTextField jtfNumber = new JTextField(5);
	private JPanel jpText = new JPanel();

	// Default the number of image
	private int num = 0;

	// Create a frame for warning
	private JFrame warnFrame = new JFrame();
	// Create panel for warning
	//private JPanel jpWarning = new JPanel();
	// Create label for warning
	private JLabel jlbWarning = new JLabel();

	// Create a log text
	private PrintWriter output = null; 
	/**construct method*/
	public DisplayImage()
	{
		setLayout(new BorderLayout(10,2));
		add(jpImage,BorderLayout.CENTER);
		add(jpButtons,BorderLayout.SOUTH);
		add(jpPoetry,BorderLayout.EAST);
		jpImage.setImage(num);
		
		//Add buttons
		jpButtons.setLayout(new GridLayout(1,4,10,10));
		jpButtons.add(jbtUP);
		jpButtons.add(jbtDown);
		jpButtons.add(jpText);
		jpButtons.add(jbtSure);
		//set the text field
		jpText.add(new JLabel("enter the number of image(1-5):"),BorderLayout.WEST);
		jpText.add(jtfNumber,BorderLayout.CENTER);
		jtfNumber.setHorizontalAlignment(JTextField.RIGHT);

		// Register listener with jbtUP button
		jbtUP.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						num--;
						if(num < 0)
						{
							num = 4;
						}
						jpImage.setImage(num);
						jpPoetry.setText();
					}
				});

		// Register listener with jbtDown button
		jbtDown.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						num++;
						if(num > 4)
						{
							num = 0;
						}
						jpImage.setImage(num);
						jpPoetry.setText();
					}
				});

		//the frame for warning
		warnFrame.setTitle("Warning");
		warnFrame.setLocation(700,300);
		warnFrame.setSize(200,230);
		warnFrame.add(jlbWarning);
		// Set  the label of warning
		java.net.URL urlWarning = this.getClass().getResource("image/warning.gif");
		assert urlWarning != null : "the warning.gif does not exits in image";//设置断言判断warning.gif是否存在
		jlbWarning.setIcon(new ImageIcon(urlWarning));
		jlbWarning.setHorizontalTextPosition(SwingConstants.CENTER);
		jlbWarning.setVerticalTextPosition(SwingConstants.BOTTOM);
		jlbWarning.setIconTextGap(8);
		jlbWarning.setFont(new Font("Serif", Font.BOLD, 14));
		jlbWarning.setForeground(Color.RED);
		// Register listener with jbtSure button
		jbtSure.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						//异常处理输入是否正确
						try
						{
							int number = Integer.parseInt(jtfNumber.getText());
							if(number >=1 && number <= 5)
							{
								num = number-1;
								jpImage.setImage(num);
						    jpPoetry.setText();
							}
							else
								throw new Exception();
						}
						catch(Exception ex)
						{
							jlbWarning.setText("Wrong entered : "+jtfNumber.getText());
							warnFrame.setVisible(true);
						}
						finally
						{
							setLog();
						}
					}
				});

	}
	/** write log */
	public void setLog() 
	{
		//异常处理输出日志
		try
		{
			// Construct a Gregorian calendar for the current date and time
			java.util.Calendar calendar = new java.util.GregorianCalendar();
			output = new PrintWriter("log.txt");
			output.println(calendar.get(Calendar.YEAR)
			+"年"+calendar.get(Calendar.MONTH)+"月"+calendar.get(Calendar.DATE)+"日  "+calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND));
			output.println("you entered is "+jtfNumber.getText());

		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			output.close();
		}
	}
	/**Main method*/
	public static void main(String[] args)
	{
		DisplayImage frame = new DisplayImage();
		frame.setTitle("Display images");
		frame.setLocation(40,40);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1100,660);
		frame.setVisible(true);
	}
} 
