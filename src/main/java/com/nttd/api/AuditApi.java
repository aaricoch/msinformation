package com.nttd.api;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.nttd.api.request.AuditRequest;
import com.nttd.api.response.AuditResponse;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/audit")
@RegisterRestClient
public interface AuditApi {

    @GET
    Uni<AuditResponse> getAll();

    @POST
    Uni<AuditResponse> add(AuditRequest auditRequest);

}
