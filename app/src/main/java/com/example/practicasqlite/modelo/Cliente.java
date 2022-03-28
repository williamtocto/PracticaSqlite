package com.example.practicasqlite.modelo;

import android.content.Context;

public class Cliente {
    private String nombre;
    private int id;
    private String fecha_nac;
    private String apellido;
    private String direccion;
    private String telefono;
    private String correo;
    private int id_usuario;

    public Cliente() {

    }
    public Cliente(String nombre, int id, String fecha_nac, String apellido, String direccion, String telefono, String correo, int id_usuario) {
        this.nombre = nombre;
        this.id = id;
        this.fecha_nac = fecha_nac;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.id_usuario = id_usuario;
    }

    public void Guardar(Context context) {
        DbHelper db = new DbHelper(context);
        String noSql = "INSERT INTO cliente (id,nombre,apellido,fecha_nacimiento,direccion,telefono,correo,id_usuario)" +
                "VALUES (" + getId() + ",'" + getNombre() + "','" + getApellido() + "','" + getFecha_nac() + "','" + getDireccion() +
                "','" + getTelefono() + "','" + getCorreo() + "'," + getId_usuario() + ");";
        db.noQuery(noSql);
        db.close();
    }

    public void editar(Context context) {
        DbHelper db = new DbHelper(context);
        String noSql = "UPDATE cliente set nombre= '" + getNombre() + "', apellido= '" + getApellido() + "', " +
                "fecha_nacimiento=  '" + getApellido() + "', fecha_nacimiento = '" + getFecha_nac() + "'," +
                " Direccion=  '" + getDireccion() + "', telefono= '" + getTelefono() + "', correo =  '" + getCorreo() + "'" +
                " where id= " + getId() + ";";
        db.noQuery(noSql);
        db.close();
    }

    public void eliminar(Context context){
        DbHelper db = new DbHelper(context);
        String noSql = "DELETE FROM cliente where id= "+getId();
        db.noQuery(noSql);
        db.close();

    }



    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }


}
