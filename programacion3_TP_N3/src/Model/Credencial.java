package Model;

public class Credencial {
    private int id;
    private int id_usuario;
    private String username;
    private String password;
    private Permisos permiso;

    public Credencial(int id_usuario, String username, String password, Permisos permiso) {
        this.id = 0;
        this.id_usuario = id_usuario;
        this.username = username;
        this.password = password;
        this.permiso = permiso;
    }

    public Credencial (){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Permisos getPermiso() {
        return permiso;
    }

    public void setPermiso(Permisos permiso) {
        this.permiso = permiso;
    }

    @Override
    public String toString() {
        return "Credencial(" +
                "id: " + id +
                ", id_usuario: " + id_usuario +
                ", username: " + username +
                ", password: " + password +
                ", permiso: " + permiso +
                ")";
    }
}
