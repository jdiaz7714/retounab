package org.retounab.restful.rercursos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.retounab.restful.conexionSQL.ConexionSQL;
import org.retounab.restful.modelo.Equipo;
import org.retounab.restful.servicio.EquipoServicio;

@Path("/equipos")
public class EquipoRecurso {
    
    EquipoServicio es = new EquipoServicio();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Equipo> getEquipos() {
        return es.getEquipos();
    }
    
    @GET
    @Path("/{equipoId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Equipo> getEquipo(@PathParam("equipoId") int id) {
        return es.getEquipo(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Equipo> addEquipo(Equipo equipo) {
        return es.addEquipo(equipo);
    }
    
    @DELETE
    @Path("/{equipoId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteEquipo(@PathParam("equipoId") int id) {
        es.deleteEquipo(id);
        return "{\"Confimacion\":\"ok\"}";
    }
    
    @PUT
    @Path("/{equipoId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Equipo> updateEquipo(@PathParam("equipoId") int id, Equipo equipo) {
        equipo.setId(id);
        return es.updateEquipo(equipo);
    }
}
