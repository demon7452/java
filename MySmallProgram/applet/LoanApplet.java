import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class LoanApplet extends JApplet
{
	//declare and create text fields for interst rate
	//year, loan amount, monthly payment, and total payment
	private JTextField jtfAnnualInterestRate = new JTextField();
	private JTextField jtfNumberOfYears = new JTextField();
	private JTextField jtfLoanAmount = new JTextField();
	private JTextField jtfMonthlyPayment = new JTextField();
	private JTextField jtfTotalPayment = new JTextField();

	//declare and create a compute payment button
	private JButton jbtComputeLoan = new JButton("Compute payment");

	public static void main(String[] args)
	{
		//create a frame
		JFrame frame = new JFrame();
		
		//create an instance of the applet
		LoanApplet applet = new LoanApplet();

		//add applet to the frame
		frame.add(applet,BorderLayout.CENTER);

		//Invoke init and start;
		applet.init();
	

		//Display the frame
		frame.setTitle("add the main to applet");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	/** Initialize user interface */
	public void init()
	{
		//set properties on the text fields
		jtfMonthlyPayment.setEditable(false);
		jtfTotalPayment.setEditable(false);

		//panel p1 to hold labels and text fields
		JPanel p1 = new JPanel(new GridLayout(5,2));
		p1.add(new JLabel("Annual interest rate"));
		p1.add(jtfAnnualInterestRate);
		p1.add(new JLabel("Number of years"));
		p1.add(jtfNumberOfYears);
		p1.add(new JLabel("Loan amount"));
		p1.add(jtfLoanAmount);
		p1.add(new JLabel("Monthly payment"));
		p1.add(jtfMonthlyPayment);
		p1.add(new JLabel("Total payment"));
		p1.add(jtfTotalPayment);
		p1.setBorder(new TitledBorder("Enter interest rate, year and loan amount"));

		//Right align text fields
		jtfAnnualInterestRate.setHorizontalAlignment(JTextField.RIGHT);
		jtfNumberOfYears.setHorizontalAlignment(JTextField.RIGHT);
		jtfLoanAmount.setHorizontalAlignment(JTextField.RIGHT);
		jtfMonthlyPayment.setHorizontalAlignment(JTextField.RIGHT);
		jtfTotalPayment.setHorizontalAlignment(JTextField.RIGHT);

		//panel p2 to hold the button 
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p2.add(jbtComputeLoan);

		//add the components to the applet
		add(p1,BorderLayout.CENTER);
		add(p2,BorderLayout.SOUTH);

		//register button listener
		jbtComputeLoan.addActionListener(new ButtonListener());
	}
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
				//get values from text fields
						double interst = Double.parseDouble(jtfAnnualInterestRate.getText());
						int year = Integer.parseInt(jtfNumberOfYears.getText());
						double loanAmount = Double.parseDouble(jtfLoanAmount.getText());

						//create a loan object
						Loan loan = new Loan(interst, year, loanAmount);

						//display monthly payment and total payment
						//jtfMonthlyPayment.setText(String.format("%.2f",loan.getMonthlyPayment()));
						//jtfTotalPayment.setText(String.format("%.2f",loan.getTotalPayment()));
						jtfMonthlyPayment.setText(String.format("%.2f",loan.getMonthlyPayment()));
						jtfTotalPayment.setText(String.format("%.2f",loan.getTotalPayment()));
						
		}
	}
}

