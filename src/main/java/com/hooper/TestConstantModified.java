package com.hooper;

import static com.hooper.CommonConstant.*;

public class TestConstantModified {

    public void randomMethod(TestClass testClass) {
        String s = "a";
        s += 1;
        System.out.println(s);
        if (MES_STATUS.FAILURE.equals(testClass.getMesStatus())) {
            testClass.setCustKind(CUST_KIND.PERSON);
            testClass.setReturnCode(RET_CODE.OK);
            testClass.setErrorCode(ERROR_CODE.BALANCE_NOT_ENOUGH);
        }
        if (MES_STATUS.SUCCESS.equals(testClass.getMesStatus()) || MES_STATUS.FAILURE.equals(testClass.getMesStatus())) {
            testClass.setCustKind(CUST_KIND.PERSON);
            testClass.setReturnCode(RET_CODE.OK);
            testClass.setErrorCode(ERROR_CODE.BALANCE_NOT_ENOUGH);
        }
    }

}
