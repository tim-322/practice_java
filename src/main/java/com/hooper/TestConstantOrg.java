package com.hooper;

public class TestConstantOrg {
    public void randomMethod(TestClass testClass) {
        String s = "a";
        s += 1;
        System.out.println(s);
        if ("03".equals(testClass.getMesStatus())) {
            testClass.setCustKind("1");
            testClass.setReturnCode("0000000");
            testClass.setErrorCode("CJ0000000");
        }
        if ("02".equals(testClass.getMesStatus()) || "03".equals(testClass.getMesStatus())) {
            testClass.setCustKind("1");
            testClass.setReturnCode("00000000");
            testClass.setErrorCode("CJDB0011");
        }
    }
}
