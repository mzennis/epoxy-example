package id.mzennis.epoxyexample.presentation.view.controller;

import com.airbnb.epoxy.TypedEpoxyController;

import java.util.ArrayList;

import id.mzennis.epoxyexample.presentation.view.model.FeedModel;
import id.mzennis.epoxyexample.presentation.view.model.inspiration.InspirationModel;

/**
 * Created by meyta on 03/01/18.
 */

public class FeedController extends TypedEpoxyController<ArrayList<FeedModel>> {

    @Override
    protected void buildModels(ArrayList<FeedModel> data) {

        for (FeedModel row : data) {
            if (row instanceof InspirationModel) {
                // ini inspiration
            }
        }
    }
}