package com.algaworks.algafood.di.service;

import com.algaworks.algafood.di.model.Client;
import com.algaworks.algafood.di.notification.Notifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientActivationService {

    private final List<Notifier> notifiers;

    @Autowired
    public ClientActivationService(List<Notifier> notifiers) {
        this.notifiers = notifiers;
    }

    public void activate(Client client) {
        client.activate();
        this.notifiers.forEach(notifier -> notifier.notify(client, "Your registration is active!"));
    }

}
