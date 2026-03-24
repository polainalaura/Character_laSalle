import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class polainalaura {

    static ArrayList<Personaje> lista = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static String fichero = "personajes.txt";

    public static void main(String[] args) {

        cargar();

        int opcion = 0;

        do {
            System.out.println("\n1. Crear personaje");
            System.out.println("2. Eliminar personaje");
            System.out.println("3. Ranking");
            System.out.println("4. Salir");

            // Validación de entrada del menú
            while (!sc.hasNextInt()) {
                System.out.println("Debes introducir un número.");
                sc.next();
            }

            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) crear();
            else if (opcion == 2) eliminar();
            else if (opcion == 3) ranking();
            else if (opcion == 4) guardar();

        } while (opcion != 4);
    }

    static void crear() {

        // Solicitud del nombre al usuario
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        // Comprobación de que no exista un personaje con el mismo nombre
        for (Personaje c : lista) {
            if (c.getName().equalsIgnoreCase(nombre)) {
                System.out.println("Nombre repetido");
                return;
            }
        }


        // Creación del personaje y confirmación
        lista.add(new Personaje(nombre, nivel, exp));
        System.out.println("Personaje creado correctamente.");
    }


    static void eliminar() {



        // Mostrar listado numerado para que el usuario elija
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + " - " + lista.get(i));
        }

        // Validación de la posición introducida por el usuario
        System.out.print("Introduce el número del personaje a eliminar: ");
        while (!sc.hasNextInt()) {
            System.out.println("Debes introducir un número válido.");
            sc.next();
        }

        int pos = sc.nextInt();

        // Eliminación del personaje si la posición es válida
        if (pos >= 0 && pos < lista.size()) {
            Personaje eliminado = lista.get(pos);
            lista.remove(pos);

            System.out.println("Personaje '" + eliminado.getName() + "' eliminado correctamente.");
            System.out.println("Volviendo al menú...");

        } else {
            System.out.println("Error: índice fuera de rango. No se pudo eliminar.");
            System.out.println("Volviendo al menú...");
        }
    }


    static void ranking() {



        // Muestra del ranking al usuario
        System.out.println("\nRanking de personajes: \n");
        for (Personaje c : lista) {
            System.out.println(c);
        }

    }


    static void guardar() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));

            // Guardar cada personaje en formato nombre;nivel;experiencia
            for (Personaje c : lista) {
                bw.write(c.getName() + ";" + c.getLevel() + ";" + c.getExperience());
                bw.newLine();
            }

            bw.close();

        } catch (IOException e) {
            System.out.println("Error al guardar");
        }
    }


    static void cargar() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fichero));
            String linea;

            // Lectura del archivo línea a línea
            while ((linea = br.readLine()) != null) {
                String[] p = linea.split(";");

                String nombre = p[0];
                int nivel = Integer.parseInt(p[1]);
                int exp = Integer.parseInt(p[2]);

                lista.add(new Personaje(nombre, nivel, exp));
            }

            br.close();

        } catch (IOException e) {
            lista = new ArrayList<>();
        }
    }
}
