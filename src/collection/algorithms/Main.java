package collection.algorithms;

import java.math.BigDecimal;

public class Main
{
	public static void main(String[] argv) throws Exception
	{
		int decimalPlaces = 2;
		BigDecimal bd = new BigDecimal("123456789.00");

		bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_DOWN);
		String string = bd.toString();
		System.out.println(string);
	}
}
