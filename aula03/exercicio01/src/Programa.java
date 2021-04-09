
public class Programa {

	public static void main(String[] args) {
		
		int[] numeros = new int[10];
		numeros[0] = 21;
		numeros[1] = 3;
		numeros[2] = 7;
		numeros[3] = 2;
		numeros[4] = 4;
		numeros[5] = 9;
		numeros[6] = 6;
		numeros[7] = 45;
		numeros[8] = 79;
		numeros[9] = 27;
		
		int maiorNumero = Uteis.maiorNumero(numeros);
		int menorNumero = Uteis.menorNumero(numeros);
		
		System.out.println("maior numero:" + maiorNumero);
		System.out.println("menor numero:" + menorNumero);

	}

	

}
