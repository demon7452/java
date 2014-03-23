public class PrimeNumber
{
	public static void main(String[] args)
	{
		final int NUMBER_OF_PRIMES=50;
		final int NUMBER_OF_PRIMES_PER_LINE=10;
		int count=0;
		int number=2;
		while(count<NUMBER_OF_PRIMES)
		{
			boolean isPrime=true;
			for(int divisor=2;divisor<=number/2;divisor++)
			{
				if(number%divisor==0)
				{
					isPrime=false;
					break;
				}			
			}
			if(isPrime)
			{
				if((count-0)%NUMBER_OF_PRIMES_PER_LINE==0)
					System.out.printf("\n%5d",number);
				else
					System.out.printf("%5d",number);
				count++;
			}
			number++;
		}
		System.out.println();
	}
}