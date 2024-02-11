package org.sualk.sentrygitpoddemo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.Exception;
import io.sentry.Sentry;

@RestController
class DemoController {

    @GetMapping
    public void get() {
        System.out.println("foo");
        try {
          throw new Exception("This is a test.");
        } catch (Exception e) {
          Sentry.captureException(e);
        }
    }
}