package com.Teslenochka.Production;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by e.teslenko on 16.04.14.
 */
public class DataBaseOpenHelper extends SQLiteOpenHelper {
    final public static String DB_NAME="training";
    final public static String TRAINING_TABLE_NAME ="trainings";
    final private Context mContext;
    final private static Integer VERSION = 1;
    //final private String CREATE_DB ="";

    public DataBaseOpenHelper(Context context){
        super(context,DB_NAME,null, VERSION);
        this.mContext = context;
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(TrainingDataBase.CREATE_DB_CMD);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //TODO: upgrade logic
    }

    public void deleteDatabase(){
        mContext.deleteDatabase(DB_NAME);
    }
}
