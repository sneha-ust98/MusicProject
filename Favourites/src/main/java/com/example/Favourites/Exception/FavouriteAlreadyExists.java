package com.example.Favourites.Exception;

public class FavouriteAlreadyExists extends Exception
{
private String msg;

    public FavouriteAlreadyExists() {
    }

    public FavouriteAlreadyExists(String msg, String message) {
        super(message);
        this.msg = msg;
    }
}