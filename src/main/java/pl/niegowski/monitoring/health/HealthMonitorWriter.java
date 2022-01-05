package pl.niegowski.monitoring.health;

public interface HealthMonitorWriter {
  void liveness(boolean liveness);

  void readiness(boolean readiness);
}
