package com.hooper;

public class CommonConstant {

    /**
     * 通用响应参数返回码常量类
     */
    public static class RET_CODE {
        /**
         * 返回码key
         */
        public static final String RETURN_CODE_KEY = "return_Code";
        /**
         * 返回信息key
         */
        public static final String RETURN_MSG_KEY = "return_Msg";
        /**
         * 通用响应参数返回码 - 成功
         */
        public static final String OK = "00000000";


        /**
         * 交易已锁定
         */
        public static final String LOCKED = "CJO00005";

        /**
         * 超出认证时长，需重发请求
         */
        public static final String VERIFY_TIMEOUT = "CJ004444";

        /**
         * 未知错误
         */
        public static final String UNKNOWN_ERROR = "999999";

        /**
         * 服务失败
         */
        public static final String SERVICE_FAILURE = "CJO01000";


        /**
         * 次数超限，需重新发起(针对需短信认证的场景)
         */
        public static final String SMS_LIMIT_EXCEEDED = "CJ005555";

        /**
         * 服务异常
         */
        public static final String SERVICE_EXCEPTION = "CJS09999";

        /**
         * 参数校验失败
         */
        public static final String INVALID_PARAMETER = "CL000005";

        /**
         * 重复请求
         */
        public static final String REPEATED_REQUEST = "CJ019997";

        /**
         * 连接失败
         */
        public static final String CONNECTION_FAILURE = "CLOS0013";

        /**
         * 请求方流水号重复
         */
        public static final String DUPLICATE_REQUEST_ID = "CJ030001";

        /**
         * 未找到对应信息记录
         */
        public static final String RECORD_NOT_FOUND = "CJ030002";


        /**
         * 重复验证
         */
        public static final String REPEATED_VALIDATION = "CJ030003";

        /**
         * 验证失败
         */
        public static final String VALIDATION_FAILURE = "CJ030005";

        /**
         * 超时失败
         */
        public static final String TIMEOUT_ERROR = "CJ030006";

        /**
         * 验证码校验超时，验证码校验失败
         */
        public static final String SMS_CODE_TIMOUT = "CJ030004";

    }

    /**
     * 通用返回错误码常量类
     */
    public static class ERROR_CODE {
        /**
         * 请求流水号重复 - CJ019998
         */
        public static final String DUPLICATE_REQ_NO = "CJ019998";
        /**
         * 入库异常 - CJ019999
         */
        public static final String DB_INSERT_ERR = "CJ019999";
        /**
         * 未知错误 - CJ019997
         */
        public static final String UNKNOWN_ERR = "CJ019997";
        /**
         * 余额不足 - CJDB0011
         */
        public static final String BALANCE_NOT_ENOUGH = "CJDB0011";


    }

    /**
     * 平台对接模式常量类
     */
    public static class JOIN_MODE {
        /**
         * 平台对接模式 - 虚账户
         */
        public static final String VIR_ACCT_MODE = "01";
        /**
         * 平台对接模式 - 实账户
         */
        public static final String REAL_ACCT_MODE = "00";
    }

    /**
     * 标准时间格式常量类
     */
    public static class STD_FORMAT {

        /**
         * 标准时间格式 - 日期时间(yyyyMMddHHmmss) -24小时制
         */
        public static final String DATETIME_yyyyMMddHHmmss = "yyyyMMddHHmmss";
        /**
         * 标准时间格式 - 日期(yyyyMMdd)
         */
        public static final String DATE_yyyyMMdd = "yyyyMMdd";
        /**
         * 标准时间格式 - 时间(hhmmss)-12小时制
         */
        public static final String TIME_12_hhmmss = "hhmmss";

        /**
         * 标准时间格式 - 时间(HHmmss)-24小时制
         */
        public static final String TIME_24_HHmmss = "HHmmss";
    }


    /**
     * 消息处理状态常量
     */
    public static class MES_STATUS {
        /**
         * 消息处理状态 - 初始化
         */
        public static final String INIT = "00";
        /**
         * 消息处理状态 - 请求处理中
         */
        public static final String PROCESSING = "01";
        /**
         * 消息处理状态 - 业务处理成功
         */
        public static final String SUCCESS = "02";
        /**
         * 消息处理状态 - 业务处理失败
         */
        public static final String FAILURE = "03";
//        /**
//         * 消息处理状态 - 业务等待重新尝试处理
//         */
//        public static final String WAIT_RETRY = "04";

        /**
         * 消息处理状态 - 挂起
         */
        public static final String SUSPEND = "20";

        /**
         * 多退少补处理状态 - 款数一致
         */
        public static final String MBFSR_SUCCESS = "W-01";
    }

    /**
     * 请求文件名称常量
     */
    public static class COMMON {
        /**
         * 默认空值 - ”-1“
         */
        public static final String DEFAULT_NULL = "-1";
        /**
         * 默认字母 true 值 - Y
         */
        public static final String DEFAULT_Y = "Y";

        /**
         * 默认字母 false 值 - N
         */
        public static final String DEFAULT_N = "N";
    }

    /**
     * 对账处理状态常量
     */
    public static class DEAL_STATUS {
        //00 ：初始化；
        //01 ：对账文件数据已准备完成；
        //02：对账文件已经生成；
        //03：对账文件准备上传；
        //04：已获取回盘文件；
        //11：对账文件数据准备异常
        //12：对账文件生成失败
        //13：对账文件发送前置失败
        //14：对账文件上传市场失败
        //15：对账文件通知市场异常

        /**
         * 对账处理状态 - 初始化
         */
        public static final String INIT = "00";
        /**
         * 对账处理状态 - 对账文件数据已准备完成
         */
        public static final String DATA_PREPARED = "01";
        /**
         * 对账处理状态 - 对账文件已经生成
         */
        public static final String FILE_GENERATED = "02";
        /**
         * 对账处理状态 - 对账文件准备上传
         */
        public static final String FILE_PREPARED = "03";
        /**
         * 对账处理状态 - 已获取回盘文件
         */
        public static final String FILE_RECEIVED = "04";
        /**
         * 对账处理状态 - 对账文件数据准备异常
         */
        public static final String DATA_PREPARE_EXCEPTION = "11";
        /**
         * 对账处理状态 - 对账文件生成失败
         */
        public static final String FILE_GENERATE_FAILURE = "12";
        /**
         * 对账处理状态 - 对账文件发送前置失败
         */
        public static final String FILE_SEND_FAILURE = "13";
        /**
         * 对账处理状态 - 对账文件上传市场失败
         */
        public static final String FILE_UPLOAD_FAILURE = "14";
        /**
         * 对账处理状态 - 对账文件通知市场异常
         */
        public static final String FILE_NOTIFY_EXCEPTION = "15";

    }

    /**
     * 市场模式常量类
     */
    public static class MARKET_CLEAR_MODE {

        /**
         * 清分模式 - 众安模式
         */
        public static final String MODEL_PARAM_05 = "05";

        /**
         * 清分模式 - 太平洋保险模式
         */
        public static final String MODEL_PARAM_06 = "06";

        /**
         * 清分模式 - 360金融模式
         */
        public static final String MODEL_PARAM_09 = "09";

        /**
         * 清分模式 - B2B存管模式
         */
        public static final String MODEL_PARAM_08 = "08";

        /**
         * 清分模式 - 支付宝-消费
         */
        public static final String MODEL_PARAM_20 = "20";

        /**
         * 清分模式 - 支付宝-理财分销
         */
        public static final String MODEL_PARAM_21 = "21";

        /**
         * 清分模式 - 支付宝-网银推单
         */
        public static final String MODEL_PARAM_22 = "22";

        /**
         * 清分模式 - 理财分销
         */
        public static final String MODEL_PARAM_23 = "23";

        /**
         * 清分模式 - 24-支付宝直付通渠道服务模式
         */
        public static final String MODEL_PARAM_24 = "24";

        /**
         * 清分模式 - 25-支付宝直付通渠道接入模式
         */
        public static final String MODEL_PARAM_25 = "25";

        /**
         * 清分模式 - 26-支付宝备付金模式
         */
        public static final String MODEL_PARAM_26 = "26";

        /**
         * 清分模式 - 二手房(我爱我家)资金监管
         */
        public static final String MODEL_PARAM_30 = "30";

        /**
         * 清分模式 - 二手房(理房通)资金监管
         */
        public static final String MODEL_PARAM_31 = "31";

        /**
         * 清分模式 - 行内预售房资金监管
         */
        public static final String MODEL_PARAM_32 = "32";

        /**
         * 清分模式 - 南通存量房资金监管
         */
        public static final String MODEL_PARAM_33 = "33";

        /**
         * 清分模式 - 上海存量房资金监管
         */
        public static final String MODEL_PARAM_34 = "34";

        /**
         * 清分模式 - 35-上海预售房资金监管
         */
        public static final String MODEL_PARAM_35 = "35";

        /**
         * 清分模式 - 银联云直通渠道服务模式
         */
        public static final String MODEL_PARAM_40 = "40";

        /**
         * 清分模式 - 银联云直通渠道接入模式
         */
        public static final String MODEL_PARAM_41 = "41";

        /**
         * 清分模式 - 电商平台资金监管模式
         */
        public static final String MODEL_PARAM_50 = "50";

        /**
         * 清分模式 - 教育缴费渠道服务模式
         */
        public static final String MODEL_PARAM_60 = "60";

        /**
         * 清分模式 - 教育缴费特殊商户接入模式
         */
        public static final String MODEL_PARAM_61 = "61";

        /**
         * 清分模式 - 62-上海教培小程序
         */
        public static final String MODEL_PARAM_62 = "62";

        /**
         * 清分模式 - 63-上海教培机构
         */
        public static final String MODEL_PARAM_63 = "63";

        /**
         * 清分模式 - 64-全国教培渠道服务模式
         */
        public static final String MODEL_PARAM_64 = "64";

        /**
         * 清分模式 - 65-全国教培教培机构模式
         */
        public static final String MODEL_PARAM_65 = "65";

        /**
         * 清分模式 - 分户核算平台记账模式
         */
        public static final String MODEL_PARAM_70 = "70";

        /**
         * 清分模式 - 分户核算不计子户余额模式
         */
        public static final String MODEL_PARAM_71 = "71";

        /**
         * 清分模式 - 外贸综合服务模式
         */
        public static final String MODEL_PARAM_72 = "72";

        /**
         * 清分模式 - 还贷通模式
         */
        public static final String MODEL_PARAM_80 = "80";

        /**
         * 清分模式 - 81-还贷通-中和农信模式
         */
        public static final String MODEL_PARAM_81 = "81";

        /**
         * 清分模式 - 82-个人经营贷-厚沃模式
         */
        public static final String MODEL_PARAM_82 = "82";

        /**
         * 清分模式 - 网银推单模式
         */
        public static final String MODEL_PARAM_90 = "90";

        /**
         * 清分模式 - 警察大队
         */
        public static final String MODEL_PARAM_A0 = "A0";

        /**
         * 清分模式 - 0a-支付机构直连模式
         */
        public static final String MODEL_PARAM_0A = "0a";

        /**
         * 清分模式 - 0b-深圳银联模式
         */
        public static final String MODEL_PARAM_0B = "0b";

        /**
         * 清分模式 - 0c-B2B存管-华能信托模式
         */
        public static final String MODEL_PARAM_0C = "0c";
    }


    /**
     *
     */
    public static class MES_DISPLAY_OPTION {

        /**
         * 银商通签约模型
         */
        public static final String MIS_POS_SIGN = "MIS-POS_SIGN";

        /**
         * 银商通验证模型
         */
        public static final String MIS_POS_VERIFY = "MIS-POS_Verify";

        /**
         * 监管模式验证模型
         */
        public static final String SUPERVISE_VERIFY = "Supervise_Verify";

        /**
         * 监管模式通知模型
         */
        public static final String SUPERVISE_NOTICE = "Supervise_Notice";

        /**
         * 银商通白名单模型
         */
        public static final String MIS_POS_WHITE = "MIS-POS_WHITE";

        /**
         * 银商通注销模型
         */
        public static final String MIS_POS_CANCED = "MIS-POS_Canced";

        /**
         * 银商通入金/充值模型
         */
        public static final String MIS_POS_IN = "MIS-POS_IN";

        /**
         * 银商通出金/提现模型
         */
        public static final String MIS_POS_OUT = "MIS-POS_OUT";

        /**
         * 银商通转账/划转模型
         */
        public static final String MIS_POS_TRANS = "MIS-POS_TRANS";


        /**
         * 银商通订单模型
         */
        public static final String MIS_POS_OREDER = "MIS-POS_OREDER";

        /**
         * 银商通文件模型
         */
        public static final String MIS_POS_FILE = "MIS-POS_File";

        /**
         * 头寸调拨模型
         */
        public static final String HIGH_PERFOMANCE = "HIGH_PERFOMANCE";

        /**
         * 绑定模型
         */
        public static final String BIND_CARD = "Bind_Card";

        /**
         * 还贷通对账模型
         */
        public static final String REPAYSUPERVISE_COUNT = "RepaySupervise_Count";

        /**
         * 还贷通清分模型
         */
        public static final String REPAYSUPERVISE_CLEAR = "RepaySupervise_Clear";

        /**
         * 二手房协议模型
         */
        public static final String SUPHT_AGREMENT = "SupHt_Agrement";

        /**
         * 二手房支付模型
         */
        public static final String SUPHT_PAYORG = "SupHt_PayOrg";

        /**
         * 二手房资金模型
         */
        public static final String SUPHT_MONEY = "SupHt_Money";

        /**
         * 网银推单
         */
        public static final String ALIPUSH = "AliPush";

        /**
         * 鉴权
         */
        public static final String PAY_AUTH = "Pay_Auth";
    }

    /**
     * 签约状态
     */
    public static class SIGN_STATE {

        /**
         * 未签约
         */
        public static final String NOT_SIGN = "0";
        /**
         * 已签约
         */
        public static final String SUCCESS = "1";
        /**
         * 已解约
         */
        public static final String CANCELED = "2";
        /**
         * 签约失败
         */
        public static final String FAILED = "3";
    }

    /**
     * 受理状态
     */
    public static class ACCT_STATE {
        ////开户受理状态码	开户成功：succes待激活：preactive	开户失败：fail已注销：canceled	已受理/受理中：accept

        /**
         * 开户成功
         */
        public static final String SUCCESS = "success";

        /**
         * 待激活
         */
        public static final String PREACTIVE = "preactive";

        /**
         * 开户失败
         */
        public static final String FAIL = "fail";

        /**
         * 已注销
         */
        public static final String CANCELED = "canceled";

        /**
         * 已受理/受理中
         */
        public static final String ACCEPT = "accept";

    }

    /**
     * 客户身份认证状态
     */
    public static class AUTH_BATCH_STATUS {
        /**
         * 当前需请求
         */
        public static final String CURRENT_REQ = "00";

        /**
         * 请求处理中
         */
        public static final String REQ_PROCESSING = "01";

        /**
         * 身份认证成功
         */
        public static final String AUTH_SUCCESS = "02";

        /**
         * 身份认证失败
         */
        public static final String AUTH_FAIL = "03";
    }

    /**
     * 公安认证状态 -法人和经办人通用
     */
    public static class POLICE_CHECK {
//        10：无需认证；00：未认证；01：认证缓存中；02：认证成功；03：认证失败；04：缓存认证失败；
        /**
         * 无需认证
         */
        public static final String NO_NEED = "10";

        /**
         * 未认证
         */
        public static final String NOT_CHECK = "00";

        /**
         * 认证缓存中
         */
        public static final String CHECK_CACHING = "01";

        /**
         * 认证成功
         */
        public static final String CHECK_SUCCESS = "02";

        /**
         * 认证失败
         */
        public static final String CHECK_FAIL = "03";

        /**
         * 缓存认证失败
         */
        public static final String CHECK_CACHE_FAIL = "04";

    }

    /**
     * 是否需要影像上传标记
     */
    public static class IMG_CHECK {
        //0为未完成影像资料认证；
        //1为影像资料认证失败；
        //2为已完成影像资料认证；

        /**
         * 未完成影像资料认证
         */
        public static final String NOT_CHECK = "0";

        /**
         * 影像资料认证失败
         */
        public static final String CHECK_FAIL = "1";

        /**
         * 已完成影像资料认证
         */
        public static final String CHECK_SUCCESS = "2";

    }

    /**
     * 是否完成影像上传
     */
    public static class IMG_UPLOAD {

        /**
         * 未完成影像资料上传
         */
        public static final String NOT_UPLOAD = "0";

        /**
         * 影像资料上传失败
         */
        public static final String NO_NEED = "1";

        /**
         * 已完成影像资料上传
         */
        public static final String UPLOAD_SUCCESS = "2";
    }

    /**
     * 是否需要短信认证
     */
    public static class SMS_FLAG_CHECK {
        /**
         * 需要进行短信认证
         */
        public static final String NEED = "0";

        /**
         * 不需要短信认证
         */
        public static final String NO_NEED = "1";

        /**
         * 已完成短信认证
         */
        public static final String CHECK_SUCCESS = "2";
    }

    /**
     * 是否需要打款激活
     */
    public static class ACTIVE_AMOUNT_FLAG {
        /**
         * 需要进行打款激活
         */
        public static final String NEED = "0";

        /**
         * 不需要打款激活
         */
        public static final String NO_NEED = "1";

        /**
         * 已完成打款激活
         */
        public static final String CHECK_SUCCESS = "2";
    }

    /**
     * 是否需要往账激活
     */
    public static class NOSTRO_ACTIVE_FLAG {
        /**
         * 需要进行往账激活
         */
        public static final String NEED = "0";

        /**
         * 不需要往账激活
         */
        public static final String NO_NEED = "1";

        /**
         * 已完成往账激活
         */
        public static final String CHECK_SUCCESS = "2";
    }

    /**
     * 消息请求标记
     */
    public static class MSG_REQ_FLAG {
//00为未请求或重新请求；01为请求处理中；03为完成本次请求；

        /**
         * 未请求或重新请求
         */
        public static final String NOT_REQ = "00";

        /**
         * 请求处理中
         */
        public static final String REQ_PROCESSING = "01";

        /**
         * 完成本次请求
         */
        public static final String REQ_SUCCESS = "03";
    }

    /**
     * 对账标记
     */
    public static class CHECK_STATUS {
        //00为未对账；01为已对账；
        /**
         * 未对账
         */
        public static final String NOT_CHECK = "00";

        /**
         * 已对账
         */
        public static final String CHECK_SUCCESS = "01";
    }

    /**
     * 优先级
     * 优先级从低到高排序,1为正常交易；2为解约类型交易；3为修改类型交易；
     */
    public static class PROCESS_PRIORITY {

        /**
         * 正常交易
         */
        public static final String NORMAL = "1";

        /**
         * 解约类型交易
         */
        public static final String CANCEL = "2";

        /**
         * 修改类型交易
         */
        public static final String MODIFY = "3";
    }

    /**
     * 是否需要通知
     */
    public static class INFORM_FLAG {
        //Y为需要，N为不需要
        /**
         * 需要通知
         */
        public static final String NEED = "Y";

        /**
         * 不需要通知
         */
        public static final String NO_NEED = "N";
    }

    /**
     * 信息状态
     */
    public static class INFO_STATUS {
        //"00:为已签约用户；
        //01:为注销用户；
        //02:为注销重新激活用户；
        //03为新签约用户；"

        /**
         * 已签约用户
         */
        public static final String SIGNED = "00";

        /**
         * 注销用户
         */
        public static final String CANCEL = "01";

        /**
         * 注销重新激活用户
         */
        public static final String REACTIVE = "02";

        /**
         * 新签约用户
         */
        public static final String NEW = "03";

    }

    /**
     * 客户类型
     */
    public static class CUST_KIND {

        /**
         * 个人客户
         */
        public static final String PERSON = "1";

        /**
         * 企业客户
         */
        public static final String COMPANY = "0";
    }

    /**
     * 证件类型
     */
    public static class CERT_TYPE {
        /**
         * 身份证 - A
         */
        public static final String ID_CARD = "A";
        //M：统一信用社会代码；
        //N：组织机构代码证号；

        /**
         * 统一信用社会代码 - M
         */
        public static final String UNIFIED_CREDIT_CODE = "M";

        /**
         * 组织机构代码证号 - N
         */
        public static final String ORGANIZATION_CODE = "N";
    }

    /**
     * 证件长期有效标记
     */
    public static class FOREVER_FLAG {
        /**
         * 长期有效
         */
        public static final String LONG_TERM = "1";

        /**
         * 非长期有效
         */
        public static final String NOT_LONG_TERM = "0";
    }

    /**
     * 汇款模式
     * 0 普通 1 实时
     */
    public static class POSENTRY_MODE {
        /**
         * 普通
         */
        public static final String NORMAL = "0";

        /**
         * 实时
         */
        public static final String REAL_TIME = "1";
    }

    /**
     * 记账标记
     * "Y为默认需要进行记账，
     * N为无需记账"
     */
    public static class RECORD_FLAG {
        /**
         * 需要记账
         */
        public static final String NEED = "Y";

        /**
         * 不需要记账
         */
        public static final String NO_NEED = "N";
    }

    /**
     * 出/入金处理标记 -TB_BASE_OUTMONEYFLOW
     * 0 未执行  1 执行中  2 已执行
     */
    public static class DEAL_FLAG {
        /**
         * 未执行
         */
        public static final String NOT_DEAL = "0";

        /**
         * 执行中
         */
        public static final String DEALING = "1";

        /**
         * 已执行
         */
        public static final String DEAL_SUCCESS = "2";

    }

    /**
     * 汇划路径代码
     * <p>
     * "1001-大额支付
     * 1002-小额支付
     * 1003-超级网银
     * 1004-上海同城
     * 1005-上海同城转汇
     * 1012-城商行
     * 1006-上海银联
     * 1007-成都银联
     * 10003-互金平台-天津银联"
     */
    public static class PAY_PATH_CODE {
        /**
         * 大额支付
         */
        public static final String BIG_AMOUNT = "1001";

        /**
         * 小额支付
         */
        public static final String SMALL_AMOUNT = "1002";

        /**
         * 超级网银
         */
        public static final String SUPER_NET_BANK = "1003";

        /**
         * 上海同城
         */
        public static final String SH_1004 = "1004";

        /**
         * 上海同城转汇
         */
        public static final String SH_1005 = "1005";

        /**
         * 城商行
         */
        public static final String CITY_1012 = "1012";

        /**
         * 上海银联
         */
        public static final String SH_1006 = "1006";

        /**
         * 成都银联
         */
        public static final String CD_1007 = "1007";

        /**
         * 互金平台-天津银联
         */
        public static final String TJ_10003 = "10003";
    }

    /**
     * 编号类型
     * "LOAN                   供应链融资
     * ORDERPAY               订单支付
     * OUTPLATCHARGE          出金平台收取手续费
     * OUTPLATCHARGE_UNFREEZE 出金平台收取手续费解冻
     * SUPERVISECLEAR         监管清分
     * CASH_OUT               现金提现
     * REV_CASH_OUT           现金提现冲正
     * REV_OUTPLATCHARGE      出金平台收取手续费冲正
     * IN                     入金/充值
     * REPAY_CLEAR_IN         还贷通清分/代扣入金
     * PLAT_CHARGE_CASH_OUT   清分从汇总户到收益户
     * CUSTOMER_CASH_OUT      从汇总户到资方/资产方
     * SUPERVISE_OUT_BACKUP   清分自动退回
     * ADVANCE_CASH_OUT       垫付保费从资产方到汇总户
     * CNAPS2_IN              退汇入金
     * REPAY_CLEAR_IN         主动还款
     * ALI_VIR_TRANS          蚂蚁金服-虚账户请款交易
     * ALI_VIR_TRANS_CANCEL   蚂蚁金服-虚账户请款交易取消
     * ALI_CASH_REBACK        蚂蚁金服-虚账户退款交易
     * ORDER                  订单类型
     * CONT                   合同类型
     * PLAT                   平台类型 "
     */
    public static class NO_TYPE {

        /**
         * 供应链融资
         */
        public static final String LOAN = "LOAN";

        /**
         * 订单支付
         */
        public static final String ORDERPAY = "ORDERPAY";

        /**
         * 出金平台收取手续费
         */
        public static final String OUTPLATCHARGE = "OUTPLATCHARGE";

        /**
         * 出金平台收取手续费解冻
         */
        public static final String OUTPLATCHARGE_UNFREEZE = "OUTPLATCHARGE_UNFREEZE";

        /**
         * 监管清分
         */
        public static final String SUPERVISECLEAR = "SUPERVISECLEAR";

        /**
         * 现金提现
         */
        public static final String CASH_OUT = "CASH_OUT";

        /**
         * 现金提现冲正
         */
        public static final String REV_CASH_OUT = "REV_CASH_OUT";

        /**
         * 出金平台收取手续费冲正
         */
        public static final String REV_OUTPLATCHARGE = "REV_OUTPLATCHARGE";

        /**
         * 入金/充值
         */
        public static final String IN = "IN";

        /**
         * 还贷通清分/代扣入金
         */
        public static final String REPAY_CLEAR_IN = "REPAY_CLEAR_IN";

        /**
         * 清分从汇总户到收益户
         */
        public static final String PLAT_CHARGE_CASH_OUT = "PLAT_CHARGE_CASH_OUT";

        /**
         * 从汇总户到资方/资产方
         */
        public static final String CUSTOMER_CASH_OUT = "CUSTOMER_CASH_OUT";

        /**
         * 清分自动退回
         */
        public static final String SUPERVISE_OUT_BACKUP = "SUPERVISE_OUT_BACKUP";

        /**
         * 垫付保费从资产方到汇总户
         */
        public static final String ADVANCE_CASH_OUT = "ADVANCE_CASH_OUT";

        /**
         * 退汇入金
         */
        public static final String CNAPS2_IN = "CNAPS2_IN";

        /**
         * 主动还款
         */
//        public static final String REPAY_CLEAR_IN = "REPAY_CLEAR_IN";

//             * ALI_VIR_TRANS          蚂蚁金服-虚账户请款交易
//     * ALI_VIR_TRANS_CANCEL   蚂蚁金服-虚账户请款交易取消
//     * ALI_CASH_REBACK        蚂蚁金服-虚账户退款交易
//     * ORDER                  订单类型
//     * CONT                   合同类型
//     * PLAT                   平台类型 "
        /**
         * 蚂蚁金服-虚账户请款交易
         */
        public static final String ALL_VIR_TRANS = "ALL_VIR_TRANS";

        /**
         * 蚂蚁金服-虚账户请款交易取消
         */
        public static final String ALL_VIR_TRANS_CANCEL = "ALI_VIR_TRANS_CANCEL";

        /**
         * 蚂蚁金服-虚账户退款交易
         */
        public static final String ALL_CASH_REBACK = "ALL_CASH_REBACK";

        /**
         * 订单类型
         */
        public static final String ORDER = "ORDER";

        /**
         * 合同类型
         */
        public static final String CONT = "CONT";

        /**
         * 平台类型
         */
        public static final String PLAT = "PLAT";

    }

    /**
     * 交易类型
     * TYPE_MAP.put("200", "由冻结账户支付到可用账户") ;
     * TYPE_MAP.put("201", "由可用账户支付到可用账户") ;
     * TYPE_MAP.put("202", "由冻结账户支付到冻结账户") ;
     * TYPE_MAP.put("203", "由可用账户支付到冻结账户") ;
     */
    public static class TRAD_TYPE {

        /**
         * 由冻结账户支付到可用账户
         */
        public static final String TYPE_200 = "200";

        /**
         * 由可用账户支付到可用账户
         */
        public static final String TYPE_201 = "201";

        /**
         * 由冻结账户支付到冻结账户
         */
        public static final String TYPE_202 = "202";

        /**
         * 由可用账户支付到冻结账户
         */
        public static final String TYPE_203 = "203";
    }

    /**
     * 是否为热处理模式
     */
    public static class IS_HOT_DEALMODEL {
        /**
         * 是
         */
        public static final String YES = "Y";

        /**
         * 否
         */
        public static final String NO = "N";
    }

    /**
     * 系统交易类型
     * CPCN：中金支付类型
     * CPCN01：中金支付网关支付
     * EMAO：直销银行类型
     * EMAO01：对私E账户赎回入金
     * EMAO02：对私E账户代扣入金（从卡）
     * EMAO03：对私E账户代扣入金（从E账户）
     * EMAO04：对私E账户出金至E账户（）
     * EMAO05：对私E账户出金至绑定卡（）
     * EMAO06：对私E账户E账户直接出金至绑定卡（）
     * EMAO07：对私E账户互联网出金（购买理财）
     * EMAO08：对公E账户代发
     * EMAO09：对公E账户代扣
     * EMAO10：对公E账户代理申购+代发
     * EMAO11：对公E账户代理赎回+代扣
     * <p>
     * BANK：本行渠道类型
     * BANK01：本行入金
     * BANK02：本行出金
     * BANK03：备付金转入
     * BANK04：备付金转出
     * BANK05：收益划转
     * BANK06：本行转账
     * BANK07：虚户飞入
     * BANK08：市场发起飞入资金
     * <p>
     * SHTC：上海同城类型
     * SHTC01：上海同城出金
     * SHTC01：上海同城转账
     * HVPS：大额支付渠道类型
     * HVPS01：大额支付出金
     * HVPS02：大额支付转账
     * HVPS03：大额支付退汇交易
     * IBPS：超级网银渠道类型
     * IBPS01：超级网银出金
     * IBPS02：超级网银飞入退回
     * BAOFOO：宝付支付渠道类型
     * BAOFOO01：宝付对私代扣入金
     * BAOFOO02：宝付对公代扣入金
     * BAOFOO03：宝付对私认证支付入金
     * IPAYNOW：现在支付渠道类型
     * IPAYNOW01：支付宝扫码入金
     * FLYIN：飞入资金
     * FLYIN01：市场发起的飞入资金
     * FLYIN02：市场发起的总账飞入
     * LOAN：供应链融资
     * LOAN01：融资放款
     * ADJUST：调账类型
     * ADJUST01：调账入金
     * ADJUST02：调账出金
     */

    public static class SYS_TRADE_TYPE {


        /**
         * 中金支付网关支付
         */
        public static final String CPCN01 = "CPCN01";

        /**
         * 对私E账户赎回入金
         */
        public static final String EMAO01 = "EMAO01";

        /**
         * 对私E账户代扣入金（从卡）
         */
        public static final String EMAO02 = "EMAO02";

        /**
         * 对私E账户代扣入金（从E账户）
         */
        public static final String EMAO03 = "EMAO03";

        /**
         * 对私E账户出金至E账户（）
         */
        public static final String EMAO04 = "EMAO04";

        /**
         * 对私E账户出金至绑定卡（）
         */
        public static final String EMAO05 = "EMAO05";

        /**
         * 对私E账户E账户直接出金至绑定卡（）
         */
        public static final String EMAO06 = "EMAO06";
        //todo
    }

    /**
     * 实际付款账户类型
     * "1.对公、2.卡、3.折、4.现金、5.其他
     * A:对公；I：内部账户；C：卡；"
     */
    public static class REAL_PAYER_TYPE {

        /**
         * 对公
         */
        public static final String COMPANY = "1";

        /**
         * 卡 - 对私（个人）
         */
        public static final String PERSON = "2";

        /**
         * 折
         */
        public static final String PASSBOOK = "3";

        /**
         * 现金
         */
        public static final String CASH = "4";

        /**
         * 其他
         */
        public static final String OTHER = "5";
    }

    /**
     * 是否进行来账登记
     */
    public static class IS_VOSTRO_ACCOUNT_FLAG {
        /**
         * 需要进行来账登记 - 标记 若该标记为Y 则CustomizationInfo =2
         */
        public static final String NEED_FLAG = "Y";

        /**
         * 不需要进行来账登记 - 标记 若该标记为N 则CustomizationInfo =0
         */
        public static final String NOT_NEED_FLAG = "N";
        /**
         * 需要进行来账登记 - CustomizationInfo = 2
         */
        public static final String NEED_FLAG_VAL = "2";
        /**
         * 不需要进行来账登记 - CustomizationInfo = 0
         */
        public static final String NOT_NEED_FLAG_VAL = "0";
    }

    /**
     * 资金账户类型
     * "Margin：保证金户
     * CashAvailable：现金可用户
     * CashFreeze：现金冻结户"
     */
    public static class FUND_ACCOUNT_TYPE {

        /**
         * 保证金户
         */
        public static final String MARGIN = "Margin";

        /**
         * 现金可用户
         */
        public static final String CASH_AVAILABLE = "CashAvailable";

        /**
         * 现金冻结户
         */
        public static final String CASH_FREEZE = "CashFreeze";
    }

    /**
     * 系统消息类型
     * "Normal：正常交易或者一般交易
     * Reverse：冲正交易
     * Reback：退回交易"
     */
    public static class SYS_OPTION {

        /**
         * 正常交易或者一般交易
         */
        public static final String NORMAL = "Normal";

        /**
         * 冲正交易
         */
        public static final String REVERSE = "Reverse";

        /**
         * 退回交易
         */
        public static final String REBACK = "Reback";

    }

    /**
     * 变动交易支出方类型
     * "C为对私客户
     * B为对公客户
     * P为平台客户"
     */

    public static class EXPENSE_ROLE_TYPE {

        /**
         * 对私客户
         */
        public static final String PERSON = "C";

        /**
         * 对公客户
         */
        public static final String COMPANY = "B";

        /**
         * 平台客户
         */
        public static final String PLATFORM = "P";

    }

    /**
     * 资金科目编号
     * 1001 入
     * 1002 出
     */
    public static class SUB_ID {

        /**
         * 入 - inorout = 1
         */
        public static final String IN = "1001";

        /**
         * 出 inorout = -1
         */
        public static final String OUT = "1002";
    }

    /**
     * 借贷
     * 1 入
     * -1 出
     */
    public static class IN_OR_OUT {

        /**
         * 入
         */
        public static final String IN = "1";

        /**
         * 出
         */
        public static final String OUT = "-1";
    }


    /**
     * 通知状态 - info_data表
     * 00为未通知，01为已通知，02为通知失败，03为无须通知
     */
    public static class MES_CON_STATUS {

        /**
         * 未通知
         */
        public static final String NOT_NOTIFY = "00";

        /**
         * 已通知
         */
        public static final String NOTIFIED = "01";

        /**
         * 通知失败
         */
        public static final String NOTIFY_FAIL = "02";

        /**
         * 无须通知
         */
        public static final String NO_NEED_NOTIFY = "03";
    }

    /**
     * 收付款客户类型
     * C：客户P_Agency：平台代理 P_Self_run：平台自营
     */
    public static class CUST_TYPE {

        /**
         * 客户
         */
        public static final String CUST = "C";

        /**
         * 平台代理
         */
        public static final String P_AGENCY = "P_Agency";

        /**
         * 平台自营
         */
        public static final String P_SELF_RUN = "P_Self_run";
    }

    /**
     * 市场网络连接方式
     * 公网：Internet
     * 专线:PrivateLine
     */
    public static class MARKET_NET_WAY {

        /**
         * 公网
         */
        public static final String INTERNET = "Internet";

        /**
         * 专线
         */
        public static final String PRIVATE_LINE = "PrivateLine";
    }


}

