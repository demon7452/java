import javax.swing.*;
import java.awt.*;

class DescriptionPanel extends JPanel
{
	private JLabel jlbImageTitle=new JLabel();
	private JTextArea jtaDescription=new JTextArea();

	public DescriptionPanel()
	{
		jlbImageTitle.setHorizontalAlignment(JLabel.CENTER);
		jlbImageTitle.setHorizontalTextPosition(JLabel.CENTER);
		jlbImageTitle.setVerticalTextPosition(JLabel.BOTTOM);

		jtaDescription.setLineWrap(true);
		jtaDescription.setWrapStyleWord(true);
		jtaDescription.setEditable(false);
	
		jlbImageTitle.setFont(new Font("SansSerif",Font.BOLD,20));
		jtaDescription.setFont(new Font("Serif",Font.PLAIN,16));

		JScrollPane scrollPane=new JScrollPane(jtaDescription);
		setLayout(new BorderLayout(5,5));
		add(jlbImageTitle,BorderLayout.WEST);
		add(scrollPane,BorderLayout.CENTER);
	}
	public void setTitle(String title)
	{
		jlbImageTitle.setText(title);
	}
	public void setImageIcon(ImageIcon icon)
	{
		jlbImageTitle.setIcon(icon);
	}
	public void setDescription(String text)
	{
		jtaDescription.setText(text);
	}
}
public class TextAreaDemo extends JFrame
{
	private DescriptionPanel descriptionPanel=new DescriptionPanel();
	public TextAreaDemo()
	{
		descriptionPanel.setTitle("Saber");
		//descriptionPanel.setImageIcon(new ImageIcon("image/3.jpg"));
		descriptionPanel.setImageIcon(new ImageIcon("image/1.gif"));
		String description="The test of text area\n\n saber is the beauty i like best.It was the best of times;it was the worst of times;it was the age of wisdom;"+
												"it was the age of foolishness;it was the epoch of belief,it was the epoch of incredulity;it was the season of light,it was the season of"+
												"darkness;it was the spring of hope,it was the winter of despair;we had everything before us,we had nothing before us;we were all going di"
												+"rect to Heaven,we were all going direct the other way.";
		descriptionPanel.setDescription(description);
		setLayout(new BorderLayout());
		add(descriptionPanel,BorderLayout.CENTER);
	}
	public static void main(String[] args)
	{
		TextAreaDemo frame=new TextAreaDemo();
		frame.setTitle("text area demo");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
