package com.example.listadetarefas.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public static int VERSION = 1;
    public static String NOME_DB = "DB_TAREFAS";
    public static String TABELA_TAREFAS = "tarefas";
   // public static String TABELA_USUARIOS = "usuarios";


    public DbHelper(@Nullable Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_TAREFAS
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " nome TEXT NOT NULL ); ";


                     //exemplo para criar mais tabelas
     /*   String sqlUsuarios = "CREATE TABLE IF NOT EXISTS " + TABELA_USUARIOS
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " nome TEXT NOT NULL ); ";  */

        try {
            db.execSQL(sql);
            //db.execSQL(sqlUsuarios);
            Log.i("INFO DB", "Sucesso ao criar Tabela APP ");
        } catch (Exception e) {
            Log.i("INFO DB", "Error ao criar a tabela " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



             String sql = " DROP TABLE " + TABELA_TAREFAS + " ; ";
           // String sql = " ALTER TABLE " + TABELA_TAREFAS + " ADD COLUMN  status VARCHAR(2)"; ex pra alterar tabela em um atualização



            try {
                db.execSQL(sql);
                onCreate(db);
                Log.i("INFO DB", "Sucesso ao atualizar APP ");
            } catch (Exception e) {
                Log.i("INFO DB", "Error ao atualizar APP  " + e.getMessage());
            }
    }
}
