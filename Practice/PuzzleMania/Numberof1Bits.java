package PuzzleMania;

public class Numberof1Bits {
	public int hammingWeight(int n) {
        int count=0;
        String s=Integer.toBinaryString(n);
        System.out.println(s);
        int len=s.length();
        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            int b=Character.getNumericValue(c);
            if(b==1)
                count+=1;
        }
        System.out.println(count);
        return count;
    }
public static void main(String[] args) {
	Numberof1Bits p=new Numberof1Bits();
	p.hammingWeight(11);
}
}
