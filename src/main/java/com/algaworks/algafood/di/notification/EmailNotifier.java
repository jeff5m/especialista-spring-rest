package com.algaworks.algafood.di.notification;

import com.algaworks.algafood.di.model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public class EmailNotifier implements Notifier {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailNotifier.class);

    private boolean upperCase;
    private final String hostSmtpServer;

    public EmailNotifier(String hostSmtpServer) {
        this.hostSmtpServer = hostSmtpServer;
    }

    public void setUpperCase(boolean upperCase) {
        this.upperCase = upperCase;
    }

    @Override
    public void notify(Client client, String message) {
        if (this.upperCase) {
            message = message.toUpperCase();
        }

        LOGGER.info("Notifying client: [{}], by email: [{}], using SMTP sever [{}], with message: [{}]",
                client.getName(), client.getEmail(), this.hostSmtpServer, message);
    }

}
