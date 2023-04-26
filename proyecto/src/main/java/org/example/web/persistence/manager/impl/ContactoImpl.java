package org.example.web.persistence.manager.impl;

import org.example.web.persistence.dao.Contacto;
import org.example.web.persistence.manager.Manager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactoImpl implements Manager {
    @Override
    public List<Contacto> findAll(Connection con) {

        try (Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            ResultSet result = stmt.executeQuery("SELECT * FROM contacts");
            result.beforeFirst();
            List<Contacto> listaContactos = new ArrayList<Contacto>();
            while(result.next()) {
                listaContactos.add(new Contacto(result));
            }

            return listaContactos;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Contacto finyById(Connection con, int id) {
        return null;
    }

    @Override
    public int updateById(Connection con, Contacto contacto) {

        String sql = "UPDATE contacts SET " +
                "nombre = ?, " +
                "apellido = ?, " +
                "telefono = ?, " +
                "email = ? " +
                "WHERE idcontacts = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
             stmt.setString(1, contacto.getNombre());
             stmt.setString(2, contacto.getApellido());
             stmt.setString(3, contacto.getTelefono());
             stmt.setString(4, contacto.getEmail());
             stmt.setInt(5, contacto.getId());
             return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }

    @Override
    public int insert(Connection con, String nombre, String apellidos, String telefono, String email) {

        String sql = "INSERT INTO contacts(nombre, apellido, telefono, email) VALUES(?, ?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, apellidos);
            stmt.setString(3, telefono);
            stmt.setString(4, email);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int deleteById(Connection con, int id) {

        String sql = "DELETE FROM contacts WHERE idcontacts = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
