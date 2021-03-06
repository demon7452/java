import javax.swing.*;
import java.net.URL;
import java.applet.*;
import java.awt.*;

public class DisplayImagePlayAudio extends JApplet
{
	private AudioClip audioClip;

	public DisplayImagePlayAudio()
	{
		URL urlForImage = getClass().getResource("1.gif");
		add(new JLabel(new ImageIcon(urlForImage)));

		URL urlForAudio = getClass().getResource("audio.wav");
		audioClip = Applet.newAudioClip(urlForAudio);
		audioClip.loop();
	}

	public void start()
	{
		if(audioClip != null)
			audioClip.loop();
	}

	public void stop()
	{
		if(audioClip != null)
			audioClip.loop();
	}
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		DisplayImagePlayAudio applet = new DisplayImagePlayAudio();

		frame.add(applet,BorderLayout.CENTER);

		applet.init();

		frame.setTitle("Display image play audio");
		frame.setLocation(400,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
}
