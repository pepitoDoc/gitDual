package edu.fpdual.controller;

import edu.fpdual.api.dto.Player;
import edu.fpdual.persistence.connector.MySQLConnector;
import edu.fpdual.persistence.manager.impl.PlayerManagerImpl;
import edu.fpdual.service.PlayerService;
import jakarta.ws.rs.core.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayerControllerTest {

    @InjectMocks
    private PlayerController playerControllerInject;

    @Mock
    private PlayerController playerControllerMock;

    @Mock
    private PlayerService playerServiceMock;

    @Mock
    private PlayerManagerImpl playerManagerMock;

    @Mock
    private Connection connectionMock;

    @Mock
    private MySQLConnector connectorMock;

    @Mock
    private Player playerMock;

    @Mock
    private PreparedStatement preparedStatementMock;

    @Test
    public void testInsertPlayer_ok() throws SQLException, ClassNotFoundException {

    }

    @Test
    public void testInsertPlayer_ko() throws SQLException, ClassNotFoundException {

        when(playerControllerMock.insertPlayer(playerMock)).thenReturn(Response.serverError().build());

        Response response = playerControllerMock.insertPlayer(playerMock);

        MatcherAssert.assertThat(response.getStatus(), Matchers.is(500));

    }

    @Test
    public void testFindPlayerByName_ok() throws SQLException, ClassNotFoundException{

        Response response = playerControllerInject.findPlayerByName("");

        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());

    }

    @Test
    public void testFindPlayer_ok() throws SQLException, ClassNotFoundException{

        Response response = playerControllerInject.findPlayer("", "");
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());

    }

}

