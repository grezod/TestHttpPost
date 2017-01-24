package iii.org.tw.testhttppost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import cz.msebera.android.httpclient.Header;

import static android.R.attr.width;
import static android.R.attr.x;
//***********
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
//************

public class MainActivity extends AppCompatActivity {
    OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String s ="";

        init();
    }

    private void init() {
        textView = (TextView)findViewById(R.id.textView);


        btnSend = (Button)findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //***********
                RequestBody requestBody =  RequestBody.create(JSON,"{\n" +
                        "  \"animalID\": 0,\n" +
                        "  \"animalData_animalTypeID\": 0,\n" +
                        "  \"animalName\": \"string\",\n" +
                        "  \"animalAddress\": \"string\",\n" +
                        "  \"animalDate\": \"string\",\n" +
                        "  \"animalGender\": \"string\",\n" +
                        "  \"animalAge\": 0,\n" +
                        "  \"animalColor\": \"string\",\n" +
                        "  \"animalBirth\": \"string\",\n" +
                        "  \"animalChip\": \"string\",\n" +
                        "  \"animalHealthy\": \"string\",\n" +
                        "  \"animalDisease_Other\": \"string\",\n" +
                        "  \"animalOwner_userID\": 0,\n" +
                        "  \"animalReason\": \"string\",\n" +
                        "  \"animalGetter_userID\": 0,\n" +
                        "  \"animalAdopted\": \"string\",\n" +
                        "  \"animalAdoptedDate\": \"string\",\n" +
                        "  \"animalNote\": \"123321\"\n" +
                        "}");

                //***************
                Request request = new Request.Builder()
                        //.url("http://atm201605.appspot.com/h")
                        //.build();
                .url("http://twpetanimal.ddns.net:9487/api/AnimalDatas")
                        .addHeader("Content-Type","application/x-www-form-urlencoded")
                        .post(requestBody)
                        .build();

                Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String json = response.body().string();
                        Log.d("http",json);



                        parseJson(json);

                    }
                });


                //*******************


            }
        });
        //****************
    }

    private void parseJson(String json) {
        //textView.setText("123");
        //*************
    }

    Button btnSend;
    TextView textView;
}


/*async

                //*******************
               // Toast.makeText(ScrollingActivity.this,"in Imgur Upload", Toast.LENGTH_SHORT).show();
                //String urlString = "https://imgur-apiv3.p.mashape.com/3/image/";

                String urlString = "http://twpetanimal.ddns.net:9487/api/AnimalDatas/2";
                //String urlString = "http://yahoo.com.tw";

                //String mashapeKey = "MaXLzROxvOmshVYRZbRxcLZL3s0ip1bnE2Kjsn8tf3B5bKRyig"; //設定自己的 Mashape Key
                //String clientId = "d8371f0a27e5085"; //設定自己的 Clinet ID
                //String titleString = "hihi45454545"; //設定圖片的標題
                //showLoadingDialog();



                AsyncHttpClient client = new AsyncHttpClient();
                //client.addHeader("X-Mashape-Key", mashapeKey);
                //client.addHeader("Authorization", "Client-ID "+clientId);
                //client.addHeader("Content-Type", "application/x-www-form-urlencoded");

                RequestParams params = new RequestParams();
                //params.put("title", titleString);
               // params.put("image", image);
                client.post



                client.get(urlString, params, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        //dismissLoadingDialog();
                        if (!response.optBoolean("success") || !response.has("data")) {
                            Log.d("editor", "response: "+response.toString());
                            Toast.makeText(MainActivity.this,"fail", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        //Toast.makeText(ScrollingActivity.this,"in On Success", Toast.LENGTH_SHORT).show();

                        JSONObject data = response.optJSONObject("data");
                        //Log.d("editor","link: "+data.optString("link"));
                        String link = data.optString("link","");
                        //int width = data.optInt("width",0);
                        //int height = data.optInt("height",0);
                        //String bbcode = "[img="+width+"x"+height+"]"+link+"[/img]";

                        Log.d("editor",data.optString("link"));
                        //Log.d("editor",bbcode);
                        //**
                        Toast.makeText(MainActivity.this,data.optString("link"),Toast.LENGTH_LONG).show();
                        //**

                    }


                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable e, JSONObject error) {

                        //Log.d("editor","error: "+error.toString());


                        Toast.makeText(MainActivity.this,"Error:! " + statusCode + " " + e.getMessage(), Toast.LENGTH_SHORT).show();


                    }
                });


                //************************

 */