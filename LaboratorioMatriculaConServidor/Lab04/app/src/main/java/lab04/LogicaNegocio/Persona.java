package lab04.LogicaNegocio;

public class Persona {
    public String nombre;
    public int cedula;
    public String email;
    public int telfono;
    public int Edad;
    public Persona() {
    }

    public Persona(String nombre, int cedula, String email, int edad, int telfono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.email = email;
        this.telfono=telfono;
    }

    public int getTelfono() {
        return telfono;
    }

    public void setTelfono(int telfono) {
        this.telfono = telfono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

}

