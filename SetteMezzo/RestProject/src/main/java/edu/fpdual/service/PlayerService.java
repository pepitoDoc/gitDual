package edu.fpdual.service;

import edu.fpdual.api.dto.Player;
import edu.fpdual.persistence.connector.MySQLConnector;
import edu.fpdual.persistence.manager.impl.PlayerManagerImpl;
import jakarta.validation.GroupSequence;
import lombok.Getter;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author: Álvaro Terrasa y Artem Korzhan
 * @version: 1.0
 * Clase de servicio para los jugadores. Gestiona la conexión con la BBDD
 * y se encarga de ejecutar los métodos SQL de persistencia, haciendo de capa
 * intermedia entre esta y su controlador pertinente.
 */
@Getter
public class PlayerService {

    /**
     * Clase del conector.
     */
    private MySQLConnector connector;
    /**
     * Clase de implementación de métodos SQL.
     */
    private PlayerManagerImpl manager;

    /**
     * Constructor que crea el objeto de servicio con sus atributos
     * @param connector - MySQLConnector
     * @param manager - PlayerManagerImpl
     */
    public PlayerService(MySQLConnector connector, PlayerManagerImpl manager) {
        this.connector = connector;
        this.manager = manager;
    }

    /**
     * Realiza una operación insert que registra un jugador en la BBDD.
     * @param player - Player
     * @return int - Resultado de la operación
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public int insertPlayer(Player player) throws SQLException, ClassNotFoundException{

        Connection con = null;

        try {
            con = connector.getMySQLConnection();
            return manager.insert(con, player);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    /**
     * Realiza una operación select que busca un jugador cuyo
     * nombre o email coincidan con los argumentos enviados correspondientes
     * @param nickname - String
     * @param email - String
     * @return Player - El jugador encontrado
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Player findPlayer(String nickname, String email) throws SQLException, ClassNotFoundException {

        Connection con = null;

        try {
            con = connector.getMySQLConnection();
            return manager.findPlayer(con, nickname, email);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    /**
     * Realiza una operación select que busca un jugador
     * cuyo nombre coincida con el argumento enviado
     * @param nickname - String
     * @return Player - El jugador encontrado
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Player findPlayerByName(String nickname) throws SQLException, ClassNotFoundException {

        Connection con = null;

        try {
            con = connector.getMySQLConnection();
            return manager.findPlayerByName(con, nickname);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    /**
     * Realiza una operación update que cambia la contraseña de un jugador por
     * la enviada en el objeto Player del argumento
     * @param player
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public int updatePassword(Player player) throws SQLException, ClassNotFoundException {

        Connection con = null;

        try {
            con = connector.getMySQLConnection();
            return manager.updatePassword(con, player);
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

}
