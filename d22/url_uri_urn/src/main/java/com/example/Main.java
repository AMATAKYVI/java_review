package com.example;

import java.net.URI;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        // url example
        // uri
        URI uri = URI.create("https://en.wikipedia.org/wiki/Main_Page");
        print(uri);
        // urn
    }

    private static void print(URI uri) {
        System.out.println("URI: " + uri);
        System.out.println("Scheme: " + uri.getScheme());
        System.out.println("Host: " + uri.getHost());
        System.out.println("Port: " + uri.getPort());
        System.out.println("Path: " + uri.getPath());
        System.out.println("Query: " + uri.getQuery());
        System.out.println("Fragment: " + uri.getFragment());
    }
}
