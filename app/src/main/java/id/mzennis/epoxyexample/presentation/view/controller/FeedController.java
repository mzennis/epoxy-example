package id.mzennis.epoxyexample.presentation.view.controller;

import com.airbnb.epoxy.TypedEpoxyController;

import java.util.ArrayList;

import javax.inject.Inject;

import id.mzennis.epoxyexample.presentation.config.ActivityScope;
import id.mzennis.epoxyexample.presentation.view.model.FeedModel;
import id.mzennis.epoxyexample.presentation.view.model.inspiration.InspirationModel;
import id.mzennis.epoxyexample.presentation.view.viewmodel.InspirationGroupViewModel;

/**
 * Created by meyta on 03/01/18.
 */


@ActivityScope
public class FeedController extends TypedEpoxyController<ArrayList<FeedModel>> {

    @Inject
    public FeedController(){
    }

    @Override
    protected void buildModels(ArrayList<FeedModel> data) {

        for (FeedModel row : data) {
            if (row instanceof InspirationModel) {
                add(new InspirationGroupViewModel((InspirationModel) row));
            }
        }
    }
}