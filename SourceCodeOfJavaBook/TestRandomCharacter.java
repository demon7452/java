public class TestRandomCharacter
{
	public static void main(String[] args)
	{
		final int Number_of_chars=201;
		final int Chars_for_line=25;
		
		for(int i=1;i<Number_of_chars;i++)
		{
			char ch=RandomCharacter.getRandomLowerCaseLetter();
			if(i%Chars_for_line==0)
				System.out.printf("%3c\n",ch);
			else
				System.out.printf("%3c",ch);
		}
		for(int i=1;i<Number_of_chars;i++)
		{
			char ch=RandomCharacter.getRandomUpperCaseLetter();
			if(i%Chars_for_line==0)
				System.out.printf("%3c\n",ch);
			else
				System.out.printf("%3c",ch);
		}
		for(int i=1;i<Number_of_chars;i++)
		{
			char ch=RandomCharacter.getRandomDigitCharacter();
			if(i%Chars_for_line==0)
				System.out.printf("%3c\n",ch);
			else
				System.out.printf("%3c",ch);
		}
		for(int i=1;i<Number_of_chars;i++)
		{
			char ch=RandomCharacter.getRandomCharacter();
			if(i%Chars_for_line==0)
				System.out.printf("%5c\n",ch);
			else
				System.out.printf("%5c",ch);
		}
	}

}

class RandomCharacter
{
	public static char getRandomCharacter(char ch1,char ch2)
	{
		return (char)(ch1+Math.random()*(ch2-ch1+1));
	}
	public static char getRandomLowerCaseLetter()
	{
		return getRandomCharacter('a','z');
	}
	public static char getRandomUpperCaseLetter()
	{
		return getRandomCharacter('A','Z');
	}
	public static char getRandomDigitCharacter()
	{
		return getRandomCharacter('0','9');
	}
	public static char getRandomCharacter()
	{
		return getRandomCharacter('\u0000','\uFFFF');
	}
}
