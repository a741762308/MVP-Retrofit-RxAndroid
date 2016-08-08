package com.jsqix.dq.mvp.retrofit.rxjava.data.bean;

/**
 * Created by dq on 2016/8/5.
 */
public class UserBean extends BaseBean{

    /**
     * code : 000
     * success : true
     * msg : 登录成功
     * obj : {"ID":28,"PHONE":"18662539527","USER_TYPE":1002,"LOGIN_PWD":"aa757a79eb3c78495453043885a68476","PAY_PWD":"ddfc1fadf334d9eeb879a2c5755b32e1","REG_DT":1426248051000,"LOGIN_DT":null,"LOGIN_IP":null,"LOGIN_CT":null,"TOKEN":"ffffffffb2b890957eb247f17eb247f1","STATUS":0,"LEADER":null,"AID":null,"CID":null,"PID":null,"NAME":"董庆（测试）","IDNO":null,"LEADER1":null}
     * url : null
     */

    private String code;
    private boolean success;
    private String msg;
    /**
     * ID : 28
     * PHONE : 18662539527
     * USER_TYPE : 1002
     * LOGIN_PWD : aa757a79eb3c78495453043885a68476
     * PAY_PWD : ddfc1fadf334d9eeb879a2c5755b32e1
     * REG_DT : 1426248051000
     * LOGIN_DT : null
     * LOGIN_IP : null
     * LOGIN_CT : null
     * TOKEN : ffffffffb2b890957eb247f17eb247f1
     * STATUS : 0
     * LEADER : null
     * AID : null
     * CID : null
     * PID : null
     * NAME : 董庆（测试）
     * IDNO : null
     * LEADER1 : null
     */

    private ObjEntity obj;
    private Object url;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ObjEntity getObj() {
        return obj;
    }

    public void setObj(ObjEntity obj) {
        this.obj = obj;
    }

    public Object getUrl() {
        return url;
    }

    public void setUrl(Object url) {
        this.url = url;
    }

    public static class ObjEntity {
        private int ID;
        private String PHONE;
        private int USER_TYPE;
        private String LOGIN_PWD;
        private String PAY_PWD;
        private long REG_DT;
        private Object LOGIN_DT;
        private Object LOGIN_IP;
        private Object LOGIN_CT;
        private String TOKEN;
        private int STATUS;
        private Object LEADER;
        private Object AID;
        private Object CID;
        private Object PID;
        private String NAME;
        private Object IDNO;
        private Object LEADER1;

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getPHONE() {
            return PHONE;
        }

        public void setPHONE(String PHONE) {
            this.PHONE = PHONE;
        }

        public int getUSER_TYPE() {
            return USER_TYPE;
        }

        public void setUSER_TYPE(int USER_TYPE) {
            this.USER_TYPE = USER_TYPE;
        }

        public String getLOGIN_PWD() {
            return LOGIN_PWD;
        }

        public void setLOGIN_PWD(String LOGIN_PWD) {
            this.LOGIN_PWD = LOGIN_PWD;
        }

        public String getPAY_PWD() {
            return PAY_PWD;
        }

        public void setPAY_PWD(String PAY_PWD) {
            this.PAY_PWD = PAY_PWD;
        }

        public long getREG_DT() {
            return REG_DT;
        }

        public void setREG_DT(long REG_DT) {
            this.REG_DT = REG_DT;
        }

        public Object getLOGIN_DT() {
            return LOGIN_DT;
        }

        public void setLOGIN_DT(Object LOGIN_DT) {
            this.LOGIN_DT = LOGIN_DT;
        }

        public Object getLOGIN_IP() {
            return LOGIN_IP;
        }

        public void setLOGIN_IP(Object LOGIN_IP) {
            this.LOGIN_IP = LOGIN_IP;
        }

        public Object getLOGIN_CT() {
            return LOGIN_CT;
        }

        public void setLOGIN_CT(Object LOGIN_CT) {
            this.LOGIN_CT = LOGIN_CT;
        }

        public String getTOKEN() {
            return TOKEN;
        }

        public void setTOKEN(String TOKEN) {
            this.TOKEN = TOKEN;
        }

        public int getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(int STATUS) {
            this.STATUS = STATUS;
        }

        public Object getLEADER() {
            return LEADER;
        }

        public void setLEADER(Object LEADER) {
            this.LEADER = LEADER;
        }

        public Object getAID() {
            return AID;
        }

        public void setAID(Object AID) {
            this.AID = AID;
        }

        public Object getCID() {
            return CID;
        }

        public void setCID(Object CID) {
            this.CID = CID;
        }

        public Object getPID() {
            return PID;
        }

        public void setPID(Object PID) {
            this.PID = PID;
        }

        public String getNAME() {
            return NAME;
        }

        public void setNAME(String NAME) {
            this.NAME = NAME;
        }

        public Object getIDNO() {
            return IDNO;
        }

        public void setIDNO(Object IDNO) {
            this.IDNO = IDNO;
        }

        public Object getLEADER1() {
            return LEADER1;
        }

        public void setLEADER1(Object LEADER1) {
            this.LEADER1 = LEADER1;
        }
    }
}
