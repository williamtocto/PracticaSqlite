package com.example.practicasqlite.modelo;

import android.content.Context;

public class Usuario {

    private int id;
    private String usuario;
    private String password;
    private String tipoUsuario;

    public Usuario() {
    }

    public Usuario(int id, String usuario, String password, String tipoUsuario) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }



    public void guardar(Context context) {
        DbHelper db = new DbHelper(context);
        System.out.println("hola");
       String noSql = "INSERT INTO usuario (id_usuario,usuario,clave,tipo_usuario) " +
            "VALUES (" + getId() + ",'" + getUsuario()+ "','" + getPassword() + "','" + getTipoUsuario()+ "');";
        db.noQuery(noSql);
        db.close();
    }

    public void Editar(Context context) {
        DbHelper db = new DbHelper(context);
        String noSql = "UPDATE usuario set usuario= ' "+getUsuario()+"', clave= '"+getPassword()+"'" +
                "where id_usuario="+getId()+";";
        db.noQuery(noSql);
        db.close();
    }

    public void eliminar(Context context){
        DbHelper db = new DbHelper(context);
        String noSql = "DELETE FROM usuario where id_usuario= "+getId();
        db.noQuery(noSql);
        db.close();

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }


}
