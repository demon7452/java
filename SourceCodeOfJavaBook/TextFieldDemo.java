import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextFieldDemo extends RadioButtonDemo
{
	//private JTextField jtfMessage=new JTextField(10);
	private JPasswordField jtfMessage=new JPasswordField(10);
	public TextFieldDemo()
	{
		jtfMessage.setEchoChar('*');
		JPanel jpTextField=new JPanel();
		jpTextField.setLayout(new BorderLayout(15,0));
		jpTextField.add(new JLabel("enter a new message"),BorderLayout.WEST);
		jpTextField.add(jtfMessage,BorderLayout.CENTER);
		add(jpTextField,BorderLayout.NORTH);

		jtfMessage.setHorizontalAlignment(SwingConstants.RIGHT);

		jtfMessage.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						messagePanel.setMessage(jtfMessage.getText());
						//jtfMessage.requestFocusInWindow();
					}
				});
	}
	public static void main(String[] args)
	{
		TextFieldDemo frame=new TextFieldDemo();
		frame.setTitle("text field demo");
		frame.pack();
		//	frame.setSize(500,500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
