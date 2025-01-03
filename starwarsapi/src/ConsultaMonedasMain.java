import servicios.ConsultaMonedasService;

import java.util.Scanner;

public class ConsultaMonedasMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultaMonedasService servicio = new ConsultaMonedasService();

        while (true) {
            System.out.println("Menú de Conversión de Monedas:");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileño");
            System.out.println("4) Real brasileño => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Salir");
            System.out.print("Elija una opción válida: ");

            int opcion = scanner.nextInt();
            if (opcion == 7) {
                System.out.println("¡Gracias por usar el conversor de monedas!");
                break;
            }

            String monedaOrigen = "";
            String monedaDestino = "";
            switch (opcion) {
                case 1:
                    monedaOrigen = "USD";
                    monedaDestino = "ARS";
                    break;
                case 2:
                    monedaOrigen = "ARS";
                    monedaDestino = "USD";
                    break;
                case 3:
                    monedaOrigen = "USD";
                    monedaDestino = "BRL";
                    break;
                case 4:
                    monedaOrigen = "BRL";
                    monedaDestino = "USD";
                    break;
                case 5:
                    monedaOrigen = "USD";
                    monedaDestino = "COP";
                    break;
                case 6:
                    monedaOrigen = "COP";
                    monedaDestino = "USD";
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
                    continue;
            }

            System.out.print("Ingrese el monto a convertir: ");
            double monto = scanner.nextDouble();

            double resultado = servicio.convertir(monedaOrigen, monedaDestino, monto);
            if (resultado != 0) {
                System.out.printf("Resultado: %.2f %s\n", resultado, monedaDestino);
            } else {
                System.out.println("No se pudo realizar la conversión. Verifique su conexión o intente más tarde.");
            }
        }

        scanner.close();
    }
}
