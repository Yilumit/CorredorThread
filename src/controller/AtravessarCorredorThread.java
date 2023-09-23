package controller;

import java.util.concurrent.Semaphore;

public class AtravessarCorredorThread extends Thread{
	private final int CORREDOR = 200;
	private String pessoa;
	private static Semaphore semaforo;
	public AtravessarCorredorThread(String pessoa, Semaphore semaforo) {
		this.pessoa = pessoa;
		AtravessarCorredorThread.semaforo = semaforo;
	}

	@Override
	public void run() {
		caminhar();
		chegou();
		try {
			semaforo.acquire();
			cruzarPorta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		
	}
	
	//Chegada no final do corredor
	private void chegou() {
		System.out.println(pessoa+" chegou na porta no final do corredor!");
	}
	
	//Cruzar porta
	private void cruzarPorta() {
		System.out.println(pessoa+" está abrindo e atravessando a porta...");
		int atravessar = (int)(Math.random()*1000)+1000;
		try {
			sleep(atravessar);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(pessoa+" atravessou a porta e ela se fechou");
	}
	
	//Caminhar pelo corredor
	private void caminhar() {
		int totalPercorrido = 0;
		
		System.out.println(pessoa+" começou a caminhar pelo corredor");
		while (totalPercorrido  < CORREDOR) {
			int caminhada = (int)(Math.random()*2)+4;
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			totalPercorrido += caminhada;
		}
	}
	
	

}
