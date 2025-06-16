package com.PI.AutoGynService.config;

//        Por que isso é o padrão Singleton?
//        O logger é instanciado uma única vez na aplicação.
//        Sempre que você chamar CustomLogger.getInstance(), vai usar a mesma instância.
//        Isso evita múltiplos objetos desnecessários na memória e centraliza o log.

public class CustomLogger {
    private static CustomLogger instance;

    private CustomLogger() {
        // Construtor privado
    }

    public static synchronized CustomLogger getInstance() {
        if (instance == null) {
            instance = new CustomLogger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
