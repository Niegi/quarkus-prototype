package pl.niegowski.controllers;

import pl.niegowski.monitoring.health.HealthMonitorReader;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

public class ReadinessEndpoint implements ReadinessEndpointSwagger {
  private static final String OK = "OK!";

  @Inject
  HealthMonitorReader healthMonitorReader;

  public Response isReady() {
    if (healthMonitorReader.isReady()) {
      return Response.ok(OK).build();
    }
    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
  }
}
