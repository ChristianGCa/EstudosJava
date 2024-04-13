package com.acme.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

public class PersistObject {

    public static void main(String[] args) {
        
        // Cria três instâncias de Activity
        Activity act1 = new Activity("saveInformation");
        act1.setPriority(Activity.Priority.NORMAL);
        act1.setExecutionDate(new Date());
        
        Activity act2 = new Activity("saveInformation");
        act2.setPriority(Activity.Priority.HIGHEST);
        act2.setExecutionDate(new Date());
        
        Activity act3 = new Activity("saveInformation");
        act3.setPriority(Activity.Priority.LOW);
        act3.setExecutionDate(new Date());
        
        // Adiciona as instâncias em um ArrayList
        ArrayList<Activity> list = new ArrayList();
        list.add(act1);
        list.add(act2);
        list.add(act3);
        
        // Chama o método saveObject para salvar o ArrayList em um arquivo
        saveObject("/home/christian/mydata/mydataArray.ser", list);
        System.out.println("Atividade salva com sucesso!");
        
        // Chama o método restoreObject para restaurar o ArrayList do arquivo
        ArrayList<Activity> acts = (ArrayList<Activity>)restoreObject("/home/christian/mydata/mydataArray.ser");
        
        for (Activity x : acts) {
            System.out.println("ID:                    "+x.getId());
            System.out.println("Name:                  "+x.getName());
            System.out.println("Execution date:        "+x.getExecutionDate());
            System.out.println("Priority:              "+x.getPriority());
        }

    }
    
    // Salvar um objeto serializado em um arquivo. Método genérico, grava qualquer objeto.
    public static void saveObject(String fileName, Object obj) {
        
        try{
            File f = new File(fileName);
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            fos.close();
            oos.close();
            
        }catch(FileNotFoundException ex) {
            System.out.println("Erro ao tentar salvar o objeto no arquivo "+fileName);
            System.out.println("Detalhe: "+ex.getMessage());
            
        }catch(IOException ex) {
            System.out.println("Exception: "+ex.getMessage());
        }
        
    }
    
    // Restaurar um objeto serializado de um arquivo.
    public static Object restoreObject(String fileName) {
        
        try {
            File f = new File(fileName);
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return ois.readObject();
            
        }catch(Exception ex) {
            System.out.println("Exception: "+ex.getMessage());
        }
        
        return null;
        
    }
}
