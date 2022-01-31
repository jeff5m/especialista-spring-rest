package com.algaworks.algafood;

import com.algaworks.algafood.di.notification.Notifier;
import com.algaworks.algafood.di.service.ClientActivationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public ClientActivationService clientActivationService(Notifier notifier) {
        return new ClientActivationService(notifier);
    }

}
