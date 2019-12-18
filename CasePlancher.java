public class CasePlancher extends Case {
    private int redux;

    CasePlancher(int r){
        super();
        redux = r;
    }

    int getRedux(){return redux;}
    public String toString(){
        return "La case retire " + redux + " point(s).";
    }
}
