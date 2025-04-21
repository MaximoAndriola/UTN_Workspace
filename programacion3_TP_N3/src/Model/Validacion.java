package Model;

import java.util.List;
import java.util.Optional;

public class Validacion {

    public static boolean validatePass(String password, String validatePassword) throws DatoInvalidoException{
        if (password.isEmpty()){
            throw new DatoInvalidoException("Se debe ingresar una contraseña");
        }
        if (!password.equals(validatePassword)){
            throw new DatoInvalidoException("Las contraseñas no coinciden");
        }
    return true;
    }

    public static Optional<Credencial> validateCredencials (List<Credencial> credencials, Credencial credencial)throws DatoInvalidoException{
        if (credencial.getUsername().isEmpty()){
            throw new DatoInvalidoException("se debe ingresar username");
        }
        if (credencial.getPassword().isEmpty()){
            throw new DatoInvalidoException("se debe ingresar contraseña");
        }
        boolean validate = false;
        validate = credencials.stream()
                .anyMatch(n -> n.getUsername().equals(credencial.getUsername()));
        if (!validate){
            throw new DatoInvalidoException("el usuario ingresado no existe");
        }
        validate = credencials.stream()
                .anyMatch(n -> n.getUsername().equals(credencial.getUsername()) && n.getPassword().equals(credencial.getPassword()));
        if (!validate){
            throw new DatoInvalidoException("la contraseña ingresada es invalida");
        }

        Optional<Credencial> reducedCredential = credencials.stream()
                .reduce((a, b) -> a);

        return reducedCredential;
    }
}
