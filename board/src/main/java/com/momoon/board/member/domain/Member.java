package com.momoon.board.member.domain;

import java.time.LocalDate;

public class Member {

    private Long id;
    private String memberId;
    private String password;
    private String name;
    private String nickname;
    private String email;
    private String phone;
    private LocalDate createDate;

    public Member() {
    }

    public Member(Long id, String memberId, String password, String name, String nickname, String email, String phone, LocalDate createDate) {
        this.id = id;
        this.memberId = memberId;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.phone = phone;
        this.createDate = createDate;
    }

    private Member(builder builder) {
        this.id = builder.id;
        this.memberId = builder.memberId;
        this.password = builder.password;
        this.name = builder.name;
        this.nickname = builder.nickname;
        this.email = builder.email;
        this.phone = builder.phone;
        this.createDate = builder.createDate;
    }

    public Long getId() {
        return id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((phone == null) ? 0 : phone.hashCode());
        result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;

        if(getClass() != obj.getClass()) return false;

        Member other = (Member) obj;

        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;

        if (memberId == null) {
            if (other.memberId != null) return false;
        } else if (!memberId.equals(other.memberId)) return false;

        if (password == null) {
            if (other.password != null) return false;
        } else if (!password.equals(other.password)) return false;

        if (name == null) {
            if (other.name != null) return false;
        } else if (!name.equals(other.name)) return false;

        if (nickname == null) {
            if (other.nickname != null) return false;
        } else if (!nickname.equals(other.nickname)) return false;

        if (email == null) {
            if (other.email != null) return false;
        } else if (!email.equals(other.email)) return false;


        if (phone == null) {
            if (other.phone != null) return false;
        } else if (!phone.equals(other.phone)) return false;


        if (createDate == null) {
            if (other.createDate != null) return false;
        } else if (!createDate.equals(other.createDate)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "id = " + id + " memberId = " + memberId + " password = " + password +
                    " name = " + name + " nickname = " +  nickname + " email = " + email + " phone = " + phone + " createDate = " + createDate;
    }


    public static class builder {
        private Long id;
        private String memberId;
        private String password;
        private String name;
        private String nickname;
        private String email;
        private String phone;
        private LocalDate createDate;

        public builder id(Long id) {
            this.id = id;
            return this;
        }

        public builder memberId(String memberId) {
            this.memberId = memberId;
            return this;
        }

        public builder password(String password) {
            this.password = password;
            return this;
        }

        public builder name(String name) {
            this.name = name;
            return this;
        }

        public builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public builder email(String email) {
            this.email = email;
            return this;
        }

        public builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public builder createDate(LocalDate createDate) {
            this.createDate = createDate;
            return this;
        }

        public Member build() {
            return new Member(this);
        }
    }
}
