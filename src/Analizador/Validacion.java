package Analizador;

public class Validacion {

	static public void checarSiExisteToken(Identificador variable) {
		for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
			if(lexer.tablaSimbolos.get(j).getName().equals(variable.getName())) {
				imprimeRaya();
				System.out.println("Linea: "+variable.getPosicion()+" Error: La variable "+variable.getName()+" ya habia sido declarada con un tipo: "+lexer.tablaSimbolos.get(j).getTipoDato());
			}
		}	

	}

	static public void validaTipos(Identificador var) {
		String tipoDato=var.getTipoDato();
		String valor=var.getValor();
		if(tipoDato.equals("int")){
			try {
				Integer.parseInt(valor);
			} catch (Exception e) {
				imprimeRaya();
				System.out.println("Linea: "+var.getPosicion()+" error en el Identificador "+var.getName()+",porque este valor no es Entero(Int) - Debes utilizar el Tipo de Dato: "+var.getTipoDato());
			}
		}
		if(tipoDato.equals("double")) {
			try {
				Double.parseDouble(valor);
			} catch (Exception e) {
				imprimeRaya();
				System.out.println("Linea: "+var.getPosicion()+" error en el Identificador "+var.getName()+",porque este valor no es Double- Debes utilizar el Tipo de Dato: "+var.getTipoDato());

			}
		}
		if(tipoDato.equals("string")){
			try {
				if(valor.startsWith("")&&valor.endsWith("\"")) {
					// System.out.println("String valido");
				}else {
					imprimeRaya();
					System.out.println("Linea: "+var.getPosicion()+" error en el Identificador "+var.getName()+" porque este no es un string debes utilizar comillas dobles: "+"\"Cadena de Ejemplo\"");
				}
			} catch (Exception e) {
				System.out.println("Error en la linea "+var.getPosicion()+" de tipo: "+e.getMessage());
			}

		}

		if(tipoDato.equals("boolean")) {
			if (valor.equals("true") || valor.equals("false")) {
				//System.out.println("Booleano correcto"); prueba unitaria
			}else {
				imprimeRaya();
				System.out.println("Linea: "+var.getPosicion()+" error en el Identificador "+var.getName()+" porque este no es un Boolean debes utilizar: "+"true, false");
			}
		}

	}

	static public void checarComparacionValores(String a, String b, int linea) {
		try {
			if(!a.isEmpty() && !b.isEmpty()) {
				try {
					if(isIntero(a)==true && isIntero(b)==true) {
						//System.out.println("Los dos son Entero");
					}else if(esDouble(a)==true && esDouble(b)==true) {
						//System.out.println("Los dos son Double");
					}else {
						System.out.println("Linea: "+linea+" error en tipo de dato");
					}
				} catch (Exception e) {
					System.out.println("Linea: "+linea+ "error"+e.getMessage());
				}
			}
		} catch (Exception e) {
			System.out.println("Linea: "+linea+" error"+e.getMessage());
		}
	}

	public static boolean isIntero(String num){
		try{
			Integer.parseInt(num);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}

	public static boolean esDouble(String num){
		try{
			Double.parseDouble(num);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}


	public static boolean esBoolean(String valor){
		if(valor.equals("true") ||valor.equals("false")) {
			return true;
		}else {
			return false;
		}
	}


	public static void obtenerDatoComparacion(String a, String b, int linea) {

		String temp1="";
		for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
			if(lexer.tablaSimbolos.get(j).getName().equals(a)) {
				temp1=lexer.tablaSimbolos.get(j).getTipoDato();
			}
		}
		if(temp1.isEmpty()) {
			System.out.println("Linea: "+linea+" error: la variable "+a+" no esta declarada");
			imprimeRaya();
		}
		for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
			if(lexer.tablaSimbolos.get(j).getName().equals(a)) {
				imprimeRaya();
				if(isIntero(b)==true && lexer.tablaSimbolos.get(j).getTipoDato().equals("int")) {
					System.out.println("Linea: "+linea+" comparacion valida "+lexer.tablaSimbolos.get(j).getTipoDato());
				}else if(esDouble(b)==true && lexer.tablaSimbolos.get(j).getTipoDato().equals("double")){
					System.out.println("Linea: "+linea+" comparacion valida "+lexer.tablaSimbolos.get(j).getTipoDato());
				}else if(esBoolean(b)==true && lexer.tablaSimbolos.get(j).getTipoDato().equals("boolean")){
					System.out.println("Linea: "+linea+" comparacion valida "+lexer.tablaSimbolos.get(j).getTipoDato());
				}else {
					System.out.println("Linea: "+linea+" error: comparacion invalida: "+b+" no es de tipo: "+lexer.tablaSimbolos.get(j).getTipoDato());

					
				}
				System.out.println("La variable "+a+" es de tipo: "+lexer.tablaSimbolos.get(j).getTipoDato());
				imprimeRaya();
			}
		}
	}

	public static void obtenerDatoComparacion2(String a, String b,int linea) {
		String temp1="";
		for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
			if(lexer.tablaSimbolos.get(j).getName().equals(a)) {
				temp1=lexer.tablaSimbolos.get(j).getTipoDato();
			}
		}
		if(temp1.isEmpty()) {
			System.out.println("Linea: "+linea+" error: la variable "+a+" no esta declarada");
			imprimeRaya();
		}
		for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
			if(lexer.tablaSimbolos.get(j).getName().equals(a)) {
				imprimeRaya();
				
				if(isIntero(b)==true && lexer.tablaSimbolos.get(j).getTipoDato().equals("int")) {
					System.out.println("Linea: "+linea+" comparacion valida "+lexer.tablaSimbolos.get(j).getTipoDato());
				}else if(esDouble(b)==true && lexer.tablaSimbolos.get(j).getTipoDato().equals("double")){
					System.out.println("Linea: "+linea+" comparacion valida "+lexer.tablaSimbolos.get(j).getTipoDato());
				}else if(esBoolean(b)==true && lexer.tablaSimbolos.get(j).getTipoDato().equals("boolean")){
					System.out.println("Linea: "+linea+" comparacion valida "+lexer.tablaSimbolos.get(j).getTipoDato());
				}else {
					System.out.println("Linea: "+linea+" error: comparacion invalida: "+b+" no es de tipo: "+lexer.tablaSimbolos.get(j).getTipoDato());
				}
				System.out.println("La variable "+a+" es de tipo: "+lexer.tablaSimbolos.get(j).getTipoDato());
				imprimeRaya();
			}
		}	

	}

	public static void obtenerDatoComparacion3(String a, String b, int linea) {
		String temp1="";
		String temp2="";
		for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
			if(lexer.tablaSimbolos.get(j).getName().equals(a)) {
				temp1=lexer.tablaSimbolos.get(j).getTipoDato();
			}
		}
		for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
			if(lexer.tablaSimbolos.get(j).getName().equals(b)) {
				temp2=lexer.tablaSimbolos.get(j).getTipoDato();
			}
		}
		if(temp1.isEmpty()) {
			System.out.println("Linea: "+linea+" error: la variable "+a+" no esta declarada");
			imprimeRaya();
		}
		if(temp2.isEmpty()) {
			System.out.println("Linea: "+linea+" error: la variable "+b+" no esta declarada");
			imprimeRaya();
		}
		if(!temp1.isEmpty() && !temp2.isEmpty() && !temp1.equals(temp2)) {
			imprimeRaya();
			System.out.println("Linea: "+linea+" error: las variables: "+a+" y "+b+" no son del mismo tipo");
			System.out.println("La variable: "+a+" es de tipo: "+temp1);
			System.out.println("La variable: "+b+" es de tipo: "+temp2);
			imprimeRaya();
		}
	}


	static public void verifTipoAignacion(String tipoDato, String valor, String identificador, int linea) {
		if(tipoDato.equals("int")){
			try {
				Integer.parseInt(valor);
				for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
					if(lexer.tablaSimbolos.get(j).getName().equals(identificador)) {
						lexer.tablaSimbolos.get(j).setValor(valor);
					}
				}
			} catch (Exception e) {
				imprimeRaya();
				System.out.println("Linea: "+linea+" IMPOSIBLE DE ASIGNAR: Error en el Identificador "+identificador+",puesto que este valor no es Entero(Int) - Debes utilizar el Tipo de Dato: "+tipoDato);
			}
		}
		if(tipoDato.equals("double")) {
			try {
				Double.parseDouble(valor);
				for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
					if(lexer.tablaSimbolos.get(j).getName().equals(identificador)) {
						lexer.tablaSimbolos.get(j).setValor(valor);
					}
				}
			} catch (Exception e) {
				imprimeRaya();
				System.out.println("Linea: "+linea+" IMPOSIBLE DE ASIGNAR: Error en el Identificador "+identificador+",puesto que este valor no es Double- Debes utilizar el Tipo de Dato: "+tipoDato);

			}
		}
		if(tipoDato.equals("string")){
			try {
				if(valor.startsWith("")&&valor.endsWith("\"")) {
					for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
						if(lexer.tablaSimbolos.get(j).getName().equals(identificador)) {
							lexer.tablaSimbolos.get(j).setValor(valor);
						}
					}
				}else {
					imprimeRaya();
					System.out.println("Linea: "+linea+" IMPOSIBLE DE ASIGNAR: Error en el Identificador "+identificador+" puesto que este no es un string debes utilizar comillas dobles: "+"\"Cadena de Ejemplo\"");
				}
			} catch (Exception e) {
				System.out.println("Linea: "+linea+" error: "+e.getMessage());
			}

		}

		if(tipoDato.equals("boolean")) {
			if (valor.equals("true") || valor.equals("false")) {
				for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
					if(lexer.tablaSimbolos.get(j).getName().equals(identificador)) {
						lexer.tablaSimbolos.get(j).setValor(valor);
					}
				}
			}else {
				imprimeRaya();
				System.out.println("Linea: "+linea+" IMPOSIBLE DE ASIGNAR: Error en el Identificador "+identificador+" puesto que intentaste asignar un valor NO BOOLEANO, debes utilizar: "+"true, false");
			}
		}

	}

	public static void asignaVarDentro(String identificador, String valor, int linea) {
		String temp1;
		boolean bandera=false;
		for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
			if(lexer.tablaSimbolos.get(j).getName().equals(identificador)) {
				bandera=true;
				temp1=lexer.tablaSimbolos.get(j).getTipoDato();
				verifTipoAignacion(temp1, valor, identificador, linea);
				if(esBoolean(valor)==true && temp1.equals("boolean")) {
					imprimeRaya();
					System.out.println("Linea: "+linea+"  asignacion booleana correcta en: "+identificador);
				}else if(isIntero(valor)==true && temp1.equals("int")){
					imprimeRaya();
					System.out.println("Linea: "+linea+"  asignacion int correcta en: "+identificador);
				}else if(esDouble(valor)==true && temp1.equals("double")){
					imprimeRaya();
					System.out.println("Linea: "+linea+"  asignacion double correcta en: "+identificador);
				}
			}

		}
		if(bandera==false) {
			imprimeRaya();
			System.out.println("Linea: "+linea+" error: la variable: "+identificador+" no se encuentra declarada y no se puede asignar");
		}
	}
	
	public static void imprimeRaya(){
		System.out.println("--------------------------------------------------------------------------------------------------------");
	}
}