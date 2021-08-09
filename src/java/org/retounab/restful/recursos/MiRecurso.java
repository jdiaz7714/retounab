package org.retounab.restful.recursos;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("mirecurso")
public class MiRecurso {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String saludar(){
        return "{\"Saludar\":\"hola Mundo todo\"}";
    }
}
