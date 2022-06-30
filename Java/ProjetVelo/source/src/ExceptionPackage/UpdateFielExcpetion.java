package ExceptionPackage;

public class UpdateFielExcpetion extends Exception {
    private String table;
    public UpdateFielExcpetion(String table){
        this.table = table;
    }
    public String getMessage(){
        return "Error : can't update "+ table;
    }
}
