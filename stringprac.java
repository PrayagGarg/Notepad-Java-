package pack2;

import java.util.Scanner;

public class stringprac {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String s=sc.nextLine();
	System.out.println(s.length());
	int j=0;
	
	for(int i=0;i<s.length();i++) {
		char ch=s.charAt(i);
		if(ch==' ' || ch=='\n') {
			j++;
		}
	}
	System.out.println(j);
}
}
