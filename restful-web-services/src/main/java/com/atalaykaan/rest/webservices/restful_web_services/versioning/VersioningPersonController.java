package com.atalaykaan.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson() {

        return new PersonV1("Kaan Atalay");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson() {

        return new PersonV2(new Name("Kaan", "Atalay"));
    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParams() {

        return new PersonV1("Kaan Atalay");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParams() {

        return new PersonV2(new Name("Kaan", "Atalay"));
    }
}
