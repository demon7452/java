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
		//������
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
		JButton analyse1 = new JButton("��һ�ַ���");
		JButton analyse2 = new JButton("�ڶ��ַ���");
		JButton decision1 = new JButton("��һ�ַ������");
		JButton decision2 = new JButton("�ڶ��ַ������");
		JButton totalDecision = new JButton("����������");

		p2a.add(analyse1);
		p2a.add(analyse2);
		p2b.add(totalDecision);

		//��һ�ַ���
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
		JButton jbtSure = new JButton("ȷ��");
		firstP1a.add(new JLabel(icon2));
		firstP1b.setLayout(new GridLayout(3,1,10,10));
		firstP1b.add(new JLabel("Ͷ����Ŀ����Ϊ������(X)?"));
		firstP1b.add(jtfYear);
		firstP1b.add(jbtSure);
		firstP1.add(firstP1a,BorderLayout.CENTER);
		firstP1.add(firstP1b,BorderLayout.EAST);
		firstAnalyse.add(firstP1,BorderLayout.CENTER);
		firstAnalyse.add(decision1,BorderLayout.SOUTH);
		firstAnalyse.setTitle("��һ�ַ���");
		firstAnalyse.setLocation(160,170);
		firstAnalyse.pack();
		//ȷ����ť
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
		JLabel jlMin = new JLabel("B-1����B�ĵȼ۷���");
		jlMin.setFont(new Font("Serif",Font.BOLD,40));
		minYear.add(jlMin);	
		minYear.setTitle("�жϽ��");
		minYear.setLocation(100,110);
		minYear.setSize(500,200);
		JLabel jlbTrue = new JLabel("B-1�ȼ���B����");
		jlbTrue.setFont(new Font("Serif",Font.BOLD,40));
		trueYear.add(jlbTrue);	
		trueYear.setTitle("�жϽ��");
		trueYear.setLocation(100,110);
		trueYear.setSize(500,200);

		JLabel jlMax = new JLabel("B-1��������B����");
		jlMax.setFont(new Font("Serif",Font.BOLD,40));
		maxYear.add(jlMax);	
		maxYear.setTitle("�жϽ��");
		maxYear.setLocation(110,120);
		maxYear.setSize(500,200);
		
		//��һ�ַ������
		decision1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						firstDecision.setVisible(true);
					}
				});
		firstDecision.add(new JLabel(icon3),BorderLayout.CENTER);
		JLabel jlbDecision1 = new JLabel("��ͬ�������£�����B.1(=B)���ڷ���A,���Ծ�����ѡ�񷽰�B");
		jlbDecision1.setFont(new Font("Serif",Font.BOLD,40));
		jlbDecision1.setForeground(Color.RED);
		firstDecision.add(jlbDecision1,BorderLayout.SOUTH);
		firstDecision.setTitle("��һ�ַ������");
		firstDecision.setLocationRelativeTo(null);
		firstDecision.setLocation(40,160);
		firstDecision.pack();

		//�ڶ��ַ���
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
		secondP2b.add(new JLabel("Ͷ������������(Y)?"));
		secondP2b.add(jtfAddYear);
		JButton jbtSure2 = new JButton("ȷ��");
		secondP2b.add(jbtSure2);
		secondAnalyse.add(secondP1,BorderLayout.NORTH);
		secondAnalyse.add(secondP2,BorderLayout.CENTER);
		secondAnalyse.add(decision2,BorderLayout.SOUTH);
		secondAnalyse.setLocation(120,20);
		secondAnalyse.setTitle("�ڶ��ַ���");
		secondAnalyse.pack();
		//�ڶ���ȷ����ť
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
		JLabel jlbSecondMin = new JLabel("����B-2���ڷ���B�����Ƿ���B����");
		jlbSecondMin.setFont(new Font("Serif",Font.BOLD,40));
		secondMinYear.add(jlbSecondMin);	
		secondMinYear.setTitle("�жϽ��");
		secondMinYear.setLocation(130,140);
		secondMinYear.setSize(500,200);

		JLabel jlbSecondTrue = new JLabel("����B-2�Ƿ���B�ĵȼ۷���");
		jlbSecondTrue.setFont(new Font("Serif",Font.BOLD,40));
		secondTrueYear.add(jlbSecondTrue);	
		secondTrueYear.setTitle("�жϽ��");
		secondTrueYear.setLocation(130,140);
		secondTrueYear.setSize(700,200);

		JLabel jlbSecondMax = new JLabel("����B-2���ڷ���B������B�ĵȼ۷���");
		jlbSecondMax.setFont(new Font("Serif",Font.BOLD,40));
		secondMaxYear.add(jlbSecondMax);	
		secondMaxYear.setTitle("�жϽ��");
		secondMaxYear.setLocation(140,150);
		secondMaxYear.setSize(900,200);
		//�ڶ��ַ������
		decision2.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						secondDecision.setVisible(true);
					}
				});
		secondDecision.add(new JLabel(icon6),BorderLayout.CENTER);
		JLabel jlbDecision2 = new JLabel("�ȽϿɵã�����B���ڷ���A!");
		jlbDecision2.setFont(new Font("Serif",Font.BOLD,40));
		jlbDecision2.setForeground(Color.RED);
		secondDecision.add(jlbDecision2,BorderLayout.SOUTH);
		secondDecision.setTitle("�ڶ��ַ������");
		secondDecision.setLocation(150,20);
		secondDecision.pack();

		
		/**����������*/
		totalDecision.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						result.setVisible(true);
					}
				});
		result.setLayout(new GridLayout(3,1,10,10));
		JLabel jlbResult1 = new JLabel("��һ�ַ������������B���ڷ���A");
		JLabel jlbResult2 = new JLabel("�ڶ��ַ������������B���ڷ���A");
		JLabel jlbResult = new JLabel("������������������Ϸ���B���ڷ���A");
		jlbResult.setFont(new Font("Serif",Font.BOLD,40));
		jlbResult.setForeground(Color.RED);
		jlbResult1.setFont(new Font("Serif",Font.BOLD,40));
		jlbResult1.setForeground(Color.RED);
		jlbResult2.setFont(new Font("Serif",Font.BOLD,40));
		jlbResult2.setForeground(Color.RED);
		result.add(jlbResult1);
		result.add(jlbResult2);
		result.add(jlbResult);
		result.setTitle("����������");
		result.setLocation(140,80);
		result.pack();
	}
	public static void main(String[] args)
	{
		Decision frame = new Decision();
		frame.setTitle("��Ŀ������¼����Ծ��߷�����Ӧ��");
		frame.setLocation(90,100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
