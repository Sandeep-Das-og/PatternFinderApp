package com.example.patternfinder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class DBHelper extends SQLiteOpenHelper {
    Context ct;
    public DBHelper(Context context) {

        super(context, "PatternData.db",null,1);
        this.ct=context;

    }
    public static String strSeparator = "__,__";
    public static String convertArrayToString(String[] array){
        String str = "";
        for (int i = 0;i<array.length; i++) {
            str = str+array[i];
            // Do not append comma at the end of last element
            if(i<array.length-1){
                str = str+strSeparator;
            }
        }
        return str;
    }
    public static String[] convertStringToArray(String str){
        String[] arr = str.split(strSeparator);
        return arr;
    }
    @Override
    public void onCreate(SQLiteDatabase DB) {

        DB.execSQL("CREATE TABLE PatternData(id TEXT primary key ,name TEXT ,pattern TEXT, formula TEXT)");
        Manager mgr = new Manager(this.ct);
        Map<String, JSONObject> mp=mgr.getMp();
        SQLiteDatabase DBB=DB;

        for (Map.Entry<String, JSONObject> item : mp.entrySet()) {
            String key = item.getKey();
            try{
            String name = item.getValue().getString("name");
            String pattern = item.getValue().getString("pattern");
            String[] formula=new String[0];

            Object forme = item.getValue().get("formula");
                if(forme instanceof JSONArray){
                     JSONArray form=(JSONArray) forme;
                    formula=new String[form.length()];
                    for(int i=0; i<formula.length; i++) {
                        formula[i]=form.optString(i);
                    }
                }
                boolean result=this.insertData(key,name,pattern,formula,DBB);

            }

            catch (Exception e){
                Log.i("are u running", " danger"+e.getMessage());

            }
        }

;

        Log.i("INSERT HUA","CHECK MY RESULT");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("drop table if exists PatternData");

    }
    public Boolean insertData(String id,String name,String pattern,String[] formula,SQLiteDatabase DB){
//        SQLiteDatabase DB=this.getWritableDatabase();

        String strformula=convertArrayToString(formula);

        ContentValues contentValues=new ContentValues();
        contentValues.put("id",id);
        contentValues.put("name",name);
        contentValues.put("pattern",pattern);
        contentValues.put("formula",strformula);
        long result=DB.insert("PatternData",null,contentValues);
        if(result==-1){
            return false;
        }

        return true;


    }


    public Cursor SearchData(String seq){
        String query="Select * from PatternData where instr(pattern,'," + seq + "')>0 or instr(pattern,'"+seq+"')==1";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cur=null;
        if(db!=null){
            cur=db.rawQuery(query,null);

        }
        return cur;

    }
}
