package org.cloudifysource.restDoclet.exampleGenerators;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.google.common.primitives.Primitives;
import static com.google.common.collect.Lists.newArrayList;

/**
 * @author Ed Kimber
 */
public class ObjectCreator {

  private Objenesis objenesis_;
  private static final Logger logger_ = Logger.getLogger(ObjectCreator.class.getName());
  private List<ExampleCreator> exampleCreators_;

  public ObjectCreator() {
    objenesis_ = new ObjenesisStd();
    exampleCreators_ = newArrayList(primitiveCreator_, wrapperCreator_, stringCreator_, enumCreator_, dateCreator_, listCreator_);
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
    for (ExampleCreator creator : exampleCreators_) {
      if (creator.match(cls)) {
        return creator.create(cls);
      }
    }
    return createObject(cls);
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

  interface ExampleCreator {
    boolean match(Class cls);
    Object create(Class cls) throws IllegalAccessException;
  }

  private static ExampleCreator stringCreator_ = new ExampleCreator() {

    @Override
    public boolean match(Class cls) {
      return String.class.isAssignableFrom(cls);
    }

    @Override
    public Object create(final Class cls) {
      return "foo";
    }
  };

  private static ExampleCreator primitiveCreator_ = new ExampleCreator() {
    @Override
    public boolean match(final Class cls) {
      return cls.isPrimitive();
    }

    @Override
    public Object create(final Class cls) {
      return PrimitiveExampleValues.getValue(cls);
    }
  };

  private static ExampleCreator wrapperCreator_ = new ExampleCreator() {
    @Override
    public boolean match(final Class cls) {
      return Primitives.isWrapperType(cls);
    }

    @Override
    public Object create(final Class cls) throws IllegalAccessException {
      return PrimitiveExampleValues.getValue(Primitives.unwrap(cls));
    }
  };

  private static ExampleCreator enumCreator_ = new ExampleCreator() {
    @Override
    public boolean match(final Class cls) {
      return cls.isEnum();
    }

    @Override
    public Object create(final Class cls) {
      return Enum.valueOf((Class<? extends Enum>) cls, cls.getEnumConstants()[0].toString());
    }
  };

  private ExampleCreator listCreator_ = new ExampleCreator() {
    @Override
    public boolean match(final Class cls) {
      return List.class.isAssignableFrom(cls);
    }

    @Override
    public Object create(final Class cls) throws IllegalAccessException {
      return createListOfType(Object.class);
    }
  };

  private ExampleCreator dateCreator_ = new ExampleCreator() {
    @Override
    public boolean match(final Class cls) {
      return Date.class.isAssignableFrom(cls);
    }

    @Override
    public Object create(final Class cls) throws IllegalAccessException {
      return new Date();
    }
  };
}
