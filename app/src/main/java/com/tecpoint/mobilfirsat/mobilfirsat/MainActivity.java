package com.tecpoint.mobilfirsat.mobilfirsat;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.tecpoint.mobilfirsat.mobilfirsat.Adapter.MenuListAdapter;
import com.tecpoint.mobilfirsat.mobilfirsat.Model.Category;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<com.tecpoint.mobilfirsat.mobilfirsat.Model.MenuItem> menuItems = new ArrayList<com.tecpoint.mobilfirsat.mobilfirsat.Model.MenuItem>();
    DrawerLayout Drawer;
    ActionBarDrawerToggle mDrawerToggle;
    ListView lsvMenu;
    MenuListAdapter menuListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);


        lsvMenu = (ListView) findViewById(R.id.lsvMenu);
        //ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,android.R.id.text1,TITLES);
      //  lsvMenu.setAdapter(adapter);


        menuItems.add(new com.tecpoint.mobilfirsat.mobilfirsat.Model.MenuItem("gencaksoy", "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTvc_fXxNEc8OSLgwiLOrQq-KgOe1LOzXHLFEpk-4Kxp1OcHJ-dKJVrk7A"));
        getMenuItems();
        menuListAdapter = new MenuListAdapter(getApplicationContext(), 0, menuItems);
        lsvMenu.setAdapter(menuListAdapter);
        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);
        mDrawerToggle = new ActionBarDrawerToggle(this, Drawer, toolbar, R.string.drawerOpen, R.string.drawerClose) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }


        };
        Drawer.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        lsvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedItem(position);
                selectedItem(position);
            }
        });


    }

    private void selectedItem(int position) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void getMenuItems() {
        ParseQuery<Category> query = new ParseQuery<Category>(Category.class);
        query.findInBackground(new FindCallback<Category>() {
            @Override
            public void done(List<Category> objects, ParseException e) {
                if (e == null) {
                    for (Category category : objects) {
                        menuItems.add(new com.tecpoint.mobilfirsat.mobilfirsat.Model.MenuItem(category.getString("Name"), category.getParseFile("Icon").getUrl()));
                    }
                    menuListAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
