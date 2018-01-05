package id.mzennis.epoxyexample.presentation.view.model.inspiration;

import java.util.ArrayList;

import id.mzennis.epoxyexample.presentation.view.model.FeedModel;

/**
 * Created by stevenfredian on 5/18/17.
 */

public class InspirationModel extends FeedModel {

    private String title;
    protected ArrayList<InspirationProductModel> listProduct;
    private int rowNumber;


    public InspirationModel(String title, ArrayList<InspirationProductModel> listProduct) {
        this.title = title;
        this.listProduct = listProduct;
    }

    public ArrayList<InspirationProductModel> getListProduct() {
        return listProduct;
    }

    public void setListProduct(ArrayList<InspirationProductModel> listProduct) {
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
