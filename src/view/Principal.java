package view;
import java.io.IOException;

import controller.ArquivosController;

public class Principal {

    public static void main(String[] args) {

        ArquivosController operacao = new ArquivosController();

        String caminho = "C:\\TEMP\\";
        String nome = "generic_food.csv";

        try {
            operacao.readFile(caminho, nome);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}