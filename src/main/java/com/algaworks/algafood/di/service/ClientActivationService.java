package com.algaworks.algafood.di.service;

import com.algaworks.algafood.di.model.Client;
import com.algaworks.algafood.di.notification.Notifier;
import com.algaworks.algafood.di.notification.NotifierType;
import com.algaworks.algafood.di.notification.PriorityLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientActivationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientActivationService.class);

    private final Notifier notifier;

    @Autowired
    public ClientActivationService(@NotifierType(PriorityLevel.NORMAL) Notifier notifier) {
        this.notifier = notifier;
    }

    public void init() {
        LOGGER.warn("First method of bean lifecycle");
    }

    public void destroy() {
        LOGGER.warn("Last method of bean lifecycle");
    }

    public void activate(Client client) {
        client.activate();
        this.notifier.notify(client, "Your registration is active!");
    }

}
