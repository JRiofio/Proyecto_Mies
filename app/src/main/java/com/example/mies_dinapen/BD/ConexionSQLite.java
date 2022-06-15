package com.example.mies_dinapen.BD;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.mies_dinapen.Entidades.Usuario;

import java.util.ArrayList;

public class ConexionSQLite  {

    //final String Tbla_user="CREATE TABLE usuarios (id INTEGER, cedula INTEGER, nombres TEXT, apellidos TEXT, direccion TEXT, telefono INTEGER, email TEXT, password VARCHAR2, cargo TEXT)";

    private final String    DATABASE_NAME="Usuarios_Dinapen";
    private final String    DATABASE_TABLE="usuario";
    private final int       DATABASE_VERSION=1;

    private static final String KEY_ID= "_id";
    private static final String KEY_CEDULA= "_cedula";
    private static final String KEY_NOMBRE= "_nombres";
    private static final String KEY_APELLIDOS = "_apellidos";
    private static final String KEY_DIRECCION = "_direccion";
    private static final String KEY_TELEFONO= "_telefono";
    private static final String KEY_EMAIL= "_email";
    private static final String KEY_PASSWORD= "_password";
    private static final String KEY_CARGO= "_cargo";

    private DBHelper ourHelper;
    private final Context ourContext;
    private SQLiteDatabase outDatabase;

    public ConexionSQLite(Context ourContext) {
        this.ourContext = ourContext;
    }

    public ConexionSQLite open() throws SQLException {
        this.ourHelper = new DBHelper(ourContext);
        this.outDatabase= this.ourHelper.getWritableDatabase();
        return this;
    }
    public void close(){
        this.ourHelper.close();
    }

    public ArrayList<Usuario> getUsuario(){
        String[] columnas= new String[] {KEY_ID,KEY_CEDULA,KEY_NOMBRE,KEY_APELLIDOS,KEY_DIRECCION,KEY_TELEFONO,KEY_EMAIL,KEY_PASSWORD,KEY_CARGO};
        Cursor c= this.outDatabase.query(DATABASE_TABLE, columnas,null,null,null,null,null);

        ArrayList<Usuario>result =new ArrayList<>();

        int iId=c.getColumnIndex(KEY_ID);
        int iCedula=c.getColumnIndex(KEY_CEDULA);
        int iNombres=c.getColumnIndex(KEY_NOMBRE);
        int iApellidos=c.getColumnIndex(KEY_APELLIDOS);
        int iDireccion=c.getColumnIndex(KEY_DIRECCION);
        int iTelefono=c.getColumnIndex(KEY_TELEFONO);
        int iEmail=c.getColumnIndex(KEY_EMAIL);
        int iPassword=c.getColumnIndex(KEY_PASSWORD);
        int iCargo=c.getColumnIndex(KEY_CARGO);

        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            int id= c.getInt(iId);
            int cedula = c.getInt(iCedula);
            String nombres= c.getString(iNombres);
            String apellidos= c.getString(iApellidos);
            String direccion= c.getString(iDireccion);
            int telefono= c.getInt(iTelefono);
            String email= c.getString(iEmail);
            String password= c.getString(iPassword);
            String cargo= c.getString(iCargo);

            Usuario usuario=new Usuario(id,cedula,nombres,apellidos,direccion,telefono,email,password,cargo);
            result.add(usuario);

        }
        c.close();
        return result;




    }


    private class DBHelper extends SQLiteOpenHelper{


        public DBHelper(@Nullable Context context) {
            super(context, DATABASE_NAME,   null , DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql= "CREATE TABLE " + DATABASE_TABLE + "("+
                    KEY_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    KEY_CEDULA + "INTEGER NOT NULL,"+
                    KEY_NOMBRE + "TEXT NOT NULL,"+
                    KEY_APELLIDOS + "TEXT NOT NULL,"+
                    KEY_DIRECCION + "TEXT NOT NULL,"+
                    KEY_TELEFONO + "INTEGER NOT NULL,"+
                    KEY_EMAIL + "TEXT NOT NULL,"+
                    KEY_PASSWORD + "TEXT NOT NULL,"+
                    KEY_CARGO + "TEXT NOT NULL);";

            db.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);

        }
    }
}
