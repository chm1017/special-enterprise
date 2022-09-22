package com.cm.special_enterprise.de.factorymethord;

import org.apache.poi.ss.formula.functions.T;

import java.lang.reflect.Constructor;

public class SingleTonFactory extends AbstractSingleTonFactory {

    @Override
    public T createSingleTonFactory(Class<T> c) throws InstantiationException, IllegalAccessException {
             T t = c.newInstance();
             return t;
    }
}
