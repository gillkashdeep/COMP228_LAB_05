package Excercise1;

import java.util.Date;

public class Game {

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getPlayerDate() {
        return playerDate;
    }

    public void setPlayerDate(Date playerDate) {
        this.playerDate = playerDate;
    }

    public int getGameId() {
        return GameId;
    }

    public void setGameId(int gameId) {
        GameId = gameId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getPlayNGameId() {
        return PlayNGameId;
    }

    public void setPlayNGameId(int playNGameId) {
        PlayNGameId = playNGameId;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }


    public Game(String playerName,int playerId,String address,String postalCode,String province,String phoneNumber,
                String playerDate,int GameId,String score,String PlayNGameId,String gameTitle)
    {
        this.playerName=playerName;
        this.playerId = playerId;
        this.address = address;
        this.postalCode =postalCode;
        this.province =province;
        this.phoneNumber = phoneNumber;
        this.GameId = GameId;
        //this
    }

    public String playerName;
    public int playerId;
    public String address;
    public String postalCode;
    public String province;
    public String phoneNumber;
    public Date playerDate;
    public int GameId;
    public double score;
    public int PlayNGameId;
    public String gameTitle;




}
