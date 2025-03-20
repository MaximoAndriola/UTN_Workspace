import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Juego juego = new Juego();
        int num = 0;

        /*do{
            System.out.println("Adivina el numero");

            try {
                num = entrada.nextInt();

                System.out.println(juego.jugar(num));
            }catch (InputMismatchException e){
                //System.out.println(e.getMessage());
                System.out.println("Debes ingresar un numero");
                num = 0;
            }
            finally {
                entrada.nextLine();
            }

        }while (juego.getValor() != num);*/

        Colegio colegio = new Colegio();
        colegio.agregarAlumno(new Alumno("Piero", 20, Nacionalidades.PERUANO));
        colegio.agregarAlumno(new Alumno("Willyrex", 20, Nacionalidades.ESPAÑOL));
        colegio.agregarAlumno(new Alumno("Messi", 20, Nacionalidades.ARGENTINO));
        colegio.agregarAlumno(new Alumno("Betzabet", 20, Nacionalidades.PERUANO));

        colegio.borrarAlumno("Piero");

        colegio.verNacionalidad(Nacionalidades.PERUANO);
        colegio.contarNacionalidades();
        colegio.verTodos();
    }

}