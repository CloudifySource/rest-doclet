/*******************************************************************************
 * Copyright (c) 2013 GigaSpaces Technologies Ltd. All rights reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.cloudifysource.restDoclet.exampleGenerators;

/**
 * Creates examples of primitive types.
 * @author yael
 * @since 0.5.0
 */
public final class PrimitiveExampleValues {
	
	private PrimitiveExampleValues() {
		
	}
	
	// These gets initialized to their default values
	private static final boolean DEFAULT_BOOLEAN = true;
	private static final byte DEFAULT_BYTE = 0;
	private static final short DEFAULT_SHORT = 0;
	private static final int DEFAULT_INT = 0;
	private static final long DEFAULT_LONG = 0;
	private static final float DEFAULT_FLOAT = 0;
	private static final double DEFAULT_DOUBLE = 0;
	
	/**
	 * Returns an example value of a primitive type.
	 * @param clazz the primitive type.
	 * @return an example value of the given primitive type.
	 */
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
