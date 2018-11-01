package com.eprogrammerz.examples.springmvc.data;

/**
 * Returns an implementation of a DataFacade.
 * Could be TestDataImpl or ProdDataImpl, depending on
 * input argument.
 * <p>
 * Input argument can be "dev" or "prod"
 */
public class DataFacadeFactory {
    public DataFacade getDataFacadeInstance(String type) {
        if (type.equals("dev")) {
            return new TestDataImpl();
        }
//		if(type.equals("prod")){
//			return new ProdDataImpl()
//		}
        return null;
    }
}
