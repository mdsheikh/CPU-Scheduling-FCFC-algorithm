
public class Assignment1 {

    public static void main(String[] args) {
    	
        if (args.length != 4) {
            System.out.print("Enter Values for n, k, d, and v.");
            System.exit(1);
            
        try {
            int n = Integer.parseInt(args[0]);
            int k = Integer.parseInt(args[1]);
            int d = Integer.parseInt(args[2]);
            int v = Integer.parseInt(args[3]);

            Simulator sim = new Simulator(n, k, d, v);
        } catch (IllegalArgumentException IAE) {
            System.out.println("Please enter valid values for n, k, d, and v");
        }
        
         
      }
  }
}