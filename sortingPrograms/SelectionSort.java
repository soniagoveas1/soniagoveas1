import java.util.Random;
public class SelectionSort {
   public static void main(String[] args) {
	  int[] data = new int[10000];
       for(int i = 0; i <= data.length - 1; i++) {
         data[i] = (int)(Math.random() * Integer.MAX_VALUE;
                }
               
     final long START_TIME = System.currentTimeMillis();
     sort(data);
     final long END_TIME = System.currentTimeMillis();
	 System.out.printf("%f\n", (END_TIME - START_TIME)/1000.0);
                
	for(int i = 0; i <= data.length-2; i++) {
       if(data[i] > data[i+1])
          System.err.println("ERROR, index " + i);
                }
        }
      
	 private static void sort(int[] data) {    
        int i = 0;
		int j = 0;
        int n = data.length;
       for(i = 0; i <= n-2; i++) {
          for(j = i+1; j <= n-1; j++) {
            if(data[j] < data[i])
               swap(data, i, j);
           }
          }
        }
		
 private static void swap(int[] data, int minLocation, int i) {
    int temp = data[minLocation];
    data[minLocation] = data[i];
    data[i] = temp;
        }
}
