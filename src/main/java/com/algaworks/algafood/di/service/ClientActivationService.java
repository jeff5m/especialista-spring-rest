package com.algaworks.algafood.di.service;

import com.algaworks.algafood.di.model.Client;
import com.algaworks.algafood.di.notification.Notifier;
import com.algaworks.algafood.di.notification.NotifierType;
import com.algaworks.algafood.di.notification.PriorityLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientActivationService implements InitializingBean, DisposableBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientActivationService.class);

    private final Notifier notifier;

    @Autowired
    public ClientActivationService(@NotifierType(PriorityLevel.NORMAL) Notifier notifier) {
        this.notifier = notifier;
    }
    public void activate(Client client) {
        client.activate();
        this.notifier.notify(client, "Your registration is active!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.warn("First method of bean lifecycle");
    }

    @Override
    public void destroy() throws Exception {
        LOGGER.warn("Last method of bean lifecycle");
    }
}
