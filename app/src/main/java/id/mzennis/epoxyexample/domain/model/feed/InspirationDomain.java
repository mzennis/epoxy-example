package id.mzennis.epoxyexample.domain.model.feed;


import java.util.List;

import javax.annotation.Nullable;

import id.mzennis.epoxyexample.domain.model.InspirationItemDomain;

/**
 * @author by nisie on 10/26/17.
 */

public class InspirationDomain {

    @Nullable
    private final String experiment_version;


    @Nullable
    private final String source;

    @Nullable
    private final String title;

    @Nullable
    private final String foreign_title;

    @Nullable
    private final String widget_url;

    @Nullable
    private final List<InspirationItemDomain> recommendation;

    public InspirationDomain(String experiment_version, String source, String title,
                             String foreign_title, String widget_url,
                             List<InspirationItemDomain> recommendation) {
        this.experiment_version = experiment_version;
        this.source = source;
        this.title = title;
        this.foreign_title = foreign_title;
        this.widget_url = widget_url;
        this.recommendation = recommendation;
    }

    @Nullable
    public String getExperimentVersion() {
        return experiment_version;
    }

    @Nullable
    public String getSource() {
        return source;
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    @Nullable
    public String getForeignTitle() {
        return foreign_title;
    }

    @Nullable
    public String getWidgetUrl() {
        return widget_url;
    }

    @Nullable
    public List<InspirationItemDomain> getListInspirationItem() {
        return recommendation;
    }
}
