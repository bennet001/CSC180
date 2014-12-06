package examples.weekseven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class PersonSerialkiller {
//	public byte[] PersonSerialKiller(Person p) {
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
//			oos.writeObject(p);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return baos.toByteArray();
//	}
	public File PersonSerialKiller(Person p){
		try (FileOutputStream cerialperson = new FileOutputStream("myFile.txt")) {
			byte[] outFile = p.toString().getBytes();
		    cerialperson.write(outFile);
		    return new File("myFile.txt");
		} catch (IOException ex){
		    // handle me
		}
		return null; 
	}

//	public Person PersonDeserialKiller(byte[] p) throws IOException {
//		ByteArrayInputStream bais = new ByteArrayInputStream(p);
//		try (ObjectInputStream oips = new ObjectInputStream(bais)) {
//			return (Person) oips.readObject();
//		} catch(ClassNotFoundException e){
//			throw new IOException(e);
//		} 
//	}
	public Person PersonDeserialKiller(File p) throws IOException {
		FileInputStream bais = new FileInputStream(p);
		try (ObjectInputStream oips = new ObjectInputStream(bais)) {
			return (Person) oips.readObject();
		} catch(ClassNotFoundException e){
			throw new IOException(e);
		} 
	}

	public static void main(String[] args) throws IOException {
		Person p = new Person("James \"Killer\"; ", "Smith,", 19);
		PersonSerialkiller pk = new PersonSerialkiller();
		System.out.println("This is true "
				+ p.equals(pk.PersonDeserialKiller(pk.PersonSerialKiller(p))));
	}
}
