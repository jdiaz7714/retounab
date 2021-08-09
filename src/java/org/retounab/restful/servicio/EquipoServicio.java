package org.retounab.restful.servicio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.retounab.restful.conexionSQL.ConexionSQL;
import org.retounab.restful.modelo.Articulo;
import org.retounab.restful.modelo.Equipo;

public class EquipoServicio {

    Connection cn;
    ConexionSQL con = new ConexionSQL();
    Statement st;
    ResultSet rs;

    public List<Equipo> getEquipos() {
        String sql = "Select * From equipos";
        ArrayList<Equipo> equipo = new ArrayList();
        Equipo aux;

        try {
            cn = con.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                aux = new Equipo(rs.getInt("id"), rs.getString("nombre"));
                equipo.add(aux);
            }
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
        }
        return equipo;
    }

    public List<Equipo> getEquipo(int id) {
        String sql = "Select * From equipos where id=" + id;
        ArrayList<Equipo> equipo = new ArrayList();
        Equipo aux;

        try {
            cn = con.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                aux = new Equipo(rs.getInt("id"), rs.getString("nombre"));
                equipo.add(aux);
            }
            return equipo;
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
        }
        return null;
    }

    public void deleteEquipo(int id) {
        String sql = "delete From equipos where id=" + id;

        try {
            cn = con.getConnection();
            st = cn.createStatement();
            st.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
        }

    }

    public List<Equipo> addEquipo(Equipo equipo) {
        ArrayList<Equipo> eq = new ArrayList();
        Equipo aux;
        equipo.setId(getMaximo());
        String sql = "Insert into equipos (id,nombre) values(" + equipo.getId() + ",'" + equipo.getNombre() + "')";
        try {

            cn = con.getConnection();
            st = cn.createStatement();
            st.executeUpdate(sql);
            aux = new Equipo(equipo.getId(), equipo.getNombre());
            eq.add(aux);

        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
        }
        return eq;
    }

    public List<Equipo> updateEquipo(Equipo equipo) {
        ArrayList<Equipo> eq = new ArrayList();
        Equipo aux;
        String sql = "Update equipos set nombre='" + equipo.getNombre() + "' where id=" + equipo.getId();
        try {

            cn = con.getConnection();
            st = cn.createStatement();
            st.executeUpdate(sql);
            aux = new Equipo(equipo.getId(), equipo.getNombre());
            eq.add(aux);
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
        }
        return eq;
    }

    private int getMaximo() {

        String sql = "Select max(id) From equipos";
        int id = 0;

        try {

            cn = con.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("max(id)") + 1;
            }
            if (id == 0) {
                return 1;
            } else {
                return id;
            }

        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
        }

        return id;
    }

}
