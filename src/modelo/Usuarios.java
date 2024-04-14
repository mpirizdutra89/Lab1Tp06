/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package modelo;


import java.util.ArrayList;

/**
 *
 * @author Martin
 */
public enum Usuarios {
    USUARIO_1("mpirizdutra89", "martin89"),
    USUARIO_2("FerrandoCarlos", "1234"),
    USUARIO_3("aguz11", "1234"),
    USUARIO_4("luis", "1234"),
    USUARIO_5("juan", "1234"),
    USUARIO_6("admin", "1234");

    private final String nombreUsuario;
    private final String clave;

    Usuarios(String nombreUsuario, String clave) {
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
    }

  

    // Método para obtener una lista de usuarios
    public static ArrayList<Login> getUsuarios() {
        ArrayList<Login> usuarios = new ArrayList<>();
        for (Usuarios usuario : Usuarios.values()) {
            usuarios.add(new Login(usuario.nombreUsuario, usuario.clave));
        }
        return usuarios;
    }
}
