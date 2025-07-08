package com.example.demovers1.config;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.identity.IdentityColumnSupportImpl;
import org.hibernate.dialect.identity.IdentityColumnSupport;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.engine.jdbc.env.spi.NameQualifierSupport;
import org.hibernate.type.StandardBasicTypes;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public class CustomSQLiteDialect extends Dialect {

    public CustomSQLiteDialect() {
        super();

        // Типове данни
        registerColumnType(Types.BIT, "boolean");
        registerColumnType(Types.TINYINT, "tinyint");
        registerColumnType(Types.SMALLINT, "smallint");
        registerColumnType(Types.INTEGER, "integer");
        registerColumnType(Types.BIGINT, "bigint");
        registerColumnType(Types.FLOAT, "float");
        registerColumnType(Types.DOUBLE, "double");
        registerColumnType(Types.NUMERIC, "numeric");
        registerColumnType(Types.DECIMAL, "decimal");
        registerColumnType(Types.CHAR, "char");
        registerColumnType(Types.VARCHAR, "varchar");
        registerColumnType(Types.LONGVARCHAR, "longvarchar");
        registerColumnType(Types.DATE, "date");
        registerColumnType(Types.TIME, "time");
        registerColumnType(Types.TIMESTAMP, "timestamp");
        registerColumnType(Types.BINARY, "blob");
        registerColumnType(Types.VARBINARY, "blob");
        registerColumnType(Types.LONGVARBINARY, "blob");
        registerColumnType(Types.BLOB, "blob");
        registerColumnType(Types.CLOB, "clob");
        registerColumnType(Types.BOOLEAN, "boolean");

        // Регистрация на SQL функции
        registerFunction("concat", new SQLFunctionTemplate(StandardBasicTypes.STRING, "?1 || ?2"));
        registerFunction("mod", new SQLFunctionTemplate(StandardBasicTypes.INTEGER, "?1 % ?2"));
        registerFunction("substr", new StandardSQLFunction("substr", StandardBasicTypes.STRING));
        registerFunction("substring", new StandardSQLFunction("substr", StandardBasicTypes.STRING));
    }

    @Override
    public IdentityColumnSupport getIdentityColumnSupport() {
        return new IdentityColumnSupportImpl();
    }


    public boolean supportsIdentityColumns() {
        return true;
    }


    public String getIdentityColumnString() {
        return "integer";
    }


    public String getIdentitySelectString() {
        return "select last_insert_rowid()";
    }

    @Override
    public NameQualifierSupport getNameQualifierSupport() {
        return NameQualifierSupport.NONE;
    }

    @Override
    public boolean supportsLimit() {
        return true;
    }

    @Override
    public boolean bindLimitParametersInReverseOrder() {
        return true;
    }


    public boolean supportsTemporaryTables() {
        return true;
    }


    public String getCreateTemporaryTableString() {
        return "create temporary table if not exists";
    }

    @Override
    public String getAddColumnString() {
        return "add column";
    }

}
