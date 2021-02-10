/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import modelo.Usuario;

/**
 *
 * @author migue
 */
public class UsuarioDao extends GeneralDao<Usuario> {

    private FileWriter fw;
    private File[] listausuario;
    private String cadena;
    private StringTokenizer token;
    private Scanner scanllave;

    public void agregar(Usuario usuario) {
        pacientes = new File(getCarpetaUsuario() + "\\" + usuario.getNombreusuario() + ".txt");
        cadena = usuario.getContraseña() + ":" + usuario.getCorreo() + ":" + usuario.getEdad() + ":" + usuario.getTelefono()
                + ":" + usuario.getNombre() + "\n";

        try {
            fw = new FileWriter(pacientes, true);
            fw.write(cadena);
            fw.close();
        } catch (Exception io) {

        }
    }

    public boolean Loguear(Usuario usuario) {
        String susuario = usuario.getNombreusuario() + ".txt";
        System.out.println(susuario);

        listausuario = getCarpetaUsuario().listFiles();

        for (int i = 0; i < listausuario.length; i++) {
            System.out.println(susuario + "==" + listausuario[i].getName());

            if (susuario.equals(listausuario[i].getName())) {
                pacientes = new File(getCarpetaUsuario() + "\\" + listausuario[i].getName());

                try {
                    scanllave = new Scanner(pacientes);
                    cadena = scanllave.nextLine();
                    System.out.println(cadena);
                    token = new StringTokenizer(cadena, ":");
                    cadena = token.nextToken();
                    System.out.println(cadena);

                    if (usuario.getContraseña().equals(cadena)) {
                        return false;
                    } else {
                        return true;
                    }

                } catch (Exception io) {

                }

            }
        }

        return true;
    }

}
