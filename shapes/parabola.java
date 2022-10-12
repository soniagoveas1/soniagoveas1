public static void parabola() {
  System.out.println("Parabola !");
      Scanner input = new Scanner (System.in);
      System.out.print("Enter height: ");
        int p = input.nextInt();
  for (int i = 0; i<p; i++) {
      for (int k = 0; k < Math.pow(2,p) - Math.pow(2,i); k++) {
        System.out.print(" ");
      }
      for (int j = 0; j < Math.pow(2, i); j++) {
        System.out.print("*");
      }
      for (int l = 0; l < Math.pow(2, i) - 1; l++) {
        System.out.print("*");
      }
        System.out.println();
  			}
		}
}
