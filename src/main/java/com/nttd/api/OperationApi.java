package com.nttd.api;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.nttd.api.response.OperationResponse;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/account")
@RegisterRestClient
public interface OperationApi {

    @GET
    @Path("/products/{idcustomer}/{flag_dif_td}")
    Uni<OperationResponse> getProducts(@PathParam("idcustomer") long idcustomer,
            @PathParam("flag_dif_td") boolean flag_dif_td);
}
