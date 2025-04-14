import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Shop {
    private List<Product> products;
    private List<Product> filteredProducts;

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

    public List<Map<String, Product>> getExpesivestProductByCategory (){
        List<Map<String, Product>> filtered = new ArrayList<>();
        ArrayList<Product> filteredProductsCopy = new ArrayList<>(filteredProducts);

        getProductsByCategory(filtered, filteredProductsCopy);

        return filtered;
    }
/*
    public List<Map<String, Product>> getProductsByCategory (List<Map<String, Product>> filtered, List<Product> filteredProductsCopy){

        if (!filteredProductsCopy.isEmpty()){
            //Obtengo la categoria
            String category = filteredProducts.getFirst().getCategory();
            //Inicializo un arreglo aux
            List<Product> aux = new ArrayList<>();
            //Filtro por la categoria, haciendo que los objetos que no sean de esa categoria pasen a aux
            filteredProductsCopy.stream()
                    .filter(n -> !n.getCategory().equals(category))
                    .forEach(aux::add);
            //Limpio la lista
            filteredProductsCopy.clear();
            //y por último traigo los objetos de aux
            filteredProductsCopy.addAll(aux);

            //Limpio aux para reutilizarlo
            aux.clear();
            //Filtro en aux por categoria y ordeno por precio
            aux = filterByCategory(category, filteredProducts);

            sortByPrice(aux);
            //Inicializo otra lista que solo va a almacenar el producto de mayor precio
            List<Product> firstProduct = aux.stream()
                     .limit(1)
                     .toList();
            //Agrego a la lista de mapas la categoria como clave y el producto como valor

            filtered.add(Map.of(category, firstProduct.getFirst()));

            //Vuelvo a llamar al metodo
            getProductsByCategory(filtered, filteredProductsCopy);
        }

        //Una vez que ya no quedan productos en filteredProducts retorno los valores
        return filtered;
    }
 */
    public List<Map<String, Product>> getProductsByCategory(List<Map<String, Product>> filtered, List<Product> filteredProductsCopy) {
        if (filteredProductsCopy.isEmpty()) {
            return filtered; // Si no quedan productos, retorna la lista
        }

        // Obtengo la categoría con control de lista vacía
        String category = filteredProductsCopy.get(0).getCategory();

        // Filtrar productos que NO son de esa categoría sin modificar la lista original
        List<Product> newFilteredProductsCopy = filteredProductsCopy.stream()
                .filter(n -> !n.getCategory().equals(category))
                .collect(Collectors.toList());

        // Filtrar por categoría y ordenar
        List<Product> sortedAux = filterByCategory(category, filteredProductsCopy);
        sortByPrice(sortedAux);

        // Obtener el producto más caro
        List<Product> firstProduct = sortedAux.stream()
                .limit(1)
                .toList();

        // Agregar la categoría y el producto a la lista de mapas
        if (!firstProduct.isEmpty()) {
            filtered.add(Map.of(category, firstProduct.get(0)));
        }

        // Llamada recursiva con la lista filtrada
        return getProductsByCategory(filtered, newFilteredProductsCopy);
    }

    public List<Product> filterByCategory (String category, List<Product> products){
        return products.stream()
                .map(q -> new Product(q.getName(), q.getPrice(), q.getCategory().toLowerCase(), q.getStock()))
                .filter(n -> n.getCategory().contains(category.toLowerCase()))
                .toList();
    }

    public List<Product> filterByPrice (Double price, List<Product> products){
        return products.stream()
                .filter(n -> n.getPrice() >= price)
                .toList();
    }

    public List<Product> filterByStock (int stock, List<Product> products){
        return products.stream()
                .filter(n -> n.getStock() >= stock)
                .toList();
    }

    public void sortByPrice (List<Product> products){
        products.stream()
                .sorted(Comparator.comparing(Product::getPrice));
    }

    public void viewShop (){
        products.forEach(System.out::println);
    }
}
