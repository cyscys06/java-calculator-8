package calculator.Model;

public class StringModel {
    private String string;
    private String separator = "";
    private String[] splitstring;
    private Integer[] numberarray;
    private Integer total;

    public String getString() { return string; }
    public void setString(String string) { this.string = string; }

    public String getSeparator() { return separator; }
    public void setSeparator(String separator) { this.separator = separator; }

    public String[] getSplitstring() { return splitstring; }
    public void setSplitstring(String[] splitstring) { this.splitstring = splitstring; }

    public Integer[] getNumberarray() { return numberarray; }
    public void setNumberarray(Integer[] numberarray) { this.numberarray = numberarray; }

    public Integer getTotal() { return total; }
    public void setTotal(Integer total) { this.total = total; }
}
