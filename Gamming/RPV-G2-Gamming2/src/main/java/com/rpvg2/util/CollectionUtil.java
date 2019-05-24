package com.rpvg2.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author gilis
 */
public class CollectionUtil {

    public static boolean possuiDuplicatas(Collection collection) {
        Set aux = new HashSet();

        return collection.stream().anyMatch((object) -> (!aux.add(object)));
    }
}
