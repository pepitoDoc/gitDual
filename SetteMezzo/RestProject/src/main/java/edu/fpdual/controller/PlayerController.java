package edu.fpdual.controller;

import edu.fpdual.api.dto.Player;
import edu.fpdual.persistence.connector.MySQLConnector;
import edu.fpdual.persistence.manager.impl.PlayerManagerImpl;
import edu.fpdual.service.PlayerService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;

/**
 * @author: Álvaro Terrasa y Artem Korzhan
 * @version: 1.0
 * Clase que contiene la API para gestionar la BBDD de jugadores.
 * Se accede a sus métodos mediante la URL "/RestProject/api/player"
 */
@Path("/player")
public class PlayerController {

    private PlayerService service;

    /**
     * Realiza una operación insert que registra un usuario en la BBDD.
     * @param player - Player
     * @return
     * <u>
     * <li>Response.status(Response.Status.CREATED) - Operación exitosa</li>
     * <li>Response.serverError() - Operación fallida</li>
     * </u>
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @POST
    @Path("/insertPlayer")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertPlayer(Player player) throws SQLException, ClassNotFoundException{

        service = new PlayerService(new MySQLConnector(), new PlayerManagerImpl());
        int result = service.insertPlayer(player);
        if (result > 0) {
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.serverError().build();
        }
    }

    /**
     * Realiza una consulta select para buscar jugadores que contengan
     * el nombre o el email proporcionado en los QueryParam.
     * @param nickname - String - QueryParam
     * @param email - String - QueryParam
     * @return - Response con el jugador encontrado
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @GET
    @Path("/findPlayer")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findPlayer(
            @QueryParam("nickname") String nickname, @QueryParam("email") String email)
            throws SQLException, ClassNotFoundException {

        service = new PlayerService(new MySQLConnector(), new PlayerManagerImpl());
        Player playerFound = service.findPlayer(nickname, email);
        return Response.ok().entity(playerFound).status(Response.Status.CREATED).build();
    }

    /**
     * Realiza una consulta select para buscar jugadores que contengan
     * el nombre proporcionado en el QueryParam.
     * @param nickname - String - QueryParam
     * @return - Response con el jugador encontrado
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @GET
    @Path("/findPlayerByName")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findPlayerByName(
            @QueryParam("nickname") String nickname)
            throws SQLException, ClassNotFoundException {

        service = new PlayerService(new MySQLConnector(), new PlayerManagerImpl());
        Player playerFound = service.findPlayerByName(nickname);
        return Response.ok().entity(playerFound).status(Response.Status.CREATED).build();
    }

    /**
     * Realiza una operación update que cambia la contraseña de
     * un usuario en la BBDD que contenga el email del jugador proporcionado
     * @param player - Player
     * @return
     * <u>
     * <li>Response.status(Response.Status.CREATED) - Operación exitosa</li>
     * <li>Response.serverError() - Operación fallida</li>
     * </u>
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @POST
    @Path("/updatePassword")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updatePassword(Player player) throws SQLException, ClassNotFoundException {

        service = new PlayerService(new MySQLConnector(), new PlayerManagerImpl());
        int result = service.updatePassword(player);
        if (result > 0) {
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.serverError().build();
        }

    }
}
