package sgrapp.co.ke.sgr;

/**
 * Created by felix.ojiem on 8/29/2017.
 */

public class SgrItem {
    private int option;
    private String optionString;

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public String getOptionString() {
        return optionString;
    }

    public void setOptionString(String optionString) {
        this.optionString = optionString;
    }

    @Override
    public String toString(){
        return option+" . "+optionString;
    }
}
