// https://segmentfault.com/a/1190000003794420

public class read4II extends Read4{

	Queue<Character> q = new LinkedList<Character>();

	public static int readII(char[] buf, int n){
		int i = 0;

		while(i < n && !q.isEmpty()){
			buf[i++] = q.poll();
		}

		for( ; i < n; i += 4){
			char[] temp = new char[4];
			int len = read4(temp);

			if(len > n - i) { //there are some extra bytes than needed
				System.arraycopy(temp, 0, buf, i, n - i);

				//store extra bytes into queue for further use
				for(int j = n - i; j < len; j++){
					q.offer(temp[j]);
				}
			}
			else{
				System.arraycopy(temp, 0, buf, i, len);
			}
		}

		if(len < 4){
			return Math.min(i + len, n);
		}
		return n;
	}
}