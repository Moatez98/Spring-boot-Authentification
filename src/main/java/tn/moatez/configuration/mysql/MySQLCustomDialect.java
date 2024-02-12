package tn.moatez.configuration.mysql;

import org.hibernate.dialect.MySQLDialect;

public class MySQLCustomDialect  extends MySQLDialect {
    @Override
    public String getTableTypeString(){
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin";
    }
}
