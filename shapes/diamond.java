public static void diamond() {
    System.out.println("Diamond !");
      Scanner input = new Scanner (System.in);
      System.out.print("Enter height: ");
        int height = input.nextInt();
               for (int i = 1; i < height; i++){
        for (int j = 1; j < height - i; j++) {
            System.out.print(" ");
        }
        for (int j = 1; j < i * 2; j++) {
       System.out.print("*");
        }
    System.out.println();
      }
      for (int i = height - 1; i >=  1; i--) {
        for (int j = 1; j < height - i; j++) {
          System.out.print(" ");
        }
        for (int j = 1; j < i * 2; j++) {
          System.out.print("*");
        }
        System.out.println();
        
        }                
}
