package tugas03;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class SerializationDemo {
    public void serialize(List<Mahasiswa> pList, String fileName) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName, true));
            out.writeObject(pList);
        }catch(IOException ex){
            System.out.println("A Problem Occured during Serialization\n"+ex.getMessage());
        }
    }

    public List<Mahasiswa> deserialize(String fileName) throws ClassNotFoundException{
        List<Mahasiswa> pList = null;
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            pList = (List<Mahasiswa>) in.readObject();
        }catch(IOException ex){
            System.out.printf("A Problem Occured during Deserializing %s%n", fileName);
            System.out.println(ex.getMessage());
        }
        return pList;
    }
    
    public void seri(List<Mahasiswa> pList, String fileName) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName, false));
            out.writeObject(pList);
        }catch(IOException ex){
            System.out.println("A Problem Occured during Serialization\n"+ex.getMessage());
        }
    }
}
