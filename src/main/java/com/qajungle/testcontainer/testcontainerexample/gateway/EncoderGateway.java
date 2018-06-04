package com.qajungle.testcontainer.testcontainerexample.gateway;

import com.qajungle.testcontainer.testcontainerexample.domain.dto.EncodeDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class EncoderGateway {

    private static final String BASE64_API = "/encoder/base64";

    private final RestTemplate restTemplate;
    private final String url;

    public EncoderGateway(final RestTemplateBuilder restTemplateBuilder, final @Value("${encode.url}") String url) {
        this.restTemplate = restTemplateBuilder.build();
        this.url = url;
    }

    public String getBase64Encode(final String toEncode){

        URI uri = UriComponentsBuilder.fromUriString(url)
                .pathSegment(BASE64_API)
                .build()
                .toUri();

        ResponseEntity<EncodeDto> response = restTemplate.postForEntity(uri, toEncode, EncodeDto.class);

        return response.getBody().getEncodeText();
    }

}
