package no.hiof.set.g6.ny;


import org.json.simple.JSONObject;

/**
 * The Base Class of all our Datatypes.
 *
 * It's important that all G6Datatypes got an empty constructor !!!
 * (Why? Because we are using java reflection to create new Datatype Instances)
 *
 */


public abstract class G6Datatype implements G6Serializable, Comparable<G6Datatype> {
    
    public G6Datatype() { }
    
    /**
     * Creates a new G6Datatype of Class clazz, using values from a JSONObject.
     * @param clazz the class of the new G6Datatype of type T
     * @param jsonObject JSONObject with appropriate content
     * @return new G6Datatype of type T
     * @throws Exception If the JSONObject could not be translated into G6Datatype T
     * or if the G6Datatype Class doesn't have an empty constructor
     */
    public static <T extends G6Datatype> T fromJson(Class<T> clazz, JSONObject jsonObject) throws Exception {
        if (clazz == null || jsonObject == null) throw new IllegalStateException("null arg fromJson");
        try { T datatype = clazz.getDeclaredConstructor().newInstance();
            datatype.fromJson(jsonObject);
            return datatype;
        } catch (NoSuchMethodException e) {
            throw new Exception(e);
        }
    }
    
    /** Datatype does not to override this */
    @Override
    public int compareTo(G6Datatype other) { return 0; }
}
