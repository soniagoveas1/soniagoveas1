//Sonia Goveas, 09/15/23
public class ShiftedBinarySearchStarterCode{
    
    //takes in array of strings
    public static void main(String[] args){
        int[] arr1 = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        int ret0 = shiftedSearchIndex(arr1, 0);
        System.out.println("Here we should get -1, and we do get: " + ret0);
        int ret7 = shiftedSearchIndex(arr1, 7);
        System.out.println("Here we should get 0 and we do get: " + ret7);
    }

    //https://www.baeldung.com/java-binary-search: help with structure
    //takes in array and target value which we want to find
    //function that checks whether target exists within given array
    public static int shiftedSearchIndex(int[] nums, int target){
      
        //based on typical binary search vars
        int left = 0; 
        int right = nums.length - 1;
        
        //bounds meet at smallest element index
        //loop breaks when smallest element is found
        while(left < right){
            
            //finding the midpoint
            int mid = left + (right - left)/2;

            //checks if middle element > element to the right
            //deals with the array not being sorted, since this is a shifted search
            //typical binary search deals with a sorted array
            if(nums[mid] > nums[right]){

                //we know middle element is not the smallest, therefore mid+1
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int start = left; 
        left = 0;
        right = nums.length - 1;

        //checks if arr is sorted
        if(target >= nums[start] && target <= nums[right]){
            left = start;

        //if not sorted, set right bound to start to search other side
        } else {
            right = start;
        }

        //follows reg binary search alg
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            
            //checks which side target is on
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        //if not found, we return '-1'
        return -1;
    }
}

