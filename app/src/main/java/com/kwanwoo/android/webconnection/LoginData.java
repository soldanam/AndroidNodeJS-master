package com.kwanwoo.android.webconnection;

import android.app.Activity;
import android.widget.EditText;

import java.net.MalformedURLException;
import java.net.URL;


public class LoginData extends PostRequest_login {
    public LoginData(Activity activity) {
        super(activity);
    }

    @Override
    protected void onPreExecute() {
        EditText server = activity.findViewById(R.id.server);
        String serverURLStr = server.getText().toString();
        try {
            url = new URL(serverURLStr + "/login");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


}
