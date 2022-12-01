package hexanome.thirteen.server.controller;

import junit.framework.TestCase;
import org.junit.Test;

public class LobbyServiceTest extends TestCase {

    /**
     * Test LobbyService creation
     */
    @Test
    public void testLobby(){
        LobbyService l = new LobbyService();
        try{
            l.registerGame();
        }
        catch (Exception e){

        }
        assertNotNull(l.getToken());
    }
}