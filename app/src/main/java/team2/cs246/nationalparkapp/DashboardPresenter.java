package team2.cs246.nationalparkapp;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.lang.ref.WeakReference;
import java.util.List;

import team2.cs246.nationalparkapp.model.Park;
import team2.cs246.nationalparkapp.model.ParkRepository;

/**
 * This class is for presenting data back to the DashBoard activity.
 * This allows for a background thread to not lock the UI on the
 * DashBoard activity class.
 */
public class DashboardPresenter implements Runnable{
    private static final String TAG = "DashboardPresenter";
    private WeakReference<Activity> activityRef;
    private RecyclerView favorites;
    private RecyclerView visited;

    public DashboardPresenter(Activity activity) {
        this.activityRef = new WeakReference<Activity>(activity);
    }

    @Override
    public void run() {
        List<Park> favorites = ParkRepository.loadFavorites(this.activityRef);
        List<Park> visited = ParkRepository.loadVisited(this.activityRef);

        final Activity activity = activityRef.get();

        if (activity != null) {
            // Ensures that it can refresh activity status back to UI
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    TextView loadFavorites = (TextView) activity.findViewById(R.id.loadFavsTv);
                    TextView loadVisited = (TextView) activity.findViewById(R.id.loadVisitedTv);

                    /*loadFavorites.setVisibility(View.VISIBLE);
                    loadVisited.setVisibility(View.VISIBLE);*/

                    if (favorites.size() == 0) {
                        TextView noFavorites = (TextView) activity.findViewById(R.id.noFavsTv);
                        loadFavorites.setVisibility(View.GONE);
                        noFavorites.setVisibility(View.VISIBLE);
                    } else {
                        RecyclerView favoritesRv = activity.findViewById(R.id.RV_FavoriteParks);
                        RecyclerAdapter favoritesRa = new RecyclerAdapter(favorites, activity);

                        loadFavorites.setVisibility(View.GONE);
                        favoritesRv.setVisibility(View.VISIBLE);

                        favoritesRv.setAdapter(favoritesRa);
                        favoritesRa.notifyDataSetChanged();
                    }
                    // Verify if there are any visited Parks first
                    if (visited.size() == 0) {
                        TextView noVisited = (TextView) activity.findViewById(R.id.noVisitTv);
                        loadVisited.setVisibility(View.GONE);
                        noVisited.setVisibility(View.VISIBLE);
                    }
                    // If there are no visited Parks update the visited Recycler Adapter
                    // to show the correct view information
                    else {
                        RecyclerView visitedRv = activity.findViewById(R.id.RV_VisitedParks);
                        RecyclerAdapter visitedRa = new RecyclerAdapter(visited, activity);

                        loadVisited.setVisibility(View.GONE);
                        visitedRv.setVisibility(View.VISIBLE);

                        visitedRv.setAdapter(visitedRa);
                        visitedRa.notifyDataSetChanged();
                    }
                }
            });
        }
    }
}
