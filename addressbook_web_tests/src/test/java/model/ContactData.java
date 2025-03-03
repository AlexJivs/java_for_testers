package model;

public record ContactData(String id, String firstname, String middlename, String lastname, String nickname, String address,
                          String home, String email) {
    public ContactData() {
        this("", "", "", "", "", "", "", "");
    }

    public ContactData withIdCntct(String id) {
        return new ContactData (id, this.firstname, this.middlename, this.lastname, this.nickname, this.address, this.home, email);
    }


    public ContactData withFirstname(String firstname) {
        return new ContactData(this.id, firstname, this.middlename, this.lastname, this.nickname, this.address, this.home, this.email);
    }

    public ContactData withMiddlename(String middlename) {
        return new ContactData(this.id, this.firstname, middlename, this.lastname, this.nickname, this.address, this.home, this.email);
    }

    public ContactData withLastname(String lastname) {
        return new ContactData(this.id, this.firstname, this.middlename, lastname, this.nickname, this.address, this.home, this.email);
    }

    public ContactData withNickname(String nickname) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, nickname, this.address, this.home, this.email);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, address, this.home, this.email);
    }

    public ContactData withHome(String home) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.address, home, this.email);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.address, this.home, email);
    }
}

