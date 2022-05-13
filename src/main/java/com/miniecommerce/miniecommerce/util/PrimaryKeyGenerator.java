package com.miniecommerce.miniecommerce.util;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class PrimaryKeyGenerator implements IdentifierGenerator {

    public static String generateNewPrimaryKey() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return generateNewPrimaryKey();
    }
}
