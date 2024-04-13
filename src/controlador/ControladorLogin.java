/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import java.awt.Font;
import javax.swing.JTextField;
import modelo.Login;
import vista.VistaLogin;

/**
 *
 * @author Matin
 */
public class ControladorLogin {
   
    private static Login loginModel;
    private static  VistaLogin lv=new VistaLogin();
    
    
   public static void Constructor(VistaLogin lv2) {
        lv=lv2;
        promptTxt();
    }

    
    
    public static void jBtnLogin() {
        try {

            loginModel = new Login(lv.getjTxtUser().getText(), lv.getjTxtClave().getText());
            if (validar()) {
                if (loginModel.verificarDatos(loginModel)) {
                      lv.dispose();   
                    controlador.ControladorMenuPrincipal.CargarVistaPrincipal(loginModel.getUsuario());
                } else {
                    ControladorMenuPrincipal.viewDialogo("Credenciales incorrectas", 1);
                    focus();
                }
            } else {
                ControladorMenuPrincipal.viewDialogo("Todo los campos son obligatorios", 1);
                focus();
            }
        } catch (Exception e) {
             ControladorMenuPrincipal.viewDialogo("Ocurrio un fallo insesperado", 0);
             resetText();
             focus();
        }
    }
    
    private static void focus(){
         lv.getjTxtUser().requestFocus();
    }
    
    private static void resetText(){
        lv.getjTxtUser().setText("");
        lv.getjTxtClave().setText("");
    }
    
    private static boolean validar(){
        return !lv.getjTxtUser().getText().isEmpty() && !lv.getjTxtClave().getText().isEmpty();
    }
    
    
    public static void CargarVistaLogin() {
        lv.setLocationRelativeTo(null);
        lv.setVisible(true);
        

    }
    private static void promptTxt() {
       ControladorMenuPrincipal.textPrompt(lv.getjTxtUser(), "Ingrese su Usaurio");
       ControladorMenuPrincipal.textPrompt(lv.getjTxtClave(), "Ingrese su clave");

    }
    
    

    
}
