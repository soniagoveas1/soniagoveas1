public class InsertionSort{
  public static void main(String[] args) {
   int[] data = new int[10000];
   	for(int i = 0; i <= data.length-1; i++) {
      data[i] = ((int) (Math.random() * Integer.MAX_VALUE));
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
   int i;
   int j;
   int item;
   int n = data.length;
   for (i = 1; i < n; i++) {
       item = data[i];
       j = i - 1;
  while (j >= 0 && data[j] > item) {
     data[j + 1] = data[j];
       j = j - 1;
      }
	  data[j + 1] = item;
                }
        }
        private static void swap(int[] data, int minLocation, int i) {
                int temp = data[minLocation];
                data[minLocation] = data[i];
                data[i] = temp;
        }
}
