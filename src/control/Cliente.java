package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		
		Socket socket;
		InputStream canalEntrada;
		OutputStream canalSaida;
		BufferedReader entrada;
		PrintWriter saida;
		
		try {
			socket = new Socket("127.0.0.1", 4000);
			
			Criptografar criptografar = new Criptografar();
			
			canalEntrada = socket.getInputStream();
			canalSaida = socket.getOutputStream();

			entrada = new BufferedReader(new InputStreamReader(canalEntrada));
			saida = new PrintWriter(canalSaida, true);
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Digite uma mensagem: ");
			String mensagem = scan.nextLine();
			
			System.out.println("Digite o código para criptografar a mensagem(Use apenas números): ");
			String codigo = scan.nextLine();
			
			String mensagemCriptografada = criptografar.encriptar(codigo, mensagem);
			mensagemCriptografada = mensagemCriptografada.concat(":").concat(codigo);
			
			saida.println(mensagemCriptografada);
			
			String resultado = entrada.readLine();
			System.out.println(resultado);
			
			socket.close();
			scan.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}