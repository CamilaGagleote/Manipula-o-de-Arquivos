package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArquivosController {

    public ArquivosController() {
        super();
    }


    public void readDir(String caminho) throws IOException {
        File diretorio = new File(caminho);

        if(diretorio.exists() && diretorio.isDirectory()) {

            File[] arquivos = diretorio.listFiles();

            for(File f : arquivos) {
                if(f.isFile()) {
                    System.out.println("     \t"+f.getName()); // nome do arquivo
                }else {
                    System.out.println("<DIR> |t"+ f.getName()); // vai ser um diretório
                }
            }
        } else {
            throw new IOException("Diretório Inválido");
        }
    }

    public void readFile(String caminho, String nome) throws IOException{

        File arq = new File(caminho, nome);
            if(arq.exists() && arq.isFile()) {
                FileInputStream fluxo = new FileInputStream(arq);

                InputStreamReader leitor = new InputStreamReader(fluxo);

                BufferedReader buffer = new BufferedReader(leitor);

                String linha = buffer.readLine();

                while(linha != null) {

                    String[] vetLinha = linha.split(",");
                    for(int i =0; i < 1; i++) {
                        if(linha.contains("Fruits")) {
                        	if(i==2)continue;
                            System.out.print("Fruta: " + vetLinha[0] + "               \tNome Cientifico: "+ vetLinha[1] + "               \tSubgrupo: "+ vetLinha[3] + "               \t");
              
                        }
                        linha = buffer.readLine();
                    }
                }

                fluxo.close();
                leitor.close();
                buffer.close();

            } else {
                throw new IOException("Arquivo inválido.");
            }

    }


}