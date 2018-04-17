import java.util.Scanner;

public class FuraFila {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        String entrada = scanner.nextLine();
        String[] array = entrada.split(" ");
        int[] numeros = new int[array.length];
        for (int i = 0; i < array.length; i++) {
        	numeros[i] = Integer.valueOf(array[i]);
        }
        
	}
	
	private static void reordenada(int[] numeros, int indice) {
		int inicio = 0;
		for (int i = indice; i < numeros.length; i++) {
			int atual = numeros[i];
			
			for (int j = indice + i; j <= 0; j--) {
				int aux = numeros[j];
				numeros[j] = numeros[i];
			}
			
		}
	}

}
