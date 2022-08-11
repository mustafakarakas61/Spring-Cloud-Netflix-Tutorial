package com.mustafa.eurekaclientorganisation.helper;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class EurekaClientOrgServiceContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
            builder.withDetail("detaylar",
            Collections.singletonMap("açıklama", "Bu bir company service, which is discovery server aware, and we can call Student Microservice with this  Microservice, which is again dicovery server aware!!! "));
    }
}
