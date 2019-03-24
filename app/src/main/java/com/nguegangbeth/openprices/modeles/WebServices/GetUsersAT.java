package com.nguegangbeth.openprices.modeles.WebServices;

import android.os.AsyncTask;

import com.nguegangbeth.openprices.modeles.users;

import java.util.ArrayList;

public class GetUsersAT extends AsyncTask {

    private ArrayList<com.nguegangbeth.openprices.modeles.users> users;
    private Exception exception;
    private GetUserATResult getUserATResult;

    public GetUsersAT(GetUserATResult getUserATResult) {
        this.getUserATResult = getUserATResult;
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        try {
            users = OpenDataWS.getUsers();
        } catch (Exception e) {
            exception = e;
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

        if (getUserATResult != null) {

            if (exception != null) {
                getUserATResult.UserError(exception);
            } else {
                getUserATResult.UserChargee(users);
            }
        }

    }

    public interface GetUserATResult {
        void UserChargee(ArrayList<users> user);

        void UserError(Exception exception);
    }
}
