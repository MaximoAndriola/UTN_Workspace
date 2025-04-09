import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Shop {
    List<Product> products;
    List<Product> filteredProducts;

    public Shop() {
        this.products = Product.cargarProductos();
        this.filteredProducts = products;
    }

    public List<Map<String, Double>> getListedNamesAndPricesByCategory (String category, Double price){
        sortByPrice(filteredProducts);
        filteredProducts = filterByCategory(category, filteredProducts);
        filteredProducts = filterByPrice(price, filteredProducts);

        return filteredProducts.stream()
                .map(n -> Map.of(n.getName(), n.getPrice()))
                .collect(Collectors.toList());
    }

    public Optional<Double> getAveragePriceByCategory (String category){
        filteredProducts = filterByCategory(category, filteredProducts);
        filteredProducts = filterByStock(0, filteredProducts);

        List<Double> prices = filteredProducts.stream()
                .map(Product::getPrice).toList();

        Optional<Double> suma = prices.stream()
                .reduce(Double::sum);

        return suma.map(n -> n / prices.size());
    }

    public List<Product> filterByCategory (String category, List<Product> p){
        return p.stream()
                .map(q -> new Product(q.getName(), q.getPrice(), q.getCategory().toLowerCase(), q.getStock()))
                .filter(n -> n.getCategory().contains(category.toLowerCase()))
                .toList();
    }

    public List<Product> filterByPrice (Double price, List<Product> p){
        return p.stream()
                .filter(n -> n.getPrice() >= price)
                .toList();
    }

    public List<Product> filterByStock (int stock, List<Product> p){
        return p.stream()
                .filter(n -> n.getStock() >= stock)
                .toList();
    }

    public void sortByPrice (List<Product> p){
        p.stream()
                .sorted(Comparator.comparing(Product::getPrice));
    }

    public void viewShop (){
        products.forEach(System.out::println);
    }
}
