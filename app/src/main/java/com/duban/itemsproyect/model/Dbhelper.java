package com.duban.itemsproyect.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Dbhelper extends SQLiteOpenHelper {
    public Dbhelper(@Nullable Context context) {
        super(context, Constantes.NAME_DB, null, Constantes.NUM_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(Constantes.SENTENCIA_PUBLICACION);
        } catch (Exception e) {
            e.printStackTrace(); // Esto se ve en Logcat
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Si en un futuro hay cambios en la base de datos
        db.execSQL("DROP TABLE IF EXISTS Publicacion");
        onCreate(db);
    }
}
