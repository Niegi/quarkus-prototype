package pl.niegowski.monitoring;

import pl.niegowski.monitoring.health.HealthMonitorReader;
import pl.niegowski.monitoring.health.HealthMonitorWriter;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.atomic.AtomicBoolean;

@ApplicationScoped
public class DefaultHealthMonitor implements HealthMonitorReader, HealthMonitorWriter {
  private final AtomicBoolean liveness = new AtomicBoolean(true);
  private final AtomicBoolean readiness = new AtomicBoolean(true);

  @Override
  public boolean isLive() {
    return liveness.get();
  }

  @Override
  public boolean isReady() {
    return readiness.get();
  }

  @Override
  public void liveness(boolean liveness) {
    this.liveness.lazySet(liveness);
    if (!liveness) {
      readiness.lazySet(false);
    }
  }

  @Override
  public void readiness(boolean readiness) {
    this.readiness.lazySet(readiness);
  }
}
