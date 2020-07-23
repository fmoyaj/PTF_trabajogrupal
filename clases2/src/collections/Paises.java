package collections;

import java.util.*;

public class Paises {
    public static void main(String[] args) {

        // Creando países
        Pais Brasil = new Pais("Brasil");
        Pais Colombia = new Pais("Colombia");
        Pais Argentina = new Pais("Argentina");
        Pais Peru = new Pais("Peru");
        Pais Venezuela = new Pais("Venezuela");
        Pais Chile = new Pais("Chile");
        Pais Ecuador = new Pais("Ecuador");
        Pais Bolivia = new Pais("Bolivia");
        Pais Paraguay = new Pais("Paraguay");
        Pais Uruguay = new Pais("Uruguay");

        // Añadiendo países a un diccionario
        Map<String, Pais> paises = new HashMap<>();
        paises.put("chile", Chile);
        paises.put("brasil", Brasil);
        paises.put("argentina", Argentina);
        paises.put("uruguay", Uruguay);
        paises.put("colombia", Colombia);
        paises.put("bolivia", Bolivia);
        paises.put("venezuela", Venezuela);
        paises.put("peru", Peru);
        paises.put("paraguay", Paraguay);
        paises.put("ecuador", Ecuador);

        // Creando listas de países vecinos
        List<Pais> vecinosBrasil = new ArrayList<>();
        Collections.addAll(vecinosBrasil, Uruguay, Paraguay, Bolivia, Peru, Colombia, Venezuela);
        List<Pais> vecinosColombia = new ArrayList<>();
        Collections.addAll(vecinosColombia, Ecuador, Peru, Venezuela);
        List<Pais> vecinosArgentina = new ArrayList<>();
        Collections.addAll(vecinosArgentina, Chile, Bolivia, Brasil, Paraguay, Uruguay);
        List<Pais> vecinosPeru = new ArrayList<>();
        Collections.addAll(vecinosPeru, Ecuador, Colombia, Brasil, Bolivia, Chile);
        List<Pais> vecinosChile = new ArrayList<>();
        Collections.addAll(vecinosChile, Argentina, Peru, Bolivia);
        List<Pais> vecinosUruguay = new ArrayList<>();
        Collections.addAll(vecinosUruguay, Argentina, Brasil);
        List<Pais> vecinosBolivia = new ArrayList<>();
        Collections.addAll(vecinosBolivia, Brasil, Paraguay, Chile, Argentina, Peru);
        List<Pais> vecinosVenezuela = new ArrayList<>();
        Collections.addAll(vecinosVenezuela, Colombia, Brasil);
        List<Pais> vecinosParaguay = new ArrayList<>();
        Collections.addAll(vecinosParaguay, Brasil, Argentina, Bolivia);
        List<Pais> vecinosEcuador = new ArrayList<>();
        Collections.addAll(vecinosEcuador, Colombia, Peru);

        // Setting el parámetro país vecino a la correspondiente lista de países vecino
        Brasil.setPaisesVecinos(vecinosBrasil);
        Colombia.setPaisesVecinos(vecinosColombia);
        Argentina.setPaisesVecinos(vecinosArgentina);
        Peru.setPaisesVecinos(vecinosPeru);
        Chile.setPaisesVecinos(vecinosChile);
        Uruguay.setPaisesVecinos(vecinosUruguay);
        Bolivia.setPaisesVecinos(vecinosBolivia);
        Venezuela.setPaisesVecinos(vecinosVenezuela);
        Paraguay.setPaisesVecinos(vecinosParaguay);
        Ecuador.setPaisesVecinos(vecinosEcuador);

        // Pido un país al usuario
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese un país de Sudamérica: ");
        String paisSeleccionado = in.nextLine().toLowerCase();
        // Si país no está definido, error y termino el programa
        if (!paises.containsKey(paisSeleccionado)) {
            System.out.println("Error. País no encontrado.");
            return;
        }

        // Definiendo lista visitados para ir guardando los países visitados
        List<Pais> visitados = new ArrayList<>();

        // Accediendo al país usando el input del usuario
        Pais p = paises.get(paisSeleccionado);

        // while: mientras los países no se repitan, imprimo la parada y lo añado a lista visitados
        while(true) {
            Pais originalP = paises.get(paisSeleccionado);
            List<Pais> pVecinos = p.getPaisesVecinos();
            Random r = new Random();
            int random = r.nextInt(pVecinos.size());
            System.out.println("Parada: " + pVecinos.get(random).getNombre());
            p = pVecinos.get(random);
            // si se repite un país, termino el viaje
            if (visitados.contains(p)){
                System.out.println("Fin del viaje");
                break;
            }
            visitados.add(p);

            // si vuelvo al país original, también termino el viaje
            if(p == originalP){
                System.out.println("Fin del viaje");
                break;
            }
        }


    }
}