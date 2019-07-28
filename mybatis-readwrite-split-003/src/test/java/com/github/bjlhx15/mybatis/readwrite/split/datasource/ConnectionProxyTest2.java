package com.github.bjlhx15.mybatis.readwrite.split.datasource;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ConnectionProxyTest2 {
    @Test
    public void testProsy() {
        IFun o = (IFun) Proxy.newProxyInstance(IFun2.class.getClassLoader(), IFun2.class.getInterfaces(), new IFunInvacationHandler());

        System.out.println(o.getClass());
        o.run();
    }

    interface IFun {
        void run();
    }

    interface IFun2 extends IFun{
        void run2(String v);
    }

    class IFunInvacationHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("---------before-------");
            Object invoke = method.invoke(args);
            System.out.println("---------after-------");

            return invoke;
        }
    }

}