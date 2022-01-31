package com.algaworks.algafood;

import com.algaworks.algafood.di.notification.EmailNotifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Bean
    public EmailNotifier emailNotifier() {
        EmailNotifier emailNotifier = new EmailNotifier("smtp.algaemail.com.br");
        emailNotifier.setUpperCase(true);
        return emailNotifier;
    }

}
