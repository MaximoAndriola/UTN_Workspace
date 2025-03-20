import java.util.ArrayList;

public class OperacionMatematica <T extends Number>{

    public Double suma(T num1, T num2){
        return (Double) num1 + (Double) num2;
    }

    public double resta(T num1, T num2){
        return (double)num1 - (double)num2;
    }

    public double multiplicacion(T num1, T num2){
        return (double)num1 * (double)num2;
    }
    public double division(T num1, T num2){
        return (double)num1 / (double)num2;
    }
}
