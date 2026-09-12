public class LibraryMemberJavaBean {
    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;

    public LibraryMemberJavaBean() {
        this(null, null);
    }

    public LibraryMemberJavaBean(String name) {
        this(null, name);
    }

    public LibraryMemberJavaBean(String membershipId, String name) {
        this.membershipId = membershipId;
        this.name = name;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String id) {
        if (membershipId == null) {
            membershipId = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premium) {
        premiumMember = premium;
    }

    public void setSecurityAnswer(String answer) {
        securityAnswer = oneWayTransform(answer);
    }

    private String oneWayTransform(String answer) {
        if (answer == null) {
            return null;
        }
        return Integer.toHexString(answer.hashCode());
    }
}
