import java.awt.*;
import javax.swing.*;
import java.util.Random;
public class PoetryText extends JPanel
{
	private String text1 = "��������ģ�\n�Ӱ�һ�³���\n���˲������\nŭˢ����ǽ��\n�ܶ����μǣ�\n��н�ﲻ�ꡣ\n���������ᣬ\n��ʶ̷��ǿ��";

	private String text2 =" ����̫���\n����IT�С�\n�׷�ɭɭ����\n����ֱãã��\n������ʮ�֣�\n��һ���ó���\n��ʮ����ʱ��\n�޷�������";

	private String text3 =" �ճ��������Ҵ���\n����������б����\nª������ͽ�ıڣ�\n������������ϡ�";

	private String text4 ="���ٲ����£�\n��ͷ���æ�� ָ������䣬\n����ϸ˼����\n bugǧ�ٸ���\ncomment��һ�С� \n���������ף�\n�������˳���";

	private String text5 ="��ʱ�񷢱���룬\n��η����IT�С�\n��ʹ�ٻ�δ�ɽ���\n����coding�ֺη���";

	private String text6 ="���겻ʶ̷��ǿ��\n���ϻ������������У�\nΪ���������æ��\n����ʶ��Bugζ��\n�ൽ�ϳ���д����ģ�\n ȴ���Ӱ��ֺη���\n��Ҳǧ�У���Ҳǧ�С�"; 
	
	private JTextArea jta = new JTextArea(8,1);
	private Random random = new Random ();
	public PoetryText()
	{
			jta.setLineWrap(true);
			jta.setWrapStyleWord(true);
			jta.setEditable(false);
			jta.setForeground(Color.BLUE);
			jta.setFont(new Font("Courier",Font.BOLD,20));
			setText();
			add(jta);
	}

	/**set the text*/
	public void setText()
	{
			int number = random.nextInt(8);
			switch(number)
			{
				case 1:
					jta.setText(text1);
					break;
				case 2:
					jta.setText(text2);
					break;
				case 3:
					jta.setText(text3);
					break;
				case 4:
					jta.setText(text4);
					break;
				case 5:
					jta.setText(text5);
					break;
				default: jta.setText(text6);
			}
	}
}
