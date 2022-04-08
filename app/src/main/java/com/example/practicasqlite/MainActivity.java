package com.example.practicasqlite;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.example.practicasqlite.modelo.Cliente;
import com.example.practicasqlite.modelo.DbHelper;
import com.example.practicasqlite.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btneliminar;
    Button btnCrear;
    Button btnEditar;
    Button btnGrabar;
    EditText id, nombre, apellido, direccion, telefono, correo, usuario, clave, fecha;
    ListView listViewcliente;

    ArrayList<String> datos;
    ArrayAdapter arrayAdapter ;
    Cliente cli = new Cliente();
    List<Cliente> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCrear = findViewById(R.id.btn_Crear);
        listar();
        listViewcliente = (ListView) findViewById(R.id.listViewCliente);

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, datos);

        listViewcliente.setAdapter(arrayAdapter);

        btnCrear.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DbHelper dbHelper = new DbHelper(MainActivity.this);
                        SQLiteDatabase db = dbHelper.getReadableDatabase();
                        if (db != null) {
                            Toast.makeText(getApplicationContext(), "Base Creada", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Error al ", Toast.LENGTH_LONG).show();
                        }
                    }
                }

        );


        // Grabar
        btnGrabar = findViewById(R.id.btn_grabar);
        id = findViewById(R.id.txt_id);
        nombre = findViewById(R.id.txt_Nombre);
        apellido = findViewById(R.id.txt_apellido);
        direccion = findViewById(R.id.txt_direccion);
        correo = findViewById(R.id.txt_correo);
        telefono = findViewById(R.id.txt_telefono);
        usuario = findViewById(R.id.txt_usuario);
        clave = findViewById(R.id.txt_clave);
        fecha = findViewById(R.id.txt_fecha);
        btnEditar = findViewById(R.id.btn_editar);
        btneliminar = findViewById(R.id.btn_eliminar);


        btnGrabar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        guardarDatos(1);

                    }
                }

        );

        btnEditar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        guardarDatos(2);

                    }
                }
        );

        btneliminar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        eliminar();

                    }
                }
        );

    }

    public void guardarDatos(int op) {
        Usuario user = new Usuario();

        user.setId(10);
        user.setUsuario(usuario.getText().toString());
        user.setPassword(clave.getText().toString());
        user.setTipoUsuario("Cliente");

        if (op == 1) {
            user.guardar(MainActivity.this);
        } else if (op == 2) {
            user.Editar(MainActivity.this);
        }

        Cliente cli = new Cliente();

        cli.setId(Integer.parseInt(id.getText().toString()));
        cli.setNombre(nombre.getText().toString());
        cli.setApellido(apellido.getText().toString());
        cli.setDireccion(direccion.getText().toString());
        cli.setTelefono(telefono.getText().toString());
        cli.setCorreo(correo.getText().toString());
        cli.setFecha_nac(fecha.getText().toString());
        cli.setId_usuario(1);

        if (op == 1) {
            cli.Guardar(MainActivity.this);
            Toast.makeText(getApplicationContext(), "Clinte creado".toString(), Toast.LENGTH_LONG).show();
        } else if (op == 2) {
            cli.editar(MainActivity.this);
            Toast.makeText(getApplicationContext(), "Clinte Editado".toString(), Toast.LENGTH_LONG).show();
        }
        actualizar();

    }


    public void eliminar() {
        Usuario user = new Usuario();
        user.setId(1);
        user.eliminar(MainActivity.this);

        cli.setId(Integer.parseInt(id.getText().toString()));
        cli.eliminar(MainActivity.this);

        Toast.makeText(getApplicationContext(), "Clinte Eliminado".toString(), Toast.LENGTH_LONG).show();
        actualizar();
    }

    public void listar() {
        datos = new ArrayList<String>();
        lista = cli.listar(MainActivity.this);

        for (int i = 0; i < lista.size(); i++) {
             datos.add(lista.get(i).getId()+" "+lista.get(i).getNombre()+"--"+lista.get(i).getApellido()
                     +"--"+ lista.get(i).getDireccion()+"--"+lista.get(i).getFecha_nac()+"--"+
                     lista.get(i).getCorreo());
        }
    }

    public  void actualizar(){
        lista.clear();
        listar();
        arrayAdapter.notifyDataSetChanged();
    }


}