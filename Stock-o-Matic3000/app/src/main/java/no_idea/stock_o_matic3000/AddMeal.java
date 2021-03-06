package no_idea.stock_o_matic3000;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class AddMeal extends BaseActivity {

ListView listView;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_meal);

        listView = (ListView)findViewById(R.id.list);

        String[] values = new String[] {
                "Add Ingredient"
        };



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        listView.setAdapter(adapter);





    }

    protected void onResume(){
        super.onResume();
        setContentView(R.layout.add_meal);

        listView = (ListView)findViewById(R.id.list);

        String[] values = control.getHolderRecipe().ingredientsToArray();



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent newActivity;
                int itemPosition     = position;
                if (itemPosition == 0) {
                    newActivity = new Intent(AddMeal.this, AddIngredient.class);
                }
                else {
                    control.setHolder(control.getHolderRecipe().getItem(position - 1));
                    newActivity = new Intent(AddMeal.this, EditIngredient.class);
                }
                startActivity(newActivity);
                //finish();
            }

        });




    }

    public void submit (View button){
        final EditText nameField = (EditText) findViewById(R.id.name);
        String name = nameField.getText().toString();
        control.getHolderRecipe().setName(name);
        control.addRecipe(control.getHolderRecipe());

        /*
        //The Following code is for the database
        String recipeName = control.getHolderRecipe().getName();
        Tag recipeTag = new Tag(recipeName);

        long recipeId = db.createTag(recipeTag);
        control.getHolderRecipe().setRecipeId(recipeId);
        */


        CharSequence text = name + " meal was Added";
        Context context = getApplicationContext();

        int duration = Toast.LENGTH_SHORT;


        Toast toast = Toast.makeText(context, text, duration);
        toast.show();





        finish();

    }

    protected void onStart(){
        super.onStart();


    }

    protected void onStop(){
        super.onStop();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }
}








