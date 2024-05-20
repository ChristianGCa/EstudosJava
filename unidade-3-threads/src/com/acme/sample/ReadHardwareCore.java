package com.acme.sample;

public class ReadHardwareCore {

    public static void main(String[] args) {
        int nucleos = Runtime.getRuntime().availableProcessors();
        System.out.println("Núcleos lógicos: "+nucleos+50);
    }
}
