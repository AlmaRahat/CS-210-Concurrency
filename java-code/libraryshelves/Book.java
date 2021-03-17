public class Book {
    private String name;
    private boolean isDummy;
    Book(String name){
        this.name = name;
        if (name!="") isDummy = false;
        else isDummy = true;
    }
    Book(){
        this.name = "";
        this.isDummy= true;
    }
    public String getName() {
        return name;
    }
}
