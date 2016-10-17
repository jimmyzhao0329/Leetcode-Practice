// https://segmentfault.com/a/1190000003794420

public class Solution extends Read4{
	public static int read(char[] buf, int n){
		for(int i = 0; i < n; i += 4){
			char[] temp = new char[4];
			int len = Read4(temp);
			System.arraycopy(temp, 0, buf, i, Math.min(n - i, len));
			if(len < 4){
				return Math.min(i + len, n);
			}
		}
	}
	return n;

	/* 
	Several possible cases:
	1, n is multiple of 4
	2, At the last time of using read4, the returned value is less than 4,
	   which means it reaches the end of file. We may only need part of this 
	   result, or we need all of them. So we use Math.min(n - i, len) to decide.
	3, n is larger than the file size. So we use Math.min(i + len, n).
	*/
}