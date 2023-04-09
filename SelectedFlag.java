public class SelectedFlag {
    private boolean selectedFlag;
    private int indexXSelectingButton;
    private int indexYSelectingButton;

    public SelectedFlag(){
        this.selectedFlag = false;
        this.indexYSelectingButton = 0;
        this.indexXSelectingButton = 0;
    }

    public void setSelectedFlag(boolean selectedFlag, int indexXSelectingButton, int indexYSelectingButton){
        this.selectedFlag = selectedFlag;
        this.indexXSelectingButton = indexXSelectingButton;
        this.indexYSelectingButton = indexYSelectingButton;
    }

    public boolean getLogicSelectedValue(){
        return selectedFlag;
    }

    public int getIndexXSelectingButton(){
        return indexXSelectingButton;
    }

    public int getIndexYSelectingButton(){
        return indexYSelectingButton;
    }

}
