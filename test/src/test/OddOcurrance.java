package test;

import java.util.HashSet;

public class OddOcurrance {
	public static void main(String[] args) {		
		int arr[]= {12,23,34,12,12,23,12,45};
		HashSet<Object> hs= new HashSet<>();
		for(int i=0;i<arr.length;i++) {
			int oddChk=arr[i];
			int cnt=0;
			for(int j=0;j<arr.length;j++) {
				int NextNum=arr[j];
				if(oddChk==NextNum) {
					cnt++;
				}			
			}
			//System.out.println(oddChk +": " +cnt);
			 hs.add(oddChk);
			 
			 int res=oddChk(cnt);
			 if(res==1) {
				 System.out.println(oddChk +": "+res );
			 }			 
		}
		//System.out.println(hs);
	}	
	public static int oddChk(int i) {
		int result = i%2;
		if(result == 1) {
			return 1;
		}
		return 0;
	}
	

}
