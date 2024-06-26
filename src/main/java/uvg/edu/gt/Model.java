package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Esta clase se encarga del funcionamiento interno del programa, lee el archivo y lo almacena dentro de un
 * VectorHeap
 * @author Jose Merida
 * @version 1.0
 * @since 09-04-2024
 */
public class Model {
    VectorHeap<Patient> patientData;
    public Model(){
        patientData = new VectorHeap<>();
    }
    /**
     * Metodo para leer los datos del archivo y almacenarlos dentro de un VectorHeap
     */
    public void readFile(){
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"))){
            //Para cada linea la separa por comas y crea un nuevo paciente con esos datos
            while ((line = br.readLine()) != null){
                String[] separated = line.split(",");
                Patient tempPatient = new Patient(separated[0], separated[1], separated[2].replaceAll(" ", ""));
                patientData.add(tempPatient);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    /**
     * Getter para el VectorHeap que contiene los datos de los pacientes
     * @return patientData
     */
    public VectorHeap<Patient> getPatientData(){
        return patientData;
    }
}
