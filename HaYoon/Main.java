package birthday_5635;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int n;
		n = sc.nextInt();
		
		Birth[] birth = new Birth[n];
		// List<Birthday> arr = new ArrayList<Birthday>();

		for(int i=0; i<n; i++) {
			
			String name = sc.next();
			int day = sc.nextInt();
			int month = sc.nextInt();
			int year = sc.nextInt();			
			
			Birth b = new Birth(name, day, month, year);
			birth[i] = b;
			//arr.add(my);
			
			birth[i].name = name;
			birth[i].day = day;
			birth[i].month = month;
			birth[i].year = year;
		};
		
		sc.close();
		
		Birth[] sort = selectionSort(birth, n);
		
		
		System.out.println(sort[n-1].name);
		System.out.println(sort[0].name);
			
	}
	
	public static void swap(Birth change[], int idx1, int idx2) {  
		  Birth temp = change[idx1];
	      change[idx1] = change[idx2];
	      change[idx2] = temp;
	 }    
	
	public static Birth[] selectionSort(Birth[] birth, int n) {
		Birth max;
		int index;
		
		for(int i=n; i>1; i--) {
			
			max = birth[0];
			index = 0;
			//System.out.println("i: " + i + " max: " + max.year);
			for(int j=1; j<i; j++) {

				//System.out.println("j: " + j);
				
				if(max.year < birth[j].year) {
					max = birth[j];
					index = j;
					//System.out.println("max: " + max.year);
				}
				if(max.year == birth[j].year) {
					if(max.month < birth[j].month) {
						max = birth[j];
						index = j;
					}
					if(max.month == birth[j].month) {
						if(max.day < birth[j].day) {
							max = birth[j];
							index = j;
						}
					}
				}
			}
			//System.out.println("index: " + index + " i: " + i);
			if(index != i-1) {
				//System.out.println("swap start");
				swap(birth, index, i-1);
			}
			
		}
		return birth;
	}
	
}

class Birth {
		
	String name;
	int day;
	int month;
	int year;
		
	
	public Birth(String name, int day, int month, int year) {
		super();
		this.name = name;
		this.day = day;
		this.month = month;
		this.year = year;
	}
		


	public Birth() {
	}


}
