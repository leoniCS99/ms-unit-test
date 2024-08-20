package org.acme.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.acme.service.MyUtilsService;

@Path("/util")
@RequiredArgsConstructor
public class MyUtilsController {

    private final MyUtilsService myUtilsService;

    @GET
    @Path("/validate/prime/{number}")
    public Response verirfyPrimeNumber(@PathParam("number") int number) {
        try {
            return Response.ok(myUtilsService.isPrimeNumber(number)).build();
        } catch (Exception exception) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/count/{text}")
    public Response verirfyTextSize(@PathParam("text") String text) {
        try {
            return Response.ok(myUtilsService.countCharacters(text)).build();
        } catch (Exception exception) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
