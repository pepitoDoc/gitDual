package edu.fpdual.service;

import edu.fpdual.api.dto.GameSiete;
import edu.fpdual.persistence.connector.MySQLConnector;
import edu.fpdual.persistence.manager.impl.GameSieteManagerImpl;
import lombok.Getter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
@Getter
/**
 * @author: Álvaro Terrasa y Artem Korzhan
 * @version: 1.0
 * Clase de servicio para el siete y medio. Gestiona la conexión con la BBDD
 * y se encarga de ejecutar los métodos SQL de persistencia, haciendo de capa
 * intermedia entre esta y su controlador pertinente.
 */
public class GameSieteService {

    /**
     * Clase del conector.
     */
    private MySQLConnector connector;
    /**
     * Clase de implementación de métodos SQL.
     */
    private GameSieteManagerImpl manager;

    /**
     * Constructor que crea el objeto de servicio con sus atributos
     * @param connector - MySQLConnector
     * @param manager - GameSieteManagerImpl
     */
    public GameSieteService(MySQLConnector connector, GameSieteManagerImpl manager) {
        this.connector = connector;
        this.manager = manager;
    }

    /**
     * Realiza una operación insert que introduce una partida en la BBDD.
     * @param gameSiete - GameSiete
     * @return int - Resultado de la operación
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public int insertGame(GameSiete gameSiete) throws SQLException, ClassNotFoundException {

        Connection con = null;

        try {
            con = connector.getMySQLConnection();
            return manager.insert(con, gameSiete);
        } finally {
            if (con!=null) {
                con.close();
            }
        }
    }

    /**
     * Realiza una consulta select en la BBDD que devuelve una lista de GameSiete
     * @param nickname - String
     * @return - List<GameSiete> - Lista de partidas recuperadas
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<GameSiete> findGameByName(String nickname) throws SQLException, ClassNotFoundException {

        Connection con = null;
        try {
            con = connector.getMySQLConnection();
            return manager.findByName(con, nickname);
        } finally {
            if (con!=null) {
                con.close();
            }
        }
    }

}
