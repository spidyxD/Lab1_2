package lab04.LogicaNegocio;

public class Usuario {
    public int username;
    public String clave;
    public String rol;

    public Usuario() {
    }

    public Usuario(int username, String clave, String rol) {
        this.username = username;
        this.clave = clave;
        this.rol = rol;
    }

    public int getUsername() {
        return username;
    }

    public void setUsername(int username) {
        this.username = username;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }


}

