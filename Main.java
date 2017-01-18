import java.io.*;
import java.util.*;

public class Main
{
public static void main(String[] args)throws IOException
{

    long number = Long.parseLong(args[0]);
    String decimals[] = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    String places[] = {"", "", "hundred", "thousand", "lakh", "crore", "arab", "kharab"};
    String integers[] = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", 
    						"twelve", "thirteen", "fourteen", "fifteen",
							"sixteen", "seventeen", "eighteen", "ninteen", "twenty"};


	String answer = "";
	String temp = "";
	int i = 1;
	long num;
	while ( number != 0) {
		temp = "";
		if (i == 2) {
			// Special case for hundred
			num = number % 10L;
			number = number / 10L;
			if (num != 0)
			answer = integers[Math.round(num)] + " " + places[i] + " " + answer;
			i++;
			continue;
		}


	num = number % 100L;
	number = number / 100L;
	if (num == 0) {
		i++;
		continue;
	}


	if (num < 21) {
		// for 'teens' and single digited
		if (i == 1)
			temp = integers[Math.round(num)];
		else
			temp = integers[Math.round(num)] + " " + places[i];
	} else {
		temp = integers[Math.round(num % 10L)];
		num = num / 10L;
		temp = decimals[Math.round(num)] + " " + temp;
		temp = temp + " " + places[i];
	}

	answer  = temp + " " + answer;
	i++;
	}
	System.out.println();
	System.out.println(answer);
}
}