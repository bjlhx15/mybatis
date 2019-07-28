package com.github.bjlhx15.mybatis.readwrite.split.datasource;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

public class ConnectionProxyTest {
    @Test
    public void testProsy() {
        IFun car =new Car();
        IFun o = (IFun) Proxy.newProxyInstance(Car.class.getClassLoader(), Car.class.getInterfaces(), new IFunInvacationHandler(car));

        System.out.println(o.getClass());
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(o);
//        invocationHandler.
        o.run();
    }

    interface IFun {
        void run();

    }

    class Car implements IFun {

        @Override
        public void run() {
            System.out.println("Car runing");
        }
    }

    class IFunInvacationHandler implements InvocationHandler {

        private final IFun vehical;
        public IFunInvacationHandler(IFun vehical){
            this.vehical = vehical;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("---------before-------");
            Object invoke = method.invoke(vehical,args);
            System.out.println("---------after-------");

            return invoke;
        }
    }

}