package com.project.udacity.inventoryapp.providers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.project.udacity.inventoryapp.R;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String LOG_TAG = DatabaseHelper.class.getName();

    private static final String DATABASE_NAME = "book_inventory_database.db";

    private static final int DATABASE_VERSION = 2;

    private static DatabaseHelper mInstance = null;

    private final Context mContext;

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    public static synchronized DatabaseHelper getInstance(Context ctx) {
        if (mInstance == null) {
            mInstance = new DatabaseHelper(ctx.getApplicationContext());
        }
        return mInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(DatabaseContract.BookEntry.CREATE_BOOK_TABLE);
        } catch (Exception ex){
            Log.e(LOG_TAG, mContext.getString(R.string.error_database_create));
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        try {
            sqLiteDatabase.execSQL(DatabaseContract.BookEntry.DROP_BOOK_TABLE);
            onCreate(sqLiteDatabase);
        } catch (Exception ex){
            Log.e(LOG_TAG, mContext.getString(R.string.error_database_upgrade));
        }
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}