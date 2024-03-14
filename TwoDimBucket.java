//Sonia Goveas, 08/31/23
public class TwoDimBucketStarterCode {
    
    //takes in array of strings
    public static void main(String[] args) {
        int[] heights = {1, 3, 4};
        System.out.println("max area should be 3, and it is " + findMaxArea(heights));
    }

    //function that finds greatest area
    public static int findMaxArea(int[] height) {
        int max = 0;
        //taking one height at a time
        int left = 0;
        int right = height.length - 1;

        //line 17: https://favtutor.com/blogs/container-with-most-water
        //idea for 'left' & 'right' pointers found on website above
        while(left < right) {
            
            //using Math function, finds the min between the left and right heights
            //this allows us to make the "bucket"
            int min = Math.min(height[left], height[right]);

            //base of "bucket" is distance between left and right
            int width = right - left;
            
            int area = min * width;

            //finding the max between the given values
            max = Math.max(max, area);

            //loops through array, if left height < right height, check for larger height
            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
 