package com.alelk.pws.database.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.Locale;

/**
 * Psalm
 *
 * Created by Alex Elkin on 03.10.2017.
 */
@Entity(tableName = "psalms")
public class Psalm {

    @PrimaryKey
    private int id;

    private String name;
    private String version;
    private String author;
    private String translator;
    private String composer;
    private String year;
    private String bibleRef;
    private String tonalities;
    private String text;
    @Ignore
    private Locale locale;

    public Psalm() {
    }

    @Ignore
    public Psalm(int id, String name, String version, String author, String translator, String composer, String year, String bibleRef, String tonalities, String text, Locale locale) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.author = author;
        this.translator = translator;
        this.composer = composer;
        this.year = year;
        this.bibleRef = bibleRef;
        this.tonalities = tonalities;
        this.text = text;
        this.locale = locale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBibleRef() {
        return bibleRef;
    }

    public void setBibleRef(String bibleRef) {
        this.bibleRef = bibleRef;
    }

    public String getTonalities() {
        return tonalities;
    }

    public void setTonalities(String tonalities) {
        this.tonalities = tonalities;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override
    public String toString() {
        return "Psalm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", author='" + author + '\'' +
                ", translator='" + translator + '\'' +
                ", composer='" + composer + '\'' +
                ", year='" + year + '\'' +
                ", bibleRef='" + bibleRef + '\'' +
                ", tonalities='" + tonalities + '\'' +
                ", text='" + text + '\'' +
                ", locale=" + locale +
                '}';
    }
}
