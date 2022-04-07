import java.rmi.registry.*;
import java.util.Scanner;

public class HelloClient {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		double a,b,c,soma;
		try {
			Registry registry = LocateRegistry.getRegistry("localhost");
			Hello stub= (Hello) registry.lookup("Servidor");

			System.out.println("Invocando metodo do servidor");
			
			System.out.println("Digite o valor do primeiro numero: ");
			a = Double.parseDouble(read.next());
			
			System.out.println("Digite o valor do segundo numero: ");
			b = Double.parseDouble(read.next());
			
			System.out.println("Digite o valor do terceiro numero: ");
			c = Double.parseDouble(read.next());
			
			soma = stub.soma(a, b, c);
			System.out.println("Servidor informa: O valor da adição é  " + soma);
			
			read.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}
}