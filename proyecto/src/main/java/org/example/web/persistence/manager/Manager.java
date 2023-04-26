package org.example.web.persistence.manager;

import org.example.web.persistence.dao.Contacto;

import java.sql.Connection;
import java.util.List;

public interface Manager {

    List<Contacto> findAll(Connection con);

    Contacto finyById(Connection con, int id);

    int updateById(Connection con, Contacto contacto);

    int insert(Connection con, String nombre, String apellidos, String telefono, String email);

    int deleteById(Connection con, int id);
}
