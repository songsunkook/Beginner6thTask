package service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SearchServiceImpl implements SearchService{
    final int max_value = 10000000;
    ArrayList<Integer> arr;
    public SearchServiceImpl(){
        arr = new ArrayList();
        for(int i=0; i<max_value; i++){
            arr.add(i);
        }
    }

    @Override
    public String linear(int key) {
        for ( int i = 0 ; i < arr.size(); i++){
            if(key==arr.get(i))break;
        }
        return "linear!";
    }

    @Override
    public String binary(int key) {
        int mid;
        int left=0, right=arr.size()-1;

        while(right>=left){
            mid=(right+left)/2;
            if(key==arr.get(mid))break;
            if(key<arr.get(mid))
                right=mid-1;
            else
                left=mid+1;
        }

        return "binary!";
    }

    @Override
    public String temp() {
        String str = null;
        //NullPointerException
        System.out.println(str.indexOf(0));
        return null;
    }
}
