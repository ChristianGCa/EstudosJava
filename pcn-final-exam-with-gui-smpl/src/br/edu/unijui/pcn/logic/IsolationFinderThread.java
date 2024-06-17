package br.edu.unijui.pcn.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Esta classe implementa uma thread para localizar indices de isolamento
 * social.
 *
 * @author Christian Gabriel Candeloni
 */
public class IsolationFinderThread extends Thread {

    private final String FILE_NAME;
    private String linhaIsolamento;
    private final String estadoSelecionado;
    private final boolean buscarMaior;

    /**
     * @param buscarMaior Indica a thread se deve buscar o maior índice (true) ou o menor (false)
     */
    public IsolationFinderThread(String fileName, String estadoSelecionado, boolean buscarMaior) {
        this.FILE_NAME = fileName;
        this.buscarMaior = buscarMaior;
        this.estadoSelecionado = estadoSelecionado;
    }

    @Override
    public void run() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            double highestIndex = -1.0;
            double lowestIndex = Double.MAX_VALUE;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (estadoSelecionado.equals("Brazil") | data[0].equalsIgnoreCase(estadoSelecionado.substring(0, estadoSelecionado.length() - 5))) {

                    double currentIndex = Double.parseDouble(data[2]);
                    if (buscarMaior == true) {

                        if (currentIndex > highestIndex) {
                            highestIndex = currentIndex;
                            linhaIsolamento = line;
                        }
                    } else {

                        if (currentIndex < lowestIndex) {
                            lowestIndex = currentIndex;
                            linhaIsolamento = line;
                        }
                    }
                }
            }
        } catch (IOException | NumberFormatException ex) {
            System.out.println("Erro ao rodar as threads. Erro: " + ex.getMessage());
        }
    }

    public String getIsolationLine() {
        return linhaIsolamento;
    }
}
