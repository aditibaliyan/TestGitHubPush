package com.in28minutes.junit;

public class myMath {

	int calculateSum(int[] nums) {
		int sum=0;
		for(int n:nums) {
			sum+=n;
		}
		return sum;
	}
}
