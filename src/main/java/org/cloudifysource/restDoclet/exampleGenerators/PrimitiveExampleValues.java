package org.cloudifysource.restDoclet.exampleGenerators;

public final class PrimitiveExampleValues {
	
	// These gets initialized to their default values
	private static boolean DEFAULT_BOOLEAN = true;
	private static byte DEFAULT_BYTE = 0;
	private static short DEFAULT_SHORT = 0;
	private static int DEFAULT_INT = 0;
	private static long DEFAULT_LONG = 0;
	private static float DEFAULT_FLOAT = 0;
	private static double DEFAULT_DOUBLE = 0;
	
	public static Object getValue(final Class<?> clazz) {
	        if (clazz.equals(boolean.class)) {
	            return DEFAULT_BOOLEAN;
	        } else if (clazz.equals(byte.class)) {
	            return DEFAULT_BYTE;
	        } else if (clazz.equals(short.class)) {
	            return DEFAULT_SHORT;
	        } else if (clazz.equals(int.class)) {
	            return DEFAULT_INT;
	        } else if (clazz.equals(long.class)) {
	            return DEFAULT_LONG;
	        } else if (clazz.equals(float.class)) {
	            return DEFAULT_FLOAT;
	        } else if (clazz.equals(double.class)) {
	            return DEFAULT_DOUBLE;
	        } else {
	            throw new IllegalArgumentException(
	                "Class type " + clazz + " not supported");
	        }
	}
}
