import org.apache.log4j.Logger;
import javax.xml.bind.*;
import java.io.File;
import java.util.List;

import ru.rsatu.denis.*;


public class MainClass {

    public static final Logger log = Logger.getLogger(MainClass.class);
    public static StringBuilder str = new StringBuilder();

    public static void main(String[] args){

        try {

            str.append("Read XML"+"\n");
            JAXBContext context = JAXBContext.newInstance(UniversityType.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            String path = "/home/denis/IntelliJIDEAProjects/ProjectJaxbParser/src/main/resources/Univer.xml";
            JAXBElement<UniversityType> univer = (JAXBElement<UniversityType>) unmarshaller.unmarshal(new File(path));
            str.append(univer +"\n");
            str.append("\n***************\n");




            str.append("Write XML"+"\n");
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            path = "/home/denis/IntelliJIDEAProjects/ProjectJaxbParser/src/main/resources/Output.xml";
            marshaller.marshal(univer, new File(path));
            str.append("Creat XML: "+path+"\n");
            log.info("Ok");

            //List<FacultysType> listf = univer.getValue().getFacultys();
            //List<Object> facults = listf.get(0).getFaculty1AndFaculty2AndFaculty3();
            //List<Object> facult1 = (List<Object>) facults.get(0);

        }catch (JAXBException e){
            log.error(e.getMessage());
            str.append("Error");
        }
        System.out.println(str);
    }
}
