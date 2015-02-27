import java.util.ArrayList;
import java.util.Random;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael KÃ¶lling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder{
    /**
     * Construct a Responder - nothing to do
     */
    
    private Random aleatorio;
    private ArrayList<String> respuestas;
    private HashMap<HashSet, String> condicionadas;
    
    public Responder(){
        aleatorio = new Random(new Date().getTime());
        respuestas = new ArrayList<String>();
        condicionadas = new HashMap<HashSet, String>();
        asignaRespuestas();
        asignaCondicionadas();
    }
    
    private void asignaRespuestas(){
        respuestas.add("Eso parece un problema serio...");
        respuestas.add("¿Has probado a apagar y volver a encender?");
        respuestas.add("¿Le dejaste el ordenador a algun amigo chistoso?");
        respuestas.add("Tiene mala pinta. Parece un fallo de hardware.");
        respuestas.add("Yo no habria hecho eso: acabas de invalidar la garantia");
        respuestas.add("Comprueba que tienes todo bien conectado");
        respuestas.add("Los CD de Windows al reves estan muy sobrevalorados");
        respuestas.add("Eres funcionario, ¿verdad?. Cafe en el teclado otra vez...");
    }
    
    private void asignaCondicionadas(){
        HashSet<String> nuevoSet = new HashSet<String>();
        nuevoSet.add("windows");
        condicionadas.put(nuevoSet, "Es un error. El sistema operativo entero es un error");
        nuevoSet = new HashSet<String>();
        nuevoSet.add("linux");
        condicionadas.put(nuevoSet, "Menos compatible, mas abierto, y con mucha gente detras");
        nuevoSet = new HashSet<String>();
        nuevoSet.add("mac");
        condicionadas.put(nuevoSet, "Cerrado como el solo. Hasta Apple tiene problemas con el codigo");
        nuevoSet = new HashSet<String>();
        nuevoSet.add("pantallazo");
        condicionadas.put(nuevoSet, "Si no te gustan, no vuelvas a hacerlo");
        nuevoSet = new HashSet<String>();
        nuevoSet.add("404");
        condicionadas.put(nuevoSet, "La pagina ya no existe, mendrugo...");
        nuevoSet = new HashSet<String>();
        nuevoSet.add("windows");
        nuevoSet.add("error");
        condicionadas.put(nuevoSet, "Eso es absolutamente normal... apaga y vamonos");
        nuevoSet = new HashSet<String>();
        nuevoSet.add("control");
        nuevoSet.add("alt");
        nuevoSet.add("suprimir");
        condicionadas.put(nuevoSet, "CONTROL... ALT..... SUPRIMIR!!!!!!!!!!");
    }

    private String getCondicionada(HashSet condicion){
        String respuestaCondicionada = condicionadas.get(condicion);
        return respuestaCondicionada;
    }
    
    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(HashSet input){
        String respuesta = getCondicionada(input);
        if (respuesta == null){
            int restantes = respuestas.size();
            if (restantes > 0){
                respuesta = respuestas.remove(aleatorio.nextInt(restantes));
            }
        }
        if (respuesta == null){
            respuesta = "Lo siento, no entiendo tu pregunta";
        }
        return respuesta;
    }
}
