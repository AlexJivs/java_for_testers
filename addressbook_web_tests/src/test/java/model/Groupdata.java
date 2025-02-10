package model;

public record Groupdata(String name, String header, String footer) {

    public  Groupdata() {
        this ("","","");
    }

    public Groupdata withName(String name) {
        return new Groupdata(name, this.header, this.footer);
    }

    public Groupdata withHeader(String header) {
        return new Groupdata(this.name, header, this.footer);
    }

    public Groupdata withFooter(String footer) {
        return new Groupdata(this.name, this.header, footer);
    }

}