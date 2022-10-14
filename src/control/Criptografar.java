package control;

public class Criptografar {
	
	public String encriptar(String codigo, String texto) {
		
		String msgEncriptografada = "";
		
		// Passando a mensagem para Unicode
		int[] unicode = this.toUnicode(texto);
		int indexModificador = 0;
		int modificador;
		
		// Encriptografando
		for(int i = 0; i < unicode.length; i++) {
			if(indexModificador == codigo.length()) {
				indexModificador = 0;
			}
			String strModificador = String.valueOf(codigo.charAt(indexModificador));
			modificador = Integer.parseInt(strModificador);
			
			int novoUnicode = unicode[i] + modificador;
			String novaLetra = String.valueOf((char)novoUnicode);
			
			msgEncriptografada = msgEncriptografada.concat(novaLetra);
			indexModificador++;
		}
		
		return msgEncriptografada;
	}
	
	public String desencriptografar(String codigo, String texto) {
		
		String msgDescriptografada = "";
		
		// Passando a mensagem para Unicode
		int[] unicode = this.toUnicode(texto);
		int indexModificador = 0;
		int modificador;
		
		// Encriptografando
		for(int i = 0; i < unicode.length; i++) {
			if(indexModificador == codigo.length()) {
				indexModificador = 0;
			}
			String strModificador = String.valueOf(codigo.charAt(indexModificador));
			modificador = Integer.parseInt(strModificador);
			
			int novoUnicode = unicode[i] - modificador;
			String novaLetra = String.valueOf((char)novoUnicode);
			
			msgDescriptografada = msgDescriptografada.concat(novaLetra);
			indexModificador++;
		}
		return msgDescriptografada;
	}
	
	private int[] toUnicode(String mensagem) {
		int[] code = new int[mensagem.length()];
		
		for(int i = 0; i < mensagem.length(); i++) {
			code[i] = (int)mensagem.charAt(i);
		}
		return code;
	}
}