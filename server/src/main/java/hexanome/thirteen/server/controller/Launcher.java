package hexanome.thirteen.server.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class launches spring and detects the necessary controllers.
 */
@SpringBootApplication(scanBasePackages = {"hexanome.thirteen.server"})
public class Launcher {

  /**
   * Launcher constructor.
   */
  public Launcher() {

  }

  /**
   * This method is the main method.
   *
   * @param args Launch parameter.
   */
  public static void main(String[] args) {
    SpringApplication.run(Launcher.class, args);
  }
}
