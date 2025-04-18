package View;

import Controller.AlumnoController;
import Controller.DireccionController;

import java.util.Scanner;

public class Menu {

    public static void showMenu (Scanner in){
        int id;

        String nombre;
        String apellido;
        int edad;
        String email;

        String calle;
        int altura;
        int alumno_id;

        int option;
        AlumnoController alumnoController = new AlumnoController();
        DireccionController direccionController = new DireccionController();

        String menu =
                "1- mostrar todos los alumnos\n" +
                "2- agregar nuevo alumno\n" +
                "3- modificar alumno\n" +
                "4- eliminar alumno\n" +
                "5- mostrar todas las direcciones\n" +
                "6- mostrar todas las direcciones de un alumno\n" +
                "7- agregar nueva direccion\n" +
                "8- eliminar direccion\n" +
                "0- salir";

        do {
            System.out.println(menu);

            option = in.nextInt();
            in.nextLine();

            switch (option){
                case 1:
                    alumnoController.listAlumno().forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("nombre: ");
                    nombre = in.nextLine();
                    System.out.println("apellido: ");
                    apellido = in.nextLine();
                    System.out.println("edad: ");
                    edad = in.nextInt();
                    in.nextLine();
                    System.out.println("email: ");
                    email = in.nextLine();

                    alumnoController.addAlumno(nombre, apellido, edad, email);
                    break;
                case 3:
                    System.out.println("ID del alumno a modificar: ");
                    id = in.nextInt();
                    in.nextLine();
                    System.out.println("Nuevo nombre: ");
                    nombre = in.nextLine();
                    System.out.println("Nuevo apellido: ");
                    apellido = in.nextLine();
                    System.out.println("Nueva edad: ");
                    edad = in.nextInt();
                    in.nextLine();
                    System.out.println("Nuevo email: ");
                    email = in.nextLine();
                    alumnoController.updateAlumno(id, nombre, apellido, edad, email);
                    break;
                case 4:
                    System.out.println("ID del alumno: ");
                    id = in.nextInt();
                    in.nextLine();
                    System.out.println("Si estas seguro presiona 1: ");
                    nombre = in.nextLine();

                    if (nombre.equals("1")){
                        alumnoController.deleteAlumno(id);
                    }
                    break;
                case 5:
                    direccionController.listDirecciones().forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("ID del alumno: ");
                    alumno_id = in.nextInt();
                    in.nextLine();
                    direccionController.listDireccionesByAlumno(alumno_id).forEach(System.out::println);
                    break;
                case 7:
                    System.out.println("Calle: ");
                    calle = in.nextLine();
                    System.out.println("Altura: ");
                    altura = in.nextInt();
                    in.nextLine();
                    System.out.println("ID del alumno al que pertence al direccion: ");
                    alumno_id = in.nextInt();
                    in.nextLine();

                    direccionController.insertDireccion(calle, altura, alumno_id);
                    break;
                case 8:
                    System.out.println("ID de la direccion: ");
                    id = in.nextInt();
                    in.nextLine();
                    direccionController.deleteDireccion(id);
                    break;
                case 0:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("el numero ingresado no existe");
                    break;
            }
        }while (option != 0);
    }
}
