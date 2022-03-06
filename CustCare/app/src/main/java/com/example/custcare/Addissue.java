package com.example.custcare;

public class Addissue {
    String ACCNO, CNAME, CADDRESS, OANO, tPNO, mID, HOUSENo, TNO, DATE, AREA;

    public Addissue() {
    }

    public Addissue(String ACCNO, String CNAME, String CADDRESS, String OANO, String tPNO, String mID, String HOUSENo, String TNO, String DATE, String AREA) {
        this.ACCNO = ACCNO;
        this.CNAME = CNAME;
        this.CADDRESS = CADDRESS;
        this.OANO = OANO;
        this.tPNO = tPNO;
        this.mID = mID;
        this.HOUSENo = HOUSENo;
        this.TNO = TNO;
        this.DATE = DATE;
        this.AREA = AREA;
    }

    public String getACCNO() {
        return ACCNO;
    }

    public void setACCNO(String ACCNO) {
        this.ACCNO = ACCNO;
    }

    public String getCNAME() {
        return CNAME;
    }

    public void setCNAME(String CNAME) {
        this.CNAME = CNAME;
    }

    public String getCADDRESS() {
        return CADDRESS;
    }

    public void setCADDRESS(String CADDRESS) {
        this.CADDRESS = CADDRESS;
    }

    public String getOANO() {
        return OANO;
    }

    public void setOANO(String OANO) {
        this.OANO = OANO;
    }

    public String gettPNO() {
        return tPNO;
    }

    public void settPNO(String tPNO) {
        this.tPNO = tPNO;
    }

    public String getmID() {
        return mID;
    }

    public void setmID(String mID) {
        this.mID = mID;
    }

    public String getHOUSENo() {
        return HOUSENo;
    }

    public void setHOUSENo(String HOUSENo) {
        this.HOUSENo = HOUSENo;
    }

    public String getTNO() {
        return TNO;
    }

    public void setTNO(String TNO) {
        this.TNO = TNO;
    }

    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    public String getAREA() {
        return AREA;
    }

    public void setAREA(String AREA) {
        this.AREA = AREA;
    }
}
