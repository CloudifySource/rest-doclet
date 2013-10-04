package org.cloudifysource.restDoclet.exampleGenerators;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @author Ed Kimber
 */
public class ObjectCreator {

  private Objenesis objenesis_;
  private static final Logger logger_ = Logger.getLogger(ObjectCreator.class.getName());


  public ObjectCreator() {
    objenesis_ = new ObjenesisStd();
  }

  public Object createObject(final Class<?> cls) throws IllegalAccessException {
    if (isAbstractOrInterface(cls)) return createProxy(cls);

    try {
      Object object = objenesis_.newInstance(cls);
      instantiateFieldsOn(object);
      return object;
    }
    catch (IllegalAccessError illegal) {
      logger_.warning("Could not instantiate an object of class: " + cls.getName());
      return null;
    }
  }

  public void instantiateFieldsOn(final Object object) throws IllegalAccessException {
    Class<?> cls = object.getClass();
    for (Field f : cls.getDeclaredFields()) {
      if (f.getType().equals(cls)) {
        continue; //avoid infinite recursion!
      }
      else {
        tryToSetField(f, object);
      }
    }
  }

  private void tryToSetField(final Field field, final Object object) {
    try {
      field.setAccessible(true);
      Class<?> fieldType = field.getType();

      if (field.getGenericType() instanceof ParameterizedType) {
        field.set(object, createParameterizedType(fieldType, (ParameterizedType) field.getGenericType()));
      }
      else {
        field.set(object, createValueForType(fieldType));
      }
    }
    catch (IllegalAccessException illegal) {
      logger_.warning("Could not set field " + field.getName() + " on a " + object.getClass());
    }
  }

  public Object createProxy(final Class cls) {
    return Enhancer.create(cls, new MethodInterceptor() {
      @Override
      public Object intercept(final Object proxy, final Method method,
                              final Object[] args, final MethodProxy methodProxy)
              throws Throwable
      {
        return createValueForType(method.getReturnType());
      }
    });
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
      return PrimitiveExampleValues.getValue(cls);
    }
    else {
      return createObject(cls);
    }
  }

  @SuppressWarnings("unchecked")
  private List createListOfType(final Class type) throws IllegalAccessException {
    LinkedList list = new LinkedList();
    list.add(createValueForType(type));
    list.add(createValueForType(type));
    return list;
  }

  private boolean isAbstractOrInterface(final Class<?> cls) {
    int modifiers = cls.getModifiers();
    return Modifier.isInterface(modifiers) || Modifier.isAbstract(modifiers);
  }

}
