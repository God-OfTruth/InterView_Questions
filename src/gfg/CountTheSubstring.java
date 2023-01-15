package gfg;

public class CountTheSubstring {
	public static void main(String[] args) {
		String s = "1111";
		System.out.println(countSubstring(s));
	}
	static long countSubstring(String s){
		int n = s.length();
		long ans = 0;
		int track = 0;
		int zero = n;
		int[] k = new int[2*n+3];
		int curr = n;
		for (int i=0; i<n; i++){
			if (s.charAt(i)=='0') curr--;
			else curr++;
			if (curr<=zero) track++;
			k[curr]++;
		}
		for (int i=0; i<n; i++){
			ans+= (n-i-track);
			if (s.charAt(i) == '1'){
				k[zero+1]--;
				zero++;
				track+=k[zero];
			} else {
				k[zero-1]--;
				zero--;
				track -= k[zero+1];
				track--;
			}
		}
		return ans;
	}
}
