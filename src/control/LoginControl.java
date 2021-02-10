package control;

import DAO.UsuarioDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Usuario;
import vista.LoginVista;
import vista.MenuVista;
import vista.RegistroUsuarioVista;

/**
 *
 * @author migue
 */
public class LoginControl implements ActionListener {

    private boolean flag;
    private LoginVista loginvista;
    private MenuVista menuvista;
    private Usuario usuario;
    private UsuarioDao usuariodao;
    private RegistroUsuarioVista ruv;

    public LoginControl(LoginVista loginvista, Usuario usuario, UsuarioDao usuarioDao, RegistroUsuarioVista ruv, MenuVista menuvista) {
        flag = false;
        this.loginvista = loginvista;
        this.ruv = ruv;
        this.usuariodao = usuarioDao;
        this.usuario = usuario;
        this.menuvista = menuvista;

        this.loginvista.getBiniciarsesion().addActionListener(this);
        this.loginvista.getBregistrarusuario().addActionListener(this);
    }

    public void actionPerformed(ActionEvent evento) {

        if (this.loginvista.getBiniciarsesion() == evento.getSource()) {

            if (this.loginvista.getTusuario().getText().equals("")) {
                this.loginvista.getAusuario().setEnabled(true);
                flag = true;
            } else {
                usuario.setNombreusuario(this.loginvista.getTusuario().getText());
                this.loginvista.getAusuario().setEnabled(false);
            }

            if (this.loginvista.getTcontrasenia().getText().equals("")) {
                this.loginvista.getAcontrasenia().setEnabled(true);
                flag = true;
            } else {
                usuario.setContraseña(this.loginvista.getTcontrasenia().getText());
                this.loginvista.getAcontrasenia().setEnabled(false);
            }

            if (flag == false) {
                if (usuariodao.Loguear(usuario) == true) {
                    this.loginvista.getAcontrasenia().setEnabled(true);
                    this.loginvista.getAusuario().setEnabled(true);

                } else {
                    this.loginvista.getTusuario().setText("");
                    this.loginvista.getTcontrasenia().setText("");
                    this.menuvista.setVisible(true);
                    this.loginvista.dispose();

                    this.loginvista.getAcontrasenia().setEnabled(false);
                    this.loginvista.getAusuario().setEnabled(false);
                }
            }

            flag = true;
        }

        if (this.loginvista.getBregistrarusuario() == evento.getSource()) {
            this.ruv.setVisible(true);
            this.loginvista.getTusuario().setText("");
            this.loginvista.getTcontrasenia().setText("");
            this.loginvista.dispose();
        }
    }
}
