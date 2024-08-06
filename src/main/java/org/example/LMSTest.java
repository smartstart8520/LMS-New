package org.example;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
public class LMSTest {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = LMSTest.class.getClassLoader();

        File file = ResourceUtils.getFile("classpath:config/ServiceAccountKey.json");
        FileInputStream serviceAccount = new FileInputStream(file);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();


        FirebaseApp.initializeApp(options);
        SpringApplication.run(LMSTest.class,args);
    }
}