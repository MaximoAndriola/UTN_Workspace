package Exeptions;

public class ProductoInvalidoExeption extends RuntimeException {
  public ProductoInvalidoExeption() {
    super("El producto ingresado es invalido");
  }
  public ProductoInvalidoExeption(String mensaje){
    super(mensaje);
  }
}
