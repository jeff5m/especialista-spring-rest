package com.algaworks.algafood.di.notification;

import com.algaworks.algafood.di.model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("prod")
@NotifierType(PriorityLevel.NORMAL)
@Component
public class EmailNotifier implements Notifier {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailNotifier.class);

    @Override
    public void notify(Client client, String message) {
        LOGGER.info("Notifying client: [{}], by email: [{}], with message: [{}]",
                client.getName(), client.getEmail(), message);
    }

}
