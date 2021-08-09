package org.retounab.restful.rercursos;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.retounab.restful.conexionSQL.ConexionSQL;
import org.retounab.restful.modelo.Articulo;

@Path("/articulos")
public class ArticuloRecurso {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Articulo> getArticulos() {
        Connection cn;
        ConexionSQL con = new ConexionSQL();
        Statement st;
        ResultSet rs;
        DefaultTableModel modelo;
        String sql = "Select * From Articulo";
        ArrayList<Articulo> articulo = new ArrayList();
        Articulo aux;

        try {
            cn = con.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                aux = new Articulo(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"), rs.getString("contenido"));
                articulo.add(aux);
            }
        } catch (Exception e) {
            //articulo = new Articulo(1, "mal", "mal", "mal");
            System.out.println("e = " + e.getMessage());
        }

        return articulo;
    }
}
