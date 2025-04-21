package View;

import Controller.CredencialController;
import Controller.UsuarioController;
import Model.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Menu {

    public static void showMenu(Scanner in, Usuario usuarioLogueado){
        int option;
        String menu =
                "1- ...\n" +
                "0- Salir\n";
        do {
            System.out.println(menu);

            option = in.nextInt();
            in.nextLine();
            switch (option) {
                case 1:

                    break;
                case 0:
                    System.out.println("salida exitosa del sistema");
                    break;
                default:
                    System.out.println("la opcion ingresada no existe");
                    break;
            }
        }while (option != 0);
    }

    public static void launchMenu (Scanner in) {
        int option;

        do {
            System.out.println("Bienvenido!!!");
            System.out.println(
                    "1- Iniciar sesion\n" +
                    "2- Registrarse\n" +
                    "0- Cerrar Programa\n");
            option = in.nextInt();
            in.nextLine();

            switch (option) {
                case 1:
                    login(in);
                    break;
                case 2:
                    register(in);
                    break;
                case 0:
                    break;
            }
        } while (option != 0);
    }


    private static void login(Scanner in){
        CredencialController credencialController = new CredencialController();
        List<Credencial> credencials = credencialController.listCredencials();
        UsuarioController usuarioController = new UsuarioController();
        List<Usuario> usuarios = usuarioController.listUsers();
        
        Optional<Credencial> optionalCredencial = Optional.empty();

        boolean validate = false;
        Credencial credencial = new Credencial();

        do {
            System.out.println("Nombre: ");
            String username = in.nextLine();

            System.out.println("Contraseña: ");
            String password = in.nextLine();


            credencial.setUsername(username);
            credencial.setPassword(password);
            try {
                optionalCredencial = Validacion.validateCredencials(credencials, credencial);
            } catch (DatoInvalidoException e) {
                System.out.println(e.getMessage());
            }

        }while (!validate);

        credencial = optionalCredencial.orElse(new Credencial());
        int user_id = credencial.getId();

        Optional<Usuario> optionalUsuario = usuarios.stream()
                .filter(n -> n.getId() == user_id)
                .reduce((a, b) -> a);

        Usuario usuarioLogueado;

        if (optionalUsuario.getClass() == null){
            throw new RuntimeException("USUARIO NULO");
        }else {
            usuarioLogueado = optionalUsuario.orElse(new Usuario());
            showMenu(in, usuarioLogueado);
        }
    }

    private static void register(Scanner in){
        UsuarioController usuarioController = new UsuarioController();
        CredencialController credencialController = new CredencialController();

        String password;
        String validatePassword;
        boolean validate = false;

        System.out.println("ingresar nombre de usuario: ");
        String username = in.nextLine();

        do {
            System.out.println("ingresar contraseña: ");
            password = in.nextLine();
            System.out.println("repetir contraseña: ");
            validatePassword = in.nextLine();

            try {
                validate = Validacion.validatePass(password, validatePassword);
            } catch (DatoInvalidoException e) {
                System.out.println(e.getMessage());
            }

        }while (!validate);

        System.out.println("ingresar nombre: ");
        String nombre = in.nextLine();
        System.out.println("ingresar apellido: ");
        String apellido = in.nextLine();
        System.out.println("ingresar dni: ");
        String dni = in.nextLine();
        System.out.println("ingresar email: ");
        String email = in.nextLine();

        try {
            usuarioController.insertUser(nombre, apellido, dni, email);

            List<Usuario> users = usuarioController.listUsers();
            List<Usuario> filteredUser = users.stream()
                    .filter(n -> n.getDni().equals(dni))
                    .toList();

            int id_usuario = filteredUser.getFirst().getId();

            credencialController.insertCredencial(id_usuario, username, password, Permisos.CLIENTE);
        }catch (SQLException e){
            System.out.println("El usuario que se intenta ingresar ya existe");
        }
    }
}
