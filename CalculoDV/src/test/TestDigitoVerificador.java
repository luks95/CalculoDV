package test;

import algoritmo.CalculoDigitoVerificador;

public class TestDigitoVerificador {

	private static int digitoFinal;

	public static void main(String[] args) {
		int cedula= 0;
		String cedulaChar = cedula+"";
		digitoFinal = CalculoDigitoVerificador.calculandoDigito(cedulaChar, cedula);
		System.out.println(digitoFinal);
		
	}

}
