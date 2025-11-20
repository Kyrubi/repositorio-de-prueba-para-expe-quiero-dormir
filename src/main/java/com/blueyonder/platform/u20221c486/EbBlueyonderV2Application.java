package com.blueyonder.platform.u20221c486;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EbBlueyonderV2Application {

    public static void main(String[] args) {
        SpringApplication.run(EbBlueyonderV2Application.class, args);
    }

}
