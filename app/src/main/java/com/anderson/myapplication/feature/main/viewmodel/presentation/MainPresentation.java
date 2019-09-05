package com.anderson.myapplication.feature.main.viewmodel.presentation;

public class MainPresentation {

    public String name;
    public String company;

    private MainPresentation(){}

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public static class Builder {
        private MainPresentation instance;

        public Builder() {instance = new MainPresentation();}

        public Builder setName(String name){
            this.instance.name = name;
            return this;
        }

        public Builder setCompany(String company){
            this.instance.company = company;
            return this;
        }

        public MainPresentation build() {
            return instance;
        }
    }
}
