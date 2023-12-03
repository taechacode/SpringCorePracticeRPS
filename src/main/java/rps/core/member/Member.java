package rps.core.member;

public class Member {

    private Long id;
    private String name;
    private MemberType memberType;

    public Member(Long id, String name, MemberType memberType) {
        this.id = id;
        this.name = name;
        this.memberType = memberType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

}
