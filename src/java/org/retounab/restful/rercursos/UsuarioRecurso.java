package org.retounab.restful.rercursos;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.retounab.restful.conexionSQL.ConexionSQL;
import org.retounab.restful.modelo.Usuario;

@Path("/usuarios")
public class UsuarioRecurso {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Usuario> getArticulos() {
        Connection cn;
        ConexionSQL con = new ConexionSQL();
        Statement st;
        ResultSet rs;
        DefaultTableModel modelo;
        String sql = "Select * From usuarios";
        ArrayList<Usuario> usuario = new ArrayList();
        Usuario aux;

        try {
            cn = con.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                aux = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("correo"), rs.getString("username"), rs.getString("password"));
                usuario.add(aux);
            }
        } catch (Exception e) {
            //articulo = new Articulo(1, "mal", "mal", "mal");
            System.out.println("e = " + e.getMessage());
        }

        return usuario;
    }
}
