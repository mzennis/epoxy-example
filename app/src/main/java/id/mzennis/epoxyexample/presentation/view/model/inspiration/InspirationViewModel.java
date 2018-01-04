package id.mzennis.epoxyexample.presentation.view.model.inspiration;

import java.util.ArrayList;

/**
 * Created by stevenfredian on 5/18/17.
 */

public class InspirationViewModel {

    private String title;
    protected ArrayList<InspirationProductViewModel> listProduct;
    private int rowNumber;


    public InspirationViewModel(String title, ArrayList<InspirationProductViewModel> listProduct) {
        this.title = title;
        this.listProduct = listProduct;
    }

    public ArrayList<InspirationProductViewModel> getListProduct() {
        return listProduct;
    }

    public void setListProduct(ArrayList<InspirationProductViewModel> listProduct) {
        this.listProduct = listProduct;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }
}
