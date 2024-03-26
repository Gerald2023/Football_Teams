package edu.fvtc.teams;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TeamsListActivity extends AppCompatActivity {

    public static final String TAG = "TeamsListActivity";
    public static final String  FILENAME="teams.txt";
    ArrayList<Team> teams;
    RecyclerView teamList;
    TeamsAdapter teamsAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_teams_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Navbar.initListButton(this);
        Navbar.initSettingsButton(this);
        Navbar.initMapButton(this);

        this.setTitle("List");

        if(teams.size() ==0)
            createTeams();
    }

    private void createTeams() {
        teams = new ArrayList<Team>();

        teams.add(new Team(1, "Packers", "Green Bay", "9205551234", 1, true,R.drawable.packers ));
        teams.add(new Team(2, "Detroit", "Green Bay", "9204441234", 2, false,R.drawable.lions ));
        teams.add(new Team(3, "Minneapolis", "Green Bay", "920331234", 4, true,R.drawable.vikings ));
        teams.add(new Team(4, "Chicago", "Green Bay", "9205551234", 4, false,R.drawable.bears ));

        RebindTeams();
    }

    private void RebindTeams() {
        //Rebind the Recycler view
        teamList = findViewById((R.id.rvTeams));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        teamList.setLayoutManager(layoutManager);
        teamsAdapter = new TeamsAdapter(teams, this);
        teamList.setAdapter(teamsAdapter);
    }


}