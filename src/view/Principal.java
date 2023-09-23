package view;

import java.util.concurrent.Semaphore;

import controller.AtravessarCorredorThread;

public class Principal {

	public static void main(String[] args) {
		String pessoas[] = {"Joao", "Maria", "Jose", "Marcia"};
		Semaphore semaforo = new Semaphore(1);
		
		int tamanho = pessoas.length;
		for (int i = 0; i < tamanho; i++) {
			AtravessarCorredorThread atr = new AtravessarCorredorThread(pessoas[i], semaforo);
			atr.start();
		}
	}

}
