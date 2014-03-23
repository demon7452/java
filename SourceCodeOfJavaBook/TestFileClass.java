public class TestFileClass
{
	public static void main(String[] args)
	{
		java.io.File file=new java.io.File("image/saber.jpg");
		System.out.println("does it exist?"+file.exists());
		System.out.println("can it be read?"+file.canRead());
		System.out.println("can it be written?"+file.canWrite());
		System.out.println("is it a directory?"+file.isDirectory());
		System.out.println("is it a file?"+file.isFile());
		System.out.println("is it a absolute?"+file.isAbsolute());
		System.out.println("is it a hidden?"+file.isHidden());
		System.out.println("absolute path is?"+file.getAbsolutePath());
		System.out.println("last modified on?"+new java.util.Date(file.lastModified()));
	}
}
