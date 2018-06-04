package com.qajungle.testcontainer.testcontainerexample.services;

import com.qajungle.testcontainer.testcontainerexample.gateway.EncoderGateway;
import com.qajungle.testcontainer.testcontainerexample.persistence.entity.Project;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.testcontainers.containers.DockerComposeContainer;

import java.io.File;
import java.net.URI;

import static org.rnorth.visibleassertions.VisibleAssertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EncoderGatewayTest {

    private final static  String HTTP = "http://";
    private final static String SERVICE_NAME = "encoder_1";
    private final static int SERVICE_PORT = 8080;

    @ClassRule
    public static DockerComposeContainer environment =
            new DockerComposeContainer(new File("src/test/resources/docker-compose.yml"))
                    .withExposedService(SERVICE_NAME, SERVICE_PORT);

    @Test
    public void should_get_text_base64_encode() {
        //Having
        String toEncode = "encodeMe";
        String expected = "ZW5jb2RlTWU=";
        String url = HTTP.concat(environment.getServiceHost(SERVICE_NAME, SERVICE_PORT))
                .concat(":" + environment.getServicePort(SERVICE_NAME, SERVICE_PORT));
        EncoderGateway encoderGateway = new EncoderGateway(new RestTemplateBuilder(), url);

        //When
        String encoded = encoderGateway.getBase64Encode(toEncode);

        //Then
        assertEquals("text encode", expected, encoded);
    }

}
