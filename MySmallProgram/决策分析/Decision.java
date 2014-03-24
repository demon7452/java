import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Decision extends JFrame
{
	private ImageIcon icon = new ImageIcon("image/1.jpg");
	private JFrame firstAnalyse = new JFrame();
	private ImageIcon icon2 = new ImageIcon("image/2.jpg");
	private JFrame firstDecision = new JFrame();
	private ImageIcon icon3 = new ImageIcon("image/3.jpg");
	private	JTextField jtfYear = new JTextField();
	private JFrame minYear = new JFrame();
	private JFrame maxYear = new JFrame();
	private JFrame trueYear = new JFrame();
	private ImageIcon icon4 = new ImageIcon("image/4.jpg");
	private ImageIcon icon5 = new ImageIcon("image/5.jpg");
	private ImageIcon icon6 = new ImageIcon("image/6.jpg");
	private ImageIcon icon7 = new ImageIcon("image/7.jpg");
	private ImageIcon icon8 = new ImageIcon("image/8.jpg");

	private JFrame secondAnalyse = new JFrame();
	private JFrame secondDecision = new JFrame();
	private JTextField jtfAddYear = new JTextField();
	private JFrame secondMinYear = new JFrame();
	private JFrame secondMaxYear = new JFrame();
	private JFrame secondTrueYear = new JFrame();


	private JFrame result = new JFrame();

	public Decision()
	{
		//主界面
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p2a = new JPanel();
		JPanel p2b = new JPanel();
		add(p1,BorderLayout.CENTER);
		add(p2,BorderLayout.SOUTH);

		p1.add(new JLabel(icon));
		p2.setLayout(new GridLayout(2,1,5,5));
		p2.add(p2a);
		p2.add(p2b);
		p2a.setLayout(new GridLayout(1,2,10,10));
		JButton analyse1 = new JButton("第一轮分析");
		JButton analyse2 = new JButton("第二轮分析");
		JButton decision1 = new JButton("第一轮分析结果");
		JButton decision2 = new JButton("第二轮分析结果");
		JButton totalDecision = new JButton("总体分析结果");

		p2a.add(analyse1);
		p2a.add(analyse2);
		p2b.add(totalDecision);

		//第一轮分析
		analyse1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						firstAnalyse.setVisible(true);
					}
				});
		JPanel firstP1 = new JPanel();
		JPanel firstP1a = new JPanel();
		JPanel firstP1b = new JPanel();
		JButton jbtSure = new JButton("确定");
		firstP1a.add(new JLabel(icon2));
		firstP1b.setLayout(new GridLayout(3,1,10,10));
		firstP1b.add(new JLabel("投资项目寿命为多少年(X)?"));
		firstP1b.add(jtfYear);
		firstP1b.add(jbtSure);
		firstP1.add(firstP1a,BorderLayout.CENTER);
		firstP1.add(firstP1b,BorderLayout.EAST);
		firstAnalyse.add(firstP1,BorderLayout.CENTER);
		firstAnalyse.add(decision1,BorderLayout.SOUTH);
		firstAnalyse.setTitle("第一轮分析");
		firstAnalyse.setLocation(160,170);
		firstAnalyse.pack();
		//确定按钮
		jbtSure.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						int year = Integer.parseInt(jtfYear.getText());
						if(year < 15)
						{
							minYear.setVisible(true);					
						}
						else if(year == 15)
						{
							trueYear.setVisible(true);
						}
						else
						{
							maxYear.setVisible(true);					
						}
					}
				});
		JLabel jlMin = new JLabel("B-1不是B的等价方案");
		jlMin.setFont(new Font("Serif",Font.BOLD,40));
		minYear.add(jlMin);	
		minYear.setTitle("判断结果");
		minYear.setLocation(100,110);
		minYear.setSize(500,200);
		JLabel jlbTrue = new JLabel("B-1等价于B方案");
		jlbTrue.setFont(new Font("Serif",Font.BOLD,40));
		trueYear.add(jlbTrue);	
		trueYear.setTitle("判断结果");
		trueYear.setLocation(100,110);
		trueYear.setSize(500,200);

		JLabel jlMax = new JLabel("B-1方案优于B方案");
		jlMax.setFont(new Font("Serif",Font.BOLD,40));
		maxYear.add(jlMax);	
		maxYear.setTitle("判断结果");
		maxYear.setLocation(110,120);
		maxYear.setSize(500,200);
		
		//第一轮分析结果
		decision1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						firstDecision.setVisible(true);
					}
				});
		firstDecision.add(new JLabel(icon3),BorderLayout.CENTER);
		JLabel jlbDecision1 = new JLabel("在同等条件下，方案B.1(=B)优于方案A,所以决策者选择方案B");
		jlbDecision1.setFont(new Font("Serif",Font.BOLD,40));
		jlbDecision1.setForeground(Color.RED);
		firstDecision.add(jlbDecision1,BorderLayout.SOUTH);
		firstDecision.setTitle("第一轮分析结果");
		firstDecision.setLocationRelativeTo(null);
		firstDecision.setLocation(40,160);
		firstDecision.pack();

		//第二轮分析
		analyse2.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						secondAnalyse.setVisible(true);
					}
				});
		JPanel secondP1 = new JPanel();
		secondP1.add(new JLabel(icon4));
		JPanel secondP2 = new JPanel();
		JPanel secondP2a = new JPanel();
		JPanel secondP2b = new JPanel();
		secondP2.add(secondP2a,BorderLayout.CENTER);
		secondP2.add(secondP2b,BorderLayout.EAST);
		secondP2a.add(new JLabel(icon5));
		secondP2b.setLayout(new GridLayout(3,1,10,10));
		secondP2b.add(new JLabel("投资寿命多少年(Y)?"));
		secondP2b.add(jtfAddYear);
		JButton jbtSure2 = new JButton("确定");
		secondP2b.add(jbtSure2);
		secondAnalyse.add(secondP1,BorderLayout.NORTH);
		secondAnalyse.add(secondP2,BorderLayout.CENTER);
		secondAnalyse.add(decision2,BorderLayout.SOUTH);
		secondAnalyse.setLocation(120,20);
		secondAnalyse.setTitle("第二轮分析");
		secondAnalyse.pack();
		//第二轮确定按钮
		jbtSure2.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						int addYear = Integer.parseInt(jtfAddYear.getText());
						if(addYear > 5)
						{
							secondMaxYear.setVisible(true);
						}
						else if(addYear == 5)
						{
							secondTrueYear.setVisible(true);
						}
						else 
						{
							secondMinYear.setVisible(true);
						}
					}
				});
		JLabel jlbSecondMin = new JLabel("方案B-2劣于方案B，不是方案B方案");
		jlbSecondMin.setFont(new Font("Serif",Font.BOLD,40));
		secondMinYear.add(jlbSecondMin);	
		secondMinYear.setTitle("判断结果");
		secondMinYear.setLocation(130,140);
		secondMinYear.setSize(500,200);

		JLabel jlbSecondTrue = new JLabel("方案B-2是方案B的等价方案");
		jlbSecondTrue.setFont(new Font("Serif",Font.BOLD,40));
		secondTrueYear.add(jlbSecondTrue);	
		secondTrueYear.setTitle("判断结果");
		secondTrueYear.setLocation(130,140);
		secondTrueYear.setSize(700,200);

		JLabel jlbSecondMax = new JLabel("方案B-2优于方案B，不是B的等价方案");
		jlbSecondMax.setFont(new Font("Serif",Font.BOLD,40));
		secondMaxYear.add(jlbSecondMax);	
		secondMaxYear.setTitle("判断结果");
		secondMaxYear.setLocation(140,150);
		secondMaxYear.setSize(900,200);
		//第二轮分析结果
		decision2.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						secondDecision.setVisible(true);
					}
				});
		secondDecision.add(new JLabel(icon6),BorderLayout.CENTER);
		JLabel jlbDecision2 = new JLabel("比较可得，方案B优于方案A!");
		jlbDecision2.setFont(new Font("Serif",Font.BOLD,40));
		jlbDecision2.setForeground(Color.RED);
		secondDecision.add(jlbDecision2,BorderLayout.SOUTH);
		secondDecision.setTitle("第二轮分析结果");
		secondDecision.setLocation(150,20);
		secondDecision.pack();

		
		/**总体分析结果*/
		totalDecision.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						result.setVisible(true);
					}
				});
		result.setLayout(new GridLayout(3,1,10,10));
		JLabel jlbResult1 = new JLabel("第一轮分析结果：方案B优于方案A");
		JLabel jlbResult2 = new JLabel("第二轮分析结果：方案B优于方案A");
		JLabel jlbResult = new JLabel("分析结果表明：总体上方案B优于方案A");
		jlbResult.setFont(new Font("Serif",Font.BOLD,40));
		jlbResult.setForeground(Color.RED);
		jlbResult1.setFont(new Font("Serif",Font.BOLD,40));
		jlbResult1.setForeground(Color.RED);
		jlbResult2.setFont(new Font("Serif",Font.BOLD,40));
		jlbResult2.setForeground(Color.RED);
		result.add(jlbResult1);
		result.add(jlbResult2);
		result.add(jlbResult);
		result.setTitle("总体分析结果");
		result.setLocation(140,80);
		result.pack();
	}
	public static void main(String[] args)
	{
		Decision frame = new Decision();
		frame.setTitle("多目标决策下假设性决策分析的应用");
		frame.setLocation(90,100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
