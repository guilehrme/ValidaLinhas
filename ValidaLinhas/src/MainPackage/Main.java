package MainPackage;

import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;


public class Main {
	
        public static Scanner arquivo;
        public static void main(String[] args) throws IOException {
            ArrayList <String> array1 = new ArrayList<String>();
            try {
              arquivo = new Scanner(new FileReader("prog.txt"));
              
              while (arquivo.hasNextLine()){
            	  array1.add(arquivo.nextLine());
              }
            } catch (IOException e) {
                System.err.printf("Erro na abertura do arquivo: %s.\n",
                  e.getMessage());
            }
            FileWriter arquivoSaída = new FileWriter("prog-check.txt");
            PrintWriter gravaArquivo = new PrintWriter(arquivoSaída);
            int tamanho= array1.size();
            Stack<Character> listaChar = new Stack<Character>();
            for(int x = 0; x < tamanho; x++){
 

                boolean invalido = false;
                String array2 = array1.get(x).toString();                              
                System.out.println(array2);
                char abre_chave = '{';
                char fecha_chave = '}';
                char abre_colchete = '[';
                char fecha_colchete = ']';
                char abre_parenteses = '(';
                char fecha_parenteses = ')';
                char maior = '>';
                char menor = '<';
                
                for (int i = 0; i < array2.length(); i++){
                if (array2.charAt(i) == abre_colchete) {
                    listaChar.push(abre_colchete);
                }else if (array2.charAt(i) == abre_chave){
                    listaChar.push(abre_chave);
                }else if (array2.charAt(i) == menor){
                    listaChar.push(menor);
                }else if (array2.charAt(i) == abre_parenteses){
                    listaChar.push(abre_parenteses);
                }else if (array2.charAt(i) == fecha_colchete){
                    if (listaChar.isEmpty()){
                        invalido = true;
                        break;
                    }
                    if (listaChar.pop() != abre_colchete){
                        invalido = true;
                        break;
                    }
                }else if (array2.charAt(i) == fecha_chave){
                    if (listaChar.isEmpty()){
                        invalido = true;
                        break;
                    }
                    if (listaChar.pop() != abre_chave){
                        invalido = true;
                        break;
                    }              
                }else if (array2.charAt(i) == fecha_parenteses){
                    if (listaChar.isEmpty()){
                        invalido = true;
                        break;
                    }
                    if (listaChar.pop() != abre_parenteses){
                        invalido = true;
                        break;
                    }
                }else if (array2.charAt(i) == maior){
                    if (listaChar.isEmpty()){
                        invalido = true;
                        break;
                    }
                    if (listaChar.pop() != menor){
                        invalido = true;
                        break;
                    }              
                }    
            }           
                
            listaChar.clear();
            
            
            if (invalido == true){
            	array2 = array2 + " - Inválido";
            }
            else{
            	array2 = array2 + " - OK";
            }
            try{
                gravaArquivo.println(array2);
            }
            catch(Exception e){
                System.err.printf("Erro no salvamento do arquivo: %s.\n",
                  e.getMessage());
            }

        }
        arquivoSaída.close();
    }

}
