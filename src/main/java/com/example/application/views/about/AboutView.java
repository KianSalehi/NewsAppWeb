package com.example.application.views.about;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.example.application.views.main.MainView;

import java.awt.*;

@Route(value = "about", layout = MainView.class)
@PageTitle("About")
public class AboutView extends Div {

    public AboutView() {
        addClassName("about-view");
        TextArea about = new TextArea();
        about.setText("News App is a Node.js backend and Java frontend developed application, which collects " +
                "(scraping) the top 5 news from BBC, CTV, and NBC news websites and posts them on the instagram" +
                "page, NewsAppNode, and web application, NewsAppWeb.\n\n The Instagram side of the application was" +
                "developed using Node backend, with the help of 'instagram-web-api', and Mongodb" +
                "modules, and api calls.\n\n The Web application side of the project was developed using Vaadin (Java web framework)" +
                "as well as Mongodb dependencies to gather the most up to date news from the database.\n\n Scraping the data" +
                "was developed by using Node.js as well as Axios and Cheerio modules.");

        add();
    }

}
