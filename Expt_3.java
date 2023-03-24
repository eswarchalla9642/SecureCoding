
import java.util.Scanner;
class Test4{
	public static final String alpha="abcdefghijklmnopqrstuvwxyzabcdefghijk";
	String key,plain,temp,plainTemp="";
	int a,b,c;
	Test4(String key ,String plain)
	{
		this.key=key;
		this.plain=plain;
	}
	void keyMakeUp()
	{
		a=plain.length();
		b=key.length();
		if (a==b)
		{
			String w=encrydecry(key,plain);
			String x=encrydecry(key,w);
			System.out.println(w);
			System.out.println(x);;
			
		}
		else {
			String temp=key;
			c=a-b;
			
			int j=0;
			for(int i=0;i<c;i++)
			{
				temp=temp+key.charAt(j);
				j++;
				if(j>=b)
					j=0;
			}
			key=temp;
			
			String w=encrydecry(key,plain);
			String x=encrydecry(key,w);
			System.out.println(w);
			System.out.println(x);;
		}
	}
	String encrydecry(String ch, String ph)
	{
		String cipher="";
		for(int i=0;i<key.length();i++)
		{
			String p = Integer.toBinaryString(alpha.indexOf(ch.charAt(i)));
			String q = Integer.toBinaryString(alpha.indexOf(ph.charAt(i)));
			//System.out.println(p+"	"+q);
			String ans = "";
			int z=p.length();
			int y=q.length(),w;
			if (z>y) {
				w=z-y;
				for (int j = 0; j < w; j++)
		        {
		             q= "0" + q;
		        }
			}
			else {
				w=y-z;
				for (int j = 0; j < w; j++)
		        {
		            p = "0" + p;
		        }
			}
			
		   // System.out.println(p+" "+q);
	        for (int k = 0; k <p.length() ; k++)
	        {
	            // If the Character matches
	            if (p.charAt(k) == q.charAt(k))
	                ans += "0";
	            else
	                ans += "1";
	        }
	        
	        //System.out.println(ans);
	        int l = Integer.parseInt(ans,2); 
	        ans="";
	        cipher+=alpha.charAt(l);
		}
		
		return cipher;
	
}
	
}
public class Expt_3 {

	public static void main(String[] args) {
		
		String key,plain;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter key text");
		key=s.next();
		System.out.println("Enter plain Text");
		plain=s.next();
		Test4 t = new Test4(key,plain);
		t.keyMakeUp();
		s.close();
	}

}