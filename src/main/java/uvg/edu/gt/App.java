package uvg.edu.gt;

/**
 * Este programa simula un sistema de atencion de pacientes que llegan a la seccion de emergencias de un hospital. Lee
 * un archivo de texto que incluye Nombre, Sintomes y Graveded. Lee los datos del archivo txt y los almacena dentro
 * de un VectorHeap (implementacion de PriorityQueue), luego se van tomando uno por uno e imprimiendo de regreso en
 * la consola
 * @author Jose Merida - 201105
 * @version 1.0
 * @since 09-04-2024
 */
public class App 
{
    public static void main( String[] args )
    {
        //Crea un nuevo Model, lee el archivo (guardando los datos en un VectorHeap)
        Model model = new Model();
        model.readFile();
        VectorHeap<Patient> patientList = model.getPatientData();
        //Mientras el VectorHeap no se encuentre vacio, toma los datos uno por uno y los imprime.
        while (!patientList.isEmpty()){
            System.out.println(patientList.remove().getData());
        }
    }
}
