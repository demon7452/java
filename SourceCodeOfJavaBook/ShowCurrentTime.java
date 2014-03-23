import javax.swing.JOptionPane;
public class ShowCurrentTime{
	public static void main(String[] args){
		long totalmilliseconds=System.currentTimeMillis();
		System.out.println(totalmilliseconds);
		long totalseconds=totalmilliseconds/1000;
		
		int currentsecond=(int)(totalseconds%60);
		
		long totalminutes=totalmilliseconds/60000;
		int currentminutes=(int)(totalminutes%60);
		
		long totalhours=totalmilliseconds/3600000;
		System.out.println(totalhours);
		int currenthour=(int)(totalhours%24);
		
		String output="current time is "+currenthour+":"+currentminutes+":"+currentsecond+" GMT";
		JOptionPane.showMessageDialog(null,output);
	}
}