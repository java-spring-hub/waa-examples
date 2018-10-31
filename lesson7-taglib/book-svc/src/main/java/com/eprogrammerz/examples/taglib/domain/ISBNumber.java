package com.eprogrammerz.examples.taglib.domain;

public class ISBNumber {

    private int start;  //first 3
    private int middle;  //middle 3
    private int end;  // last 3


    public ISBNumber(int start, int middle, int end) {
        this.start = start;
        this.middle = middle;
        this.end = end;
    }

    public ISBNumber() {

    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getMiddle() {
        return middle;
    }

    public void setMiddle(int middle) {
        this.middle = middle;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String toString() {
        return "Boo Boo";
    }


}
