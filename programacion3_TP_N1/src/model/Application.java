package model;

public class Application extends Payment{
    private AppNames appName;
    private int userId;

    public Application(double value, String currency, AppNames appName, int userId) {
        super(value, currency);
        this.appName = appName;
        this.userId = userId;
    }

    public Application(){

    }

    @Override
    public boolean validateFounds(Double payment) {
        boolean validate = false;



        return validate;
    }

    @Override
    public boolean validatePayment() {
        return false;
    }
}
