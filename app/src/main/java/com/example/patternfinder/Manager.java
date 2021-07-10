package com.example.patternfinder;

import android.content.Context;
import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.*;

public class Manager {
    private Map<String, JSONObject> mp;
    Context ct;
    public Manager(Context ct) {
        this.mp=new HashMap<String,JSONObject>();
        this.ct=ct;
        try {
            readData();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String loadJSONFromAsset(String filename) {
        String json = null;
        try {
            InputStream is = this.ct.getAssets().open(filename);
            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;

    }

    public void readData() throws Exception {
        String path="OEISData";
        JSONObject obj2=new JSONObject(loadJSONFromAsset(path+"/"+"A001000.json"));
        Log.i("resultaaya",  obj2.getJSONObject("A001000").getString("name"));

        String[] listFiles=this.ct.getAssets().list(path);
        if (listFiles.length > 0) {
            // This is a folder
            for (String file : listFiles) {
                    // This is a file
                if(!file.contains(".json")) continue;
                JSONObject obj=new JSONObject(loadJSONFromAsset(path+"/"+file));

                Iterator<?> keys = obj.keys();
                while(keys.hasNext() ) {
                    String key = (String) keys.next();
                    this.mp.put(key, obj.getJSONObject(key));
                }

            }
        }
        for(Map.Entry<String,JSONObject> item:mp.entrySet()){
            String key=item.getKey();
            String name=item.getValue().getString("name");
            if(Integer.parseInt(key.substring(1,key.length())) % 5000==0)
            Log.i("Key "+key+" : ", " name :"+name);


        }


//        Log.i("itr", "onCreate: inside");
//
//        try {
//
//            for(var file:)
//            JSONObject json = new JSONObject(loadJSONFromAsset());
//
//            Log.i("out", json.getJSONObject("A000001").getString("name"));
//
//
//        } catch (Exception e) {
//            Log.d("result", "readData: done");
//
//        }
    }
}
