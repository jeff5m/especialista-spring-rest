package com.algaworks.algafood;

import com.algaworks.algafood.di.notification.Notifier;
import com.algaworks.algafood.di.notification.SMSNotifier;
import com.algaworks.algafood.di.service.ClientActivationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public Notifier notifier() {
        return new SMSNotifier();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public ClientActivationService clientActivationService(Notifier notifier) {
        return new ClientActivationService(notifier);
    }

}
