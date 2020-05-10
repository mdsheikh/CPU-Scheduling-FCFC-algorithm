
import java.util.Random;

public class randomGenerator {

	private Random randomGiver;
	
	public randomGenerator() {
		randomGiver=new Random();
		
	}
	
	public double randomDoubleGiver() {
		return  randomGiver.nextDouble();
		
	}
	public double randomGaussianGiver() {
		return  randomGiver.nextGaussian();
		
	}
	
}
