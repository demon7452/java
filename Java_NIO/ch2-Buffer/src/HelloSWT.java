import javax.swing.JButton;
import javax.swing.JLabel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
/**
 * SWT learning
 * @author demon7452
 * @version 2014-10-10
 */
public class HelloSWT
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Display display = new Display();//Display类用于直接调用系统资源
		Shell shell = new Shell(display);//shell窗口对象
		
//		Shell shell2 = new Shell(display);
//		shell2.setText("shell2");
//		shell2.setImage(display.getSystemImage(org.eclipse.swt.SWT.ICON_ERROR));
		
		shell.setText("first swt");
		shell.setImage(display.getSystemImage(org.eclipse.swt.SWT.ICON_ERROR));//display调用系统图标
		
		//CLabel是label的升级控件，可以显示图片;初始化时必须依赖一个shell对象
		CLabel label = new CLabel(shell, org.eclipse.swt.SWT.LEFT);
		label.setImage(display.getSystemImage(org.eclipse.swt.SWT.ICON_INFORMATION));
		label.setText("Hello SWT\n");
		label.pack();
		
//		CLabel label2 = new CLabel(shell,SWT.LEFT_TO_RIGHT);
//		label2.setText("label2");
//		label2.pack();
		
		
		shell.setSize(200, 200);
		shell.open();

		while(!shell.isDisposed())
		{
			//销毁资源
			if(display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

}
