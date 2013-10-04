package org.cloudifysource.restDoclet.exampleGenerators;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.LinkedList;
import java.util.List;

import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

/**
 * @author Ed Kimber
 */
public class ObjectCreator {

  private Objenesis objenesis_;

  public ObjectCreator() {
    objenesis_ = new ObjenesisStd();
  }

  public Object createObject(final Class<?> cls) throws IllegalAccessException {
    Object object = objenesis_.getInstantiatorOf(cls).newInstance();
    instantiateFieldsOn(object);
    return object;
  }

  public void instantiateFieldsOn(final Object object) throws IllegalAccessException {
    Class<?> cls = object.getClass();
    for (Field f : cls.getDeclaredFields()) {
      f.setAccessible(true);
      if (f.getGenericType() instanceof ParameterizedType) {
        f.set(object, createParameterizedType(f.getType(), (ParameterizedType) f.getGenericType()));
      }
      else {
        f.set(object, createValueForType(f.getType()));
      }
    }
  }

  /**
   * Only Lists with one simple generic param currently supported.
   */
  private Object createParameterizedType(final Class base, final ParameterizedType genericType)
          throws IllegalAccessException
  {
    Class type = (Class) genericType.getActualTypeArguments()[0];
    if (List.class.isAssignableFrom(base)) {
      return createListOfType(type);
    }
    else {
      return createObject(base);
    }
  }

  private Object createValueForType(final Class<?> cls) throws IllegalAccessException {
    if (String.class.isAssignableFrom(cls)) {
      return "foo";
    }
    else if (List.class.isAssignableFrom(cls)) {
      return createListOfType(Object.class);
    }
    else if (cls.isPrimitive()) {
      return null;
    }
    else {
      return createObject(cls);
    }
  }

  @SuppressWarnings("unchecked")
  private List createListOfType(final Class type) throws IllegalAccessException {
    LinkedList list = new LinkedList();
    list.add(createObject(type));
    list.add(createObject(type));
    return list;
  }


}
