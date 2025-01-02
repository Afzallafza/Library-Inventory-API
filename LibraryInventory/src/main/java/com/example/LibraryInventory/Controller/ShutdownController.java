package com.example.LibraryInventory.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShutdownController {

    @Autowired
    private ConfigurableApplicationContext context;

    @PostMapping("/exit")
    public String exitApplication() {
        Thread shutdownThread = new Thread(() -> {
            try {
                Thread.sleep(30000); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            context.close(); 
        });
        shutdownThread.start();
        return "Application is shutting down gracefully...";
    }
}
