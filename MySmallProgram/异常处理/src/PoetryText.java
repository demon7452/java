import java.awt.*;
import javax.swing.*;
import java.util.Random;
public class PoetryText extends JPanel
{
	private String text1 = "需求三天改，\n加班一月长。\n家人不相见，\n怒刷进度墙。\n奋斗需牢记，\n调薪语不详。\n此中辛酸泪，\n恨识谭浩强。";

	private String text2 =" 年少太轻狂，\n误入IT行。\n白发森森立，\n两眼直茫茫。\n语言数十种，\n无一称擅长。\n三十而立时，\n无房单身郎";

	private String text3 =" 日出东隅照我床，\n悠悠青龙倚斜阳。\n陋室区区徒四壁，\n代码行行正铿锵。";

	private String text4 ="年少不经事，\n埋头编程忙。 指键铿锵落，\n不及细思量。\n bug千百个，\ncomment无一行。 \n休言敏捷易，\n做来断人肠。";

	private String text5 ="少时狂发编程想，\n无畏赴身IT行。\n纵使荣华未可近，\n我自coding又何妨！";

	private String text6 ="少年不识谭浩强，\n爱上机房。郎误入行，\n为赋新码调试忙。\n而今识尽Bug味，\n编到断肠，写到天荒，\n 却道加班又何妨，\n汗也千行，泪也千行。"; 
	
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
