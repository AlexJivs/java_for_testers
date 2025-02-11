package model;

public record ContactData(String firstname, String middlename, String lastname, String nickname, String address,
                          String home, String email) {
    public  ContactData() {
        this ("", "", "", "", "", "","" );
    }

    public ContactData withFirstname(String firstname) {
        return new ContactData(firstname, this.middlename, this.lastname, this.nickname, this.address, this.home, this.email);
    }

    public ContactData withMiddlename(String middlename) {
        return new ContactData(this.firstname, middlename, this.lastname, this.nickname, this.address, this.home, this.email);
    }

    public ContactData withLastname(String lastname) {
        return new ContactData(this.firstname, this.middlename, lastname, this.nickname, this.address, this.home, this.email);
    }

    public ContactData withNickname(String nickname) {
        return new ContactData(this.firstname, this.middlename, this.lastname, nickname, this.address, this.home, this.email);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, address, this.home, this.email);
    }

    public ContactData withHome(String home) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.address, home, this.email);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.address, this.home, email);
    }
}