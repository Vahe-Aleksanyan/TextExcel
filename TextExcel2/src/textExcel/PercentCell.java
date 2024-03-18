package textExcel;

public class PercentCell extends RealCell {
    

    int prec;
    public PercentCell(String str) {

        //  "6.78" ---> 6.78 ---> 0.0678 ---> "0.0678" 

        // convert string into double, divide by 100, then again convert into string
        super(Double.parseDouble(str) / 100 + "" );
        // super((Double.parseDouble(str) / 100 + "").substring(0, str.length() + 2) );
        this.prec = str.length();
        
    }

    public String abbreviatedCellText() {
        

        // get the decimal value, multiply by 100, then truvate by storing the value in int; 0.08447 --> 8
        double result = super.getDoubleValue() * 100;
        int intResult = (int)  result;
        String strresult = intResult + "%";
        while (strresult.length() < 10) {
            strresult += " ";
        }
        return strresult;
    }

    public String fullCellText() {
        // double result = super.getDoubleValue();
        // return result + "";

        String result = super.fullCellText();
        if(result.length() >= prec + 2 ) {
            return result.substring(0, prec);
        }
        return result;
    }

    public double getDoubleValue() { return super.getDoubleValue(); }
}
