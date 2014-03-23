import java.awt.*;
import javax.swing.*;

public class TestFigurePanel extends JFrame
{
	public TestFigurePanel()
	{
		setLayout(new GridLayout(2,3,5,5));
		add(new FigurePanel(FigurePanel.LINE));
		add(new FigurePanel(FigurePanel.RECTANGLE));
		add(new FigurePanel(FigurePanel.ROUND_RECTANGLE));
		add(new FigurePanel(FigurePanel.OVAL));
		add(new FigurePanel(FigurePanel.RECTANGLE,true));
		FigurePanel panel=new FigurePanel(FigurePanel.ROUND_RECTANGLE,true);
		JButton jbt=new JButton("ok");
		panel.setLayout(new BorderLayout());
		panel.add(jbt,BorderLayout.CENTER);
		add(panel);
	}
	public static void main(String[] args)
	{
		TestFigurePanel frame=new TestFigurePanel();
		frame.setTitle("test figure panel");
		frame.setSize(400,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
