/**
 * output the  key of vi plugin
 * @author demon7452
 * @version 2014-9-18
 */
public class OutputKey
{
	public static void main(String[] args) throws Exception 
	{
 
		CheckLicenseFile licenseFile = new CheckLicenseFile();
		String valueString = licenseFile.encrypt("demon7452", "demon7452");
		System.out.println(valueString);//输出结果：YJsZ-AQTb_Z6LLjmAcupVk7ngPKUO2rYQBKgbm1WGi4
	}
 }
