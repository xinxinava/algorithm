package com.littlebean.nowcode.linkedlist;

import com.littlebean.util.ListNode;

import java.util.ArrayList;

public class BM5 {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
       return divideMerge(lists, 0,lists.size()-1);
    }
    public ListNode divideMerge(ArrayList<ListNode> lists, int left, int right){
        if(left>right) {
            return null;
        }else if(left==right){
            return lists.get(left);
        }
        int mid=(left+right)/2;
        return mergeTwo(divideMerge(lists,left,mid),divideMerge(lists,mid+1,right));
    }
    public ListNode mergeTwo(ListNode list1, ListNode list2){
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        ListNode dummyNode=new ListNode(-1);
        ListNode p=dummyNode;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                p.next=list1;
                list1=list1.next;
            }else {
                p.next=list2;
                list2=list2.next;
            }
            p=p.next;
            p.next=null;
        }
        if(list1!=null){
            p.next=list1;
        }
        if(list2!=null){
            p.next=list2;
        }
        return dummyNode.next;
    }
}
