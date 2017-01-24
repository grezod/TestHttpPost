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
import java.util.ArrayList;

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
    String callBackJson = "123";


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

                textView.setText("1");
            }
        });
        //****************
    }

    private void parseJson(String json) {
       // ArrayList<>


    }

    Button btnSend;
    TextView textView;
}

