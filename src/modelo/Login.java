/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author agustin
 */
public class Login {
    private String usuario;
    private String clave;
    
   
    
    public Login(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }
    
 
     
    public boolean verificarDatos(Login loginIngresado) {
        boolean res=false;
        for (Login usuario : Usuarios.getUsuarios()) {
            if(loginIngresado.usuario.equals(usuario.usuario) && loginIngresado.clave.equals(usuario.clave) ){
                res=true;
                break;
            }
        }
        return res;
    }



    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    
    
    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }

    @Override
    public String toString() {
        return "Login{" + "usuario=" + usuario + ", clave=" + clave + '}';
    }
    
    
}
