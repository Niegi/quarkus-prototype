package pl.niegowski.controllers;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("")
public interface ReadinessEndpointSwagger {
  String PATH_READY = "ready";

  @Operation(summary = "Get ready probe of the application")
  @APIResponses(
    value = {
      @APIResponse(
        responseCode = "200",
        description = "OK",
        content = @Content(mediaType = MediaType.APPLICATION_JSON)
      ),
      @APIResponse(
        responseCode = "500",
        description = "Error",
        content = @Content(mediaType = MediaType.APPLICATION_JSON)
      )
    })
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path(PATH_READY)
  Response isReady();
}
