package com.algaworks.algafood.di.notification;

import com.algaworks.algafood.di.model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@NotifierType(PriorityLevel.URGENT)
@Component
public class SMSNotifier implements Notifier {

    private static final Logger LOGGER = LoggerFactory.getLogger(SMSNotifier.class);

    @Override
    public void notify(Client client, String message) {
        LOGGER.info("Notifying client: [{}], by sms to: [{}], with message: [{}]",
                client.getName(), client.getPhone(), message);
    }

}
