import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LeerCSV {
    public static void main(String[] args) throws IOException {
        String rutaCsv = "texto.csv";
        //abrir fichero a leer
        FileReader archivo = new FileReader(rutaCsv);
        //crear ArraList para almacenmar el contendo del CSV
        ArrayList<Alumnos> alumnosClase = new ArrayList<>();

        //leer con Scanner
        Scanner scanner = new Scanner(archivo);

        // Saltar la cabecera
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        while (scanner.hasNextLine()){

            //variable para almacenar la linea leida
            String linea = scanner.nextLine();

            //dividir por comas
            String [] datos = linea.split(",");

            //crear objeto alumno para almacenar en arrayList alumnosClase
            int id = Integer.parseInt(datos[0].trim());
            String nombre=datos[1].trim();
            String email=datos[2].trim();

            Alumnos alumno = new Alumnos(id,nombre,email);

            //guardar el objeto almunos en el arrayList
            alumnosClase.add(alumno);

        }
        scanner.close();
        for (Alumnos a : alumnosClase) {
            System.out.println(a);
        }
        //guardar el contenido del arrayList en un String con toString()
        String contenidoLista=alumnosClase.toString();
        // abrir archivo para escribir
        String rutaEscribirCSV ="read.csv";
        FileWriter escribirCSV = new FileWriter(rutaEscribirCSV);
        escribirCSV.write(contenidoLista);
        //cerrar fichero
        escribirCSV.close();
    }
}