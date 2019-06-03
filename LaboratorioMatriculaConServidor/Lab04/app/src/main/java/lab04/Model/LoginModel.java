package lab04.Model;

import lab04.LogicaNegocio.Usuario;

public class LoginModel {
    private Usuario user = new Usuario();

    public LoginModel(Usuario user) {
        this.user = user;
    }
    public LoginModel() {
        this.user = new Usuario();
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
