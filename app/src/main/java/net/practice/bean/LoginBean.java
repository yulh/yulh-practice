package net.practice.bean;

public class LoginBean {

    String name="";
    String memberId="";
    String rank="";
    String gpsCount="";
    String posId="";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getGpsCount() {
        return gpsCount;
    }

    public void setGpsCount(String gpsCount) {
        this.gpsCount = gpsCount;
    }

    public String getPosId() {
        return posId;
    }

    public void setPosId(String posId) {
        this.posId = posId;
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "name='" + name + '\'' +
                ", memberId='" + memberId + '\'' +
                ", rank='" + rank + '\'' +
                ", gpsCount='" + gpsCount + '\'' +
                ", posId='" + posId + '\'' +
                '}';
    }
}
