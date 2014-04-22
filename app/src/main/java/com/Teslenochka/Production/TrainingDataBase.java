package com.Teslenochka.Production;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by e.teslenko on 16.04.14.
 */
public final class TrainingDataBase { //singleton
    private TrainingDataBase(Context context){
        mContext = context;
        mDbHelper = new DataBaseOpenHelper(mContext);


    };

    private SQLiteDatabase mDB =null;
    private DataBaseOpenHelper mDbHelper;
    private final Context mContext;

    private static TrainingDataBase instance = null;
    public static TrainingDataBase getInstance(){
        if (instance == null)
        {
            throw new RuntimeException("not initialized!!!");
        }
        return instance;
    }

    public static TrainingDataBase init(Context context){
        if (instance != null) throw new RuntimeException ("already initialized");
        return instance = new TrainingDataBase(context);
    }

    public Cursor getAllTrainings(){

        mDB = mDbHelper.getReadableDatabase();
        String[] args = {
            Training.COLUMN_T_NAME,
            TrainingType.COLUMN_TT_NAME };
        String queryStr = "SELECT " +Training.TABLE_NAME+"." +Training.COLUMN_T_NAME + ", " +
                TrainingType.TABLE_NAME+"."+TrainingType.COLUMN_TT_NAME +
                " FROM "+Training.TABLE_NAME + " INNER JOIN " + TrainingType.TABLE_NAME +
                " ON " + Training.TABLE_NAME+"."+ Training.COLUMN_T_ID +"=" + TrainingType.TABLE_NAME+"."+TrainingType.COLUMN_TT_ID;

        return mDB.rawQuery(queryStr,args,null);
    }

    public void insertTrainingType(String name){

    }

    public void insertTraining (String name, String type){

    }


    public abstract class TrainingType {
        public static final String TABLE_NAME="TrainingTypes";
        public static final String COLUMN_TT_NAME ="tt_name";
        public static final String COLUMN_TT_ID ="tt_ID";
        public static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+ "(" + COLUMN_TT_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " +COLUMN_TT_NAME + " TEXT NOT NULL)";

    }
    public abstract class Training { //trainings table
        public static final String TABLE_NAME="Trainings";
        public static final String COLUMN_T_NAME ="t_name";
        public static final String COLUMN_T_ID ="t_ID";
        public static final String COLUMN_T_TRAINING_TYPE ="";
        public static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+ "(" + COLUMN_T_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " +COLUMN_T_NAME + " TEXT NOT NULL,"+ COLUMN_T_TRAINING_TYPE +"INTEGER,"+
        "FOREIGN KEY ("+ COLUMN_T_TRAINING_TYPE +") REFERENCES "+ TrainingType.TABLE_NAME +"("+ TrainingType.COLUMN_TT_ID+") )";
    }

    public static final String CREATE_DB_CMD = TrainingType.CREATE_TABLE + ';' + Training.CREATE_TABLE;


}
