package com.example.practicasqlite.modelo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NOMBRE = "tienda.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLA_CLIENTE = "cliente";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override


    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        String sql = "CREATE TABLE usuario  (" +
                "id_usuario INTEGER NOT NULL," +
                "tipo_usuario TEXT NOT NULL," +
                "usuario TEXT," +
                "clave TEXT," +
                "PRIMARY KEY(id_usuario)); ";

        sqLiteDatabase.execSQL(sql);

        String sql_1 = " CREATE TABLE cliente ( " +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "nombre	TEXT NOT NULL," +
                "apellido	TEXT NOT NULL," +
                "fecha_nacimiento	DATE," +
                "direccion	NUMERIC," +
                "telefono	TEXT," +
                "correo	TEXT," +
                "id_usuario	INTEGER," +
                "FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario))";

        sqLiteDatabase.execSQL(sql_1);

       String sql_2 = "CREATE TABLE categoria ( " +
                "id_categoria INTEGER," +
                "nombre	TEXT," +
                "PRIMARY KEY(id_categoria));";

        sqLiteDatabase.execSQL(sql_2);


       String sql_3 = "CREATE TABLE  producto  ("+
        "id_producto INTEGER,"+
                "nombre TEXT NOT NULL,"+
                "descripcion TEXT,"+
                "precio REAL NOT NULL,"+
                "stock INTEGER,"+
                "id_categoria INTEGER,"+
                "PRIMARY KEY(id_producto),"+
                "FOREIGN KEY(id_categoria) REFERENCES categoria(id_categoria));";
        sqLiteDatabase.execSQL(sql_3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void noQuery( String sql){
        this.getWritableDatabase().execSQL(sql);
    }

    public Cursor query(String sql){
      return  this.getReadableDatabase().rawQuery(sql,null);
    }
}
