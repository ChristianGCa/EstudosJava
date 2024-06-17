package br.edu.unijui.pcn.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Esta classe implementa uma thread para localizar indices de isolamento
 * social.
 *
 * @author <seu nome aqui>
 */
public class IsolationFinderThread extends Thread {

    private final String FILE_NAME;
    private String linhaMaiorIsolamento;
    private String linhaMenorIsolamento;
    private String estadoSelecionado;

    public IsolationFinderThread(String fileName, String estadoSelecionado) {
        this.FILE_NAME = fileName;
        // removendo a uf dos estado selecionado
        this.estadoSelecionado = estadoSelecionado;
    }

    @Override
    public void run() {
        // Implemente aqui seu código
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            double highestIndex = -1.0;
            double lowestIndex = Double.MAX_VALUE;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                
                if (estadoSelecionado.equals("Brazil") | data[0].equalsIgnoreCase(estadoSelecionado.substring(0, estadoSelecionado.length()-5))) {

                    double currentIndex = Double.parseDouble(data[2]);

                    if (currentIndex > highestIndex) {
                        highestIndex = currentIndex;
                        linhaMaiorIsolamento = line;
                    }

                    if (currentIndex < lowestIndex) {
                        lowestIndex = currentIndex;
                        linhaMenorIsolamento = line;
                    }
                }
            }
        } catch (IOException | NumberFormatException ex) {
            System.out.println("Erro ao rodar as threads. Erro: " + ex.getMessage());
        }
    }

    public String getHighestIsolationLine() {
        return linhaMaiorIsolamento;
    }

    public String getLowestIsolationLine() {
        return linhaMenorIsolamento;
    }

}
