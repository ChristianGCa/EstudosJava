package com.acme.exercicio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnaliseDatasetCsv {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String arquivoCSV = "/home/christian/Downloads/social-distancing-cities-final.csv";
        String estado = "Rio Grande do Sul";
        String municipio = "Ijuí";
        try {

            int totalRegistros = contarRegistros(arquivoCSV);
            System.out.println("Total de registros no arquivo: " + totalRegistros);

            int registros = contarRegistrosPorCidade(arquivoCSV, municipio);
            System.out.println("Registros para o município de " + municipio + ": " + registros);

            Map<String, Double> isolamentoPorCidade = calcularIsolamentoPorCidade(arquivoCSV, "Rio Grande do Sul");
            System.out.println("\n/// Índices de isolamento social no " + estado + " ///\n");
            System.out.println("Maior: " + encontrarCidadeMaiorIsolamento(isolamentoPorCidade));
            System.out.println("Menor: " + encontrarCidadeMenorIsolamento(isolamentoPorCidade));

            long endTime = System.currentTimeMillis();
            
            // Calculando o tempo de execução do programa
            System.out.println("Tempo de execução: " + (endTime - startTime) + " ms");
            
        } catch (IOException e) {
            System.out.println("Erro ao processar o arquivo CSV: " + e.getMessage());
        }
    }

    // Método para contar o número total de registros no dataset
    private static int contarRegistros(String arquivoCSV) {

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(arquivoCSV));
            int totalRegistros = 0;
            while (reader.readLine() != null) {
                totalRegistros++;
            }
            reader.close();
            return totalRegistros;
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado: " + ex);
        } catch (IOException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                System.out.println("Erro ao tentar fechar o buffer: " + ex);
            }
        }
        return 0;
    }

    // Método para contar o número de registros para uma determinada cidade no dataset
    private static int contarRegistrosPorCidade(String arquivoCSV, String cidade) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(arquivoCSV));
            int registrosCidade = 0;
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados[1].trim().equals(cidade)) {
                    registrosCidade++;
                }
            }
            reader.close();
            return registrosCidade;
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado: " + ex);
        } catch (IOException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                System.out.println("Erro ao tentar fechar o buffer: " + ex);
            }
        }
        return 0;
    }

    // Método para calcular o índice de isolamento social por cidade
    private static Map<String, Double> calcularIsolamentoPorCidade(String arquivoCSV, String estado) throws IOException {
        Map<String, Double> isolamentoPorCidade = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(arquivoCSV));
        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] dados = linha.split(",");
            if (dados[0].trim().equals(estado)) {
                String cidade = dados[1].trim();
                double isolamento = Double.parseDouble(dados[2].trim());
                isolamentoPorCidade.put(cidade, isolamento);
            }
        }
        reader.close();
        return isolamentoPorCidade;
    }

    // Método para encontrar a cidade com o maior isolamento social no estado especificado
    private static String encontrarCidadeMaiorIsolamento(Map<String, Double> isolamentoPorCidade) {
        String cidadeMaiorIsolamento = null;
        double maxIsolamento = Double.MIN_VALUE;
        for (Map.Entry<String, Double> entry : isolamentoPorCidade.entrySet()) {
            if (entry.getValue() > maxIsolamento) {
                maxIsolamento = entry.getValue();
                cidadeMaiorIsolamento = entry.getKey();
            }
        }
        return cidadeMaiorIsolamento;
    }

    // Método para encontrar a cidade com o menor isolamento social no estado especificado
    private static String encontrarCidadeMenorIsolamento(Map<String, Double> isolamentoPorCidade) {
        String cidadeMenorIsolamento = null;
        double minIsolamento = Double.MAX_VALUE;
        for (Map.Entry<String, Double> entry : isolamentoPorCidade.entrySet()) {
            if (entry.getValue() < minIsolamento) {
                minIsolamento = entry.getValue();
                cidadeMenorIsolamento = entry.getKey();
            }
        }
        return cidadeMenorIsolamento;
    }
}
