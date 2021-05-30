package com.example.application.views.news;

import com.mongodb.*;
import com.mongodb.client.*;

import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import org.bson.Document;



import java.util.ArrayList;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.example.application.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;



@Route(value = "news", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("News")
public class NewsView extends HorizontalLayout {

    private TextField name;
    private Button sayHello;

    public NewsView() {
        addClassName("news-view");



        HorizontalLayout layout = new HorizontalLayout();
        layout.setPadding(true);

        Component bbcColumn = bbcColumn();
        Component ctvColumn = ctvColumn();
        Component nbcColumn = nbcColumn();

        layout.add(bbcColumn, ctvColumn, nbcColumn);
        add(layout);

    }
    public VerticalLayout bbcColumn(){

        String username="";
        String password="";
        MongoClient mongoClient = MongoClients.create("mongodb+srv://"+username+":"+password+"@cluster0.7aovf.mongodb.net/GamblerBot?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase("News");
        MongoCollection collection = database.getCollection("bbc");
        FindIterable<Document> iterable = collection.find().sort(new BasicDBObject("time",-1));
        Document document = iterable.first();
        ArrayList bbcNews = (ArrayList) document.get("news");
        System.out.println(bbcNews);

        VerticalLayout layout = new VerticalLayout();
        layout.setPadding(true);

        Button sourceTitle = new Button();
        sourceTitle.setText("BBC News");
        sourceTitle.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layout.add(sourceTitle);

        for (int i=0;i<bbcNews.size();i++){
            Document document1 = (Document) bbcNews.get(i);
            String title= (String) document1.get("title");
            String link = (String) document1.get("link");
            Button newsButton = new Button(title);
            Anchor url = new Anchor(link);
            url.setTarget("_blank");
            url.add(newsButton);
            layout.add(url);
        }
        layout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        return  layout;
    }
    public VerticalLayout ctvColumn(){

        String username="";
        String password="";
        MongoClient mongoClient = MongoClients.create("mongodb+srv://"+username+":"+password+"@cluster0.7aovf.mongodb.net/GamblerBot?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase("News");
        MongoCollection collection = database.getCollection("ctv");
        FindIterable<Document> iterable = collection.find().sort(new BasicDBObject("time",-1));
        Document document = iterable.first();
        ArrayList ctvNews = (ArrayList) document.get("news");
        System.out.println(ctvNews);

        VerticalLayout layout = new VerticalLayout();
        layout.setPadding(true);

        Button sourceTitle = new Button();
        sourceTitle.setText("CTV News");
        sourceTitle.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layout.add(sourceTitle);

        for (int i=0;i<ctvNews.size();i++){
            Document document1 = (Document) ctvNews.get(i);
            String title= (String) document1.get("title");
            String link = (String) document1.get("link");
            Button newsButton = new Button(title);
            Anchor url = new Anchor(link);
            url.setTarget("_blank");
            url.add(newsButton);
            layout.add(url);
        }
        layout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        return  layout;
    }
    public VerticalLayout nbcColumn(){

        String username="";
        String password="";
        MongoClient mongoClient = MongoClients.create("mongodb+srv://"+username+":"+password+"@cluster0.7aovf.mongodb.net/GamblerBot?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase("News");
        MongoCollection collection = database.getCollection("nbc");
        FindIterable<Document> iterable = collection.find().sort(new BasicDBObject("time",-1));
        Document document = iterable.first();
        ArrayList nbcNews = (ArrayList) document.get("news");
        System.out.println(nbcNews);

        VerticalLayout layout = new VerticalLayout();
        layout.setPadding(true);

        Button sourceTitle = new Button();
        sourceTitle.setText("NBC News");
        sourceTitle.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layout.add(sourceTitle);

        for (int i=0;i<nbcNews.size();i++){
            Document document1 = (Document) nbcNews.get(i);
            String title= (String) document1.get("title");
            String link = (String) document1.get("link");
            Button newsButton = new Button(title);
            Anchor url = new Anchor(link);
            url.setTarget("_blank");
            url.add(newsButton);
            layout.add(url);
        }
        layout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        return  layout;
    }

}
