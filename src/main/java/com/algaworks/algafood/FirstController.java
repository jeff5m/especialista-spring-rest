package com.algaworks.algafood;

import com.algaworks.algafood.di.model.Client;
import com.algaworks.algafood.di.service.ClientActivationService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    private final ClientActivationService clientActivationService;

    public FirstController(ClientActivationService clientActivationService) {
        this.clientActivationService = clientActivationService;
    }

    @GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello() {
        Client john = new Client("John", "john_asdf@gmail.com", "54987654321");

        clientActivationService.activate(john);

        return "Hello 48";
    }

}
