package com.algaworks.algafood.di.service;

import com.algaworks.algafood.di.model.Client;
import com.algaworks.algafood.di.notification.Notifier;
import org.springframework.stereotype.Service;

@Service
public class ClientActivationService {

    private final Notifier notifier;

    public ClientActivationService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void activate(Client client) {
        client.activate();
        this.notifier.notify(client, "Your registration is active!");
    }

}
