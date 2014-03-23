public class DisplayTime{
	public static void main(String[] args){
		int seconds=500;
		int minutes=seconds/60;
		int remainseconds=seconds%60;
	javax.swing.JOptionPane.showMessageDialog(null,seconds+" seconds is "+minutes+" minutes and "+remainseconds+" seconds!");
	
	}
}