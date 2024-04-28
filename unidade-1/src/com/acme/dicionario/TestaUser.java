package com.acme.dicionario;

import java.util.HashMap;
import java.util.Map;

public class TestaUser {
    
    // Método para pesquisar usuários pelo login
    public static void searchUserByLogin(String login, Map<String, User> userMap) {
        boolean found = false;

        for (Map.Entry<String, User> entry : userMap.entrySet()) {
            User user = entry.getValue();
            if (user.getLogin().equals(login)) {
                if (!found) {
                    System.out.println("Usuário(s) encontrado(s) com o login '" + login + "':");
                    found = true;
                }
                System.out.println("Perfil: " + user.getProfile());
            }
        }

        if (!found) {
            System.out.println("Nenhum usuário encontrado com o login '" + login + "'.");
        }
    }
    
    public static void main(String[] args) {
        
         // Criando um HashMap para armazenar usuários por login
        Map<String, User> userMap = new HashMap<>();
        
        User u1 = new User();
        u1.setLogin("23463");
        u1.setPassword("password1");
        u1.setProfile("Aluno");
        
        User u2 = new User();
        u2.setLogin("67345");
        u2.setPassword("password2");
        u2.setProfile("Aluno");
        
        User u3 = new User();
        u3.setLogin("23490");
        u3.setPassword("password3");
        u3.setProfile("Aluno");
        
        User u4 = new User();
        u4.setLogin("34556");
        u4.setPassword("password4");
        u4.setProfile("Aluno");
        
        User u5 = new User();
        u5.setLogin("12987");
        u5.setPassword("password5");
        u5.setProfile("Professor");
        
        // Armazenando os usuários
        userMap.put(u1.getLogin(), u1);
        userMap.put(u2.getLogin(), u2);
        userMap.put(u3.getLogin(), u3);
        userMap.put(u4.getLogin(), u4);
        userMap.put(u5.getLogin(), u5);
        
        // Testando a busca por login
        searchUserByLogin("12987", userMap); // Exemplo de pesquisa por um login existente
        searchUserByLogin("23463", userMap);    // Exemplo de pesquisa por um login inexistente
        
    }
    
}
