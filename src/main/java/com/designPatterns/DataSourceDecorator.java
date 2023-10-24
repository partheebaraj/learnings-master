package com.designPatterns;

import javax.xml.crypto.Data;

public class DataSourceDecorator implements DataSource {

    DataSource wrappee;

    public DataSourceDecorator(DataSource dataSource) {
        this.wrappee = dataSource;
    }

    @Override
    public String readData() {
        return wrappee.readData();
    }

    @Override
    public void writeData(String data) {
      wrappee.readData();
    }
}
