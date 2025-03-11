package model;

public record ContactData(String id, String firstname, String lastname,String address, String home, String email, String photo) {
    public ContactData() {
        this("", "", "", "", "", "", "");
    }

    public ContactData withIdCntct(String id) {
        return new ContactData (id, this.firstname, this.lastname, this.address, this.home, email, this.photo);
    }


    public ContactData withFirstname(String firstname) {
        return new ContactData(this.id, firstname, this.lastname, this.address, this.home, this.email, this.photo);
    }

    //public ContactData withMiddlename(String middlename) {
       // return new ContactData(this.id, this.firstname, middlename, this.lastname, this.address, this.home, this.email);
   // }

    public ContactData withLastname(String lastname) {
        return new ContactData(this.id, this.firstname, lastname, this.address, this.home, this.email, this.photo);
    }

   // public ContactData withNickname(String nickname) {
    //    return new ContactData(this.id, this.firstname, this.middlename, this.lastname, nickname, this.address, this.home, this.email);
   // }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstname, this.lastname, address, this.home, this.email, this.photo);
    }

    public ContactData withHome(String home) {
        return new ContactData(this.id, this.firstname, this.lastname, this.address, home, this.email, this.photo);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.firstname, this.lastname, this.address, this.home, email, this.photo);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstname, this.lastname, this.address, this.home, this.email, photo);
    }

}

