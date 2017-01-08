package com.sort;

import java.util.Scanner;

public class Counting {
	private int[] arr;
	private int[] count;
	private int[] count_plus;
	private int[] result;
	private int max = 0;

	public void setInfo() {//숫자 입력
        /*Scanner sc = new Scanner(System.in);
        //System.out.println("입력할 숫자개수를 입력하세요 :");
        int size = sc.nextInt();
        arr = new int[size];
       // System.out.println("숫자를 차례대로 입력하세요 :");
        for (int i = 0; i < arr.length; i++) {
            int num = sc.nextInt();
            arr[i] = num;
        }*/
        
        int[] arr = {10, 5, 2, 2, 1, 4};
        result(arr);
    }

	public int findMax(int[] arr){	//최대값 찾아서 count함수의 길이와 배열값 생성
		for(int i=0; i<arr.length; i++){
			if(max <= arr[i]){
				max = arr[i];
			}
		}
		
		/*System.out.println("max " +max);*/
		return max;
	}
	
	public int[] count(int[] arr){	//arr배열의 숫자 카운팅해서 count배열에 넣어주는 함수 
		count = new int[findMax(arr)+1];
		
		for(int i=0; i<arr.length; i++){
			count[arr[i]]++;
		}
		
		/*System.out.println("count[]");
		for(int i=0; i<count.length; i++){
			System.out.println(count[i]);
		}*/
		return count;
	}
	
	public int[] count_plus(int[] arr){	//count_plus에 수열로 count값 누적시켜 생성
		count_plus = count(arr);
		
		for(int i=1; i<count_plus.length; i++){
			count_plus[i] = count_plus[i-1] + count_plus[i];
		}
		
		/*System.out.println("count_plus[]");
		for(int i=0; i<count_plus.length; i++){
			System.out.println(count_plus[i]);
		}*/
		return count_plus;
	}
	
	public void result(int[] arr){
		count_plus(arr);
		
		result = new int[arr.length];
		
		for(int i=0; i<arr.length; i++){
			result[count_plus[arr[i]]-1] = arr[i];
			
			System.out.println(result[count_plus[arr[i]]-1]+"+"+arr[i]);
			System.out.println("result[1] = "+arr[1]);
			System.out.println("result[1] = "+result[1]);
		}
		System.out.println(result[1]);
		for(int i=0; i<result.length; i++){
			System.out.println(result[i]);
		}
		
		//printInfo();
	}
	
	public void printInfo(){
		System.out.println("result[]");
		for(int i=0; i<result.length; i++){
			System.out.println(result[i]);
		}
	}
	
	public static void main(String[] args) {	
		Counting co = new Counting();
		co.setInfo();
	}

}
