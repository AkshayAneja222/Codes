import java.io.*;

public class SubstringWithNoRepeat {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t--!=0) {
			String str = br.readLine();
			int[] freq = new int[26];
			char[] arr = str.toCharArray();
			int maxLength=0;
			int length=0;
			char[] output = new char[arr.length];
			
			for(int i=0;i<26;freq[i++]=0);
			for(int i=0;i<arr.length;output[i]=arr[i++]);
			int start =-1;
			
			for(int i=0;i<arr.length;i++) {
				char c =arr[i];
				
				if(freq[c-'a']>=1) {
					if(maxLength<length)
						maxLength=length;
					int begin=start;
					for(int j=begin;j<arr.length;j++) {
						start++;
						if(arr[j]!=c) {
							length--;
							freq[arr[j]-'a']--;
						}else {
							break;
						}
					}
				}else {
					freq[c-'a']++;
					length++;
					if(start==-1)
						start=i;
				}
			}
			if(maxLength<length)
				maxLength=length;
			System.out.println(maxLength);
		}
		br.close();
	}
}
