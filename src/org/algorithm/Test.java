package org.algorithm;

import org.algorithm.linkedlist.MyLinkedList;
import org.algorithm.monotonicStack.DailyTemperatures;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        dailyTemp();
    }

    public static void myLinkedList() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(2);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(3);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(5);
        myLinkedList.addAtTail(5);
        myLinkedList.get(5);
        myLinkedList.deleteAtIndex(6);
        myLinkedList.deleteAtIndex(4);
    }

    public static void dailyTemp() {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] temps = new int[]{73,74,75,71,69,72,76,73};
        int[] res = dailyTemperatures.dailyTemperatures(temps);
        System.out.println(Arrays.toString(res));
    }
}
