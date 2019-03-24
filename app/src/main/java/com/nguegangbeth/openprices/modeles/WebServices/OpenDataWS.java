package com.nguegangbeth.openprices.modeles.WebServices;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nguegangbeth.openprices.modeles.users;

import java.util.ArrayList;

/**
 * Created by johnn on 08/03/2018.
 */

public class OpenDataWS {

    private static final String WS_URL = "http://192.168.137.1/openprice/userGET";

    public static ArrayList<users> getUsers() throws Exception {
        String reponseEnJson = OkHttpUtils.sendGetOkHttpRequest(WS_URL);

        Gson gson = new Gson();

        return gson.fromJson(reponseEnJson, new TypeToken<ArrayList<users>>() {
        }.getType());

    }


    /*public static Administrator getAdmin() throws Exception {
        String reponseEnJson = OkHttpUtils.sendGetOkHttpRequest(WS_URL);

        Gson gson = new Gson();

        Administrator user = gson.fromJson(reponseEnJson, Administrator.class);

        return user;

    }

    public static ArrayList<Planning> getPlannings() throws Exception {

        String reponseEnJson = OkHttpUtils.sendGetOkHttpRequest(WS_URL_PLANNING);

        Gson gson = new Gson();

        return gson.fromJson(reponseEnJson, new TypeToken<ArrayList<Planning>>() {
        }.getType());

    }

    public static ArrayList<TeamPlayers> getTeamPlayers() throws Exception {

        String reponseEnJson = OkHttpUtils.sendGetOkHttpRequest(WS_URL_TEAMS);

        Gson gson = new Gson();

        ArrayList<TeamPlayers> players = gson.fromJson(reponseEnJson, new TypeToken<ArrayList<TeamPlayers>>() {
        }.getType());


        return players;
    }

    public static ArrayList<TeamPlay> getTeamPlay() throws Exception {

        String reponseEnJson = OkHttpUtils.sendGetOkHttpRequest(WS_URL_TEAMSPLAY);

        Log.i("teams", reponseEnJson);
        Gson gson = new Gson();

        ArrayList<TeamPlay> teamPlays = gson.fromJson(reponseEnJson, new TypeToken<ArrayList<TeamPlay>>() {
        }.getType());

        return teamPlays;
    }

    public static ArrayList<Days> getDays() throws Exception {

        String reponseEnJson = OkHttpUtils.sendGetOkHttpRequest(WS_URL_DAYS);

        Log.i("teams", reponseEnJson);
        Gson gson = new Gson();

        ArrayList<Days> days = gson.fromJson(reponseEnJson, new TypeToken<ArrayList<Days>>() {
        }.getType());

        return days;
    }

    public static ArrayList<Score> getScores() throws Exception {

        String reponseEnJson = OkHttpUtils.sendGetOkHttpRequest(WS_URL_SCORES);

        Log.i("teams", reponseEnJson);
        Gson gson = new Gson();

        ArrayList<Score> scores = gson.fromJson(reponseEnJson, new TypeToken<ArrayList<Score>>() {
        }.getType());

        return scores;
    }

    public static ArrayList<MatchPlayer> getMatchPlayer() throws Exception {

        String reponseEnJson = OkHttpUtils.sendGetOkHttpRequest(WS_URL_MATCHPLAYER);

        Log.i("teams", reponseEnJson);
        Gson gson = new Gson();

        ArrayList<MatchPlayer> matchPlayers = gson.fromJson(reponseEnJson, new TypeToken<ArrayList<MatchPlayer>>() {
        }.getType());

        return matchPlayers;
    }

    public static ArrayList<Classement> getClassement() throws Exception {

        String reponseEnJson = OkHttpUtils.sendGetOkHttpRequest(WS_URL_CLASSEMENT);

        Log.i("teams", reponseEnJson);
        Gson gson = new Gson();

        ArrayList<Classement> classements = gson.fromJson(reponseEnJson, new TypeToken<ArrayList<Classement>>() {
        }.getType());

        return classements;
    }

    public static ArrayList<Butteur> getButteur() throws Exception {

        String reponseEnJson = OkHttpUtils.sendGetOkHttpRequest(WS_URL_BUTTEUR);

        Log.i("teams", reponseEnJson);
        Gson gson = new Gson();

        ArrayList<Butteur> butteurs = gson.fromJson(reponseEnJson, new TypeToken<ArrayList<Butteur>>() {
        }.getType());

        return butteurs;
    }*/


}
