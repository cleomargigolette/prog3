
public class Uteis {

	/*
	 * Inicialmente, o primeiro número do array é o menor número. Após, o
	 * algoritmo verifica cada numero do array e atualiza a variável menorNumero
	 * com o próximo menor número encontrado.
	 */
	public static int menorNumero(int[] numeros) {
		
		int menorNumero = numeros[0];
		
		for (int i = 0; i < numeros.length; i++) {
			if(numeros[i] < menorNumero) {
				menorNumero = numeros[i];
			}
		}
		
		return menorNumero;
		
	}

	/*
	 * Inicialmente, o primeiro n�mero do array � o maior n�mero. Ap�s, o
	 * algoritmo verifica cada n�mero do array e atualiza a vari�vel maiorNumero 
	 * com o pr�ximo maior n�mero encontrado. 
	 */
	public static int maiorNumero(int[] numeros) {
		
		int maiorNumero = numeros[0];
		
		for (int i = 0; i < numeros.length; i++) {
			if(numeros[i] > maiorNumero) {
				maiorNumero = numeros[i];
			}
		}
		
		return maiorNumero;
		
	}
	
}
