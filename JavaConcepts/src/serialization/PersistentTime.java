package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * @author js674007
 * 
 *         Compaitable changes
 * 
 *         Adding fields - When the class being reconstituted has a field that
 *         does not occur in the stream, that field in the object will be
 *         initialized to the default value for its type. If class-specific
 *         initialization is needed, the class may provide a readObject method
 *         that can initialize the field to nondefault values. Adding classes -
 *         The stream will contain the type hierarchy of each object in the
 *         stream. Comparing this hierarchy in the stream with the current class
 *         can detect additional classes. Since there is no information in the
 *         stream from which to initialize the object, the class's fields will
 *         be initialized to the default values. Removing classes - Comparing
 *         the class hierarchy in the stream with that of the current class can
 *         detect that a class has been deleted. In this case, the fields and
 *         objects corresponding to that class are read from the stream.
 *         Primitive fields are discarded, but the objects referenced by the
 *         deleted class are created, since they may be referred to later in the
 *         stream. They will be garbage-collected when the stream is
 *         garbage-collected or reset. Adding writeObject/readObject methods -
 *         If the version reading the stream has these methods then readObject
 *         is expected, as usual, to read the required data written to the
 *         stream by the default serialization. It should call defaultReadObject
 *         first before reading any optional data. The writeObject method is
 *         expected as usual to call defaultWriteObject to write the required
 *         data and then may write optional data. Removing
 *         writeObject/readObject methods - If the class reading the stream does
 *         not have these methods, the required data will be read by default
 *         serialization, and the optional data will be discarded. Adding
 *         java.io.Serializable - This is equivalent to adding types. There will
 *         be no values in the stream for this class so its fields will be
 *         initialized to default values. The support for subclassing
 *         nonserializable classes requires that the class's supertype have a
 *         no-arg constructor and the class itself will be initialized to
 *         default values. If the no-arg constructor is not available, the
 *         InvalidClassException is thrown. Changing the access to a field - The
 *         access modifiers public, package, protected, and private have no
 *         effect on the ability of serialization to assign values to the
 *         fields. Changing a field from static to nonstatic or transient to
 *         nontransient - When relying on default serialization to compute the
 *         serializable fields, this change is equivalent to adding a field to
 *         the class. The new field will be written to the stream but earlier
 *         classes will ignore the value since serialization will not assign
 *         values to static or transient fields.
 * 
 *         InCompaitable Changes
 * 
 *         Deleting fields - If a field is deleted in a class, the stream
 *         written will not contain its value. When the stream is read by an
 *         earlier class, the value of the field will be set to the default
 *         value because no value is available in the stream. However, this
 *         default value may adversely impair the ability of the earlier version
 *         to fulfill its contract. Moving classes up or down the hierarchy -
 *         This cannot be allowed since the data in the stream appears in the
 *         wrong sequence. Changing a nonstatic field to static or a
 *         nontransient field to transient - When relying on default
 *         serialization, this change is equivalent to deleting a field from the
 *         class. This version of the class will not write that data to the
 *         stream, so it will not be available to be read by earlier versions of
 *         the class. As when deleting a field, the field of the earlier version
 *         will be initialized to the default value, which can cause the class
 *         to fail in unexpected ways. Changing the declared type of a primitive
 *         field - Each version of the class writes the data with its declared
 *         type. Earlier versions of the class attempting to read the field will
 *         fail because the type of the data in the stream does not match the
 *         type of the field. Changing the writeObject or readObject method so
 *         that it no longer writes or reads the default field data or changing
 *         it so that it attempts to write it or read it when the previous
 *         version did not. The default field data must consistently either
 *         appear or not appear in the stream. Changing a class from
 *         Serializable to Externalizable or vice versa is an incompatible
 *         change since the stream will contain data that is incompatible with
 *         the implementation of the available class. Changing a class from a
 *         non-enum type to an enum type or vice versa since the stream will
 *         contain data that is incompatible with the implementation of the
 *         available class. Removing either Serializable or Externalizable is an
 *         incompatible change since when written it will no longer supply the
 *         fields needed by older versions of the class. Adding the writeReplace
 *         or readResolve method to a class is incompatible if the behavior
 *         would produce an object that is incompatible with any older version
 *         of the class.
 *
 */
public class PersistentTime implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -860099487580L;
	private Date time;
	private String str = "Some String value";
	public static final int city = 0;

	public PersistentTime() {
		time = Calendar.getInstance().getTime();
	}

	public Date getTime() {
		return time;
	}

	public static void main(String[] args) {
		String fileName = "Object.ser";

		if (args.length > 0) {
			fileName = args[0];
		}

		PersistentTime time = new PersistentTime();
		FileOutputStream fos = null;
		ObjectOutputStream os = null;

		
		/*
		 * try { fos = new FileOutputStream(fileName); os = new ObjectOutputStream(fos);
		 * 
		 * os.writeObject(time); os.close();
		 * System.out.println(time.getTime().toString());
		 * System.out.println("Object has been serialized......"); } catch (IOException
		 * e) { e.printStackTrace(); }
		 */
		 

		deserializeObject(fileName);
	}

	private static void deserializeObject(String fileName) {

		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);

			PersistentTime time = (PersistentTime) ois.readObject();

			System.out.println(time.getTime().toString());
			System.out.println("Object has been deserialized ......");

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}