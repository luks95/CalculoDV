package algoritmo;

public class CalculoDigitoVerificador {
	
	/*
	 * El metodo debe recibir el R.U.C. en tipo de dato String e Integer, los mismo valores deben de ser cargados a una
	 * variable antes de pasar al metodo de calculo
	 * 
	 * */
	public static int calculandoDigito(String pNumero, int pBasemax) {
	    int vTotal, vResto, k, vNumeroAux, vDigit;
	    String vNumeroAl = "";

	    for (int i = 0; i < pNumero.length(); i++) {
	            char c = pNumero.charAt(i);
	            if(Character.isDigit(c)) {
	                    vNumeroAl += c;
	            } else {
	                    vNumeroAl += (int) c;
	            }
	    }

	    k = 2;
	    vTotal = 0;

	    for(int i = vNumeroAl.length() - 1; i >= 0; i--) {
	            k = k > pBasemax ? 2 : k;
	            vNumeroAux = vNumeroAl.charAt(i) - 48;
	            vTotal += vNumeroAux * k++;
	    }

	    vResto = vTotal % 11;
	    vDigit = vResto > 1 ? 11 - vResto : 0;

	    return vDigit;
	}
}
