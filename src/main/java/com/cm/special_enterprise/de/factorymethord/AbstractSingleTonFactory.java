package com.cm.special_enterprise.de.factorymethord;

import org.apache.poi.ss.formula.functions.T;

public abstract class AbstractSingleTonFactory {
    public abstract T createSingleTonFactory(Class<T> c) throws InstantiationException, IllegalAccessException;
}
