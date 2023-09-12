public class Selection {
	public static void main(String[] args) {
     int[] data = new int[args.length];
     for(int i = 0; i <= data.length-1; i++) {
       data[i] = Integer.parseInt(args[i]);
          }
       sort(data);
     for(int i = 0; i <= data.length-1; i++) {
        System.out.println(data[i]);
          }
        }
 
 private static void sort(int[] data) {
	 int i;
	 int j;
	 int minLocation;
     int n = data.length;
    	
	for(i = 0; i <= n - 2; i++) {
      minLocation = i;
     for(j = i + 1; j <= n - 1; j++) {
        if(data[j] < data[minLocation]) {
           minLocation = j;
           swap(data, minLocation, i);
     	  }
  	  }
	}  
 }
        
private static void swap(int[] data, int minLocation, int i) {
	int temp = data[minLocation];
	data[minLocation] = data[i];
	data[i] = temp;
        }
}
