package hexanome.thirteen.client.controller;

import static hexanome.thirteen.client.constant.UriConstant.SERVER_URL_ONE;
import static hexanome.thirteen.client.constant.UriConstant.SERVER_URL_TWO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * The controller class that handle requests from the server.
 */
public class ServerController {

  /**
   * For compilation.
   */
  public ServerController() {

  }

  /**
   * Main class for testing.
   *
   * @param args args
   */
  public static void main(String[] args) {
    ServerController serverController = new ServerController();
    try {
      serverController.getBoard(1);
      serverController.getTokens(1);
      serverController.getPlayers(1);
      serverController.getPlayer(1, "maex");
      serverController.getPlayerInventory(1, "maex");
      serverController.getnobleInventory(1, "maex");
      serverController.getBonusTokens(1, "maex");
      serverController.getPlayerReserved(1, "maex");
      serverController.getPlayerPrestige(1, "maex");
      //serverController.purchaseCard(1, "maex",6 );


    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Code provided by ARC

  /**
   * Get overrall game state.
   *
   * @param gameId current game id
   * @throws IOException exception
   */
  public void getBoard(int gameId) throws IOException {
    try {
      URL url = new URL(SERVER_URL_TWO + "splendor/api/games/" + gameId + "/board");
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod("GET");

      /* Payload support */
      /*
    con.setDoOutput(true);
    DataOutputStream out = new DataOutputStream(con.getOutputStream());
    out.writeBytes("{
        \n");
        out.writeBytes("    \"creator\": \"maex\",
            \n");
            out.writeBytes("    \"gameServer\": \"Colt Express\",
                \n");
                out.writeBytes("    \"players\": [
                    \n");
                    out.writeBytes("        {
                        \n");
                        out.writeBytes("            \"name\": \"maex\",
                            \n");
                            out.writeBytes("            \"preferredColour\": \"CAFFEE\"
                                \n");
                                out.writeBytes("        },
                                    \n");
                                    out.writeBytes("        {
                                        \n");
                                        out.writeBytes("            \"name\": \"joerg\",
                                            \n");
                                            out.writeBytes("            \"preferredColour\":
                                            \"1CE7EA\"
                                                \n");
                                                out.writeBytes("        }
                                                    \n");
                                                    out.writeBytes("    ],
                                                        \n");
                                                        out.writeBytes("    \"savegame\": \"\"
                                                            \n");
                                                            out.writeBytes("}");
    out.flush();
    out.close();
    */

      int status = con.getResponseCode();
      status += 0;
      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
      String inputLine;
      StringBuffer content = new StringBuffer();
      while ((inputLine = in.readLine()) != null) {
        content.append(inputLine);
      }
      in.close();
      con.disconnect();
      System.out.println("Response status: " + status);
      System.out.println(content.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Request get tokens for server.
   *
   * @param gameId game id
   * @throws IOException exception
   */
  public void getTokens(int gameId) throws IOException {

    try {
      URL url = new URL(SERVER_URL_TWO + "splendor/api/games/" + gameId + "/board/tokens");
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod("GET");

      /* Payload support */
      /*
    con.setDoOutput(true);
    DataOutputStream out = new DataOutputStream(con.getOutputStream());
    out.writeBytes("{
        \n");
        out.writeBytes("    \"creator\": \"maex\",
            \n");
            out.writeBytes("    \"gameServer\": \"Colt Express\",
                \n");
                out.writeBytes("    \"players\": [
                    \n");
                    out.writeBytes("        {
                        \n");
                        out.writeBytes("            \"name\": \"maex\",
                            \n");
                            out.writeBytes("            \"preferredColour\": \"CAFFEE\"
                                \n");
                                out.writeBytes("        },
                                    \n");
                                    out.writeBytes("        {
                                        \n");
                                        out.writeBytes("            \"name\": \"joerg\",
                                            \n");
                                            out.writeBytes("            \"preferredColour\":
                                            \"1CE7EA\"
                                                \n");
                                                out.writeBytes("        }
                                                    \n");
                                                    out.writeBytes("    ],
                                                        \n");
                                                        out.writeBytes("    \"savegame\": \"\"
                                                            \n");
                                                            out.writeBytes("}");
    out.flush();
    out.close();
     */

      int status = con.getResponseCode();
      status += 0;
      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
      String inputLine;
      StringBuffer content = new StringBuffer();
      while ((inputLine = in.readLine()) != null) {
        content.append(inputLine);
      }
      in.close();
      con.disconnect();
      System.out.println("Response status: " + status);
      System.out.println(content.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Get all players from the server.
   *
   * @param gameId game id
   * @throws IOException exception
   */
  public void getPlayers(int gameId) throws IOException {
    URL url = new URL(SERVER_URL_TWO + "splendor/api/games/" + gameId + "/players");
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");

    /* Payload support */
    /*
    con.setDoOutput(true);
    DataOutputStream out = new DataOutputStream(con.getOutputStream());
    out.writeBytes("{
        \n");
        out.writeBytes("    \"creator\": \"maex\",
            \n");
            out.writeBytes("    \"gameServer\": \"Colt Express\",
                \n");
                out.writeBytes("    \"players\": [
                    \n");
                    out.writeBytes("        {
                        \n");
                        out.writeBytes("            \"name\": \"maex\",
                            \n");
                            out.writeBytes("            \"preferredColour\": \"CAFFEE\"
                                \n");
                                out.writeBytes("        },
                                    \n");
                                    out.writeBytes("        {
                                        \n");
                                        out.writeBytes("            \"name\": \"joerg\",
                                            \n");
                                            out.writeBytes("            \"preferredColour\":
                                            \"1CE7EA\"
                                                \n");
                                                out.writeBytes("        }
                                                    \n");
                                                    out.writeBytes("    ],
                                                        \n");
                                                        out.writeBytes("    \"savegame\": \"\"
                                                            \n");
                                                            out.writeBytes("}");
    out.flush();
    out.close();

     */

    int status = con.getResponseCode();
    status += 0;
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer content = new StringBuffer();
    while ((inputLine = in.readLine()) != null) {
      content.append(inputLine);
    }
    in.close();
    con.disconnect();
    System.out.println("Response status: " + status);
    System.out.println(content.toString());
  }

  /**
   * Get individual player information.
   *
   * @param gameId     game id
   * @param playerName player name
   * @throws IOException exception
   */
  public void getPlayer(int gameId, String playerName) throws IOException {
    URL url = new URL(SERVER_URL_ONE + "splendor/api/games/" + gameId + "/players/" + playerName);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");

    int status = con.getResponseCode();
    status += 0;
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer content = new StringBuffer();
    while ((inputLine = in.readLine()) != null) {
      content.append(inputLine);
    }
    in.close();
    con.disconnect();
    System.out.println("Response status: " + status);
    System.out.println(content.toString());
  }

  /**
   * Get inventory of a specific player.
   *
   * @param gameId     game id
   * @param playerName player name
   * @throws IOException exception
   */
  public void getPlayerInventory(int gameId, String playerName) throws IOException {
    URL url = new URL(
        SERVER_URL_ONE + "splendor/api/games/" + gameId + "/players/"
            + playerName + "/inventory");
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");

    int status = con.getResponseCode();
    status += 0;
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer content = new StringBuffer();
    while ((inputLine = in.readLine()) != null) {
      content.append(inputLine);
    }
    in.close();
    con.disconnect();
    System.out.println("Response status: " + status);
    System.out.println(content.toString());
  }

  /**
   * get player's noble inventory.
   *
   * @param gameId     game id
   * @param playerName player name
   * @throws IOException exception
   */
  public void getnobleInventory(int gameId, String playerName) throws IOException {
    URL url = new URL(SERVER_URL_ONE + "splendor/api/games/" + gameId + "/players/" + playerName
        + "/nobleInventory");
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");

    int status = con.getResponseCode();
    status += 0;
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer content = new StringBuffer();
    while ((inputLine = in.readLine()) != null) {
      content.append(inputLine);
    }
    in.close();
    con.disconnect();
    System.out.println("Response status: " + status);
    System.out.println(content.toString());
  }

  /**
   * Get all bonus tokens of a player.
   *
   * @param gameId     game id
   * @param playerName player name
   * @throws IOException exception
   */
  public void getBonusTokens(int gameId, String playerName) throws IOException {
    URL url = new URL(SERVER_URL_ONE + "splendor/api/games/" + gameId + "/players/" + playerName
        + "/bonusTokens");
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");

    int status = con.getResponseCode();
    status += 0;
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer content = new StringBuffer();
    while ((inputLine = in.readLine()) != null) {
      content.append(inputLine);
    }
    in.close();
    con.disconnect();
    System.out.println("Response status: " + status);
    System.out.println(content.toString());
  }

  /**
   * Request player reserved card.
   *
   * @param gameId     game id
   * @param playerName player name
   * @throws IOException exception
   */
  public void getPlayerReserved(int gameId, String playerName) throws IOException {
    URL url = new URL(
        SERVER_URL_ONE + "splendor/api/games/" + gameId + "/players/" + playerName + "/reserved");
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");

    int status = con.getResponseCode();
    status += 0;
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer content = new StringBuffer();
    while ((inputLine = in.readLine()) != null) {
      content.append(inputLine);
    }
    in.close();
    con.disconnect();
    System.out.println("Response status: " + status);
    System.out.println(content.toString());
  }

  /**
   * Request player prestige points.
   *
   * @param gameId     game id
   * @param playerName player name
   * @throws IOException exception
   */
  public void getPlayerPrestige(int gameId, String playerName) throws IOException {

    URL url =
        new URL(SERVER_URL_ONE + "splendor/api/games/" + gameId + "/players/" + playerName
            + "/prestigePoints");
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");

    int status = con.getResponseCode();
    status += 0;
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer content = new StringBuffer();
    while ((inputLine = in.readLine()) != null) {
      content.append(inputLine);
    }
    in.close();
    con.disconnect();
    System.out.println("Response status: " + status);
    System.out.println(content.toString());

  }

  /**
   * Request to purchase a card from the server.
   *
   * @param gameId     game id
   * @param playerName player name
   * @param slotId     slot id
   * @throws IOException exception
   */
  public void purchaseCard(int gameId, String playerName, int slotId) throws IOException {

    URL url = new URL(SERVER_URL_ONE + "splendor/api/games/" + gameId + "/players/" + playerName
        + "/actions/purchase/" + slotId);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("POST");

    int status = con.getResponseCode();
    status += 0;
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer content = new StringBuffer();
    while ((inputLine = in.readLine()) != null) {
      content.append(inputLine);
    }
    in.close();
    con.disconnect();
    System.out.println("Response status: " + status);
    System.out.println(content.toString());
  }
}
