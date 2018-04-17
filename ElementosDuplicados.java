import java.util.Scanner;

public class ElementosDuplicados {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        String entrada = scanner.nextLine();
        String[] array = entrada.split(" ");
        int[] numeros = new int[array.length];
        for (int i = 0; i < array.length; i++) {
        	numeros[i] = Integer.valueOf(array[i]);
        }
        System.out.println(procuraDuplicado(numeros));
	}
	
	private static boolean procuraDuplicado(int[] numeros) {
		for(int i = 0; i < numeros.length; i++) {
        	for(int j = i + 1; j < numeros.length; j++) {
        		if(numeros[i] == numeros[j]) {
        			return true;
        		}
        	}
        }
		return false;
	}

}
