package pl.niegowski.monitoring.health;

public interface HealthMonitorReader {
  boolean isLive();

  boolean isReady();
}
