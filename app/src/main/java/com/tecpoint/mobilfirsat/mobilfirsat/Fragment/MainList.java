package com.tecpoint.mobilfirsat.mobilfirsat.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.tecpoint.mobilfirsat.mobilfirsat.Model.Category;
import com.tecpoint.mobilfirsat.mobilfirsat.Model.Feed;
import com.tecpoint.mobilfirsat.mobilfirsat.Model.FeedItem;
import com.tecpoint.mobilfirsat.mobilfirsat.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainList extends Fragment {

    private ListView lsvMainList;
    private String CategoryName;
    private String CotegoryObjectId;
    List<FeedItem> feedItemList;

    public MainList(String CategoryName) {
        this.CategoryName = CategoryName;
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_list, container, false);
        lsvMainList = (ListView) getActivity().findViewById(R.id.lsvMainList);
        feedItemList = new ArrayList<FeedItem>();
getList();
        

        return view;
    }

    private void getList() {

        final ParseQuery<Category> query = new ParseQuery<Category>(Category.class);
        query.whereEqualTo(CategoryName, "Name");
        query.getFirstInBackground(new GetCallback<Category>() {
            @Override
            public void done(Category object, ParseException e) {
                CotegoryObjectId = object.getString("objectId");
            }
        });


        ParseQuery<Feed> feedParseQuery = new ParseQuery<Feed>(Feed.class);
        feedParseQuery.whereEqualTo(CotegoryObjectId, "CategoryId");
        feedParseQuery.findInBackground(new FindCallback<Feed>() {
            @Override
            public void done(List<Feed> objects, ParseException e) {
                for (Feed feed : objects) {
                    final FeedItem feedItem = new FeedItem();
                    feedItem.setTitle(feed.getString("Title"));
                    feedItem.setDescription(feed.getString("Description"));
                    feedItem.setSendDate(feed.getDate("createdAt"));
                    feedItem.setLike("184");
                    feedItem.setDislike("15");
                    feedItem.setSikayet("9");

                    ParseQuery<ParseUser> userParseQuery = ParseUser.getQuery();
                    userParseQuery.whereEqualTo("objectId", feed.getString("UserId"));
                    userParseQuery.findInBackground(new FindCallback<ParseUser>() {
                        @Override
                        public void done(List<ParseUser> objects, ParseException e) {
                            for (ParseUser user : objects) {
                                feedItem.setUserName(user.getString("username"));
                                feedItem.setUserProfileImageUrl(user.getString("ProfilImage"));
                            }
                        }
                    });


                }
            }
        });

    }

}
