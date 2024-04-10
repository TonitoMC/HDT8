package uvg.edu.gt;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Model model = new Model();
        model.readFile();
        VectorHeap<Patient> patientList = model.getPatientData();
        while (!patientList.isEmpty()){
            System.out.println(patientList.remove().getData());
        }
    }
}
