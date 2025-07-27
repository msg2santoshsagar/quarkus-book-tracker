package com.alfie.quarkusbooktracker.resource;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.time.Instant;
import java.util.Map;

@Path("/api/version")
public class VersionResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getVersionInfo() {
        return Map.of(
                "app", "quarkus-book-tracker",
                "version", "1.0.0",
                "timestamp", Instant.now().toString(),
                "status", "UP"
        );
    }
}
