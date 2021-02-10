package control;

import DAO.UsuarioDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Usuario;
import vista.LoginVista;
import vista.RegistroUsuarioVista;

/**
 *
 * @author migue
 */
public class RegistroUsuarioControl implements ActionListener {

    private boolean flag;
    private RegistroUsuarioVista ruv;
    private Usuario usuario;
    private UsuarioDao usuariodao;
    private LoginVista loginvista;

    public RegistroUsuarioControl(RegistroUsuarioVista ruv, Usuario usuario, UsuarioDao usuariodao, LoginVista loginvista) {
        flag = false;
        this.ruv = ruv;
        this.usuario = usuario;
        this.usuariodao = usuariodao;
        this.loginvista = loginvista;

        this.ruv.getBfinalizar().addActionListener(this);
        this.ruv.getBregresar().addActionListener(this);
    }

    public void actionPerformed(ActionEvent evento) {

        if (this.ruv.getBfinalizar() == evento.getSource()) {

            if (this.ruv.getTnombre().getText().equals("")) {
                this.ruv.getAnombre().setEnabled(true);
                flag = true;
            } else {
                usuario.setNombre(ruv.getTnombre().getText());
                this.ruv.getAnombre().setEnabled(false);
            }

            if (this.ruv.getTnombreusuario().getText().equals("")) {
                this.ruv.getAnombreusuario().setEnabled(true);
                flag = true;
            } else {
                usuario.setNombreusuario(ruv.getTnombreusuario().getText());
                this.ruv.getAnombreusuario().setEnabled(false);
            }

            if (this.ruv.getTcorreo().getText().equals("")) {
                this.ruv.getAcorreo().setEnabled(true);
                flag = true;
            } else {
                usuario.setCorreo(ruv.getTcorreo().getText());
                this.ruv.getAcorreo().setEnabled(false);
            }

            if (this.ruv.getTtelefono().getText().equals("")) {
                this.ruv.getAtelefono().setEnabled(true);
                flag = true;
            } else {
                usuario.setTelefono(ruv.getTtelefono().getText());
                this.ruv.getAtelefono().setEnabled(false);
            }

            if (this.ruv.getTedad().getText().equals("")) {
                this.ruv.getAedad().setEnabled(true);
                flag = true;
            } else {
                usuario.setEdad(ruv.getTedad().getText());
                this.ruv.getAedad().setEnabled(false);
            }

            if (this.ruv.getTcontrasenia().getText().equals("")) {
                this.ruv.getAcontraseña().setEnabled(true);
                flag = true;
            } else {
                usuario.setContraseña(ruv.getTcontrasenia().getText());
                this.ruv.getAcontraseña().setEnabled(false);
            }

            if (flag == false) {
                usuariodao.agregar(usuario);

                this.ruv.getTnombre().setText("");
                this.ruv.getTnombreusuario().setText("");
                this.ruv.getTcorreo().setText("");
                this.ruv.getTtelefono().setText("");
                this.ruv.getTedad().setText("");
                this.ruv.getTcontrasenia().setText("");

                this.loginvista.setVisible(true);
                this.ruv.dispose();
            }
        }

        if (this.ruv.getBregresar() == evento.getSource()) {
            this.loginvista.setVisible(true);

            this.ruv.getTnombre().setText("");
            this.ruv.getTnombreusuario().setText("");
            this.ruv.getTcorreo().setText("");
            this.ruv.getTtelefono().setText("");
            this.ruv.getTedad().setText("");
            this.ruv.getTcontrasenia().setText("");

            this.ruv.dispose();
        }

    }

}
