package view;

import repositories.interfaces.entities.PedidoEntity;
import repositories.interfaces.enums.Estados;
import repositories.interfaces.enums.Tipos;
import repositories.interfaces.exceptions.PedidoException;
import repositories.interfaces.service.BebidaService;
import repositories.interfaces.service.ClienteService;
import repositories.interfaces.service.PedidoService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MenuController {

    private static final Scanner scanner = new Scanner(System.in);
    private static final BebidaService bebidaService = new BebidaService();
    private static final ClienteService clienteService = new ClienteService();
    private static final PedidoService pedidoService = new PedidoService();

    public static void mostrarMenuPrincipal() {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. CRUD de bebidas");
            System.out.println("2. Filtrar bebidas por tipo");
            System.out.println("3. Filtrar bebidas segun stock");
            System.out.println("4. Buscar clientes por localidad");
            System.out.println("5. Listar pedidos por cliente");
            System.out.println("6. Cambiar el estado de un pedido");
            System.out.println("7. Ingresar un nuevo pedido con validaciones");
            System.out.println("8. Contar la cantidad de pedidos agrupados por estado");

            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Que operacion desea realizar?");
                    System.out.println("A - Insertar una bebida nueva");
                    System.out.println("B - Listar todas las bebidas");
                    System.out.println("C - Actualizar una bebida");
                    System.out.println("D - Eliminar una bebida");

                    char operacion = scanner.nextLine().charAt(0);
                    switch (operacion){
                        case 'A':
                            String nombre = scanner.nextLine();
                            String tipo = scanner.nextLine();
                            Double precioUnitario = scanner.nextDouble();
                            scanner.nextLine();
                            Integer stock = scanner.nextInt();
                            scanner.nextLine();
                            bebidaService.createBebida(nombre, Tipos.valueOf(tipo), precioUnitario, stock);
                            break;
                        case 'B':

                            System.out.println(bebidaService.listBebidas());

                            break;
                        case 'C':
                            String nombre1 = scanner.nextLine();
                            String tipo1 = scanner.nextLine();
                            Double precioUnitario1 = scanner.nextDouble();
                            scanner.nextLine();
                            Integer stock1 = scanner.nextInt();
                            scanner.nextLine();
                            bebidaService.updateBebida(nombre1, Tipos.valueOf(tipo1), precioUnitario1, stock1);

                            break;
                        case 'D':
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            bebidaService.deleteBebida(id);
                            break;
                    }
                    break;
                case 2:
                    String tipo = scanner.nextLine();
                    System.out.println(bebidaService.filterByTipo(Tipos.valueOf(tipo)));
                    break;
                case 3:
                    int stock = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println(bebidaService.filterByStock(stock));
                    break;
                case 4:
                    String localidad = scanner.nextLine();

                    System.out.println(clienteService.filterByLocalidad(localidad));
                    break;
                case 5:

                    int idCliente = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        System.out.println(clienteService.filterById(idCliente));

                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 6:
                    int idPedido = scanner.nextInt();
                    scanner.nextLine();
                    String estado = scanner.nextLine();
                    try {
                        pedidoService.changeEstado(idPedido, Estados.valueOf(estado));
                    } catch (PedidoException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 7:
                    int idCliente1 = scanner.nextInt();
                    scanner.nextLine();
                    int idBebida = scanner.nextInt();
                    scanner.nextLine();
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        pedidoService.ingresarPedido(idCliente1, idBebida, cantidad);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 8:
                    List<Map<Estados, List<PedidoEntity>>>  listedByEstado = pedidoService.listByEstado();
                    System.out.println(listedByEstado);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
