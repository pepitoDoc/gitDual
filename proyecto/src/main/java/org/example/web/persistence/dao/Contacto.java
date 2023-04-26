package org.example.web.persistence.dao;

import lombok.*;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
public class Contacto {

    int id;
    String nombre;
    String apellido;
    String telefono;
    String email;

    public Contacto(ResultSet result) {
        try {
            this.id = result.getInt("idcontacts");
            this.nombre = result.getString("nombre");
            this.apellido = result.getString("apellido");
            this.telefono = result.getString("telefono");
            this.email = result.getString("email");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
