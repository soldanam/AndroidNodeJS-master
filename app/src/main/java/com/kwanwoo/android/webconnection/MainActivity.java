package com.kwanwoo.android.webconnection;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "AndroidNodeJS";
    final static String defaultUrl = "http://13.124.142.127:80";//다솔

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText server = (EditText) findViewById(R.id.server);
        server.setText(defaultUrl);

        Button insertBtn = (Button) findViewById(R.id.insertBtn);//회원가입
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edit_ID = (EditText) findViewById(R.id.ID); //Title= ID 로 바꿈
                EditText edit_PASSWORD = (EditText) findViewById(R.id.PASSWORD);//content = Password 로 바꿈

                JSONObject postDataParam = new JSONObject();//JSON생성 : JSONObject는 JSON형태의 데이터를 관리해 주는 메서드
                try {
                    postDataParam.put("id", edit_ID.getText().toString());//데이터 집어넣기
                    postDataParam.put("password", edit_PASSWORD.getText().toString());
                } catch (JSONException e) {
                    Log.e(TAG, "JSONEXception");
                }
                new InsertData(MainActivity.this).execute(postDataParam); //ui 작업해주기 위해 asynctask 실행 insert에
            }
        });


        Button loginBtn = (Button) findViewById(R.id.login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText login_ID = (EditText) findViewById(R.id.login_id); //Title= ID 로 바꿈
                EditText login_PASSWORD = (EditText) findViewById(R.id.login_password);//content = Password 로 바꿈
                JSONObject postDataParam_login = new JSONObject();//JSON생성 : JSONObject는 JSON형태의 데이터를 관리해 주는 메서드
                try {
                    postDataParam_login.put("login_id", login_ID.getText().toString());//데이터 집어넣기
                    postDataParam_login.put("login_password", login_PASSWORD.getText().toString());
                } catch (JSONException e) {
                    Log.e(TAG, "JSONEXception");
                }
                new LoginData(MainActivity.this).execute(postDataParam_login);
            }
        });


        Button getBtn = (Button) findViewById(R.id.getBtn);
        getBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new GetData(MainActivity.this).execute();

            }
        });

        ListView txtList = (ListView) findViewById(R.id.txtList);
        txtList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Adapter adapter = adapterView.getAdapter();
                JSONObject postDataParam = new JSONObject();
                try {
                    postDataParam.put("id", ((Book)adapter.getItem(i)).id);
                } catch (JSONException e) {
                    Log.e(TAG, "JSONEXception");
                }
                new DeleteData(MainActivity.this).execute(postDataParam);
                new GetData(MainActivity.this).execute();
            }
        });

    }

    private void sendPostRequest(String s, String s1) {

    }


}


