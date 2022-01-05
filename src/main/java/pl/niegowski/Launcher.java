package pl.niegowski;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

// bez Launchera też działa, tylko w dev-mode
@QuarkusMain
public class Launcher {
  public static void main(String[] args) {
    Quarkus.run();
  }
}
