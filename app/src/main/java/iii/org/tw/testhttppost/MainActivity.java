package iii.org.tw.testhttppost;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

import static android.R.attr.id;
import static android.R.attr.width;
import static android.R.attr.x;
import static android.media.CamcorderProfile.get;
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

    //**


    private ArrayList<String>[] iv_Array_動物品種清單;
    private ArrayList<String> iv_ArrayList_動物類別清單;


    //*
    OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    String callBackJson = "123";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String s = "";


        create根據動物類別產生品種字串(client,"");
        //init測試拿回動物類型();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2 = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void init測試拿回動物類型() {
        textView = (TextView) findViewById(R.id.textView);


        btnSend = (Button) findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //***********

                //***************
                Request request = new Request.Builder()
                        .url("http://twpetanimal.ddns.net:9487/api/v1/animalData_Type")
                        .addHeader("Content-Type", "raw")
                        .get()
                        .build();

                Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String json = response.body().string();
                        JSONArray jObj = null;
                        try {
                            jObj = new JSONArray(json);
                           // String id = jObj.getString("animalID");
                            for (int i =0;i<jObj.length();i+=1){
                                JSONObject j = (JSONObject) jObj.get(i);
                                if(j.getString("animalKind").equals("CAT")){

                                    Log.d("animalType",j.getString("animalType"));
                                }



                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        // Log.d("http",json);
                        //textView.setText(json);

                        parseJson(json);
                    }
                });


                //*******************

                textView.setText(callBackJson);
            }
        });
        //****************
    }


    private void init() {
        textView = (TextView) findViewById(R.id.textView);


        btnSend = (Button) findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //***********
                RequestBody requestBody = RequestBody.create(JSON, "{\n" +
                        "  \"animalID\": 0,\n" +
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
                        "  \"animalNote\": \"string\",\n" +
                        "  \"animalKind\": \"string\",\n" +
                        "  \"animalType\": \"string\",\n" +
                        "  \"animalData_Pic\": [\n" +
                        "    {\n" +
                        "      \"animalPicID\":0 ,\n" +
                        "      \"animalPic_animalID\":0 ,\n" +
                        "      \"animalPicAddress\": \"string\",\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"animalData_Condition\": [\n" +
                        "    {\n" +
                        "      \"conditionID\": 0,\n" +
                        "      \"condition_animalID\":0 ,\n" +
                        "      \"conditionAge\": \"string\",\n" +
                        "      \"conditionEconomy\": \"string\",\n" +
                        "      \"conditionHome\": \"string\",\n" +
                        "      \"conditionFamily\": \"string\",\n" +
                        "      \"conditionReply\": \"string\",\n" +
                        "      \"conditionPaper\": \"string\",\n" +
                        "      \"conditionFee\": \"string\",\n" +
                        "      \"conditionOther\": \"string\",\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}");

                //***************
                Request request = new Request.Builder()
                        .url("http://twpetanimal.ddns.net:9487/api/v1/AnimalDatas")
                        .addHeader("Content-Type", "raw")
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
                        Log.d("http", json);
                        //textView.setText(json);

                        parseJson(json);
                    }
                });


                //*******************

                textView.setText(callBackJson);
            }
        });
        //****************
    }

    private void parseJson(String json) {
        ArrayList<petData> petDataArrayList = new ArrayList<>();

        try {


            JSONObject jObj = new JSONObject(json);
            String id = jObj.getString("animalID");
            String place = jObj.getString("animalAddress");
            petData pet = new petData();
            Log.d("id", id);
            Log.d("Place", place);
            callBackJson = place;
            /*
            JSONArray array = new JSONArray(json);

            for (int i = 0; i < array.length(); i++) {
                JSONObject jObj = array.getJSONObject(i);
                String id = jObj.getString("animal_id");
                String place = jObj.getString("animal_place");
                petData pet = new petData();
                Log.d("id",id);
                Log.d("Place",place);

            }
*/
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    Button btnSend;
    TextView textView;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        client2.connect();
        AppIndex.AppIndexApi.start(client2, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        AppIndex.AppIndexApi.end(client2, getIndexApiAction());
        client2.disconnect();
    }

    public void create根據動物類別產生品種字串(OkHttpClient p_okHttpClient_client,String p_String_url) {

        if("".equals(p_String_url)){
            p_String_url = "http://twpetanimal.ddns.net:9487/api/v1/animalData_Type";
        }

        Request request = new Request.Builder()
                .url(p_String_url)
                .addHeader("Content-Type", "raw")
                .get()
                .build();

        Call call = p_okHttpClient_client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {


            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String json = response.body().string();
                JSONArray l_JSONArray_jObj = null;
                try {
                    l_JSONArray_jObj = new JSONArray(json);
                    iv_ArrayList_動物類別清單 = new ArrayList<String>();
                    //**
                    for (int i =0;i<l_JSONArray_jObj.length();i+=1) {
                        JSONObject l_JSONObject = (JSONObject) l_JSONArray_jObj.get(i);
                        if(!iv_ArrayList_動物類別清單.contains(l_JSONObject.getString("animalKind"))){
                            iv_ArrayList_動物類別清單.add(l_JSONObject.getString("animalKind"));
                            Log.d("l_JSString(animalType)",l_JSONObject.getString("animalType"));
                        }
                    }
                    Log.d("iv_ArrayList_動物類別清單",iv_ArrayList_動物類別清單.toString()+"共"+iv_ArrayList_動物類別清單.size()+"種");
                    iv_Array_動物品種清單 = new ArrayList[iv_ArrayList_動物類別清單.size()];
                    for (int j =1;j<=iv_ArrayList_動物類別清單.size();j+=1) {
                        iv_Array_動物品種清單[j-1]=new ArrayList<String>();
                    }


                    for (int i =0;i<l_JSONArray_jObj.length();i+=1) {
                        JSONObject l_JSONObject = (JSONObject) l_JSONArray_jObj.get(i);
                        for (int j =1;j<=iv_ArrayList_動物類別清單.size();j+=1) {

                           //Log.d("1",l_JSONObject.getString("animalKind"));
                           // Log.d("2",iv_ArrayList_動物類別清單.get(j-1));

                            if(l_JSONObject.getString("animalKind").equals(iv_ArrayList_動物類別清單.get(j-1))){
                                //iv_Array_動物品種清單[j-1].add(l_JSONObject.getString("animalType"));
                                iv_Array_動物品種清單[j-1].add(l_JSONObject.getString("animalType"));
                            }

                        }
                    }

                    for (int i =1;i<=iv_ArrayList_動物類別清單.size();i+=1) {
                        //iv_Array_動物品種清單[i-1].toString();
                        Log.d("第"+i+"份動物品種清單",iv_Array_動物品種清單[i-1].toString());
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });


        //*******************




        //****************
    }
}

