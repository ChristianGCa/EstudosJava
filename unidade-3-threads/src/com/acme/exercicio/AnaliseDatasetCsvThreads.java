package com.acme.exercicio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AnaliseDatasetCsvThreads {

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

            Map<String, Double> isolamentoPorCidade = calcularIsolamentoPorCidade(arquivoCSV, estado);
            System.out.println("\n/// Índices de isolamento social no " + estado + " ///\n");
            
            

            Thread t1 = new Thread(() -> {
                String maiorIsolamento = encontrarCidadeMaiorIsolamento(isolamentoPorCidade);
                System.out.println("Maior: " + maiorIsolamento);
            });

            // Thread para encontrar a cidade com menor isolamento
            Thread t2 = new Thread(() -> {
                String menorIsolamento = encontrarCidadeMenorIsolamento(isolamentoPorCidade);
                System.out.println("Menor: " + menorIsolamento);
            });

            // Iniciar as threads
            t1.start();
            t2.start();

            // Aguardar a conclusão das threads
            t1.join();
            t2.join();
            
            long endTime = System.currentTimeMillis();

            // Calculando o tempo de execução do programa
            System.out.println("Tempo de execução: " + (endTime - startTime) + " ms");

        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao processar o arquivo CSV: " + e.getMessage());
        }
    }

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
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                System.out.println("Erro ao tentar fechar o buffer: " + ex);
            }
        }
        return 0;
    }

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
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                System.out.println("Erro ao tentar fechar o buffer: " + ex);
            }
        }
        return 0;
    }

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
