package Bundle.data;

import java.util.ArrayList;


public class FileList {
    private FileList(){}

    private ArrayList<String> importedFileList = new ArrayList<>();
    public ArrayList<String> getImportedFileList() {
        return importedFileList;
    }

    public void setImportedFileList(ArrayList<String> importedFileList) {
        this.importedFileList = importedFileList;
    }

}
