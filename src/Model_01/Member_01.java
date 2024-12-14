
package Model_01;



public class Member_01  {
        
    private int memberId;
    private String name;
    private String contactInfo;
    private MembershipCard_01 membershipCard;
    
    public Member_01(int memberId, String name, String contactInfo, MembershipCard_01 membershipCard) {

        this.memberId = memberId;
        this.name = name;
        this.contactInfo = contactInfo;
        this.membershipCard = membershipCard;
    }

    public int getmemberId() {
        return memberId;
    }

    public String getNmae() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public MembershipCard_01 getmembershipCard() {
        return membershipCard;
    }

    public String getrole() {
        return "Member_01";
    }

    public String displaydetails() {
        return memberId + name + contactInfo + membershipCard;
    }
}
