package Configuracao;

import java.lang.reflect.Field;

/**
 * Classe com metodos genericos para utilizar o reflection
 *
 * @author gilis
 */
public abstract class JUnitTestReflectionBase {

    @SuppressWarnings("unchecked")
    public static <V> V getAtributo(Object object, String fieldName) {
        Class<?> clazz = object.getClass();
        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                return (V) field.get(object);
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            } catch (IllegalAccessException | IllegalArgumentException | SecurityException e) {
                throw new IllegalStateException(e);
            }
        }
        return null;
    }

    public static boolean setAtributo(Object object, String fieldName, Object fieldValue) {
        Class<?> clazz = object.getClass();
        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(object, fieldValue);
                return true;
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            } catch (IllegalAccessException | IllegalArgumentException | SecurityException e) {
                throw new IllegalStateException(e);
            }
        }
        return false;
    }
}
