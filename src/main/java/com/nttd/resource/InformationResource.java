package com.nttd.resource;

import com.nttd.dto.ResponseDto;
import com.nttd.service.InformationService;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/api/information")
public class InformationResource {

    @Inject
    InformationService informationService;

    @GET
    @Path("/{id}")
    public Uni<ResponseDto> getProducts(@PathParam("id") long id) {
        return informationService.getProducts(id);
    }

}
