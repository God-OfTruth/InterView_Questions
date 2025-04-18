package leet_code;

public class _11 {
	public static void main(String[] args) {
		System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
	}
	public static int maxArea(int[] height) {
		int res = 0;
		int left = 0;
		int right = height.length-1;

		while(left != right){
			int area = (right-left) * Math.min(height[left], height[right]);
			res = Math.max(res, area);
			if(height[left]< height[right]){
				left++;
			} else {
				right--;
			}
		}

		return res;
	}
}
