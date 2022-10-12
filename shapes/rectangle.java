 public static void rectangle() {
    System.out.println("Rectangle !");
     Scanner input = new Scanner(System.in);
     System.out.print("Enter length: ");
     int length = input.nextInt();
     System.out.print("Enter width: ");
     int width = input.nextInt();
      for (int i = 0; i < length; i++){
        for (int j = 0; j < width; j++) {
            System.out.print("*");
        }
        System.out.println();
      }
  }
