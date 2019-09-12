package dev.ivanov.logsgenerator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MarkerFactory;
import org.slf4j.helpers.BasicMarker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static net.logstash.logback.argument.StructuredArguments.*;

@SpringBootApplication
@Slf4j

@RestController
public class LogsgeneratorApplication implements CommandLineRunner {


  public static void main(String[] args) {
    SpringApplication.run(LogsgeneratorApplication.class, args);
    double d = 100.0;
    double p = 300.0;
    BigDecimal b = new BigDecimal("100");
    System.out.println((p - 200) / 3);
    System.out.println(d / 3 + " " + b.divide(new BigDecimal(3), 2, RoundingMode.DOWN));
  }

  @RequestMapping("/")
  public String home() {
    return "Hello Docker World";
  }

  @Override
  public void run(String... args) throws Exception {
    for (int i = 0; i < 10_000; i++) {
      log.info("[{}] Hello3", value("RqUID", "1551"));
      Thread.sleep(1000);
    }

  }
}
