package Wrestler_1900;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 다 비교해서 제일 능력치 쎈 얘를 앞으로.. 근데 이게 흠.. 버블정렬을 해야 됨.. 
		// 넘어가면 index++ 정렬은 index순으로...
		// Wrestler 객체에 힘, 마술링, index가 있어야 됨
		// 버블정렬을 하면서 힘 + (상대힘*마술링)이 크면 뒤로 이동하면서 index++
		// https://sewonkimm.github.io/algorithm/2020/12/30/BOJ1900.html 나랑 비슷하게 풀었는데 해결 방법을 안알려줌..
		// 코테.. 내가 할 수 있을까?...
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		List<Wrestler> arr = new ArrayList<Wrestler>();
		
		for(int i = 0; i < n; i++) {
			Wrestler wrestler = new Wrestler();
			
			wrestler.number = i+1;
			wrestler.power = sc.nextInt();
			wrestler.magic = sc.nextInt();
			
			arr.add(wrestler);
		}
		
		bubleSort(arr);

		
		arr.sort(Comparator.naturalOrder());
		
		for(int i = 0; i < n; i++) 
			System.out.println(arr.get(i).number);
	}
	
	public static void bubleSort(List<Wrestler> arr) {
	    for(int i = 0; i < arr.size(); i++) {
	        for(int j = 0 ; j < arr.size() - i - 1 ; j++) {
	        	int Wrestlerr1 = arr.get(j).power + arr.get(j+1).power * arr.get(j).magic;
	        	int Wrestlerr2 = arr.get(j+1).power + arr.get(j).power * arr.get(j+1).magic;
	            if( Wrestlerr1 > Wrestlerr2) {
	            	Wrestler w1 = arr.get(j);
	            	Wrestler w2 = arr.get(j+1);

	            	Wrestler tmp = arr.get(j);
	            	arr.add(j, w2);
	            	arr.remove(j+1);
	            	arr.add(j+1, w1);
	            	arr.remove(j+2);
	            	
	            	arr.get(j).index++;	            	
	            }
	        }
	    }
	}
}

class Wrestler implements Comparable<Wrestler>{
	int number;
	int power;
	int magic;
	int index = 0;
	
	@Override
	public int compareTo(Wrestler o) {
		if(o.index > this.index){
			return -1;
		} else if(o.index < this.index){
			return 1;
		} 
		return -1;
	}
}

