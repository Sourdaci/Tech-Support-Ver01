import java.util.ArrayList;
import java.util.Random;
import java.util.Date;
import java.util.HashMap;
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
    private HashMap<String, String> condicionadas;
    
    public Responder(){
        aleatorio = new Random(new Date().getTime());
        respuestas = new ArrayList<String>();
        condicionadas = new HashMap<String, String>();
        asignaRespuestas();
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
        condicionadas.put("windows", "Es un error. El sistema operativo entero es un error");
        condicionadas.put("linux", "Menos compatible, mas abierto, y con mucha gente detras");
        condicionadas.put("mac", "Cerrado como el solo. Hasta Apple tiene problemas con el codigo");
        condicionadas.put("pantallazo", "Si no te gustan, no vuelvas a hacerlo");
        condicionadas.put("404", "La pagina ya no existe, mendrugo...");
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(){
        return respuestas.get(aleatorio.nextInt(respuestas.size()));
    }
}
