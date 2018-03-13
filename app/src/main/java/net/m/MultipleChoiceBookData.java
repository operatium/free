package net.m;

/**
 * Created by java on 2018/3/8.
 */

public class MultipleChoiceBookData {
    private String bookcode;
    private String bookname;
    private String bookurl;
    private String booktype;

    public String getBookcode() {
        return bookcode;
    }

    public MultipleChoiceBookData setBookcode(String bookcode) {
        this.bookcode = bookcode;
        return this;
    }

    public String getBookname() {
        return bookname;
    }

    public MultipleChoiceBookData setBookname(String bookname) {
        this.bookname = bookname;
        return this;
    }

    public String getBookurl() {
        return bookurl;
    }

    public MultipleChoiceBookData setBookurl(String bookurl) {
        this.bookurl = bookurl;
        return this;
    }

    public String getBooktype() {
        return booktype;
    }

    public MultipleChoiceBookData setBooktype(String booktype) {
        this.booktype = booktype;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MultipleChoiceBookData) {
            return this.getBookcode().equals(((MultipleChoiceBookData) obj).getBookcode());
        }
        return false;
    }
}
