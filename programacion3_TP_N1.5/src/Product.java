import java.util.List;

public class Product {
    private String name;
    private double price;
    private String category;
    private int stock;

    // Constructor, Getters y Setters
    public Product(String name, double price, String category, int
            stock) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public static List<Product> cargarProductos() {
        return List.of(
                new Product("Laptop", 1500, "Electronica", 5),
                new Product("Smartphone", 800, "Electronica", 10),
                new Product("Televisor", 1200, "Electronica", 3),
                new Product("Heladera", 2000, "Hogar", 2),
                new Product("Microondas", 500, "Hogar", 8),
                new Product("Silla", 150, "Muebles", 12),
                new Product("Mesa", 300, "Muebles", 7),
                new Product("Zapatillas", 100, "Deportes", 15),
                new Product("Pelota", 50, "Deportes", 20),
                new Product("Bicicleta", 500, "Deportes", 5),
                new Product("Libro", 30, "Librería", 50),
                new Product("Cuaderno", 10, "Librería", 100),
                new Product("Lámpara", 80, "Hogar", 30),
                new Product("Cafetera", 250, "Hogar", 6),
                new Product("Auriculares", 120, "Electronica", 14),
                new Product("Teclado", 90, "Electronica", 9),
                new Product("Mouse", 60, "Electronica", 18),
                new Product("Monitor", 700, "Electronica", 4),
                new Product("Cama", 800, "Muebles", 2),
                new Product("Sofá", 1000, "Muebles", 3),
                new Product("Espejo", 120, "Hogar", 12),
                new Product("Ventilador", 150, "Hogar", 7),
                new Product("Patines", 180, "Deportes", 5),
                new Product("Raqueta", 220, "Deportes", 6),
                new Product("Taza", 15, "Hogar", 40)
        );
    }

    @Override
    public String toString() {
        return "Producto( " +
                "nombre: " + name +
                ", precio: " + price +
                ", categoria: " + category +
                ", stock: " + stock +
                " )";
    }
}