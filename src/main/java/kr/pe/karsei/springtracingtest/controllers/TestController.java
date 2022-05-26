package kr.pe.karsei.springtracingtest.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping(value = "api1")
@RequiredArgsConstructor
public class TestController {
    private final RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello() {
        log.info("called hello method");
        return "hello, world!";
    }

    @GetMapping("call")
    public String call() {
        log.info("called call method");
        String url = "http://localhost:7000/api1/hello";

        StringBuilder sb = new StringBuilder();
        try {
            log.info("sending");
            sb.append(restTemplate.getForObject(url, String.class));
        }
        catch (HttpStatusCodeException e) {
            throw e;
        }
        log.info("sending done");

        return String.format("call - %s", sb);
    }
}
