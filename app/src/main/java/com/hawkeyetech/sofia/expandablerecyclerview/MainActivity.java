package com.hawkeyetech.sofia.expandablerecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewClickListener {

    private MovieCategoryAdapter mAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Movies movie_one = new Movies("The Shawshank Redemption");
        Movies movie_two = new Movies("The Godfather");
        Movies movie_three = new Movies("The Dark Knight");
        Movies movie_four = new Movies("Schindler's List ");
        Movies movie_five = new Movies("12 Angry Men ");
        Movies movie_six = new Movies("Pulp Fiction");
        Movies movie_seven = new Movies("The Lord of the Rings: The Return of the King");
        Movies movie_eight = new Movies("The Good, the Bad and the Ugly");
        Movies movie_nine = new Movies("Fight Club");
        Movies movie_ten = new Movies("Star Wars: Episode V - The Empire Strikes");
        Movies movie_eleven = new Movies("Forrest Gump");
        Movies movie_tweleve = new Movies("Inception");

        MovieCategory molvie_category_one = new MovieCategory("Drama", Arrays.asList(movie_one, movie_two, movie_three, movie_four));
        MovieCategory molvie_category_two = new MovieCategory("Action", Arrays.asList(movie_five, movie_six, movie_seven, movie_eight));
        MovieCategory molvie_category_three = new MovieCategory("History", Arrays.asList(movie_nine, movie_ten, movie_eleven, movie_tweleve));
        MovieCategory molvie_category_four = new MovieCategory("Thriller", Arrays.asList(movie_one, movie_five, movie_nine, movie_tweleve));

        final List<MovieCategory> movieCategories_one = Arrays.asList(molvie_category_one, molvie_category_two);
        final List<MovieCategory> movieCategories_two = Arrays.asList(molvie_category_three, molvie_category_four);


        MainHeading headings1 = new MainHeading("Movies", movieCategories_one);
        MainHeading headings2 = new MainHeading("Dramas", movieCategories_two);


        final List<MainHeading> mainHeadings = Arrays.asList(headings1, headings2);

        List<Object> finalList = new ArrayList<>();
        MovieCategory movieCategory;
        for (int i = 0; i < mainHeadings.size(); i++) {
            finalList.add(mainHeadings.get(i));

            for (int j = 0; j < mainHeadings.get(i).getChildItemList().size(); j++) {
                movieCategory = (MovieCategory) mainHeadings.get(i).getChildItemList().get(j);
                finalList.add(movieCategory);

                for (int k = 0; k < movieCategory.getChildItemList().size(); k++) {
                    finalList.add(movieCategory.getChildItemList().get(k));
                }
            }
        }

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mAdapter = new MovieCategoryAdapter(this, mainHeadings, this);
        mAdapter.setExpandCollapseListener(new ExpandableRecyclerAdapter.ExpandCollapseListener() {
            @Override
            public void onListItemExpanded(int position) {
                /*MovieCategory expandedMovieCategory = mainHeadings.get(position);

                String toastMsg = getResources().getString(R.string.expanded, expandedMovieCategory.getName());*/
                Toast.makeText(MainActivity.this,
                        "Expanded",
                        Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onListItemCollapsed(int position) {
                /*MovieCategory collapsedMovieCategory = movieCategories.get(position);

                String toastMsg = getResources().getString(R.string.collapsed, collapsedMovieCategory.getName());*/
                Toast.makeText(MainActivity.this,
                        "Closed",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mAdapter.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mAdapter.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onViewClick(View view, int position, int viewType, Object object) {
        if (object instanceof Movies) {
            Toast.makeText(MainActivity.this,
                    "Clicked " + position,
                    Toast.LENGTH_SHORT)
                    .show();
        }
        Log.i("Position", position + "");
    }
}
