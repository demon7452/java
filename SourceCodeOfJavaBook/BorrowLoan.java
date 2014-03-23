import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BorrowLoan 
{
	public static void main(String[] args)
	{
		JFrame frame=new JFrame();
		FlowLayout layout=new FlowLayout();
		frame.setLayout(layout);

		JButton jbt=new JButton("Borrow Loan");
		frame.add(jbt);

		Listener l=new Listener();
		jbt.addActionListener(l);

		frame.setTitle("Loan Test");
		frame.setSize(200,150);
		frame.setLocation(400,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
class Listener implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		String nameString=JOptionPane.showInputDialog("enter the fullname");
		String[] tokens=nameString.split("\\s");
		String firstname=tokens[0];
		char mi=tokens[1].charAt(0);
		String lastname=tokens[2];
		Name name=new Name(firstname,mi,lastname);

		Address address=new Address("100 main street","savannah","GA","31419");

		Loan loan=new Loan(5.5,15,20000);

		Borrower borrower=new Borrower(name,address);
		borrower.setLoan(loan);

		JOptionPane.showMessageDialog(null,borrower.toString());
	}
}
