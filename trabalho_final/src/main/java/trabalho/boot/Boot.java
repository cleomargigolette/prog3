package trabalho.boot;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import trabalho.gui.menu.ControladorMenu;

public class Boot {

	public static void main(String[] args){
		
		executar();
		
	}

	public static void executar(){

		Logger.getRootLogger().setLevel(Level.OFF); //desabilita logs no console
		
		exibeAbertura();
		new ControladorMenu().executar();
		exibeEncerramento();
		
	}
	
	public static void exibeAbertura() {
		
		System.out.println();
		System.out.println();
		System.out.println("****** LOJAS TABAJARAS ******");
		System.out.println("Versão: 1.0.0");
		System.out.println();
		System.out.println();
		
	}
	
	public static void exibeEncerramento() {
		
		System.out.println();
		System.out.println();
		System.out.println("****** O SOFTWARE FOI ENCERRADO. ******");
		System.out.println();
		System.out.println();
		
	}
	
}
