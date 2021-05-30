package com.example.application.views.about;


import com.vaadin.flow.component.textfield.TextArea;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.example.application.views.main.MainView;

import java.awt.*;

@Route(value = "about", layout = MainView.class)
@PageTitle("About")
public class AboutView extends Div {

    public AboutView() {

        VerticalLayout layout = new VerticalLayout();
        layout.setPadding(true);
        addClassName("about-view");
        TextArea about = new TextArea("ABOUT");
        about.setValue("News App is a Node.js backend and Java frontend developed application, which collects " +
                "(scraping) the top 5 news from BBC, CTV, and NBC news websites and posts them on the instagram" +
                " page, NewsAppNode, and web application, NewsAppWeb.\n\nDevelopment: \nThe Instagram side of the application was" +
                " developed using Node backend, with the help of 'instagram-web-api', and Mongodb" +
                " modules, and api calls.\nThe Web application side of the project was developed using Vaadin (Java web framework)" +
                " as well as Mongodb dependencies to gather the most up to date news from the database.\nScraping the data" +
                " was developed by using Node.js as well as Axios and Cheerio modules.");
        about.setReadOnly(true);
        about.setWidth("50%");
        layout.add(about);
        layout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);


        add(layout);
    }

}
